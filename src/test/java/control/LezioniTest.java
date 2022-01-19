package control;

import model.bean.LezioneBean;
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
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LezioniTest {
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
    MockitoAnnotations.initMocks(this);
    ILezioneDAO lezioneDao = mock(LezioneDAO.class);
    IStudenteDAO studenteDao = mock(StudenteDAO.class);
    ITutoratoDidatticoDAO tutoratoDidatticoDao = mock(TutoratoDidatticoDAO.class);
    StudenteBean studenteBean = new StudenteBean();
    UserBean userBean = new UserBean();

    servlet.setLezioneDao(lezioneDao);
    servlet.setStudenteDao(studenteDao);
    servlet.setTutoratoDidatticoDAO(tutoratoDidatticoDao);

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("S");

    when(studenteDao.doRetrieveByEmail(userBean.getEmail())).thenReturn(studenteBean);
    Collection<LezioneBean> list = new ArrayList<>();
    list.add(new LezioneBean());
    list.add(new LezioneBean());
    list.add(new LezioneBean());

    request.getSession().setAttribute("utente", userBean);
    when(lezioneDao.doRetrieveLezioneByStudente(userBean.getEmail())).thenReturn(list);
    request.getSession().setAttribute("listaLezioni", list);

    servlet.doGet(request, response);
    assertEquals("view/LezioniStudentePage.jsp", response.getRedirectedUrl());
  }

  // L'utente non è loggato,dunque non può accedere alla pagina della lista delle lezioni
  @Test
  void testViewLezioni2()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);
    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un tutor,dunque può vedere la lista delle lezioni
  @Test
  void testViewLezioni3()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);
    ILezioneDAO lezioneDao = mock(LezioneDAO.class);
    ITutorDAO tutorDao = mock(TutorDAO.class);
    ITutoratoDidatticoDAO tutoratoDidatticoDao = mock(TutoratoDidatticoDAO.class);
    TutorBean tutorBean = new TutorBean();
    UserBean userBean = new UserBean();

    servlet.setLezioneDao(lezioneDao);
    servlet.setTutoratoDidatticoDAO(tutoratoDidatticoDao);
    servlet.setTutorDao(tutorDao);

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");

    when(tutorDao.doRetrieveByEmail(userBean.getEmail())).thenReturn(tutorBean);
    Collection<LezioneBean> list = new ArrayList<>();
    list.add(new LezioneBean());
    list.add(new LezioneBean());
    list.add(new LezioneBean());

    request.getSession().setAttribute("utente", userBean);
    when(lezioneDao.doRetrieveLezioneByStudente(userBean.getEmail())).thenReturn(list);
    request.getSession().setAttribute("listaLezioni", list);

    servlet.doGet(request, response);
    assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato non è nè un tutor nè uno studente
  @Test
  void testViewLezioni4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean userBean = new UserBean();
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("PA");
    request.getSession().setAttribute("utente", userBean);

    servlet.doGet(request, response);
    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }
}
