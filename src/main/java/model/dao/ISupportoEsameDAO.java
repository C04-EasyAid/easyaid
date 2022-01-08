package model.dao;

import model.bean.SupportoEsameBean;

import java.sql.SQLException;
import java.util.List;

public interface ISupportoEsameDAO {
  List<SupportoEsameBean> doRetrieveAllByStudente(String emailStudente)
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveAllByTutor(String emailTutor)
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveAllRichiesteSupportoEsameCompletate()
      throws SQLException, ClassNotFoundException;

  List<SupportoEsameBean> doRetrieveRichiesteSupportoEsameNonAccettate()
      throws SQLException, ClassNotFoundException;

  SupportoEsameBean doRetriveById(int id) throws SQLException, ClassNotFoundException;

  boolean InserimentoSupportoEsame(SupportoEsameBean Bean) throws SQLException;

  boolean accettaRichiesta(int idSupporto, String emailTutor, String commento) throws SQLException;

  boolean approvaRichiesta(int idSupporto, String emailProf) throws SQLException;
}
