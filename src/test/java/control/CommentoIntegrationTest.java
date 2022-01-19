package control;

import model.bean.LezioneBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
@author Martina Giugliano
 */
class CommentoIntegrationTest {
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
    void testInserimentoCommentoTutor3() throws ServletException, IOException, SQLException {
        IUserDAO userDao = new UserDAO();
        UserBean userBean = new UserBean();
        TutorBean tutorBean = new TutorBean();

        userBean.setEmail("lorenzorossi1@studenti.unisa.it");
        userBean.setPassword("Lorenzo#rossi1");
        userBean.setRuolo("T");

        LezioneBean lezione = new LezioneBean();
        lezione.setId(4);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("lezione", lezione);
        String msg = "Ok,Ci sarò!";
        request.setParameter("commento", msg);

        ICommentoDAO commentoDao = new CommentoDAO();
        ITutorDAO tutorDao = new TutorDAO();
        servlet.setDaoC(commentoDao);
        servlet.setDaoT(tutorDao);
        commentoDao.insertCommentoTutor(lezione.getId(), msg, userBean.getEmail());
        servlet.doGet(request, response);

        assertEquals(
                "Commento inserito con successo",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }

    @Test
    void testInserimentoCommentoStudente3() throws ServletException, IOException, SQLException {
        IUserDAO userDao = new UserDAO();
        UserBean userBean = new UserBean();
        StudenteBean studenteBean = new StudenteBean();

        userBean.setEmail("abaglio9@studenti.unisa.it");
        userBean.setPassword("Aldo#Baglio45");
        userBean.setRuolo("S");

        LezioneBean lezione = new LezioneBean();
        lezione.setId(4);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("lezione", lezione);
        String msg = "Ok,Ci sarò!";
        request.setParameter("commento", msg);

        ICommentoDAO commentoDao = new CommentoDAO();
        IStudenteDAO studenteDAO = new StudenteDAO();
        servlet.setDaoC(commentoDao);
        servlet.setDaoS(studenteDAO);
        commentoDao.insertCommentoStudente(lezione.getId(), msg, userBean.getEmail());
        servlet.doGet(request, response);

        assertEquals(
                "Commento inserito con successo",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
}
