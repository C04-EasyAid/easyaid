package model.dao;

import model.bean.LezioneBean;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LezioneDAOTest {

    private final LezioneDAO lezioneDao = new LezioneDAO();

    @Test
    void doRetrieveLezioneById1() throws SQLException, ClassNotFoundException {
      int id = 11;
        LezioneBean expected = new LezioneBean();
        expected.setId(11);

        LezioneBean result = lezioneDao.doRetrieveLezioneById(11);

        assertEquals(expected.getId(),result.getId());
    }

    @Test
    void doRetrieveLezioneById2() throws SQLException, ClassNotFoundException {
        int id = 0;
        LezioneBean expected = null;

        LezioneBean result = lezioneDao.doRetrieveLezioneById(0);

        assertEquals(null,result);
    }

    @Test
    void doRetrieveLezioniById1() throws SQLException, ClassNotFoundException {

        List<LezioneBean> expected = new ArrayList<>();
        expected.add(new LezioneBean());

        int idTutorato = 18;


        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioniById(idTutorato);

        assertEquals(expected.size(),result.size());
    }

    @Test
    void doRetrieveLezioniById2() throws SQLException, ClassNotFoundException {

        List<LezioneBean> expected = new ArrayList<>();
        int idTutorato = 0;


        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioniById(idTutorato);
        assertEquals(expected,result);
    }

    @Test
    void doRetrieveLezioniCompletateById1() throws SQLException, ClassNotFoundException {

        List<LezioneBean> expected = new ArrayList<>();
        expected.add(new LezioneBean());

        int idTutorato = 18;

        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
        assertEquals(expected.size(),result.size());
    }

    @Test
    void doRetrieveLezioniCompletateById2() throws SQLException, ClassNotFoundException {

        List<LezioneBean> expected = new ArrayList<>();
        int idTutorato = 0;


        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioniCompletateById(idTutorato);
        assertEquals(expected,result);
    }

    @Test
    void doRetrieveLezioneByStudente1() throws SQLException, ClassNotFoundException {
        String emailStudente = "marcoverdi4@studenti.unisa.it";

        List<LezioneBean> expected = new ArrayList<>();
        expected.add(new LezioneBean());

        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioneByStudente(emailStudente);

        assertEquals(expected.size(),result.size());

    }

    @Test
    void doRetrieveLezioneByStudente2() throws SQLException, ClassNotFoundException {

        String emailStudente = "";

        List<LezioneBean> expected = new ArrayList<>();

        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioneByStudente(emailStudente);

        assertEquals(expected,result);
    }

    @Test
    void doRetrieveLezioneByTutor1() throws SQLException, ClassNotFoundException {
        String emailTutor = "adebiase41@studenti.unisa.it";

        List<LezioneBean> expected = new ArrayList<>();
        expected.add(new LezioneBean());

        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioneByTutor(emailTutor);

        assertEquals(expected.size(),result.size());

    }

    @Test
    void doRetrieveLezioneByTutor2() throws SQLException, ClassNotFoundException {

        String emailTutor = "";

        List<LezioneBean> expected = new ArrayList<>();

        Collection<LezioneBean> result = lezioneDao.doRetrieveLezioneByTutor(emailTutor);

        assertEquals(expected,result);
    }

    @Test
    void doRetrieveTutoratoByLezione1() throws SQLException {

        int lezione = 17;

        int expectedTutorato = 23;

        int result = lezioneDao.doRetrieveTutoratoByLezione(lezione);

        assertEquals(expectedTutorato,result);
    }

    @Test
    void doRetrieveTutoratoByLezione2() throws SQLException {

        int lezione = 0;

        int expectedTutorato = 0;

        int result = lezioneDao.doRetrieveTutoratoByLezione(lezione);

        assertEquals(expectedTutorato,result);
    }

    @Test
    void countOre1() throws SQLException, ClassNotFoundException {

        Collection<LezioneBean> lezioni = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class,()->lezioneDao.countOre(lezioni,0));

    }

    @Test
    void countOre2() throws SQLException, ClassNotFoundException {

        int idTutorato = 18;
        Collection<LezioneBean> lezioni = lezioneDao.doRetrieveLezioniById(18);

        assertEquals(1,lezioneDao.countOre(lezioni,idTutorato));

    }


    @Test
    void insertNewLezione1() throws SQLException, ClassNotFoundException {

        int tutorato = 18;
        String oraInizio = "10:00";
        String oraFine = "12:00";
        String tutor = "mdibianco45@studenti.unisa.it";
        String luogo = "Edificio F3, Aula F2";

        LezioneBean lezione = new LezioneBean();
        lezione.setTutorato(tutorato);
        lezione.setOraInizio(oraInizio);
        lezione.setOraFine(oraFine);
        lezione.setData(new Date());
        lezione.setTutor(tutor);
        lezione.setLuogo(luogo);

        assertEquals(true,lezioneDao.insertNewLezione(lezione));

        ArrayList<LezioneBean> lezioni = (ArrayList<LezioneBean>) lezioneDao.doRetrieveLezioniById(tutorato);
        lezione = lezioni.get(lezioni.size()-1);
        lezioneDao.deleteLezione(lezione);
    }

    @Test
    void insertNewLezione2() throws SQLException, ClassNotFoundException {

        int tutorato = 0;
        String oraInizio = "10:00";
        String oraFine = "12:00";
        String tutor = "mdibianco45@studenti.unisa.it";
        String luogo = "Edificio F3, Aula F2";

        LezioneBean lezione = new LezioneBean();
        lezione.setTutorato(tutorato);
        lezione.setOraInizio(oraInizio);
        lezione.setOraFine(oraFine);
        lezione.setData(new Date());
        lezione.setTutor(tutor);
        lezione.setLuogo(luogo);

        assertEquals(false,lezioneDao.insertNewLezione(lezione));

    }


    @Test
    void confermaLezione1() throws SQLException {

       int idLezione = 18;

       assertEquals(true,lezioneDao.confermaLezione(idLezione));

    }

    @Test
    void confermaLezione2() throws SQLException {

        int idLezione = 0;

        assertEquals(false,lezioneDao.confermaLezione(idLezione));

    }

    @Test
    void deleteLezione1() throws SQLException, ClassNotFoundException {
        int tutorato = 18;
        String oraInizio = "10:00";
        String oraFine = "12:00";
        String tutor = "mdibianco45@studenti.unisa.it";
        String luogo = "Edificio F3, Aula F2";

        LezioneBean lezione = new LezioneBean();
        lezione.setTutorato(tutorato);
        lezione.setOraInizio(oraInizio);
        lezione.setOraFine(oraFine);
        lezione.setData(new Date());
        lezione.setTutor(tutor);
        lezione.setLuogo(luogo);

        lezioneDao.insertNewLezione(lezione);

        ArrayList<LezioneBean> lezioni = (ArrayList<LezioneBean>) lezioneDao.doRetrieveLezioniById(tutorato);
        lezione = lezioni.get(lezioni.size()-1);

        assertEquals(true,lezioneDao.deleteLezione(lezione));

    }

    @Test
    void deleteLezione2() throws SQLException, ClassNotFoundException {
        int tutorato = 0;
        String oraInizio = "10:00";
        String oraFine = "12:00";
        String tutor = "mdibianco45@studenti.unisa.it";
        String luogo = "Edificio F3, Aula F2";

        LezioneBean lezione = new LezioneBean();
        lezione.setTutorato(tutorato);
        lezione.setOraInizio(oraInizio);
        lezione.setOraFine(oraFine);
        lezione.setData(new Date());
        lezione.setTutor(tutor);
        lezione.setLuogo(luogo);

        lezioneDao.insertNewLezione(lezione);


        assertEquals(false,lezioneDao.deleteLezione(lezione));

    }

}