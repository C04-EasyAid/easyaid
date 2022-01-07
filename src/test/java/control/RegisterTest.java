package control;


import model.bean.StudenteBean;
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
    System.out.println("TEST"+studente);
    System.out.println("TEST"+utenteTemporaneo);

    try {
      when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    servlet.setDao(userDAO);
    servlet.doGet(request,response);

    assertEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    UserDAO dao = new UserDAO();
    String nome="Lorenzo";
    String cognome="Rossi";
    String email="l.rossi@studenti.unisa.it";
    String password="Lorenzo#rossi1";
    String ruolo="Studente";
    String tipoDisabilita="DSA";
    String oreDisponibiliStudente="25";
    String specificheDisturbo="Dislessia";
    String percentualeDisabilita="30";
    StudenteBean studente=new StudenteBean(email,tipoDisabilita,specificheDisturbo,Integer.parseInt(oreDisponibiliStudente),Integer.parseInt(percentualeDisabilita));
    UserBean utenteTemporaneo=new UserBean(nome,cognome,email,password,"S");
    dao.insertStudente(studente,utenteTemporaneo);
  }
}
