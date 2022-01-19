package control;


import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.dao.IUserDAO;
import org.junit.jupiter.api.BeforeEach;
import model.bean.UserBean;
import model.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * @author Giovanni Toriello
 * Testing per l'inserimento di uno Studente
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
  void TestInserimentoStudente1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);
    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));

  }

  @Test
  void TestInserimentoStudente7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }


  @Test
  void TestInserimentoStudente14() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
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
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);


    servlet.setDao(userDAO);
    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoStudente15() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Studente";
    String tipoDisabilita="DSA";
    String oreDisponibiliStudente="25";
    String specificheDisturbo="Dislessia";
    String percentualeDisabilita="30";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("tipoDisabilita",tipoDisabilita);
    request.setParameter("oreDisponibiliStudente",oreDisponibiliStudente);
    request.setParameter("specificheDisturbo",specificheDisturbo);
    request.setParameter("percentualeDisabilita",percentualeDisabilita);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));

    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertEquals("Studente con disabilità/DSA inserito con successo.", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestInserimentoTutor1() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="L";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor2() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo Franco Antonio Rossi";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor3() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo#";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor4() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="R";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor5() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="RossiLorenziidwmmskmcxksamkcmskm";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor6() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi#";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor7() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi#studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor8() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi1@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor9() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = null;
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor10() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="lrossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "L";
    String oreDisponibili = "100";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor11() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "LaureaskxasdjbasjsdbajsbdjbTriennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor12() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea#Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoTutor13() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Tutor";
    String dipartimento = "Informatica";
    String qualifica = "Laurea Triennale";
    String oreDisponibili = "25";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoTutor",dipartimento);
    request.setParameter("qualifica",qualifica);
    request.setParameter("oreDisponibiliTutor",oreDisponibili);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"T");
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor(email);
    tutor.setOreSvolte(0);
    tutor.setDipartimento(dipartimento);
    tutor.setQualifica(qualifica);
    tutor.setOreDisponibili(Integer.parseInt(oreDisponibili));


    try {
      when(userDAO.insertTutor(tutor,utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente1() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="L";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente2() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo Amerigo Cornelio Giuseppe Roberto Riccardo Giovanni";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente3() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo#";
    String cognome="R";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente4() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossifbvdfdsvdvdsvsvdsvdsvdsvdsvds";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente5() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi#";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente6() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi1@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente7() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi#studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente8() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="lrossi";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente9() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente10() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = null;
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
  @Test
  void TestInserimentoProfessoreReferente11() throws ServletException, IOException {MockitoAnnotations.initMocks(this);
    IUserDAO userDAO = mock(UserDAO.class);

    UserBean persAdmin = new UserBean();
    UserBean bean = new UserBean();
    persAdmin.setEmail("cgigli91@unisa.it");
    persAdmin.setPassword("C#Gigli#9109");
    persAdmin.setRuolo("PA");
    request.getSession().setAttribute("utente",persAdmin);
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Professore Referente";
    String dipartimento = "Informatica";
    request.setParameter("nome",nome);
    request.setParameter("cognome",cognome);
    request.setParameter("email",email);
    request.setParameter("password",password);
    request.setParameter("ruolo",ruolo);
    request.setParameter("dipartimentoProf",dipartimento);
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"P");
    ProfessoreReferenteBean prof = new ProfessoreReferenteBean();
    prof.setEmail(email);
    prof.setDipartimento(dipartimento);



    try {
      when(userDAO.insertProfessoreReferente(prof,utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }


   @Test
  void permessiNonConcessi() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
     String nome="Lorenzo";
     String cognome="Rossi";
     String email="l.rossi@studenti.unisa.it";
     String password="Lorenzo#rossi1";
     String ruolo="Professore Referente";
     String dipartimento = "Informatica";
     request.setParameter("nome",nome);
     request.setParameter("cognome",cognome);
     request.setParameter("email",email);
     request.setParameter("password",password);
     request.setParameter("ruolo",ruolo);
     request.setParameter("dipartimentoProf",dipartimento);
     servlet.doGet(request,response);

    assertEquals("Permessi non concessi all'utente",request.getSession().getAttribute("alertMsg"));

   }



}
