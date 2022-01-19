package model.dao;

import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import org.junit.jupiter.api.Test;
import other.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
  private final UserDAO dao = new UserDAO();

  @Test
  void doRetrieveUtente() throws SQLException, ClassNotFoundException {

    String email = "abaglio9@studenti.unisa.it";
    String nome = "Aldo";
    String cognome = "Baglio";
    String password = "Aldo#Baglio45";
    String ruolo = "S";

    UserBean utente = new UserBean(nome, cognome, email, password, ruolo);

    UserBean bean = dao.doRetrieveUtente(utente);

    assertEquals(nome, bean.getNome());
    assertEquals(cognome, bean.getCognome());
    assertEquals(email, utente.getEmail());
    assertEquals(password, utente.getPassword());
    assertEquals(ruolo, utente.getRuolo());
  }

  @Test
  void insertUtente() throws SQLException {
    String nome = "Giuseppe";
    String cognome = "Verdi";
    String email = "gverdi87@studenti.unisa.it";
    String password = "Giuseppe#Verdi89";
    String ruolo = "S";

    UserBean bean = new UserBean(nome, cognome, email, password, ruolo);

    boolean result = dao.insertUtente(bean);

    assertEquals(true, result);

    dao.deleteUtente(bean);
  }

  @Test
  void insertStudente() throws SQLException, ClassNotFoundException {
    String nome = "Giuseppe";
    String cognome = "Verdi";
    String email = "gverdi87@studenti.unisa.it";
    String password = "Giuseppe#Verdi89";
    String ruolo = "S";
    String tipoDisabilita = "DSA";
    String specificheDisturbo = "dislessia";
    int percentualeDisabilita = 34;
    int oreDisponibili = 35;

    UserBean utente = new UserBean(nome, cognome, email, password, ruolo);
    StudenteBean studente =
        new StudenteBean(
            email, tipoDisabilita, specificheDisturbo, oreDisponibili, percentualeDisabilita);
    boolean result = dao.insertStudente(studente, utente);

    assertEquals(true, result);

    dao.deleteUtente(utente);
  }

  @Test
  void insertTutor() throws SQLException {
    String nome = "Giuseppe";
    String cognome = "Verdi";
    String email = "gverdi87@studenti.unisa.it";
    String password = "Giuseppe#Verdi89";
    String ruolo = "T";
    String dipartimento = "informatica";
    String qualifica = "Laurea Triennale";
    int oreSvolte = 24;
    int oreDisponibili = 16;

    UserBean utente = new UserBean(nome, cognome, email, password, ruolo);
    TutorBean tutor = new TutorBean(email, dipartimento, qualifica, oreSvolte, oreDisponibili);

    boolean result = dao.insertTutor(tutor, utente);

    assertEquals(true, result);

    dao.deleteUtente(utente);
  }

  @Test
  void insertProfessoreReferente() throws SQLException {
    String nome = "Giuseppe";
    String cognome = "Verdi";
    String email = "gverdi87@studenti.unisa.it";
    String password = "Giuseppe#Verdi89";
    String ruolo = "P";
    String dipartimento = "matematica";

    UserBean utente = new UserBean(nome, cognome, email, password, ruolo);
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean(email, dipartimento);

    boolean result = dao.insertProfessoreReferente(prof, utente);

    assertEquals(true, result);

    dao.deleteUtente(utente);
  }

  @Test
  void doRetrieveAll() throws SQLException, ClassNotFoundException {

    List<UserBean> list = new ArrayList<>();
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());
    list.add(new UserBean());

    List<UserBean> result = (List<UserBean>) dao.doRetrieveAll();

    assertEquals(result.size(), list.size());
  }

  @Test
  void doRetrieveUtenteByEmail() throws SQLException, ClassNotFoundException {

    String email = "adevito11@unisa.it";
    String nome = "Aldo";
    String cognome = "De Vito";
    String password = Utils.generatePwd("Aldo#Dev#1103");
    String ruolo = "P";

    UserBean bean = dao.doRetrieveUtenteByEmail(email);

    assertEquals(email, bean.getEmail());
    assertEquals(nome, bean.getNome());
    assertEquals(cognome, bean.getCognome());
    assertEquals(password, bean.getPassword());
    assertEquals(ruolo, bean.getRuolo());
  }
}
