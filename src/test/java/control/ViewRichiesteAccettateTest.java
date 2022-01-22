package control;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViewRichiesteAccettateTest {

  private ViewRichiesteAccettateServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteAccettateServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente non è loggato nel sistema
  @Test
  void viewRichiesteAccettateTest1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("Permessi non concessi all'utente", request.getSession().getAttribute("alertMsg"));
  }

  // L'utente loggato non è un tutor
  @Test
  void viewRichiesteAccettateTest2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean bean = new UserBean();
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);

    assertEquals("Permessi non concessi all'utente", request.getSession().getAttribute("alertMsg"));
  }

  // L'utente loggato è un tutor
  @Test
  void viewRichiesteAccettateTest3()
      throws ServletException, IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);
    IsupportoEsameDao supportoEsameDao = mock(SupportoEsameDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(TutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("adebiase41@studenti.unisa.it");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);

    List<SupportoEsameBean> listSupporto = new ArrayList<>();
    List<TutoratoDidatticoBean> listTutorati = new ArrayList<>();

    servlet.setSupportoDao(supportoEsameDao);
    servlet.setTutoratoDao(tutoratoDidatticoDao);

    when(supportoEsameDao.doRetrieveAllByTutor(bean.getEmail())).thenReturn(listSupporto);
    when(tutoratoDidatticoDao.doRetrieveAllByTutor(bean.getEmail())).thenReturn(listTutorati);

    request.getSession().setAttribute("richiesteEsamiAccettate", listSupporto);
    request.getSession().setAttribute("richiesteTutoratoAccettate", listTutorati);

    servlet.doGet(request, response);

    assertEquals("view/RichiesteAccettatePage.jsp", response.getRedirectedUrl());
  }
}
