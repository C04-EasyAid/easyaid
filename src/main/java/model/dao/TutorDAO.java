package model.dao;

import model.bean.TutorBean;
import model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.dao.ConnectionPool.conn;
/** @author Roberto Tartaglia Classe TutorDAO */
public class TutorDAO {
  public synchronized TutorBean doRetrieveByEmail(String email)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutor WHERE email_tutor = '" + email + "'";
    TutorBean tutor = new TutorBean();
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        tutor.setEmailTutor(email);
        tutor.setDipartimento(rs.getString("dipartimento"));
        tutor.setOreDisponibili(rs.getInt("ore_disponibili"));
        tutor.setOreSvolte(rs.getInt("ore_svolte"));
        tutor.setQualifica(rs.getString("qualifica"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return tutor;
  }

  public synchronized boolean insertTutor(TutorBean t, UserBean b) throws SQLException {
    boolean tutor = false;
    UserDAO userDao = new UserDAO();
    if (userDao.insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO tutor VALUES (?,?,?,?,?)";
      PreparedStatement stmt = null;
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        stmt.setString(1, t.getEmailTutor());
        stmt.setString(2, t.getDipartimento());
        stmt.setString(3, t.getQualifica());
        stmt.setInt(4, t.getOreSvolte());
        stmt.setInt(5, t.getOreDisponibili());
        ResultSet rs = null;
        tutor = stmt.executeUpdate() == 1;
        conn.commit();
      } catch (SQLException e) {
        tutor = false;
        e.printStackTrace();
      } finally {
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      }
    }
    return tutor;
  }
}
