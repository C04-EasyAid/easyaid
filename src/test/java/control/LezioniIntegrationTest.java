package control;

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
    ilezioneDao lezioneDao = new LezioneDAO();
    istudenteDao studenteDao = new studenteDao();
    itutoratodidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDAO();
    UserBean userBean = new UserBean();

    servlet.setLezioneDao(lezioneDao);
    servlet.setStudenteDao(studenteDao);
    servlet.settutoratodidatticodao(tutoratoDidatticoDao);

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
    ilezioneDao lezioneDao = new LezioneDAO();
    itutorDao tutorDao = new TutorDAO();
    itutoratodidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDAO();
    UserBean userBean = new UserBean();

    servlet.setLezioneDao(lezioneDao);
    servlet.settutoratodidatticodao(tutoratoDidatticoDao);
    servlet.setTutorDao(tutorDao);

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");

    request.getSession().setAttribute("utente", userBean);

    servlet.doGet(request, response);
    assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
  }
}
