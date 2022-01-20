package control;

import model.bean.SupportoEsameBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.SupportoEsameDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@author Serena Liguori
class AccettazioneRichiestaIntegrationTest {
  private AccettazioneRichiestaServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new AccettazioneRichiestaServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testAccettazioneRichiesta() throws ServletException, IOException {
    ISupportoEsameDAO supportoDao = new SupportoEsameDAO();
    UserBean bean = new UserBean();
    bean.setNome("Lorenzo");
    bean.setCognome("Rossi");
    bean.setEmail("lorenzorossi1@studenti.unisa.it");
    bean.setPassword("Lorenzo#rossi1");
    bean.setRuolo("S");
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", bean);
    request.getSession().setAttribute("supporto", supportoEsameBean);
    String msg = "ok va bene";
    request.setParameter("commento", msg);
    servlet.setSupportodao(supportoDao);
    servlet.doGet(request, response);

    assertEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
}
