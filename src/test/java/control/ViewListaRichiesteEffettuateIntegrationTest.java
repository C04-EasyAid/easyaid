package control;

import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.itutoratodidatticoDao;
import model.dao.supportoesameDao;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Martina Giugliano
 */
class ViewListaRichiesteEffettuateIntegrationTest {
  private ViewListaRichiesteEffettuateServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewListaRichiesteEffettuateServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  // L'utente loggato alla piattaforma è uno studente e può vedere la lista delle richieste
  // effettuate
  @Test
  void testViewListarichiesteEffettuate()
      throws SQLException, ClassNotFoundException, ServletException, IOException {
    itutoratodidatticoDao tutoratoDao = new TutoratoDidatticoDAO();
    ISupportoEsameDAO supportoDao = new supportoesameDao();

    servlet.setSupportoDao(supportoDao);
    servlet.setTutoratoDao(tutoratoDao);

    UserBean studente = new UserBean();
    studente.setEmail("abaglio9@studenti.unisa.it");
    studente.setRuolo("S");
    request.getSession().setAttribute("utente", studente);

    servlet.doGet(request, response);

    assertEquals("view/ListaRichiesteEffettuatePage.jsp", response.getRedirectedUrl());
  }
}
