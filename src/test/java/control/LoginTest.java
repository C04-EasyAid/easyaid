package control;


import model.dao.IUserDAO;
import org.junit.jupiter.api.BeforeEach;
import model.bean.UserBean;
import model.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * @author Giovanni Toriello
 * Testing per il Login
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
        IUserDAO userDAO = mock(UserDAO.class);

        String email ="prova@email.it";
        request.setParameter("Email", email);
        String password = "admin";
        request.setParameter("password", password);
        UserBean bean = new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);

        when(userDAO.doRetrieveUtente(bean)).thenReturn(bean);
        servlet.setDao(userDAO);
        servlet.doGet(request,response);

        assertEquals("L'operazione non e' andata a buon fine", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }

    //TC_GA_1.2
    @Test
    void testLogin2() throws IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDAO = mock(UserDAO.class);
        String email ="abaglio9@studenti.unisa.it";
        request.setParameter("Email", email);
        String password = "admin";
        request.setParameter("password", password);
        UserBean bean = new UserBean();
        bean.setEmail(email);
        bean.setPassword(password);

        when(userDAO.doRetrieveUtente(bean)).thenReturn(bean);
        servlet.setDao(userDAO);
        servlet.doGet(request,response);
        assertEquals("L'operazione non e' andata a buon fine", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }

    //TC_GA_1.3
    @Test
    void testLogin3() throws IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDAO = mock(UserDAO.class);

        String email = "abaglio9@studenti.unisa.it";
        request.setParameter("Email",email);
        String password = "Aldo#Baglio45";
        request.setParameter("Password", password);

        servlet.doGet(request, response);

        assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
    }
}