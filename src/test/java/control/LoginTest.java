package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import model.bean.UserBean;
import model.dao.IuserDao;
import model.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Testing per il Login.
 *
 * @author Giovanni Toriello
 */
class LoginTest {

  private LoginServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new LoginServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // TC_GA_1.1
  @Test
  void testLogin1() throws IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    String email = "prova@email.it";
    request.setParameter("Email", email);
    String password = "admin";
    request.setParameter("password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);

    IuserDao userDao = mock(UserDao.class);
    when(userDao.doRetrieveUtente(bean)).thenReturn(bean);
    servlet.setDao(userDao);
    servlet.doGet(request, response);

    assertEquals(
        "L'operazione non e' andata a buon fine",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  // TC_GA_1.2
  @Test
  void testLogin2() throws IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);

    String email = "abaglio9@studenti.unisa.it";
    request.setParameter("Email", email);
    String password = "admin";
    request.setParameter("password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);

    IuserDao userDao = mock(UserDao.class);
    when(userDao.doRetrieveUtente(bean)).thenReturn(bean);
    servlet.setDao(userDao);
    servlet.doGet(request, response);
    assertEquals(
        "L'operazione non e' andata a buon fine",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  // TC_GA_1.3
  @Test
  void testLogin3() throws IOException, SQLException, ClassNotFoundException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    servlet.setDao(userDao);

    String email = "abaglio9@studenti.unisa.it";
    request.setParameter("Email", email);
    String password = "Aldo#Baglio45";
    request.setParameter("Password", password);
    UserBean bean = new UserBean();
    bean.setEmail(email);
    bean.setPassword(password);

    when(userDao.doRetrieveUtente(bean)).thenReturn(bean);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }
}
