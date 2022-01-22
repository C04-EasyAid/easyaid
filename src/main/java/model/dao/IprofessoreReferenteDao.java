package model.dao;

import java.sql.SQLException;
import model.bean.ProfessoreReferenteBean;

/**
 * Classe ProfessoreReferenteDAO.
 *
 * @author Roberto Tartaglia
 */

public interface IprofessoreReferenteDao {
  ProfessoreReferenteBean doRetrieveByEmail(String email)
      throws SQLException, ClassNotFoundException;
}
