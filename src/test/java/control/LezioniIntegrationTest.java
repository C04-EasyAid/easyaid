package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.bean.UserBean;
import model.dao.IlezioneDao;
import model.dao.IstudenteDao;
import model.dao.ItutorDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.LezioneDao;
import model.dao.StudenteDao;
import model.dao.TutorDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



/**
 * Test di integrazione per la funzionalità: visualizza lista lezioni.
 *
 * @author Martina Giugliano
 *
 */
class LezioniIntegrationTest {
  private LezioniServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new LezioniServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente loggato è uno studente,e può vedere la lista delle lezioni
  @Test
  void testViewLezioni1()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    IlezioneDao lezioneDao = new LezioneDao();
    IstudenteDao studenteDao = new StudenteDao();
    ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();

    servlet.setLezioneDao(lezioneDao);
    servlet.setStudenteDao(studenteDao);
    servlet.settutoratodidatticodao(tutoratoDidatticoDao);

    UserBean userBean = new UserBean();
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("S");

    request.getSession().setAttribute("utente", userBean);

    servlet.doGet(request, response);
    assertEquals("view/LezioniStudentePage.jsp", response.getRedirectedUrl());
  }
  // L'utente loggato è un tutor,dunque può vedere la lista delle lezioni

  @Test
  void testViewLezioni2()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    IlezioneDao lezioneDao = new LezioneDao();
    ItutorDao tutorDao = new TutorDao();
    ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();

    servlet.setLezioneDao(lezioneDao);
    servlet.settutoratodidatticodao(tutoratoDidatticoDao);
    servlet.setTutorDao(tutorDao);

    UserBean userBean = new UserBean();
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");

    request.getSession().setAttribute("utente", userBean);

    servlet.doGet(request, response);
    assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
  }
}
