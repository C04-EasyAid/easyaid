package control;
/**
 * @author Serena Liguori
 * Testing per l'inserimento di un commento
 */
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.CommentoDAO;
import model.dao.ICommentoDAO;
import model.dao.IUserDAO;
import model.dao.UserDAO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommentoTest {
    private CommentoServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() {
        servlet = new CommentoServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    void TestInserimentoCommento1(){
        MockitoAnnotations.initMocks(this);
        IUserDAO userDAO = mock(UserDAO.class);
        ICommentoDAO commentoDAO= mock(CommentoDAO.class);
        UserBean tutor = new UserBean();
        tutor.setEmail("lorenzorossi1@studenti.unisa.it");
        tutor.setPassword("Lorenzo#rossi1");
        tutor.setRuolo("T");
        LezioneBean lezione= new LezioneBean();
        lezione.setId(4);
        request.getSession().setAttribute("utente",tutor);
        request.getSession().setAttribute("lezione",lezione);
        String msg="";
        request.setParameter("commento",msg);
        servlet.setDaoC(commentoDAO);
        try {
            when(userDAO.insertStudente(studente,utenteTemporaneo)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        servlet.doGet(request,response);

        assertNotEquals("Utente inserito con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }


    @Test
    void TestInserimentoCommento2(){
        MockitoAnnotations.initMocks(this);
        IUserDAO userDAO = mock(UserDAO.class);
        UserBean tutor = new UserBean();
        tutor.setEmail("lorenzorossi1@studenti.unisa.it");
        tutor.setPassword("Lorenzo#rossi1");
        tutor.setRuolo("T");
        request.getSession().setAttribute("utente",tutor);
    }

    @Test
    void TestInserimentoCommento3(){
        MockitoAnnotations.initMocks(this);
        IUserDAO userDAO = mock(UserDAO.class);
        UserBean tutor = new UserBean();
        tutor.setEmail("lorenzorossi1@studenti.unisa.it");
        tutor.setPassword("Lorenzo#rossi1");
        tutor.setRuolo("T");
        request.getSession().setAttribute("utente",tutor);
    }


}