package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.CommentoDao;
import model.dao.IcommentoDao;
import model.dao.IlezioneDao;
import model.dao.LezioneDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class SingolaLezioneTest {

  private SingolaLezioneServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new SingolaLezioneServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // l'utente non è loggato,dunque non può visualizzare le informazioni della singola lezione
  @Test
  void testsingolaLezione1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato non è nè uno studente nè un tutor,dunque non può vedere le informazioni della
  // singola lezione
  @Test
  void testsingolaLezione2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    UserBean bean = new UserBean();
    bean.setRuolo("PA");
    request.getSession().setAttribute("utente", bean);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è uno studente,dunque puoò vedere le informazioni della singola lezione
  @Test
  void testsingolaLezione3()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    UserBean userBean = new UserBean();
    userBean.setRuolo("S");
    request.getSession().setAttribute("utente", userBean);

    LezioneBean lezioneBean = new LezioneBean();
    lezioneBean.setId(5);
    request.setParameter("lezione", String.valueOf(lezioneBean.getId()));

    IlezioneDao lezioneDao = mock(LezioneDao.class);
    IcommentoDao commentoDao = mock(CommentoDao.class);

    servlet.setLezioneDao(lezioneDao);
    servlet.setCommentiDao(commentoDao);

    Collection<CommentoBean> listCommenti = new ArrayList<>();
    listCommenti.add(new CommentoBean());
    listCommenti.add(new CommentoBean());
    listCommenti.add(new CommentoBean());

    when(lezioneDao.doRetrieveLezioneById(lezioneBean.getId())).thenReturn(lezioneBean);
    when(commentoDao.doRetrieveCommento(lezioneBean.getId())).thenReturn(listCommenti);

    request.getSession().setAttribute("lezione", lezioneBean);
    request.getSession().setAttribute("listaCommenti", listCommenti);

    servlet.doGet(request, response);

    assertEquals("view/LezionePage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un tutor,dunque puoò vedere le informazioni della singola lezione
  @Test
  void testsingolaLezione4()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    UserBean userBean = new UserBean();
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);

    LezioneBean lezioneBean = new LezioneBean();
    lezioneBean.setId(5);
    request.setParameter("lezione", String.valueOf(lezioneBean.getId()));

    IlezioneDao lezioneDao = mock(LezioneDao.class);
    IcommentoDao commentoDao = mock(CommentoDao.class);

    servlet.setLezioneDao(lezioneDao);
    servlet.setCommentiDao(commentoDao);

    Collection<CommentoBean> listCommenti = new ArrayList<>();
    listCommenti.add(new CommentoBean());
    listCommenti.add(new CommentoBean());
    listCommenti.add(new CommentoBean());

    when(lezioneDao.doRetrieveLezioneById(lezioneBean.getId())).thenReturn(lezioneBean);
    when(commentoDao.doRetrieveCommento(lezioneBean.getId())).thenReturn(listCommenti);

    request.getSession().setAttribute("lezione", lezioneBean);
    request.getSession().setAttribute("listaCommenti", listCommenti);

    servlet.doGet(request, response);

    assertEquals("view/LezionePage.jsp", response.getRedirectedUrl());
  }
}
