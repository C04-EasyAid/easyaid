package model.dao;

import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;

import java.sql.SQLException;
import java.util.Collection;

public interface IUserDAO {
  // Metodo che restituisce l'utente dal database
  UserBean doRetrieveUtente(UserBean b) throws SQLException, ClassNotFoundException;

  // Metodo che restituisce true se è l'utente è stato inserito
  boolean insertUtente(UserBean b) throws SQLException;

  // Metodo che restituisce true se è lo studente è stato inserito
  boolean insertStudente(StudenteBean s, UserBean b) throws SQLException, ClassNotFoundException;

  // Metodo che restituisce true se il tutor è stato inserito
  boolean insertTutor(TutorBean t, UserBean b) throws SQLException;

  // Metodo che restituisce true se il tutor è stato inserito
  boolean insertProfessoreReferente(ProfessoreReferenteBean p, UserBean b) throws SQLException;

  // Metodo che restituisce la lista degli utenti nel Database
  Collection<UserBean> doRetrieveAll() throws ClassNotFoundException, SQLException;

  // Metodo che restituisce l'utente dal database tramite Email
  UserBean doRetrieveUtenteByEmail(String email) throws SQLException, ClassNotFoundException;
}
