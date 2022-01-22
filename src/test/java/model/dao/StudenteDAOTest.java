package model.dao;

import model.bean.StudenteBean;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudenteDAOTest {

  private final StudenteDAO dao = new StudenteDAO();

  @Test
  void doRetrieveByEmail1() throws SQLException, ClassNotFoundException {
    String email = "abaglio9@studenti.unisa.it";

    StudenteBean studente = dao.doRetrieveByEmail(email);
    assertEquals(email, studente.getEmail());
    assertEquals("DSA", studente.getTipoDisabilita());
    assertEquals("dislessia", studente.getSpecificheDisturbo());
    assertEquals(15, studente.getPercentualeDisabilita());
    assertEquals(22, studente.getOreDisponibili());
  }

  @Test
  void doRetrieveByEmail2() throws SQLException, ClassNotFoundException {
    String email = "";

    StudenteBean studente = dao.doRetrieveByEmail(email);
    assertEquals(null, studente.getEmail());
    assertEquals(null, studente.getTipoDisabilita());
    assertEquals(null, studente.getSpecificheDisturbo());
    assertEquals(0, studente.getPercentualeDisabilita());
    assertEquals(0, studente.getOreDisponibili());
  }

  @Test
  void updateOreDisponibili1() throws SQLException {

    int oreRichieste = 5;
    String email = "paolorossi10@studenti.unisa.it";

    assertEquals(true,dao.updateOreDisponibili(oreRichieste,email));

    dao.updateOreDisponibili(-oreRichieste,email);
  }

  @Test
  void updateOreDisponibili2() throws SQLException {

    int oreRichieste = 5;
    String email = "";

    assertEquals(false,dao.updateOreDisponibili(oreRichieste,email));
  }

}
