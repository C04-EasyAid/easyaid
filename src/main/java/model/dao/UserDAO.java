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

import static other.Utils.generatePwd;

/** @author Giovanni Toriello Classe UserDAO */
public class UserDAO {
  public synchronized UserBean doRetrieveUtente(UserBean b)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String pwd = generatePwd(b.getPassword());
    String query = "SELECT * FROM utente WHERE email = ? AND password = ?";
    UserBean user = null;
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, b.getEmail());
      stmt.setString(2, pwd);
      ResultSet rs = stmt.executeQuery();
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
    } finally {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return user;
  }

  public synchronized boolean insertUtente(UserBean b) throws SQLException {
    boolean utente = false;
    Connection conn = null;
    String pwd = generatePwd(b.getPassword());
    String query = "INSERT INTO utente VALUES (?,?,?,?,?)";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);

      stmt.setString(1, b.getNome());
      stmt.setString(2, b.getCognome());
      stmt.setString(3, b.getEmail());
      stmt.setString(4, pwd);
      stmt.setString(5, b.getRuolo());
      utente = stmt.executeUpdate() == 1;
      conn.commit();
    } catch (SQLException e) {
      utente = false;
      e.printStackTrace();

    } finally {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return utente;
  }

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
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return utenti;
  }

  public synchronized UserBean doRetrieveUtenteByEmail(String email)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM utente WHERE email = ?";
    UserBean user = null;
    PreparedStatement stmt = null;

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
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
    } finally {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return user;
  }
}
