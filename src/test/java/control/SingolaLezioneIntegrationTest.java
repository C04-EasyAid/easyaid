package control;

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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Serena Liguori
 */
class SingolaLezioneIntegrationTest {
  private SingolaLezioneServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new SingolaLezioneServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testsingolaLezione1()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    UserBean bean = new UserBean();
    bean.setNome("Aldo");
    bean.setCognome("Baglio");
    bean.setEmail("abaglio9@studenti.unisa.it");
    bean.setPassword("Aldo#Baglio45");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);

    LezioneBean lezione = new LezioneBean();
    lezione.setId(11);
    request.setParameter("lezione", String.valueOf(lezione.getId()));

    IlezioneDao lezioneDao = new LezioneDao();
    IcommentoDao commentoDao = new CommentoDao();
    servlet.setLezioneDao(lezioneDao);
    servlet.setCommentiDao(commentoDao);
    lezione = lezioneDao.doRetrieveLezioneById(lezione.getId());
    Collection<CommentoBean> listCommenti = new ArrayList<>();
    listCommenti = commentoDao.doRetrieveCommento(lezione.getId());
    request.getSession().setAttribute("lezione", lezione);
    request.getSession().setAttribute("listaCommenti", listCommenti);
    servlet.doGet(request, response);
    assertEquals("view/LezionePage.jsp", response.getRedirectedUrl());
  }

  @Test
  void testsingolaLezione2()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    UserBean bean = new UserBean();
    bean.setNome("Antonio");
    bean.setCognome("De Biase");
    bean.setEmail("adebiase41@studenti.unisa.it");
    bean.setPassword("Antonio#DB123");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);

    LezioneBean lezione = new LezioneBean();
    lezione.setId(11);
    request.setParameter("lezione", String.valueOf(lezione.getId()));

    IlezioneDao lezioneDao = new LezioneDao();
    IcommentoDao commentoDao = new CommentoDao();
    servlet.setLezioneDao(lezioneDao);
    servlet.setCommentiDao(commentoDao);
    lezione = lezioneDao.doRetrieveLezioneById(lezione.getId());
    Collection<CommentoBean> listCommenti = new ArrayList<>();
    listCommenti = commentoDao.doRetrieveCommento(lezione.getId());
    request.getSession().setAttribute("lezione", lezione);
    request.getSession().setAttribute("listaCommenti", listCommenti);
    servlet.doGet(request, response);
    assertEquals("view/LezionePage.jsp", response.getRedirectedUrl());
  }
}
