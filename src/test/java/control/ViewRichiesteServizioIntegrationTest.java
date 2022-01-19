package control;

import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@author Serena Liguori
 class ViewRichiesteServizioIntegrationTest {
    private ViewRichiesteServizioServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() {
        servlet = new ViewRichiesteServizioServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    void testVisualizzaRichiesteServizio() throws SQLException, ClassNotFoundException, ServletException, IOException {

    ISupportoEsameDAO supportoEsameDao = new SupportoEsameDAO();
    ITutoratoDidatticoDAO tutoratoDidatticoDao = new TutoratoDidatticoDAO();
    UserBean bean = new UserBean();
    bean.setNome("Antonio");
    bean.setCognome("De Biase");
    bean.setEmail("adebiase41@studenti.unisa.it");
    bean.setPassword("Antonio#DB123");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);
    servlet.setEsameDAO(supportoEsameDao);
    servlet.setTutoratoDAO(tutoratoDidatticoDao);
    servlet.doGet(request, response);

    assertEquals("view/BachecaTutorPage.jsp", response.getRedirectedUrl());
        }
}
