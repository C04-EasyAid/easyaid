package control;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

//@author Serena Liguori
class ViewRichiesteServizioIntegrationTest {
  private ViewRichiesteServizioServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteServizioServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testVisualizzaRichiesteServizio()
      throws SQLException, ClassNotFoundException, ServletException, IOException {

    IsupportoEsameDao supportoEsameDao = new SupportoEsameDao();
    ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();
    UserBean bean = new UserBean();
    bean.setNome("Antonio");
    bean.setCognome("De Biase");
    bean.setEmail("adebiase41@studenti.unisa.it");
    bean.setPassword("Antonio#DB123");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);
    servlet.setEsameDao(supportoEsameDao);
    servlet.setTutoratoDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);

    assertEquals("view/BachecaTutorPage.jsp", response.getRedirectedUrl());
  }
}
