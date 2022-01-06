package model.dao;

import model.bean.ProfessoreReferenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.dao.ConnectionPool.conn;
/** @author Roberto Tartaglia Classe ProfessoreReferenteDAO */
public class ProfessoreReferenteDAO {
  public synchronized ProfessoreReferenteBean doRetrieveByEmail(String email)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM professore_referente WHERE email_prof_refe = '" + email + "'";
    ProfessoreReferenteBean tutor = new ProfessoreReferenteBean();
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        tutor.setEmail(email);
        tutor.setDipartimento(rs.getString("dipartimento"));
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

  public synchronized boolean insertProfessoreReferente(ProfessoreReferenteBean p, UserBean b)
      throws SQLException {
    boolean prof = false;
    UserDAO userDao = new UserDAO();
    if (userDao.insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO professore_referente VALUES (?,?)";
      PreparedStatement stmt = null;
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        stmt.setString(1, p.getEmail());
        stmt.setString(2, p.getDipartimento());
        ResultSet rs = null;
        prof = stmt.executeUpdate() == 1;
        conn.commit();
      } catch (SQLException e) {
        prof = false;
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
    return prof;
  }
}
