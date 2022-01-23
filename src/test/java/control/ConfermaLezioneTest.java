package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.IlezioneDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.LezioneDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Test di integrazione conferma lezione.
 *
 * @author Serena Liguori
 *
 */

class ConfermaLezioneTest {

  private ConfermaLezioneServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ConfermaLezioneServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente non è loggato
  @Test
  void testConfermaLezione1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato non è un tutor
  @Test
  void testConfermaLezione2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean user = new UserBean();
    user.setRuolo("S");
    request.getSession().setAttribute("utente", user);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un tutor,e può confermare l'ultima lezione
  @Test
  void testConfermaLezione3()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);
    UserBean user = new UserBean();
    user.setEmail("lorenzorossi1@studenti.unisa.it");
    user.setRuolo("T");
    request.getSession().setAttribute("utente", user);

    LezioneBean lezione = new LezioneBean();
    lezione.setId(5);
    lezione.setTutorato(24);
    request.getSession().setAttribute("lezione", lezione);

    IlezioneDao lezioneDao = mock(LezioneDao.class);
    ItutoratoDidatticoDao tutoratoDao = mock(TutoratoDidatticoDao.class);

    servlet.setlezioneDao(lezioneDao);
    servlet.settutoratodidatticoDao(tutoratoDao);

    Collection<LezioneBean> lezioni = new ArrayList<>();
    lezioni.add(new LezioneBean());
    lezioni.add(new LezioneBean());
    lezioni.add(new LezioneBean());

    when(lezioneDao.confermaLezione(lezione.getId())).thenReturn(true);
    when(lezioneDao.doRetrieveLezioniCompletateById(lezione.getTutorato())).thenReturn(lezioni);
    when(tutoratoDao.completaRichiesta(lezione.getTutorato(), user.getEmail())).thenReturn(true);
    when(lezioneDao.countOre(lezioni, lezione.getTutorato())).thenReturn(0);

    servlet.doGet(request, response);

    assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato è un tutor,e può confermare la  lezione
  @Test
  void testConfermaLezione4()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);
    UserBean user = new UserBean();
    user.setEmail("lorenzorossi1@studenti.unisa.it");
    user.setRuolo("T");
    request.getSession().setAttribute("utente", user);

    LezioneBean lezione = new LezioneBean();
    lezione.setId(5);
    lezione.setTutorato(24);
    request.getSession().setAttribute("lezione", lezione);

    IlezioneDao lezioneDao = mock(LezioneDao.class);
    ItutoratoDidatticoDao tutoratoDao = mock(TutoratoDidatticoDao.class);

    servlet.setlezioneDao(lezioneDao);
    servlet.settutoratodidatticoDao(tutoratoDao);

    Collection<LezioneBean> lezioni = new ArrayList<>();
    lezioni.add(new LezioneBean());
    lezioni.add(new LezioneBean());
    lezioni.add(new LezioneBean());

    when(lezioneDao.confermaLezione(lezione.getId())).thenReturn(true);
    when(lezioneDao.doRetrieveLezioniCompletateById(lezione.getTutorato())).thenReturn(lezioni);
    when(tutoratoDao.completaRichiesta(lezione.getTutorato(), user.getEmail())).thenReturn(true);
    when(lezioneDao.countOre(lezioni, lezione.getTutorato())).thenReturn(1);

    servlet.doGet(request, response);

    assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
  }
}
