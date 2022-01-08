package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.StudenteBean;
import model.bean.UserBean;
import model.dao.IUserDAO;
import model.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 *Testing per l'inserimento di uno Studente.
 *
 * @author Giovanni Toriello
 *
 */

class RegisterTest {
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
  void testInserimentoStudente1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "L";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "LorenzoRossidfasdadadartyuklo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo#";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "R";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossilalsdladladsladadasdfg";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi#@?^&%";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi#studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "abaglio9@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "lrossi";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "lorenzorossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "25";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "";
    String oreDisponibiliStudente = "30";
    String specificheDisturbo = "Dislessia";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente14() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    UserBean bean = new UserBean();
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Studente";
    String tipoDisabilita = "DSA";
    String oreDisponibiliStudente = "30";
    String specificheDisturbo = "";
    String percentualeDisabilita = "30";
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("tipoDisabilita", tipoDisabilita);
    request.setParameter("oreDisponibiliStudente", oreDisponibiliStudente);
    request.setParameter("specificheDisturbo", specificheDisturbo);
    request.setParameter("percentualeDisabilita", percentualeDisabilita);

    IUserDAO userDao = mock(UserDAO.class);
    servlet.setDao(userDao);
    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testInserimentoStudente15() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDao = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "S");
    StudenteBean studente =
        new StudenteBean(
            email,
            tipoDisabilita,
            specificheDisturbo,
            Integer.parseInt(oreDisponibiliStudente),
            Integer.parseInt(percentualeDisabilita));
    System.out.println("TEST" + studente);
    System.out.println("TEST" + utenteTemporaneo);

    try {
      when(userDao.insertStudente(studente, utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

}
