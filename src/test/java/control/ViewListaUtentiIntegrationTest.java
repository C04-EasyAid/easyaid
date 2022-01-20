package control;

import model.bean.UserBean;
import model.dao.IUserDAO;
import model.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Martina Giugliano
 */
class ViewListaUtentiIntegrationTest {
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
  void testViewListaUtenti()
      throws SQLException, ClassNotFoundException, ServletException, IOException {

    IUserDAO userDao = new UserDAO();
    servlet.setUserDao(userDao);
    UserBean personaleAdm = new UserBean();
    personaleAdm.setNome("Carla");
    personaleAdm.setCognome("Gigli");
    personaleAdm.setEmail("cgigli91@unisa.it");
    personaleAdm.setPassword("C#Gigli#9109");
    personaleAdm.setRuolo("PA");

    request.getSession().setAttribute("utente", personaleAdm);

    servlet.doGet(request, response);

    assertEquals("view/ListaUtentiPage.jsp", response.getRedirectedUrl());
  }
}
