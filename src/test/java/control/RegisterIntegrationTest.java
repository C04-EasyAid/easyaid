package control;

import model.bean.UserBean;
import model.dao.IUserDAO;
import model.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
@author Martina Giugliano
 */
class RegisterIntegrationTest {
  private RegisterServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new RegisterServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void TestInserimentoStudente() throws ServletException, IOException, SQLException {
    IUserDAO userDAO = new UserDAO();

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi1@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    servlet.setDao(userDAO);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    userDAO.deleteUtente(new UserBean(nome, cognome, email, password, ruolo));
  }

  @Test
  void TestInserimentoTutor() throws ServletException, IOException, SQLException {
    IUserDAO userDAO = new UserDAO();

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi1@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoTutor", dipartimento);
    request.setParameter("qualifica", qualifica);
    request.setParameter("oreDisponibiliTutor", oreDisponibili);

    servlet.setDao(userDAO);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    userDAO.deleteUtente(new UserBean(nome, cognome, email, password, ruolo));
  }

  @Test
  void TestInserimentoProfessoreReferente() throws ServletException, IOException, SQLException {
    IUserDAO userDAO = new UserDAO();
    UserBean persAdmin = new UserBean();

    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi1@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);

    servlet.setDao(userDAO);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));

    userDAO.deleteUtente(new UserBean(nome, cognome, email, password, ruolo));
  }
}
