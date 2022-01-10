package control;
/* @author Martina Giugliano Testing per l'inserimento di una richiesta di tutorato didattico */
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.IUserDAO;
import model.dao.TutorDAO;
import model.dao.UserDAO;
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
    void TestInserimentoRichiestaTutorato1() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato2() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato3() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato4() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato5() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato6() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato7() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato8() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenThrow(new SQLException());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato9() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato10() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato11() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato12() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato13() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato14() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }
    @Test
    void TestInserimentoRichiestaTutorato15() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        IUserDAO userDao = mock(UserDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = mock(ITutoratoDidatticoDAO.class);
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
        String email = bean.getEmail();
        request.setParameter("date_disponibili",dateDisponibili);
        request.setParameter("ore_disponibili",oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento",insegnamento);
        request.setParameter("dipartimento",dipartimento);
        request.setParameter("docente",docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);
        try {
            when(tutoratoDidatticoDAO.InserimentoTutoratoDidattico(tutoratoDidatticoBean)).thenReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertNotEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
    }



}