package control;

import model.bean.ProfessoreReferenteBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Martina Giugliano
 */
class ViewProfiloUtenteIntegrationTest {
  private ProfiloUtenteServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ProfiloUtenteServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di uno studente
  @Test
  void testProfiloUtente1()
      throws ServletException, IOException, SQLException, ClassNotFoundException {

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("abaglio9@studenti.unisa.it");
    userBean.setRuolo("S");
    request.setParameter("usrEmail", userBean.getEmail());
    StudenteBean studente = new StudenteBean();
    studente.setEmail("abaglio9@studenti.unisa.it");

    istudenteDao studenteDao = new studenteDao();
    iuserDao userDao = new UserDAO();

    servlet.setStudenteDao(studenteDao);
    servlet.setUserdao(userDao);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di un tutor
  @Test
  void testProfiloUtente2()
      throws ServletException, IOException, SQLException, ClassNotFoundException {

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setRuolo("T");
    request.setParameter("usrEmail", userBean.getEmail());
    TutorBean tutor = new TutorBean();
    tutor.setEmailTutor("lorenzorossi1@studenti.unisa.it");

    itutorDao tutorDao = new TutorDAO();
    iuserDao userDao = new UserDAO();

    servlet.setTutorDao(tutorDao);
    servlet.setUserdao(userDao);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un personale amministrativo;vuole visualizzare il profilo di un professore
  // referente
  @Test
  void testProfiloUtente3()
      throws ServletException, IOException, SQLException, ClassNotFoundException {

    UserBean userLoggato = new UserBean();
    userLoggato.setRuolo("PA");
    request.getSession().setAttribute("utente", userLoggato);

    UserBean userBean = new UserBean();
    userBean.setEmail("adevito11@unisa.it");
    userBean.setRuolo("P");
    request.setParameter("usrEmail", userBean.getEmail());
    ProfessoreReferenteBean professore = new ProfessoreReferenteBean();
    professore.setEmail("lorenzorossi1@studenti.unisa.it");

    iprofessorereferenteDao professoreDao = new professorereferenteDao();
    iuserDao userDao = new UserDAO();

    servlet.setProfessoreDao(professoreDao);
    servlet.setUserdao(userDao);

    servlet.doGet(request, response);

    assertEquals("view/UserPage.jsp", response.getRedirectedUrl());
  }
}
