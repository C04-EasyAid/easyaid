package model.dao;

import java.sql.SQLException;
import java.util.Collection;
import model.bean.CommentoBean;

/**
 * Classe ICommentoDAO.
 *
 * @author Mariagiovanna Bianco
 */

public interface ICommentoDAO {
  // Metodo che restituisce il commento
  Collection<CommentoBean> doRetrieveCommento(int id) throws ClassNotFoundException, SQLException;

  // Metodo che restituisce un booleano
  // true=commento inserito
  // false=commento non inserito
  boolean insertCommentoTutor(int lezione, String msg, String emailMittente) throws SQLException;

  // Metodo che restituisce un booleano
  // true=commento inserito
  // false=commento non inserito
  boolean insertCommentoStudente(int lezione, String msg, String emailMittente) throws SQLException;

  boolean deleteCommento(CommentoBean b) throws SQLException;
}
