package control;
/* @author Martina Giugliano Testing per l'inserimento di una richiesta di supporto esame */
import model.bean.SupportoEsameBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InserimentoSupportoTest {
  private InserimentoRichiestaSupportoServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new InserimentoRichiestaSupportoServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void InserimentoSupportoTest() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Pr";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest3() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Prograhgfhfhfghgfhgfhgfmmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest4() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Progra#####mmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest5() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest6() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest7() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest8() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16#00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest9() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 0;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest10() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 6;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest11() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean))
          .thenThrow(new SQLException());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest12() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "D";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest13() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distgbgbgvgbgbgbgbgbgbgbbgbgasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest14() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi###";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest15() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Ed";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest16() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18,Piano Terra";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest17() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio #F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest18() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest19() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "Tempo Aggiuntivo";
    String tipoAssistenza = "";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  @Test
  void InserimentoSupportoTest20() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    iuserDao userDao = mock(UserDAO.class);
    ISupportoEsameDAO supportoEsameDAO = mock(supportoesameDao.class);
    UserBean bean = new UserBean();
    bean.setEmail("paolorossi10@studenti.unisa.it");
    bean.setPassword("Paolo#Rossi10");
    bean.setRuolo("S");
    request.getSession().setAttribute("utente", bean);
    String data = "2021-12-11";
    String ora = "16:00";
    int oreRichieste = 3;
    String modalitaEsame = "Scritto";
    String eventualiAusili = "";
    String tipoAssistenza = "Tutor Lettore";
    String luogo = "Edificio F3 Aula 18";
    String dipartimento = "Informarica";
    String insegnamento = "Programmazione I";
    String docente = "Distasi";
    String email = bean.getEmail();
    request.setParameter("dipartimento", dipartimento);
    request.setParameter("insegnamento", insegnamento);
    request.setParameter("data", data);
    request.setParameter("ora", ora);
    request.setParameter("ore_richieste", String.valueOf(oreRichieste));
    request.setParameter("docente", docente);
    request.setParameter("luogo", luogo);
    request.setParameter("modalita_esame", modalitaEsame);
    request.setParameter("tipo_di_assistenza", tipoAssistenza);
    request.setParameter("eventuali_ausili", eventualiAusili);
    SupportoEsameBean supportoEsameBean = new SupportoEsameBean();
    supportoEsameBean.setData(data);
    supportoEsameBean.setDipartimento(dipartimento);
    supportoEsameBean.setDocente(docente);
    supportoEsameBean.setInsegnamento(insegnamento);
    supportoEsameBean.setLuogo(luogo);
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setOra(ora);
    supportoEsameBean.setOreRichieste(oreRichieste);
    supportoEsameBean.setStatus(0);
    supportoEsameBean.setStudenteEmail(bean.getEmail());
    supportoEsameBean.setEventualiAusili(eventualiAusili);
    supportoEsameBean.setTipoAssistenza(tipoAssistenza);
    supportoEsameBean.setModalitaEsame(modalitaEsame);
    try {
      when(supportoEsameDAO.InserimentoSupportoEsame(supportoEsameBean)).thenReturn(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    servlet.setsupportoesameDao(supportoEsameDAO);
    servlet.doGet(request, response);
    assertNotEquals(
        "Richiesta di servizio di supporto esame inserita con successo!",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
  }

  // permessi non concessi all'utente
  @Test
  void InserimentoSupportotest21() throws ServletException, IOException {
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
