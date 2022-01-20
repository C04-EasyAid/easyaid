package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.itutoratodidatticoDao;
import model.dao.supportoesameDao;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViewRichiesteCompletateTest {
  private ViewRichiesteCompletateServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteCompletateServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // Il professore referente non è loggato alla piattaforma
  @Test
  void testVisualizzaRichiesteCompletate1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato al sistema non è un professore referente e non può visualizzare la lista delle
  // richieste di
  // servizio completate
  @Test
  void testVisualizzaRichiesteCompletate2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean bean = new UserBean();
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }

  // Il tutor è loggato e può visualizzare le richieste di servizio completate
  @Test
  void testVisualizzaRichiesteCompletate3()
      throws SQLException, ClassNotFoundException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    ISupportoEsameDAO supportoEsameDao = mock(supportoesameDao.class);
    itutoratodidatticoDao tutoratoDidatticoDao = mock(TutoratoDidatticoDAO.class);
    UserBean bean = new UserBean();
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);
    List<SupportoEsameBean> listSupporto = new ArrayList<>();
    List<TutoratoDidatticoBean> listTutorati = new ArrayList<>();

    servlet.setesamedao(supportoEsameDao);
    servlet.settutoratoDao(tutoratoDidatticoDao);

    when(supportoEsameDao.doRetrieveAllRichiesteSupportoEsameCompletate()).thenReturn(listSupporto);
    when(tutoratoDidatticoDao.doRetrieveAllRichiesteTutoratoDidatticoCompletate())
        .thenReturn(listTutorati);

    request.getSession().setAttribute("richiesteEsamiNonAccettate", listSupporto);
    request.getSession().setAttribute("richiesteTutoratoNonAccettate", listTutorati);

    servlet.doGet(request, response);

    assertEquals("view/RichiesteCompletatePage.jsp", response.getRedirectedUrl());
  }
}
