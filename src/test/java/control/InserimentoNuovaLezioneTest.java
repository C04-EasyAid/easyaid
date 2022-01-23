package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.LezioneBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.IlezioneDao;
import model.dao.IuserDao;
import model.dao.LezioneDao;
import model.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class InserimentoNuovaLezioneTest {

  private InserimentoNuovaLezioneServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new InserimentoNuovaLezioneServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testInserimentonuovalezione1() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenReturn(true);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione2() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(2);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenReturn(false);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione3() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenReturn(false);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione4() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-05";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione5() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione6() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14 00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione7() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione8() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16 00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione9() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "12:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione10() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edi";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione11() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404, piano terra";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testInserimentonuovalezione12() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404####";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(1);
        when(lezioneDao.insertNewLezione(lezioneBean)).thenThrow(new SQLException());
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertNotEquals(
          "Lezione Inserita",
          Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // L'utente non ha ipermessi necessari
  @Test
  void testInserimentonuovalezione13() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request, response);

    assertEquals("view/LoginPage.jsp", response.getRedirectedUrl());
  }

  // Errore nel metodo countOre per le lezioni
  @Test
  void testInserimentonuovalezione14() throws ParseException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    IuserDao userDao = mock(UserDao.class);
    UserBean userBean = new UserBean();
    TutorBean tutorBean = new TutorBean();
    IlezioneDao lezioneDao = mock(LezioneDao.class);
    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");
    request.getSession().setAttribute("utente", userBean);
    int idTutorato = 18;
    String oraInizio = "14:00";
    String oraFine = "16:00";
    String data = "2022-01-25";
    String luogo = "Edificio F3 aula 404####";
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    request.setParameter("oraInizio", oraInizio);
    request.setParameter("oraFine", oraFine);
    request.setParameter("idTutorato", String.valueOf(idTutorato));
    request.setParameter("data", data);
    request.setParameter("luogo", luogo);
    try {
      Date date = dateParser.parse(data);
      LezioneBean lezioneBean = new LezioneBean();
      lezioneBean.setTutorato(idTutorato);
      lezioneBean.setTutor(userBean.getEmail());
      lezioneBean.setOraInizio(oraInizio);
      lezioneBean.setOraFine(oraFine);
      lezioneBean.setData(date);
      lezioneBean.setLuogo(luogo);
      Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
      lezioni.add(lezioneBean);
      try {
        when(lezioneDao.countOre(lezioni, idTutorato)).thenReturn(2);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      servlet.setLezioneDao(lezioneDao);
      servlet.doGet(request, response);
      assertEquals("view/LezioniTutorPage.jsp", response.getRedirectedUrl());
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
