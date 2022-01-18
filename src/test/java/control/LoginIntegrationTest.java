package control;

import model.bean.UserBean;
import model.dao.IUserDAO;
import model.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
/**
 *Testing di integrazione per il Login.
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
void LoginIntegrationTest1() throws IOException {
        IUserDAO user = new UserDAO();
        String email = "abaglio9@studenti.unisa.it";
        request.setParameter("Email", email);
        String password = "Aldo#Baglio45";
        request.setParameter("Password", password);
        UserBean bean=new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRuolo("S");
        request.getSession().setAttribute("utente", bean);
        servlet.doGet(request,response);

    }
    @Test
    void LoginIntegrationTest2() throws IOException {
        IUserDAO user = new UserDAO();
        String email = "lorenzorossi1@studenti.unisa.it";
        request.setParameter("Email", email);
        String password = "Lorenzo#rossi11";
        request.setParameter("Password", password);
        UserBean bean=new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRuolo("T");
        request.getSession().setAttribute("utente", bean);
        servlet.doGet(request,response);

    }
    @Test
    void LoginIntegrationTest3() throws IOException {
        IUserDAO user = new UserDAO();
        String email = "rdistasi@unisa.it";
        request.setParameter("Email", email);
        String password = "R#Distasi#908";
        request.setParameter("Password", password);
        UserBean bean=new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRuolo("P");
        request.getSession().setAttribute("utente", bean);
        servlet.doGet(request,response);

    }
    @Test
    void LoginIntegrationTest4() throws IOException {
        IUserDAO user = new UserDAO();
        String email = "cgigli91@unisa.it";
        request.setParameter("Email", email);
        String password = "C#Gigli#9109";
        request.setParameter("Password", password);
        UserBean bean=new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRuolo("PA");
        request.getSession().setAttribute("utente", bean);
        servlet.doGet(request,response);

    }
}