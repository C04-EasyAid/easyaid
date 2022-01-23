package control;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.IuserDao;
import model.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



/**
 *  Testing  di unità per la funzioanlità: inserimento studente,
 *  inserimento tutor e inserimento professore referente.
 *
 *  @author Giovanni Toriello
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
  void testinserimentoStudente1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente14() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

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
  void testinserimentoStudente15() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);


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

  @Test
  void testinserimentoTutor1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "L";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo Franco Antonio Rossi";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo#";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "R";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "RossiLorenziidwmmskmcxksamkcmskm";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi#";
    String email = "l.rossi@studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi#studenti.unisa.it";
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Tutor";
    String dipartimento = null;
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "lrossi1";
    String ruolo = "Tutor";
    String dipartimento = "Informatica";
    String qualifica = "L";
    String oreDisponibili = "100";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoTutor", dipartimento);
    request.setParameter("qualifica", qualifica);
    request.setParameter("oreDisponibiliTutor", oreDisponibili);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor11() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Tutor";
    String dipartimento = "Informatica";
    String qualifica = "LaureaskxasdjbasjsdbajsbdjbTriennale";
    String oreDisponibili = "25";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoTutor", dipartimento);
    request.setParameter("qualifica", qualifica);
    request.setParameter("oreDisponibiliTutor", oreDisponibili);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea#Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoTutor", dipartimento);
    request.setParameter("qualifica", qualifica);
    request.setParameter("oreDisponibiliTutor", oreDisponibili);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoTutor13() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));

    try {
      when(userDao.insertTutor(tutor, utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "L";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo Amerigo Cornelio Giuseppe Roberto Riccardo Giovanni";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo#";
    String cognome = "R";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossifbvdfdsvdvdsvsvdsvdsvdsvdsvds";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi#";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
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
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi#studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente", persAdmin);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "lrossi";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Professore Referente";
    String dipartimento = null;
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertNotEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentoProfessorereferente11() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

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
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    UserBean utenteTemporaneo = new UserBean(nome, cognome, email, password, "P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);

    try {
      when(userDao.insertProfessoreReferente(prof, utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertEquals(
        "Utente inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void permessiNonConcessi() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    String nome = "Lorenzo";
    String cognome = "Rossi";
    String email = "l.rossi@studenti.unisa.it";
    String password = "Lorenzo#rossi1";
    String ruolo = "Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome", nome);
    request.setParameter("cognome", cognome);
    request.setParameter("email", email);
    request.setParameter("password", password);
    request.setParameter("ruolo", ruolo);
    request.setParameter("dipartimentoProf", dipartimento);
    servlet.doGet(request, response);

    assertEquals("Permessi non concessi all'utente", request.getSession().getAttribute("alertMsg"));
  }
}
