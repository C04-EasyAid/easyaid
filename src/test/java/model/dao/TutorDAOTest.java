package model.dao;

import model.bean.ProfessoreReferenteBean;
import model.bean.TutorBean;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TutorDAOTest {

    private final TutorDAO tutorDao = new TutorDAO();

    @Test
    void doRetrieveByEmail1() throws SQLException, ClassNotFoundException {
        String email = "adebiase41@studenti.unisa.it";

        TutorBean tutor = tutorDao.doRetrieveByEmail(email);
        assertEquals(email, tutor.getEmailTutor());
        assertEquals("informatica", tutor.getDipartimento());
        assertEquals("Laurea Triennale",tutor.getQualifica());
        assertEquals(10,tutor.getOreSvolte());
        assertEquals(30,tutor.getOreDisponibili());

    }

    @Test
    void doRetrieveByEmail2() throws SQLException, ClassNotFoundException {
        String email = null;

        TutorBean tutor = tutorDao.doRetrieveByEmail(email);
        assertEquals(null, tutor.getEmailTutor());
        assertEquals(null, tutor.getDipartimento());
        assertEquals(null,tutor.getQualifica());
        assertEquals(0,tutor.getOreSvolte());
        assertEquals(0,tutor.getOreDisponibili());

    }
}