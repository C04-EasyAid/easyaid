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

/*
@author Serena Liguori
 */
class ViewRichiesteAccettateIntegrationTest {
  private ViewRichiesteAccettateServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewRichiesteAccettateServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void viewRichiesteAccettateTest()
      throws ServletException, IOException, SQLException, ClassNotFoundException {

    IsupportoEsameDao supportoEsameDao = new SupportoEsameDao();
    ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();
    UserBean bean = new UserBean();
    bean.setNome("Antonio");
    bean.setCognome("De Biase");
    bean.setEmail("adebiase41@studenti.unisa.it");
    bean.setPassword("Antonio#DB123");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);
    servlet.setSupportoDao(supportoEsameDao);
    servlet.setTutoratoDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);

    assertEquals("view/RichiesteAccettatePage.jsp", response.getRedirectedUrl());
  }
}
