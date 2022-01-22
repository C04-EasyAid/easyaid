package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.bean.SupportoEsameBean;

/**
 * Classe ISupportoEsameDAO.
 *
 * @author Martina Giugliano
 */

public interface IsupportoEsameDao {
  List<SupportoEsameBean> doRetrieveAllByStudente(String emailStudente)
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveAllByTutor(String emailTutor)
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveAllRichiesteSupportoEsameCompletate()
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveRichiesteSupportoEsameNonAccettate()
      throws SQLException, ClassNotFoundException;

  SupportoEsameBean doRetriveById(int id) throws SQLException, ClassNotFoundException;

  boolean inserimentoSupportoEsame(SupportoEsameBean bean) throws SQLException;

  boolean accettaRichiesta(int idSupporto, String emailTutor, String commento) throws SQLException;

  boolean approvaRichiesta(int idSupporto, String emailProf) throws SQLException;

  boolean deleteSupporto(SupportoEsameBean s) throws SQLException;
}
