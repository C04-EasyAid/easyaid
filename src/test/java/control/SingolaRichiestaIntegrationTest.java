package control;

/*
@author Martina Giugliano
 */

import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SingolaRichiestaIntegrationTest {
  private SingolaRichiestaServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new SingolaRichiestaServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente è loggato,può visualizzare le informazioni relative alla richiesta di supporto esame
  @Test
  void testSingolaRichiesta() throws IOException, SQLException, ClassNotFoundException {

    UserBean bean = new UserBean();
    request.getSession().setAttribute("utente", bean);

    ITutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();
    servlet.setTutoratoDao(tutoratoDao);

    TutoratoDidatticoBean esameBean = new TutoratoDidatticoBean();
    esameBean.setId(24);
    request.setParameter("idTutorato", String.valueOf(esameBean.getId()));

    servlet.doGet(request, response);

    assertEquals("view/RichiestaPage.jsp", response.getRedirectedUrl());
  }
}
