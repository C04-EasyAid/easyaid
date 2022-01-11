package control;

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

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SingolaRichiestaTest {

    private SingolaRichiestaServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;


    @BeforeEach
    void setUp(){
        servlet = new SingolaRichiestaServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    //L'utente non è loggato
    @Test
    void testSingolaRichiesta1() throws IOException {
        MockitoAnnotations.initMocks(this);

        servlet.doGet(request,response);

        assertEquals("view/LoginPage.jsp",response.getRedirectedUrl());

    }

    //L'utente è loggato,può visualizzare le informazioni relative alla richiesta di supporto esame
    @Test
    void testSingolaRichiesta2() throws IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        UserBean bean = new UserBean();
        request.getSession().setAttribute("utente",bean);

        ISupportoEsameDAO supportoDao = mock(SupportoEsameDAO.class);
        servlet.setSupportoDao(supportoDao);

        SupportoEsameBean esameBean = new SupportoEsameBean();
        esameBean.setId(5);
        request.setParameter("idSupporto", String.valueOf(esameBean.getId()));

        when(supportoDao.doRetriveById(esameBean.getId())).thenReturn(esameBean);

        servlet.doGet(request,response);

        assertEquals("view/RichiestaPage.jsp",response.getRedirectedUrl());

    }

    //L'utente è loggato,può visualizzare le informazioni relative alla richiesta di supporto esame
    @Test
    void testSingolaRichiesta3() throws IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        UserBean bean = new UserBean();
        request.getSession().setAttribute("utente",bean);

        ITutoratoDidatticoDAO tutoratoDao = mock(TutoratoDidatticoDAO.class);
        servlet.setTutoratoDao(tutoratoDao);

        TutoratoDidatticoBean esameBean = new TutoratoDidatticoBean();
        esameBean.setId(5);
        request.setParameter("idTutorato", String.valueOf(esameBean.getId()));

        when(tutoratoDao.doRetriveById(esameBean.getId())).thenReturn(esameBean);

        servlet.doGet(request,response);

        assertEquals("view/RichiestaPage.jsp",response.getRedirectedUrl());

    }

}