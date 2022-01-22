package control;

import java.io.IOException;
import java.sql.SQLException;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ItutoratoDidatticoDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Martina Giugliano
 */

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

    ItutoratoDidatticoDao tutoratoDao = new TutoratoDidatticoDao();
    servlet.setTutoratoDao(tutoratoDao);

    TutoratoDidatticoBean esameBean = new TutoratoDidatticoBean();
    esameBean.setId(24);
    request.setParameter("idTutorato", String.valueOf(esameBean.getId()));

    servlet.doGet(request, response);

    assertEquals("view/RichiestaPage.jsp", response.getRedirectedUrl());
  }
}
