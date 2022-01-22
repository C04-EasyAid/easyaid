package model.dao;

import model.bean.TutorBean;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TutorDaoTest {

  private final TutorDao tutorDao = new TutorDao();

  @Test
  void doRetrieveByEmail1() throws SQLException, ClassNotFoundException {
    String email = "adebiase41@studenti.unisa.it";

    TutorBean tutor = tutorDao.doRetrieveByEmail(email);
    assertEquals(email, tutor.getEmailTutor());
    assertEquals("informatica", tutor.getDipartimento());
    assertEquals("Laurea Triennale", tutor.getQualifica());
    assertEquals(10, tutor.getOreSvolte());
    assertEquals(30, tutor.getOreDisponibili());
  }

  @Test
  void doRetrieveByEmail2() throws SQLException, ClassNotFoundException {
    String email = null;

    TutorBean tutor = tutorDao.doRetrieveByEmail(email);
    assertEquals(null, tutor.getEmailTutor());
    assertEquals(null, tutor.getDipartimento());
    assertEquals(null, tutor.getQualifica());
    assertEquals(0, tutor.getOreSvolte());
    assertEquals(0, tutor.getOreDisponibili());
  }

  @Test
  void updateOreDisponibili1() throws SQLException {

    int oreRichieste = 2;
    String email = "saracapriotti55@studenti.unisa.it";

    assertEquals(true,tutorDao.updateOreDisponibili(oreRichieste,email));

    tutorDao.updateOreDisponibili(-oreRichieste,email);
  }

  @Test
  void updateOreDisponibili2() throws SQLException {

    int oreRichieste = 2;
    String email = "";

    assertEquals(false,tutorDao.updateOreDisponibili(oreRichieste,email));
  }

  @Test
  void updateOreSvolte1() throws SQLException {
    int oreRichieste = 2;
    String email = "saracapriotti55@studenti.unisa.it";

    assertEquals(true,tutorDao.updateOreSvolte(oreRichieste,email));

    tutorDao.updateOreSvolte(-oreRichieste,email);
  }

  @Test
  void updateOreSvolte2() throws SQLException {
    int oreRichieste = 2;
    String email = "";

    assertEquals(false,tutorDao.updateOreSvolte(oreRichieste,email));

  }

}
