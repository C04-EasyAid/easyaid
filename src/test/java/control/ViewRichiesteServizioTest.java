package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

class ViewRichiesteServizioTest {
  private ViewRichiesteServizioServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteServizioServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // Il tutor non è loggato alla piattaforma
  @Test
  void testVisualizzaRichiesteServizio1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato al sistema non è un tutor e non può visualizzare la lista delle richieste di
  // servizio non accettate
  @Test
  void testVisualizzaRichiesteServizio2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean bean = new UserBean();
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }

  // Il tutor è loggato e può visualizzare le richieste di servizio non accettate
  @Test
  void testVisualizzaRichiesteServizio3()
      throws SQLException, ClassNotFoundException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IsupportoEsameDao supportoEsameDao = mock(SupportoEsameDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(TutoratoDidatticoDao.class);
    servlet.setEsameDao(supportoEsameDao);
    servlet.setTutoratoDao(tutoratoDidatticoDao);

    UserBean bean = new UserBean();
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);
    List<SupportoEsameBean> listSupporto = new ArrayList<>();
    List<TutoratoDidatticoBean> listTutorati = new ArrayList<>();

    when(supportoEsameDao.doRetrieveRichiesteSupportoEsameNonAccettate()).thenReturn(listSupporto);
    when(tutoratoDidatticoDao.doRetrieveRichiesteTutoratoDidatticoNonAccettate())
        .thenReturn(listTutorati);

    request.getSession().setAttribute("richiesteEsamiNonAccettate", listSupporto);
    request.getSession().setAttribute("richiesteTutoratoNonAccettate", listTutorati);

    servlet.doGet(request, response);

    assertEquals("view/BachecaTutorPage.jsp", response.getRedirectedUrl());
  }
}
