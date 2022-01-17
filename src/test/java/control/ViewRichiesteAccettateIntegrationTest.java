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

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class ViewRichiesteAccettateIntegrationTest {
    private ViewRichiesteAccettateServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() {
        servlet = new ViewRichiesteAccettateServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    void viewRichiesteAccettateTest3() throws ServletException, IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        ISupportoEsameDAO supportoEsameDao = new SupportoEsameDAO();
        ITutoratoDidatticoDAO tutoratoDidatticoDao = new TutoratoDidatticoDAO();
        UserBean bean=new UserBean();
        bean.setNome("Antonio");
        bean.setCognome("De Biase");
        bean.setEmail("adebiase41@studenti.unisa.it");
        bean.setPassword("Antonio#DB123");
        bean.setRuolo("T");
        request.getSession().setAttribute("utente",bean);
        servlet.setSupportoDao(supportoEsameDao);
        servlet.setTutoratoDao(tutoratoDidatticoDao);
        servlet.doGet(request, response);

        assertEquals("Operazione riuscita con successo!", request.getSession().getAttribute("alertMsg"));
    }
}
