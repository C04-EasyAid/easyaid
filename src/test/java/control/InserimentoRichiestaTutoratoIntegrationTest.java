package control;

import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.IUserDAO;
import model.dao.TutoratoDidatticoDAO;
import model.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@author Serena Liguori
 */
class InserimentoRichiestaTutoratoIntegrationTest {
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
    void TestInserimentoRichiestaTutorato1() throws ServletException, IOException, SQLException {

        IUserDAO userDao = new UserDAO();
        ITutoratoDidatticoDAO tutoratoDidatticoDAO = new TutoratoDidatticoDAO();
        UserBean bean = new UserBean();
        bean.setNome("Paolo");
        bean.setCognome("Rossi");
        bean.setEmail("paolorossi10@studenti.unisa.it");
        bean.setPassword("Paolo#Rossi10");
        bean.setRuolo("S");
        request.getSession().setAttribute("utente", bean);
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 20;
        String email = bean.getEmail();
        request.setParameter("date_disponibili", dateDisponibili);
        request.setParameter("ore_disponibili", oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento", insegnamento);
        request.setParameter("dipartimento", dipartimento);
        request.setParameter("docente", docente);
        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        servlet.setDao(tutoratoDidatticoDAO);
        servlet.doGet(request, response);
        assertEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
        tutoratoDidatticoDAO.deleteTutorato(tutoratoDidatticoBean);
    }
}
