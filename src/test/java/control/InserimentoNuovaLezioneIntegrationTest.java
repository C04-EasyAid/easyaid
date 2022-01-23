package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.IlezioneDao;
import model.dao.LezioneDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


    /**
    * Test di integrazione per la funzionalità: inserimento nuova lezione.
    *
    * @author Martina Giugliano
    */
    class InserimentoNuovaLezioneIntegrationTest {
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
        void testInserimentoNuovaLezione() throws ParseException, ServletException, IOException,
                ClassNotFoundException {

            UserBean userBean = new UserBean();
            IlezioneDao lezioneDao = new LezioneDao();
            userBean.setNome("Lorenzo");
            userBean.setCognome("Rossi");
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

                servlet.setLezioneDao(lezioneDao);
                servlet.doGet(request, response);
                assertEquals(
                        "Lezione Inserita",
                        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));
                List<LezioneBean> list =
                        (List<LezioneBean>) lezioneDao.doRetrieveLezioniById(idTutorato);
                lezioneBean = list.get(list.size() - 1);
                lezioneDao.deleteLezione(lezioneBean);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

