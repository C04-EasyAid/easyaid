package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.bean.TutoratoDidatticoBean;

/**
 * Classe ITutoratoDidatticoDAO.
 *
 * @author Martina Giugliano
 */

public interface ITutoratoDidatticoDAO {
  List<TutoratoDidatticoBean> doRetrieveAllByStudente(String emailStudente)
      throws SQLException, ClassNotFoundException;

  List<TutoratoDidatticoBean> doRetrieveAllByTutor(String emailTutor)
      throws SQLException, ClassNotFoundException;

  List<TutoratoDidatticoBean> doRetrieveAllRichiesteTutoratoDidatticoCompletate()
      throws SQLException, ClassNotFoundException;

  List<TutoratoDidatticoBean> doRetrieveRichiesteTutoratoDidatticoNonAccettate()
      throws SQLException, ClassNotFoundException;

  TutoratoDidatticoBean doRetriveById(int id) throws SQLException, ClassNotFoundException;

  boolean InserimentoTutoratoDidattico(TutoratoDidatticoBean Bean) throws SQLException;

  boolean accettaRichiesta(int idSupporto, String emailTutor, String commento) throws SQLException;

  boolean approvaRichiesta(int idTutorato, String emailProf) throws SQLException;

  boolean completaRichiesta(int idTutorato, String emailTutor) throws SQLException;

  boolean deleteTutorato(TutoratoDidatticoBean t) throws SQLException;
}
