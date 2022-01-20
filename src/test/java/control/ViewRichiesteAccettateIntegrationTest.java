package control;

import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.itutoratodidatticoDao;
import model.dao.supportoesameDao;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    ISupportoEsameDAO supportoEsameDao = new supportoesameDao();
    itutoratodidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDAO();
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
