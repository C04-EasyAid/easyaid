package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
/**
 * Testing di integrazione per l' approvazione di una richiesta di servizio.
 *
 * @author Giovanni Toriello
 */
class ApprovazioneRichiestaIntegrationTest {
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
  void ApprovazioneRichiestaTutoratoIntegrationTest()
      throws ServletException, IOException, SQLException {
    IuserDao user = new UserDao();
    String email = "rdistasi@unisa.it";
    request.setParameter("Email", email);
    String password = "R#Distasi#908";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);
    ItutoratoDidatticoDao tutoratoDao = new TutoratoDidatticoDao();
    TutoratoDidatticoBean tutorato = new TutoratoDidatticoBean();
    tutorato.setId(14);
    servlet.doGet(request, response);
  }

  @Test
  void ApprovazioneRichiestaSupportoIntegrationTest()
      throws ServletException, IOException, SQLException {
    IuserDao user = new UserDao();
    String email = "rdistasi@unisa.it";
    request.setParameter("Email", email);
    String password = "R#Distasi#908";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);
    IsupportoEsameDao supportoDAO = new SupportoEsameDao();
    SupportoEsameBean supporto = new SupportoEsameBean();
    supporto.setId(15);
    servlet.doGet(request, response);
  }
}
