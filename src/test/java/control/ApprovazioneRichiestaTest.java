package control;
/** @author Martina Giugliano Testing per l'approvazione di una richiesta */
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApprovazioneRichiestaTest {
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
    void TestApprovazioneRichiesta1() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);

        ITutoratoDidatticoDAO tutoratoDAO = mock(TutoratoDidatticoDAO.class);

        UserBean userBean = new UserBean();

        userBean.setEmail("lorenzorossi1@studenti.unisa.it");

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setId(5);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);

        servlet.setTutoratodao(tutoratoDAO);
        try {
            when(tutoratoDAO.approvaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail())).thenThrow(new SQLException());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.doGet(request, response);

        assertNotEquals("Richiesta approvata con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestApprovazioneRichiesta2() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);

        ITutoratoDidatticoDAO tutoratoDAO = mock(TutoratoDidatticoDAO.class);

        UserBean userBean = new UserBean();

        userBean.setEmail("lorenzorossi1@studenti.unisa.it");

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setId(5);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);

        servlet.setTutoratodao(tutoratoDAO);
        try {
            when(tutoratoDAO.approvaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail())).thenReturn(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.doGet(request, response);

        assertEquals("Richiesta approvata con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestApprovazioneRichiesta3() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);

        ISupportoEsameDAO supportoDAO = mock(SupportoEsameDAO.class);

        UserBean userBean = new UserBean();

        userBean.setEmail("lorenzorossi1@studenti.unisa.it");

        SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
        supportoEsameBean.setId(5);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("supporto", supportoEsameBean);

        servlet.setSupportodao(supportoDAO);
        try {
            when(supportoDAO.approvaRichiesta(supportoEsameBean.getId(),userBean.getEmail())).thenThrow(new SQLException());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.doGet(request, response);

        assertNotEquals("Richiesta approvata con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestApprovazioneRichiesta4() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);

        ISupportoEsameDAO supportoDAO = mock(SupportoEsameDAO.class);

        UserBean userBean = new UserBean();

        userBean.setEmail("lorenzorossi1@studenti.unisa.it");

        SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
        supportoEsameBean.setId(5);
        request.getSession().setAttribute("utente", userBean);
        request.getSession().setAttribute("supporto", supportoEsameBean);

        servlet.setSupportodao(supportoDAO);
        try {
            when(supportoDAO.approvaRichiesta(supportoEsameBean.getId(), userBean.getEmail())).thenReturn(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.doGet(request, response);

        assertEquals("Richiesta approvata con successo", Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }

    @Test
    void testApprovazioneRichiesta5() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);

        servlet.doGet(request,response);

        assertEquals("view/HomePage.jsp",response.getRedirectedUrl());
    }


}