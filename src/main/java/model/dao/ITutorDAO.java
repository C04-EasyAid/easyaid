package model.dao;

import java.sql.SQLException;
import model.bean.TutorBean;

/**
 * Classe ITutorDAO.
 *
 * @author Roberto Tartaglia
 */

public interface ITutorDAO {
  TutorBean doRetrieveByEmail(String email) throws SQLException, ClassNotFoundException;
}
