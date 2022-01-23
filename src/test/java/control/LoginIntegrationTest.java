package control;

import java.io.IOException;
import model.bean.UserBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


/**
 * Testing di integrazione per il Login.
 *
 * @author Giovanni Toriello
 *
 */

class LoginIntegrationTest {
  private LoginServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new LoginServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void loginintegrationTest1() throws IOException {
    String email = "abaglio9@studenti.unisa.it";
    request.setParameter("Email", email);
    String password = "Aldo#Baglio45";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);
  }

  @Test
  void loginintegrationTest2() throws IOException {
    String email = "lorenzorossi1@studenti.unisa.it";
    request.setParameter("Email", email);
    String password = "Lorenzo#rossi11";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);
  }

  @Test
  void loginintegrationTest3() throws IOException {
    String email = "rdistasi@unisa.it";
    request.setParameter("Email", email);
    String password = "R#Distasi#908";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("P");
    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);
  }

  @Test
  void loginintegrationTest4() throws IOException {
    String email = "cgigli91@unisa.it";
    request.setParameter("Email", email);
    String password = "C#Gigli#9109";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);
    bean.setRuolo("PA");
    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);
  }
}
