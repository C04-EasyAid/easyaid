package control;

import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.CommentoDAO;
import model.dao.ICommentoDAO;
import model.dao.ILezioneDAO;
import model.dao.LezioneDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SingolaLezioneIntegrationTest {
    private SingolaLezioneServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new SingolaLezioneServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
        }

    @Test
    void testsingolaLezione1() throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserBean bean = new UserBean();
        bean.setNome("Aldo");
        bean.setCognome("Baglio");
        bean.setEmail("abaglio9@studenti.unisa.it");
        bean.setPassword("Aldo#Baglio45");
        bean.setRuolo("S");
        request.getSession().setAttribute("utente",bean);

        LezioneBean lezione = new LezioneBean();
        lezione.setId(11);
        request.setParameter("lezione", String.valueOf(lezione.getId()));

        ILezioneDAO lezioneDao = new LezioneDAO();
        ICommentoDAO commentoDao = new CommentoDAO();
        servlet.setLezioneDao(lezioneDao);
        servlet.setCommentiDao(commentoDao);
        lezione= lezioneDao.doRetrieveLezioneById(lezione.getId());
        Collection<CommentoBean> listCommenti = new ArrayList<>();
        listCommenti=commentoDao.doRetrieveCommento(lezione.getId());
        request.getSession().setAttribute("lezione",lezione);
        request.getSession().setAttribute("listaCommenti",listCommenti);
        servlet.doGet(request,response);
        assertEquals("view/LezionePage.jsp",response.getRedirectedUrl());
    }

    @Test
    void testsingolaLezione2() throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserBean bean = new UserBean();
        bean.setNome("Antonio");
        bean.setCognome("De Biase");
        bean.setEmail("adebiase41@studenti.unisa.it");
        bean.setPassword("Antonio#DB123");
        bean.setRuolo("T");
        request.getSession().setAttribute("utente",bean);

        LezioneBean lezione = new LezioneBean();
        lezione.setId(11);
        request.setParameter("lezione", String.valueOf(lezione.getId()));

        ILezioneDAO lezioneDao = new LezioneDAO();
        ICommentoDAO commentoDao = new CommentoDAO();
        servlet.setLezioneDao(lezioneDao);
        servlet.setCommentiDao(commentoDao);
        lezione= lezioneDao.doRetrieveLezioneById(lezione.getId());
        Collection<CommentoBean> listCommenti = new ArrayList<>();
        listCommenti=commentoDao.doRetrieveCommento(lezione.getId());
        request.getSession().setAttribute("lezione",lezione);
        request.getSession().setAttribute("listaCommenti",listCommenti);
        servlet.doGet(request,response);
        assertEquals("view/LezionePage.jsp",response.getRedirectedUrl());
    }
}
