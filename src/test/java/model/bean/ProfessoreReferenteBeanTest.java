package model.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe di test per la classe ProfessoreReferenteBean.
 *
 *  @author Riccardo Polidoro
 *
 */

public class ProfessoreReferenteBeanTest {
  private final String email = "email@prova.unisa.it";
  private final String dipartimento = "dipartimento";
  private final ProfessoreReferenteBean bean = new ProfessoreReferenteBean();

  @BeforeEach
  public void beforeEach() {
    bean.setEmail(email);
    bean.setDipartimento(dipartimento);
  }

  @Test
  public void getEmail() {
    assertEquals(email, bean.getEmail());
  }

  @Test
  public void getDipartimento() {
    assertEquals(dipartimento, bean.getDipartimento());
  }

  @Test
  public void setEmail() {
    String email = "email@prova.unisa.it";
    bean.setEmail(email);
    assertEquals(email, bean.getEmail());
  }

  @Test
  public void setDipartimento() {
    String dipartimento = "dipartimento";
    bean.setDipartimento(dipartimento);
    assertEquals(dipartimento, bean.getDipartimento());
  }

  @Test
  public void professoreReferenteBean() {
    String email = "email@prova.unisa.it";
    String dipartimento = "dipartimento";
    ProfessoreReferenteBean bean = new ProfessoreReferenteBean(email, dipartimento);
    assertEquals(email, bean.getEmail());
    assertEquals(dipartimento, bean.getDipartimento());
  }
}
