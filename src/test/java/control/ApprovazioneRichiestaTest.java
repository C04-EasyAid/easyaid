package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.IsupportoEsameDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.SupportoEsameDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Testing per l'approvazione di una richiesta.
 *
 * @author Martina Giugliano
 *
 */
class ApprovazioneRichiestaTest {
  private ApprovazioneRichiestaServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ApprovazioneRichiestaServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testApprovazioneRichiesta1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    ItutoratoDidatticoDao tutoratoDao = mock(TutoratoDidatticoDao.class);
    servlet.setTutoratodao(tutoratoDao);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);

    try {
      when(tutoratoDao.approvaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail()))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta approvata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testApprovazioneRichiesta2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    ItutoratoDidatticoDao tutoratoDao = mock(TutoratoDidatticoDao.class);
    servlet.setTutoratodao(tutoratoDao);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);

    try {
      when(tutoratoDao.approvaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail()))
          .thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertEquals(
        "Richiesta approvata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testApprovazioneRichiesta3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    IsupportoEsameDao supportoDao = mock(SupportoEsameDao.class);
    servlet.setSupportodao(supportoDao);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("supporto", supportoEsameBean);

    try {
      when(supportoDao.approvaRichiesta(supportoEsameBean.getId(), userBean.getEmail()))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta approvata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testApprovazioneRichiesta4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    IsupportoEsameDao supportoDao = mock(SupportoEsameDao.class);
    servlet.setSupportodao(supportoDao);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("supporto", supportoEsameBean);


    try {
      when(supportoDao.approvaRichiesta(supportoEsameBean.getId(), userBean.getEmail()))
          .thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertEquals(
        "Richiesta approvata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testApprovazioneRichiesta5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }
}
