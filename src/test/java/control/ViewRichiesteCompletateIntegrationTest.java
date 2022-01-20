package control;

import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@author Serena Liguori
class ViewRichiesteCompletateIntegrationTest {
  private ViewRichiesteCompletateServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteCompletateServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testVisualizzaRichiesteServizio()
      throws SQLException, ClassNotFoundException, ServletException, IOException {

    ISupportoEsameDAO supportoEsameDao = new SupportoEsameDAO();
    ITutoratoDidatticoDAO tutoratoDidatticoDao = new TutoratoDidatticoDAO();
    UserBean bean = new UserBean();
    bean.setNome("Aldo");
    bean.setCognome("De Vito");
    bean.setEmail("adevito11@unisa.it");
    bean.setPassword("Aldo#Dev#1103");
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);
    servlet.setEsameDAO(supportoEsameDao);
    servlet.setTutoratoDAO(tutoratoDidatticoDao);

    servlet.doGet(request, response);

    assertEquals("view/RichiesteCompletatePage.jsp", response.getRedirectedUrl());
  }
}
