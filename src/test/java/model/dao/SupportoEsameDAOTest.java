package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.SupportoEsameBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupportoEsameDAOTest {

    private final SupportoEsameDao dao = new SupportoEsameDao();

    @Test
    void doRetrieveAllByStudente() throws SQLException, ClassNotFoundException {
        List<SupportoEsameBean> expected = new ArrayList<>();
        expected.add(new SupportoEsameBean());

        String email = "abaglio9@studenti.unisa.it";

        List<SupportoEsameBean> result = dao.doRetrieveAllByStudente(email);

        assertEquals(expected.size(), result.size());

    }

    @Test
    void doRetrieveAllByTutor() throws SQLException, ClassNotFoundException {
        List<SupportoEsameBean> expected = new ArrayList<>();
        expected.add(new SupportoEsameBean());

        String email = "lorenzorossi1@studenti.unisa.it";

        List<SupportoEsameBean> result = dao.doRetrieveAllByTutor(email);

        assertEquals(expected.size(), result.size());

    }



    @Test
    void doRetrieveAllRichiesteSupportoEsameCompletate()
            throws SQLException, ClassNotFoundException {

        List<SupportoEsameBean> expected = new ArrayList<>();
        expected.add(new SupportoEsameBean());

        List<SupportoEsameBean> result = dao.doRetrieveAllRichiesteSupportoEsameCompletate();

        assertEquals(expected.size(), result.size());
    }

    @Test
    void doRetrieveRichiesteSupportoEsameNonAccettate()
            throws SQLException, ClassNotFoundException {
        List<SupportoEsameBean> expected = new ArrayList<>();
        expected.add(new SupportoEsameBean());


        List<SupportoEsameBean> result = dao.doRetrieveRichiesteSupportoEsameNonAccettate();

        assertEquals(expected.size(), result.size());
    }

    @Test
    void doRetriveById1() throws SQLException, ClassNotFoundException {

        SupportoEsameBean expected = new SupportoEsameBean();
        expected.setId(15);

        SupportoEsameBean result = dao.doRetriveById(15);

        assertEquals(expected.getId(), result.getId());
    }

    @Test
    void doRetriveById2() throws SQLException, ClassNotFoundException {

        SupportoEsameBean expected = null;

        SupportoEsameBean result = dao.doRetriveById(0);

        assertEquals(null, result);
    }

    @Test
    void inserimentoSupportoEsame1() throws SQLException, ClassNotFoundException {

        String email = "abaglio9@studenti.unisa.it";
        String data = "2021-12-11";
        String ora = "16:00";
        int oreRichieste = 2;
        String modalitaEsame = "Scritto";
        String eventualiAusili = "Tempo Aggiuntivo";
        String tipoAssistenza = "Tutor Lettore";
        String luogo = "Edificio F3 Aula 18";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String docente = "Distasi";

        SupportoEsameBean bean = new SupportoEsameBean();
        bean.setStudenteEmail(email);
        bean.setData(data);
        bean.setOra(ora);
        bean.setOreRichieste(oreRichieste);
        bean.setModalitaEsame(modalitaEsame);
        bean.setEventualiAusili(eventualiAusili);
        bean.setTipoAssistenza(tipoAssistenza);
        bean.setLuogo(luogo);
        bean.setDipartimento(dipartimento);
        bean.setInsegnamento(insegnamento);
        bean.setDocente(docente);

        assertEquals(true, dao.inserimentoSupportoEsame(bean));

        List<SupportoEsameBean> list = dao.doRetrieveAllByStudente(email);
        SupportoEsameBean supportoEsameBean = list.get(list.size() - 1);
        dao.deleteSupporto(supportoEsameBean);

    }

    @Test
    void inserimentoSupportoEsame2() throws SQLException, ClassNotFoundException {


        SupportoEsameBean bean = new SupportoEsameBean();


        assertEquals(false, dao.inserimentoSupportoEsame(bean));

    }

    @Test
    void accettaRichiesta1() throws SQLException, ClassNotFoundException {

        String email = "abaglio9@studenti.unisa.it";
        String data = "2021-12-11";
        String ora = "16:00";
        int oreRichieste = 2;
        String modalitaEsame = "Scritto";
        String eventualiAusili = "Tempo Aggiuntivo";
        String tipoAssistenza = "Tutor Lettore";
        String luogo = "Edificio F3 Aula 18";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String docente = "Distasi";

        SupportoEsameBean bean = new SupportoEsameBean();
        bean.setStudenteEmail(email);
        bean.setData(data);
        bean.setOra(ora);
        bean.setOreRichieste(oreRichieste);
        bean.setModalitaEsame(modalitaEsame);
        bean.setEventualiAusili(eventualiAusili);
        bean.setTipoAssistenza(tipoAssistenza);
        bean.setLuogo(luogo);
        bean.setDipartimento(dipartimento);
        bean.setInsegnamento(insegnamento);
        bean.setDocente(docente);
        dao.inserimentoSupportoEsame(bean);

        String emailTutor = "lorenzorossi1@studenti.unisa.it";
        String commento = "ok,va bene!";

        List<SupportoEsameBean> list = dao.doRetrieveAllByStudente(email);
        SupportoEsameBean supportoEsameBean = list.get(list.size() - 1);

        assertEquals(true, dao.accettaRichiesta(supportoEsameBean.getId(), emailTutor, commento));

        dao.deleteSupporto(supportoEsameBean);
    }

    @Test
    void accettaRichiesta2() throws SQLException, ClassNotFoundException {

        String email = "abaglio9@studenti.unisa.it";


        SupportoEsameBean bean = new SupportoEsameBean();


        String emailTutor = "lorenzorossi1@studenti.unisa.it";
        String commento = "ok,va bene!";



        assertEquals(false, dao.accettaRichiesta(bean.getId(), emailTutor, commento));

    }



    @Test
    void approvaRichiesta1() throws SQLException, ClassNotFoundException {

        String email = "abaglio9@studenti.unisa.it";
        String data = "2021-12-11";
        String ora = "16:00";
        int oreRichieste = 2;
        String modalitaEsame = "Scritto";
        String eventualiAusili = "Tempo Aggiuntivo";
        String tipoAssistenza = "Tutor Lettore";
        String luogo = "Edificio F3 Aula 18";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String docente = "Distasi";

        SupportoEsameBean bean = new SupportoEsameBean();
        bean.setStudenteEmail(email);
        bean.setData(data);
        bean.setOra(ora);
        bean.setOreRichieste(oreRichieste);
        bean.setModalitaEsame(modalitaEsame);
        bean.setEventualiAusili(eventualiAusili);
        bean.setTipoAssistenza(tipoAssistenza);
        bean.setLuogo(luogo);
        bean.setDipartimento(dipartimento);
        bean.setInsegnamento(insegnamento);
        bean.setDocente(docente);
        dao.inserimentoSupportoEsame(bean);

        String emailTutor = "lorenzorossi1@studenti.unisa.it";
        String commento = "ok,va bene!";
        String emailProf = "mlamberti78@unisa.it";

        List<SupportoEsameBean> list = dao.doRetrieveAllByStudente(email);
        SupportoEsameBean supportoEsameBean = list.get(list.size() - 1);

        dao.accettaRichiesta(supportoEsameBean.getId(), emailTutor, commento);
        assertEquals(true, dao.approvaRichiesta(supportoEsameBean.getId(), emailProf));

        dao.deleteSupporto(supportoEsameBean);

    }

    @Test
    void approvaRichiesta2() throws SQLException {
        String email = "abaglio9@studenti.unisa.it";

        SupportoEsameBean bean = new SupportoEsameBean();

        String emailProf = "mlamberti78@unisa.it";

        assertEquals(false, dao.approvaRichiesta(bean.getId(), emailProf));
    }

    @Test
    void deleteSupporto1() throws SQLException, ClassNotFoundException {

        String email = "abaglio9@studenti.unisa.it";
        String data = "2021-12-11";
        String ora = "16:00";
        int oreRichieste = 2;
        String modalitaEsame = "Scritto";
        String eventualiAusili = "Tempo Aggiuntivo";
        String tipoAssistenza = "Tutor Lettore";
        String luogo = "Edificio F3 Aula 18";
        String dipartimento = "Informatica";
        String insegnamento = "Programmazione I";
        String docente = "Distasi";

        SupportoEsameBean bean = new SupportoEsameBean();
        bean.setStudenteEmail(email);
        bean.setData(data);
        bean.setOra(ora);
        bean.setOreRichieste(oreRichieste);
        bean.setModalitaEsame(modalitaEsame);
        bean.setEventualiAusili(eventualiAusili);
        bean.setTipoAssistenza(tipoAssistenza);
        bean.setLuogo(luogo);
        bean.setDipartimento(dipartimento);
        bean.setInsegnamento(insegnamento);
        bean.setDocente(docente);

        dao.inserimentoSupportoEsame(bean);

        List<SupportoEsameBean> list = dao.doRetrieveAllByStudente(email);
        SupportoEsameBean supportoEsameBean = list.get(list.size() - 1);
        assertEquals(true, dao.deleteSupporto(supportoEsameBean));

    }

    @Test
    void deleteSupporto2() throws SQLException, ClassNotFoundException {


        String email = "abaglio9@studenti.unisa.it";
        SupportoEsameBean bean = new SupportoEsameBean();

        assertEquals(false, dao.deleteSupporto(bean));

    }

}