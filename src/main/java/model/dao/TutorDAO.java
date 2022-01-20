package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.TutorBean;

/**
 * Classe TutorDAO.
 *
 * @author Roberto Tartaglia
 */

public class TutorDAO implements itutorDao {
  @Override
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
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return tutor;
  }
}
