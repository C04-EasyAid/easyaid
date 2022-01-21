package model.dao;

import java.sql.SQLException;
import model.bean.StudenteBean;

/**
 * Classe IStudenteDAO.
 *
 * @author Giovanni Toriello
 */

public interface IStudenteDAO {
  // Metodo che restituisce lo studente
  StudenteBean doRetrieveByEmail(String email) throws SQLException;

  boolean updateOreDisponibili(int oreRichieste, String emailStudente) throws SQLException;
}
