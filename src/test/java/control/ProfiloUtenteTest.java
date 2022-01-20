package control;

import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfiloUtenteTest {

  private ProfiloUtenteServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ProfiloUtenteServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente non è loggato all'interno della piattaforma,dunque non può accedere alla pagina
  @Test
  void testProfiloUtente1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato non è un personale amministrativo
  @Test
  void testProfiloUtente2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("S");
    request.getSession().setAttribute("utente", userLoggato);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;errore nel parametro http "usrEmail"
  @Test
  void testProfiloUtente3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    servlet.doGet(request, response);

    assertEquals("view/ListaUtentiPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di uno studente
  @Test
  void testProfiloUtente4()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("abaglio9@studenti.unisa.it");
    userBean.setRuolo("S");
    request.setParameter("usrEmail", userBean.getEmail());
    StudenteBean studente = new StudenteBean();
    studente.setEmail("abaglio9@studenti.unisa.it");

    istudenteDao studenteDao = mock(model.dao.studenteDao.class);
    iuserDao userDao = mock(UserDAO.class);

    servlet.setStudenteDao(studenteDao);
    servlet.setUserdao(userDao);

    when(userDao.doRetrieveUtenteByEmail(userBean.getEmail())).thenReturn(userBean);
    when(studenteDao.doRetrieveByEmail(studente.getEmail())).thenReturn(studente);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di un tutor
  @Test
  void testProfiloUtente5()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setRuolo("T");
    request.setParameter("usrEmail", userBean.getEmail());
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor("lorenzorossi1@studenti.unisa.it");

    itutorDao tutorDao = mock(TutorDAO.class);
    iuserDao userDao = mock(UserDAO.class);

    servlet.setTutorDao(tutorDao);
    servlet.setUserdao(userDao);

    when(userDao.doRetrieveUtenteByEmail(userBean.getEmail())).thenReturn(userBean);
    when(tutorDao.doRetrieveByEmail(tutor.getEmailTutor())).thenReturn(tutor);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di un professore
  // referente
  @Test
  void testProfiloUtente6()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("adevito11@unisa.it");
    userBean.setRuolo("P");
    request.setParameter("usrEmail", userBean.getEmail());
    ProfessoreReferenteBean professore = new ProfessoreReferenteBean();
    professore.setEmail("lorenzorossi1@studenti.unisa.it");

    iprofessorereferenteDao professoreDao = mock(professorereferenteDao.class);
    iuserDao userDao = mock(UserDAO.class);

    servlet.setProfessoreDao(professoreDao);
    servlet.setUserdao(userDao);

    when(userDao.doRetrieveUtenteByEmail(userBean.getEmail())).thenReturn(userBean);
    when(professoreDao.doRetrieveByEmail(professore.getEmail())).thenReturn(professore);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }
}
