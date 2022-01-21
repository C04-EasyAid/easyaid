package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.ProfessoreReferenteBean;

/**
 * Classe ProfessoreReferenteDAO.
 *
 * @author Roberto Tartaglia
 */
public class ProfessoreReferenteDAO implements IProfessoreReferenteDAO {
  @Override
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
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return tutor;
  }
}
