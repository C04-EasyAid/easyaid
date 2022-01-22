package model.dao;

import java.sql.SQLException;
import model.bean.ProfessoreReferenteBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test ProfessoreReferenteDAO.
 *
 *  @author Giovanni Toriello
 */

class ProfessoreReferenteDaoTest {
  private final ProfessoreReferenteDao dao = new ProfessoreReferenteDao();

  @Test
  void doRetrieveByEmail1() throws SQLException, ClassNotFoundException {
    String email = "dbelli01@unisa.it";

    ProfessoreReferenteBean professore = dao.doRetrieveByEmail(email);
    assertEquals(email, professore.getEmail());
    assertEquals("informatica", professore.getDipartimento());
  }

  @Test
  void doRetrieveByEmail2() throws SQLException, ClassNotFoundException {
    String email = "dbelli01p@unisa.it";

    ProfessoreReferenteBean professore = dao.doRetrieveByEmail(email);
    assertEquals(null, professore.getEmail());
    assertNotEquals("fisica", professore.getDipartimento());
  }
}
