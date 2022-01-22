package model.dao;

import model.bean.TutoratoDidatticoBean;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TutoratoDidatticoDAOTest {

    private final TutoratoDidatticoDao dao = new TutoratoDidatticoDao();

    @Test
    void doRetrieveAllByStudente1() throws SQLException, ClassNotFoundException {
       String email = "paolorossi10@studenti.unisa.it";
       List<TutoratoDidatticoBean> expected = new ArrayList<>();
       expected.add(new TutoratoDidatticoBean());
       expected.add(new TutoratoDidatticoBean());
       expected.add(new TutoratoDidatticoBean());
       expected.add(new TutoratoDidatticoBean());
       expected.add(new TutoratoDidatticoBean());

       List<TutoratoDidatticoBean> result = dao.doRetrieveAllByStudente(email);

       assertEquals(expected.size(),result.size());
    }

    @Test
    void doRetrieveAllByStudente2() throws SQLException, ClassNotFoundException {
        String email = "";
        List<TutoratoDidatticoBean> expected = new ArrayList<>();

        List<TutoratoDidatticoBean> result = dao.doRetrieveAllByStudente(email);

        assertEquals(expected,result);
    }

    @Test
    void doRetrieveAllByTutor1() throws SQLException, ClassNotFoundException {
        String email = "paoloserrati23@studenti.unisa.it";
        List<TutoratoDidatticoBean> expected = new ArrayList<>();
        expected.add(new TutoratoDidatticoBean());
        expected.add(new TutoratoDidatticoBean());
        expected.add(new TutoratoDidatticoBean());
        expected.add(new TutoratoDidatticoBean());

        List<TutoratoDidatticoBean> result = dao.doRetrieveAllByTutor(email);

        assertEquals(expected.size(),result.size());

    }

    @Test
    void doRetrieveAllByTutor2() throws SQLException, ClassNotFoundException {
        String email = "";
        List<TutoratoDidatticoBean> expected = new ArrayList<>();

        List<TutoratoDidatticoBean> result = dao.doRetrieveAllByTutor(email);

        assertEquals(expected,result);
    }

    @Test
    void doRetrieveAllRichiesteTutoratoDidatticoCompletate() throws SQLException, ClassNotFoundException {
        List<TutoratoDidatticoBean> expected = new ArrayList<>();
        expected.add(new TutoratoDidatticoBean());
        expected.add(new TutoratoDidatticoBean());

        List<TutoratoDidatticoBean> result = dao.doRetrieveAllRichiesteTutoratoDidatticoCompletate();

        assertEquals(expected.size(),result.size());

    }


    @Test
    void doRetrieveRichiesteTutoratoDidatticoNonAccettate() throws SQLException, ClassNotFoundException {
        List<TutoratoDidatticoBean> expected = new ArrayList<>();
        expected.add(new TutoratoDidatticoBean());

        List<TutoratoDidatticoBean> result = dao.doRetrieveRichiesteTutoratoDidatticoNonAccettate();

        assertEquals(expected.size(),result.size());

    }

    @Test
    void doRetriveById1() throws SQLException, ClassNotFoundException {

        TutoratoDidatticoBean expected = new TutoratoDidatticoBean();
        expected.setId(14);

        TutoratoDidatticoBean result = dao.doRetriveById(14);

        assertEquals(expected.getId(),result.getId());

    }

    @Test
    void doRetriveById2() throws SQLException, ClassNotFoundException {

        TutoratoDidatticoBean expected = null;

        TutoratoDidatticoBean result = dao.doRetriveById(0);

        assertEquals(expected,result);
    }

    @Test
    void inserimentoTutoratoDidattico() throws SQLException, ClassNotFoundException {
        String email = "paolorossi10@studenti.unisa.it";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 5;

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        assertEquals(true,dao.inserimentoTutoratoDidattico(tutoratoDidatticoBean));
        List<TutoratoDidatticoBean> list = dao.doRetrieveAllByStudente(email);
        tutoratoDidatticoBean = list.get(list.size()-1);
        dao.deleteTutorato(tutoratoDidatticoBean);

    }

    @Test
    void accettaRichiesta() throws SQLException, ClassNotFoundException {
        String email = "paolorossi10@studenti.unisa.it";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 5;

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        assertEquals(true,dao.inserimentoTutoratoDidattico(tutoratoDidatticoBean));
        List<TutoratoDidatticoBean> list = dao.doRetrieveAllByStudente(email);
        tutoratoDidatticoBean = list.get(list.size()-1);

        String emailTutor = "adebiase41@studenti.unisa.it";
        String commento = "Ok,va bene!";

        assertEquals(true,dao.accettaRichiesta(tutoratoDidatticoBean.getId(),emailTutor,commento));

        dao.deleteTutorato(tutoratoDidatticoBean);
    }

    @Test
    void approvaRichiesta() throws SQLException, ClassNotFoundException {

        String email = "paolorossi10@studenti.unisa.it";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 5;

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        assertEquals(true,dao.inserimentoTutoratoDidattico(tutoratoDidatticoBean));
        List<TutoratoDidatticoBean> list = dao.doRetrieveAllByStudente(email);
        tutoratoDidatticoBean = list.get(list.size()-1);

        String emailTutor = "adebiase41@studenti.unisa.it";
        String commento = "Ok,va bene!";
        String emailProf ="gporetti89@unisa.it";

        dao.accettaRichiesta(tutoratoDidatticoBean.getId(),emailTutor,commento);
        assertEquals(true, dao.approvaRichiesta(tutoratoDidatticoBean.getId(),emailProf));

        dao.deleteTutorato(tutoratoDidatticoBean);

    }

    @Test
    void completaRichiesta() throws SQLException, ClassNotFoundException {
        String email = "paolorossi10@studenti.unisa.it";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 5;

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        assertEquals(true,dao.inserimentoTutoratoDidattico(tutoratoDidatticoBean));
        List<TutoratoDidatticoBean> list = dao.doRetrieveAllByStudente(email);
        tutoratoDidatticoBean = list.get(list.size()-1);

        String emailTutor = "adebiase41@studenti.unisa.it";
        String commento = "Ok,va bene!";

        dao.accettaRichiesta(tutoratoDidatticoBean.getId(),emailTutor,commento);
        assertEquals(true,dao.completaRichiesta(tutoratoDidatticoBean.getId(),emailTutor));

        dao.deleteTutorato(tutoratoDidatticoBean);

    }

    @Test
    void deleteTutorato1() throws SQLException, ClassNotFoundException {
        String email = "paolorossi10@studenti.unisa.it";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String dateDisponibili = "Martedi,Mercoledì";
        String oreDisponibili = "14:00-16:00,18:00-20:00";
        String docente = "Distasi";
        int oreRichieste = 5;

        TutoratoDidatticoBean tutoratoDidatticoBean = new TutoratoDidatticoBean();
        tutoratoDidatticoBean.setDocente(docente);
        tutoratoDidatticoBean.setStudenteEmail(email);
        tutoratoDidatticoBean.setDateDisponibili(dateDisponibili);
        tutoratoDidatticoBean.setDipartimento(dipartimento);
        tutoratoDidatticoBean.setOreRichieste(oreRichieste);
        tutoratoDidatticoBean.setInsegnamento(insegnamento);
        tutoratoDidatticoBean.setStatus(0);
        tutoratoDidatticoBean.setOreDisponibili(oreDisponibili);

        dao.inserimentoTutoratoDidattico(tutoratoDidatticoBean);
        List<TutoratoDidatticoBean> list = dao.doRetrieveAllByStudente(email);
        tutoratoDidatticoBean = list.get(list.size()-1);
        assertEquals(true,dao.deleteTutorato(tutoratoDidatticoBean));

    }

    @Test
    void deleteTutorato2() throws SQLException {
        String email = "abaglio9@studenti.unisa.it";

        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();

        assertEquals(false,dao.deleteTutorato(bean));

    }

}