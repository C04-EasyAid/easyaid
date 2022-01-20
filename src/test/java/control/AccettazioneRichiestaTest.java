package control;
/** @author Martina Giugliano Testing per l'accettazione di una richiesta */
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.itutoratodidatticoDao;
import model.dao.supportoesameDao;
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

class AccettazioneRichiestaTest {
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
  void TestAccettazioneRichiesta1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    itutoratodidatticoDao tutoratoDAO = mock(TutoratoDidatticoDAO.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);
    String msg = null;
    request.setParameter("commento", msg);
    servlet.setTutoratodao(tutoratoDAO);
    try {
      when(tutoratoDAO.accettaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail(), msg))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestAccettazioneRichiesta2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    MockitoAnnotations.initMocks(this);

    itutoratodidatticoDao tutoratoDAO = mock(TutoratoDidatticoDAO.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);
    String msg =
        "Ta5u3NJ38OOADdAD1A2uzHu0Lw8OD7e0v0e0BpT814Y63H3ye7NUbP03pq"
            + "h48nykpup7M1ah0daYYi5028Laxm8vVgUpUi6M5GEBDwvBZsIB8gs7pCeDkz3596e5FtzN1J"
            + "O7Fl7C4YQ870IF8q01w6QWHNYfBuqU9RqeM83AH7414AUpLgc8IQ62Nf3633bgPd7"
            + "WKHrZ2BVFT6rPRBVWkXG5Cm1GYMW1UCephHi0O76hP9Z4fc2TfKNhDMWw2hsCXsynp"
            + "bFjmk6vSL41tSVW03I0LZSjM2D8Q6K6fpRH0Ajy36nZaAS6IY9ZsHECrsV2Z2I51Fh5W"
            + "KEUwYx1tiOc79U28NVA9t9cr6psAMdsOu5syHkenamjUTafSTVC4u5PQWC7denLZO99i5lkzy"
            + "uoNwaR71TJt0KtgL3jFdt565NjencLofL5rDRP1GYsAitGLG572jTKFKTCbTa";
    request.setParameter("commento", msg);
    servlet.setTutoratodao(tutoratoDAO);
    try {
      when(tutoratoDAO.accettaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail(), msg))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestAccettazioneRichiesta3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    MockitoAnnotations.initMocks(this);

    itutoratodidatticoDao tutoratoDAO = mock(TutoratoDidatticoDAO.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("tutorato", tutoratoDidatticoBean);
    String msg = "ok va bene";
    request.setParameter("commento", msg);
    servlet.setTutoratodao(tutoratoDAO);
    try {
      when(tutoratoDAO.accettaRichiesta(tutoratoDidatticoBean.getId(), userBean.getEmail(), msg))
          .thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestAccettazioneRichiesta4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    ISupportoEsameDAO supportoDao = mock(supportoesameDao.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("supporto", supportoEsameBean);
    String msg = null;
    request.setParameter("commento", msg);
    servlet.setSupportodao(supportoDao);
    try {
      when(supportoDao.accettaRichiesta(supportoEsameBean.getId(), userBean.getEmail(), msg))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestAccettazioneRichiesta5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    ISupportoEsameDAO supportoDao = mock(supportoesameDao.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("supporto", supportoEsameBean);
    String msg =
        "Ta5u3NJ38OOADdAD1A2uzHu0Lw8OD7e0v0e0BpT814Y63H3ye7NUbP03pq"
            + "h48nykpup7M1ah0daYYi5028Laxm8vVgUpUi6M5GEBDwvBZsIB8gs7pCeDkz3596e5FtzN1J"
            + "O7Fl7C4YQ870IF8q01w6QWHNYfBuqU9RqeM83AH7414AUpLgc8IQ62Nf3633bgPd7"
            + "WKHrZ2BVFT6rPRBVWkXG5Cm1GYMW1UCephHi0O76hP9Z4fc2TfKNhDMWw2hsCXsynp"
            + "bFjmk6vSL41tSVW03I0LZSjM2D8Q6K6fpRH0Ajy36nZaAS6IY9ZsHECrsV2Z2I51Fh5W"
            + "KEUwYx1tiOc79U28NVA9t9cr6psAMdsOu5syHkenamjUTafSTVC4u5PQWC7denLZO99i5lkzy"
            + "uoNwaR71TJt0KtgL3jFdt565NjencLofL5rDRP1GYsAitGLG572jTKFKTCbTa";
    request.setParameter("commento", msg);
    servlet.setSupportodao(supportoDao);
    try {
      when(supportoDao.accettaRichiesta(supportoEsameBean.getId(), userBean.getEmail(), msg))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertNotEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void TestAccettazioneRichiesta6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    ISupportoEsameDAO supportoDao = mock(supportoesameDao.class);

    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");

    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setId(5);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("supporto", supportoEsameBean);
    String msg = "ok va bene";
    request.setParameter("commento", msg);
    servlet.setSupportodao(supportoDao);
    try {
      when(supportoDao.accettaRichiesta(supportoEsameBean.getId(), userBean.getEmail(), msg))
          .thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.doGet(request, response);

    assertEquals(
        "Richiesta accettata con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }
}
