package model.dao;

import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static model.dao.ConnectionPool.conn;
import static other.Utils.generatePwd;

/**
 * @author Giovanni Toriello
 * Classe UserDAO
 */
public class UserDAO implements IUserDAO {
  // Metodo che restituisce l'utente dal database
  @Override
  public  synchronized UserBean doRetrieveUtente(UserBean b)
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
        user.setPassword(rs.getString("nome"));
        user.setRuolo(rs.getString("ruolo"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    } finally {
      if(stmt!=null){
      stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
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
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      // Setta i paremetri nella query
      stmt.setString(1, b.getNome());
      stmt.setString(2, b.getCognome());
      stmt.setString(3, b.getEmail());
      stmt.setString(4, pwd);
      stmt.setString(5, b.getRuolo());
      // Esegue la query
     utente = stmt.executeUpdate()==1;
     conn.commit();
    } catch (SQLException e) {
      utente = false;
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    } finally {
      if(stmt!=null){
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return utente;
  }
  // Metodo che restituisce true se è lo studente è stato inserito
  @Override
  public synchronized boolean insertStudente(StudenteBean s, UserBean b)
      throws SQLException, ClassNotFoundException {
    boolean studente = false;
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
      } catch (SQLException e) {
        studente = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      } finally {
        if(stmt!=null){
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
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
    if (insertUtente(b) && t.getOreDisponibili()<100) {
      Connection conn = null;
      String query = "INSERT INTO tutor VALUES (?,?,?,?,?)";
      PreparedStatement stmt = null;
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
      } catch (SQLException e) {
        tutor = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      } finally {
        if(stmt!=null){
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      }
    }
    return tutor;
  }
  // Metodo che restituisce true se il tutor è stato inserito
  @Override
  public synchronized boolean insertProfessoreReferente(
          ProfessoreReferenteBean p, UserBean b) throws SQLException {
    boolean prof = false;
    // Viene prima inserito l'utente generico (UserBean);
    // Se il metodo restituisce true continua per inserire il prof
    if (insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO professore_referente VALUES (?,?)";
      PreparedStatement stmt = null;
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
      } catch (SQLException e) {
        prof = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      } finally {
        if(stmt!=null){
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
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
    } catch (SQLException e) {

    } finally {
      if(stmt!=null){
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
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
        user.setPassword(rs.getString("nome"));
        user.setRuolo(rs.getString("ruolo"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    } finally {
      if(stmt!=null){
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return user;
  }
}
