package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.StudenteBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.IstudenteDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.IuserDao;
import model.dao.StudenteDao;
import model.dao.TutoratoDidatticoDao;
import model.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Testing per l'inserimento di una richiesta di tutorato didattico.
 *
 * @author Martina Giugliano
 *
 */
class InserimentoRichiestaTutoratoTest {

  private InserimentoRichiestaTutoratoServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new InserimentoRichiestaTutoratoServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testinserimentorichiestaTutorato1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(TutoratoDidatticoDao.class);
    IstudenteDao studenteDao = mock(StudenteDao.class);

    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informatica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 5;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

    StudenteBean studente = new StudenteBean();
    studente.setOreDisponibili(22);
    try {
      when(studenteDao.doRetrieveByEmail(email)).thenReturn(studente);
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setstudenteDao(studenteDao);
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Pr";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Prograngngnghnmmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;

    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programm<%£azione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 0;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 30;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;

    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;

    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi#";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;

    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato11() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "08";
    String docente = "Distasi";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14#:00-16#00,18#00-20:00";
    String docente = "Distasi";
    int oreRichieste = 20;

    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato13() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "D";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato14() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Distahthgfhfghgfhsi";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void testinserimentorichiestaTutorato15() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    ItutoratoDidatticoDao tutoratoDidatticoDao = mock(ItutoratoDidatticoDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String dateDisponibili = "Martedi,Mercoledì";
    String oreDisponibili = "14:00-16:00,18:00-20:00";
    String docente = "Dista#si";
    int oreRichieste = 20;
    request.setParameter("date_disponibili", dateDisponibili);
    request.setParameter("ore_disponibili", oreDisponibili);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("docente", docente);
    TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
    tutoratoDidatticoBean.setDocente(docente);
    String email = bean.getEmail();
    tutoratoDidatticoBean.setStudenteEmail(email);
    tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
    tutoratoDidatticoBean.setDipartimento(dipartimento);
    tutoratoDidatticoBean.setOreRichieste(oreRichieste);
    tutoratoDidatticoBean.setInsegnamento(insegnamento);
    tutoratoDidatticoBean.setStatus(0);
    tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
    try {
      when(tutoratoDidatticoDao.inserimentoTutoratoDidattico(tutoratoDidatticoBean))
          .thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setDao(tutoratoDidatticoDao);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di tutorato didattico inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  // Permessi non concessi all'utente
  @Test
  void testinserimentorichiestaTutorato16() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("T");
    request.getSession().setAttribute("utente", bean);

    servlet.doGet(request, response);

    assertEquals("view/HomePage.jsp", response.getRedirectedUrl());
  }
}
