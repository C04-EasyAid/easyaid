package model.dao;

import static other.Utils.generatePwd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;


/**
 * Classe UserDAO.
 *
 * @author Giovanni Toriello
 */
public class UserDao implements IuserDao {
  // Metodo che restituisce l'utente dal database
  @Override
  public synchronized UserBean doRetrieveUtente(UserBean b)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String pwd = generatePwd(b.getPassword());
    String query = "SELECT * FROM utente WHERE email = ? AND password = ?";
    UserBean user = null;
    PreparedStatement stmt = null;
    // Se riesce a connettersi, la connessione è != da null ed entra nello statement
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, b.getEmail());
      stmt.setString(2, pwd);
      ResultSet rs = stmt.executeQuery();
      // Se trova l'utente lo crea con tutti gli attributi
      if (rs.next()) {
        user = new UserBean();
        user.setNome(rs.getString("nome"));
        user.setCognome(rs.getString("cognome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRuolo(rs.getString("ruolo"));
      }
      stmt.close();
      conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    }

    return user;
  }
  // Metodo che restituisce true se è l'utente è stato inserito

  @Override
  public synchronized boolean insertUtente(UserBean b) throws SQLException {
    boolean utente = false;
    Connection conn = null;
    String pwd = generatePwd(b.getPassword());
    String query = "INSERT INTO utente VALUES (?,?,?,?,?)";
    PreparedStatement stmt = null;
    // Se riesce a connettersi, la connessione è != da null ed entra nello statement
    try {
      String nome = b.getNome();
      if (nome.length() > 26 || nome.length() < 2) {
        return false;
      }
      String email = b.getEmail();
      String expressionPlus = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
      Pattern pplus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
      Matcher mplus = pplus.matcher(email);
      boolean matchFoundPlus = mplus.matches();
      if (!matchFoundPlus) {
        return false;
      }
      String cognome = b.getCognome();
      if (cognome.length() > 26 || cognome.length() < 2) {
        return false;
      }
      String password = b.getPassword();
      if (password.length() < 12) {
        return false;
      }
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      // Setta i paremetri nella query
      stmt.setString(1, b.getNome());
      stmt.setString(2, b.getCognome());
      stmt.setString(3, b.getEmail());
      stmt.setString(4, pwd);
      stmt.setString(5, b.getRuolo());
      // Esegue la query
      utente = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      utente = false;
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    }

    return utente;
  }
  // Metodo che restituisce true se è lo studente è stato inserito

  @Override
  public synchronized boolean insertStudente(StudenteBean s, UserBean b) throws SQLException {
    boolean studente = false;
    String expressionPlus = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    Pattern pplus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
    Matcher mplus = pplus.matcher(s.getEmail());
    boolean matchFoundPlus = mplus.matches();
    if (!matchFoundPlus) {
      return false;
    }
    if (!s.getTipoDisabilita().matches("[a-zA-Z]+")
        || !s.getSpecificheDisturbo().matches("[a-zA-Z]+")) {
      return false;
    }
    if (s.getPercentualeDisabilita() > 100) {
      return false;
    }
    // Viene prima inserito l'utente generico (UserBean);
    // Se il metodo restituisce true continua per inserire lo studente
    if (insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO studente VALUES (?,?,?,?,?)";
      PreparedStatement stmt = null;
      // Se riesce a connettersi, la connessione è != da null ed entra nello statement
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        // Setta i paremetri nella query
        stmt.setString(1, s.getEmail());
        stmt.setString(2, s.getTipoDisabilita());
        stmt.setString(3, s.getSpecificheDisturbo());
        stmt.setInt(4, s.getPercentualeDisabilita());
        stmt.setInt(5, s.getOreDisponibili());
        // Esegue la query
        ResultSet rs = null;
        studente = stmt.executeUpdate() == 1;
        conn.commit();
        stmt.close();
        conn.close();
      } catch (SQLException e) {
        studente = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      }
    }

    return studente;
  }

  // Metodo che restituisce true se il tutor è stato inserito

  @Override
  public synchronized boolean insertTutor(TutorBean t, UserBean b) throws SQLException {
    boolean tutor = false;
    // Viene prima inserito l'utente generico (UserBean);
    // Se il metodo restituisce true continua per inserire il tutor
    if (insertUtente(b) && t.getOreDisponibili() < 100) {
      Connection conn = null;
      String query = "INSERT INTO tutor VALUES (?,?,?,?,?)";
      PreparedStatement stmt = null;
      String dipartimento = t.getDipartimento();
      String qualifica = t.getQualifica();
      Integer oreSvolte = t.getOreSvolte();
      Integer oreDisponbili = t.getOreDisponibili();
      if (dipartimento == null) {
        return false;
      }
      if (qualifica.length() < 2 || qualifica.length() > 50) {
        return false;
      }

      // Se riesce a connettersi, la connessione è != da null ed entra nello statement
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        // Setta i paremetri nella query
        stmt.setString(1, t.getEmailTutor());
        stmt.setString(2, t.getDipartimento());
        stmt.setString(3, t.getQualifica());
        stmt.setInt(4, t.getOreSvolte());
        stmt.setInt(5, t.getOreDisponibili());
        // Esegue la query
        ResultSet rs = null;
        tutor = stmt.executeUpdate() == 1;
        conn.commit();

        stmt.close();
        conn.close();

      } catch (SQLException e) {
        tutor = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      }
    }
    return tutor;
  }
  // Metodo che restituisce true se il tutor è stato inserito

  @Override
  public synchronized boolean insertProfessoreReferente(ProfessoreReferenteBean p, UserBean b)
      throws SQLException {
    boolean prof = false;
    // Viene prima inserito l'utente generico (UserBean);
    // Se il metodo restituisce true continua per inserire il prof
    if (insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO professore_referente VALUES (?,?)";
      PreparedStatement stmt = null;
      String dipartimento = p.getDipartimento();
      if (dipartimento == null) {
        return false;
      }
      // Se riesce a connettersi, la connessione è != da null ed entra nello statement
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        // Setta i paremetri nella query
        stmt.setString(1, p.getEmail());
        stmt.setString(2, p.getDipartimento());
        // Esegue la query
        ResultSet rs = null;
        prof = stmt.executeUpdate() == 1;
        conn.commit();

        stmt.close();
        conn.close();

      } catch (SQLException e) {
        prof = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      }
    }
    return prof;
  }
  // Metodo che restituisce la lista degli utenti nel Database

  @Override
  public synchronized Collection<UserBean> doRetrieveAll()
      throws ClassNotFoundException, SQLException {
    Collection<UserBean> utenti = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "SELECT * FROM utente";
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      UserBean bean = null;
      while (rs.next()) {
        bean = new UserBean();
        bean.setNome(rs.getString("nome"));
        bean.setCognome(rs.getString("cognome"));
        bean.setEmail(rs.getString("email"));
        bean.setPassword(rs.getString("password"));
        bean.setRuolo(rs.getString("ruolo"));
        utenti.add(bean);
      }
      stmt.close();
      conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return utenti;
  }
  // Metodo che restituisce l'utente dal database tramite Email

  @Override
  public synchronized UserBean doRetrieveUtenteByEmail(String email)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM utente WHERE email = ?";
    UserBean user = null;
    PreparedStatement stmt = null;
    // Se riesce a connettersi, la connessione è != da null ed entra nello statement
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
      // Se trova l'utente lo crea con tutti gli attributi
      if (rs.next()) {
        user = new UserBean();
        user.setNome(rs.getString("nome"));
        user.setCognome(rs.getString("cognome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRuolo(rs.getString("ruolo"));
      }
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    }

    return user;
  }

  @Override
  public synchronized boolean deleteUtente(UserBean b) throws SQLException {
    boolean delete = false;

    Connection conn = null;
    String query = "DELETE FROM utente WHERE email=?";
    PreparedStatement stmt = null;

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, b.getEmail());
      System.out.println(stmt);

      ResultSet rs = null;
      delete = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return delete;
  }
}
