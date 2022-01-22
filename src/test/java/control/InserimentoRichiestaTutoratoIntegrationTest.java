package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.IstudenteDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.StudenteDao;
import model.dao.TutoratoDidatticoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


/**
 * Test di intergazione pr la funzionalità: inserimento richiesta tutorato.
 *
 *@author Serena Liguori
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
    void testinserimentorichiestaTutorato1() throws ServletException, IOException,
            SQLException, ClassNotFoundException {

        ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();
        IstudenteDao studenteDao = new StudenteDao();
        servlet.setDao(tutoratoDidatticoDao);
        servlet.setstudenteDao(studenteDao);
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

        int oreRichieste = 5;
        request.setParameter("date_disponibili", dateDisponibili);
        request.setParameter("ore_disponibili", oreDisponibili);
        request.setParameter("ore_richieste", String.valueOf(oreRichieste));
        request.setParameter("insegnamento", insegnamento);
        request.setParameter("dipartimento", dipartimento);
        String docente = "Distasi";
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


        servlet.doGet(request, response);
        assertEquals(
                "Richiesta di servizio di tutorato didattico inserita con successo!",
                Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));

        List<TutoratoDidatticoBean> list =
                tutoratoDidatticoDao.doRetrieveAllByStudente(bean.getEmail());
        tutoratoDidatticoBean = list.get(list.size() - 1);
        tutoratoDidatticoDao.deleteTutorato(tutoratoDidatticoBean);
        studenteDao.updateOreDisponibili(-oreRichieste, email);
    }
}
