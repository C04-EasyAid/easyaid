package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.bean.UserBean;
import model.dao.IsupportoEsameDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.SupportoEsameDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

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

    IsupportoEsameDao supportoEsameDao = new SupportoEsameDao();
    ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();
    servlet.setEsameDao(supportoEsameDao);
    servlet.setTutoratoDao(tutoratoDidatticoDao);

    UserBean bean = new UserBean();
    bean.setNome("Aldo");
    bean.setCognome("De Vito");
    bean.setEmail("adevito11@unisa.it");
    bean.setPassword("Aldo#Dev#1103");
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);

    servlet.doGet(request, response);

    assertEquals("view/RichiesteCompletatePage.jsp", response.getRedirectedUrl());
  }
}
