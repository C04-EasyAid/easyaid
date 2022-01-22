package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import model.bean.UserBean;
import model.dao.IuserDao;
import model.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViewListaUtentiTest {

  private ViewListaUtentiServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewListaUtentiServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente loggato è un personale amministrativo,dunque può vedere la lista degli utenti del
  // sistema
  @Test
  void testViewListaUtenti1()
      throws SQLException, ClassNotFoundException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);

    servlet.setUserDao(userDao);
    UserBean personaleAdm = new UserBean();
    personaleAdm.setRuolo("PA");

    request.getSession().setAttribute("utente", personaleAdm);

    Collection<UserBean> utenti = new ArrayList<>();
    utenti.add(new UserBean());
    utenti.add(new UserBean());
    utenti.add(new UserBean());

    when(userDao.doRetrieveAll()).thenReturn(utenti);
    request.getSession().setAttribute("usrList", utenti);

    servlet.doGet(request, response);

    assertEquals("view/ListaUtentiPage.jsp", response.getRedirectedUrl());
  }

  // L'utente non è loggato
  @Test
  void testViewListaUtenti2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // L'utente loggato non è un personale amministrativo
  @Test
  void testViewListaUtenti3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean bean = new UserBean();
    bean.setRuolo("S");

    request.getSession().setAttribute("utente", bean);
    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }
}
