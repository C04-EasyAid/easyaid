package model.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 *Classe di test per la classe TutorBean.
 *
 * @author Riccardo Polidoro
 *
 */
public class TutorBeanTest {
  private final String emailTutor = "email@prova.unisa.it";
  private final String dipartimento = "dipartimento";
  private final String qualifica = "qualifica";
  private final int oreSvolte = 20;
  private final int oreDisponibili = 10;
  private final TutorBean bean = new TutorBean();

  /**
   * Setting delle variabili per ogni test.
   */
  @BeforeEach
  public void beforeEach() {
    bean.setEmailTutor(emailTutor);
    bean.setDipartimento(dipartimento);
    bean.setQualifica(qualifica);
    bean.setOreSvolte(oreSvolte);
    bean.setOreDisponibili(oreDisponibili);
  }

  @Test
  public void getEmailTutor() {
    assertEquals(emailTutor, bean.getEmailTutor());
  }

  @Test
  public void getDipartimento() {
    assertEquals(dipartimento, bean.getDipartimento());
  }

  @Test
  public void getQualifica() {
    assertEquals(qualifica, bean.getQualifica());
  }

  @Test
  public void getOreSvolte() {
    assertEquals(oreSvolte, bean.getOreSvolte());
  }

  @Test
  public void getOreDisponibili() {
    assertEquals(oreDisponibili, bean.getOreDisponibili());
  }

  @Test
  public void setEmailTutor() {
    String email = "email@prova.unisa.it";
    bean.setEmailTutor(email);
    assertEquals(email, bean.getEmailTutor());
  }

  @Test
  public void setDipartimento() {
    String dipartimento = "dipartimento";
    bean.setDipartimento(dipartimento);
    assertEquals(dipartimento, bean.getDipartimento());
  }

  @Test
  public void setQualifica() {
    String qualifica = "qualifica";
    bean.setQualifica(qualifica);
    assertEquals(qualifica, bean.getQualifica());
  }

  @Test
  public void setOreSvolte() {
    int oreSvolte = 20;
    bean.setOreSvolte(oreSvolte);
    assertEquals(oreSvolte, bean.getOreSvolte());
  }

  @Test
  public void setOreDisponibili() {
    int oreDisponibili = 10;
    bean.setOreDisponibili(oreDisponibili);
    assertEquals(oreDisponibili, bean.getOreDisponibili());
  }

  @Test
  public void tutorBean() {
    String emailTutor = "email@prova.unisa.it";
    String dipartimento = "dipartimento";
    String qualifica = "qualifica";
    int oreSvolte = 20;
    int oreDisponibili = 10;
    TutorBean bean = new TutorBean(emailTutor, dipartimento, qualifica, oreSvolte, oreDisponibili);
    assertEquals(emailTutor, bean.getEmailTutor());
    assertEquals(dipartimento, bean.getDipartimento());
    assertEquals(qualifica, bean.getQualifica());
    assertEquals(oreSvolte, bean.getOreSvolte());
    assertEquals(oreDisponibili, bean.getOreDisponibili());
  }
}
