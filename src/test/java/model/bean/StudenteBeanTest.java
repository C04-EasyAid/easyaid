package model.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe di test per la classe StudenteBean.
 *
 * @author Riccardo Polidoro
 *
 */

public class StudenteBeanTest {
  private final String email = "email@prova.unisa.it";
  private final String tipoDisabilita = "tipoDisabilita";
  private final String specificheDisturbo = "specificheDisturbo";
  private final int oreDisponibili = 10;
  private final int percentualeDisabilita = 60;
  private final StudenteBean bean = new StudenteBean();

  /**
   *Setting delle variabili per ogni test.
   */
  @BeforeEach
  public void beforeEach() {
    bean.setEmail(email);
    bean.setTipoDisabilita(tipoDisabilita);
    bean.setSpecificheDisturbo(specificheDisturbo);
    bean.setOreDisponibili(oreDisponibili);
    bean.setPercentualeDisabilita(percentualeDisabilita);
  }

  @Test
  public void getEmail() {
    assertEquals(email, bean.getEmail());
  }

  @Test
  public void getTipoDisabilita() {
    assertEquals(tipoDisabilita, bean.getTipoDisabilita());
  }

  @Test
  public void getSpecificheDisturbo() {
    assertEquals(specificheDisturbo, bean.getSpecificheDisturbo());
  }

  @Test
  public void getOreDisponibili() {
    assertEquals(oreDisponibili, bean.getOreDisponibili());
  }

  @Test
  public void getPercentualDisabilita() {
    assertEquals(percentualeDisabilita, bean.getPercentualeDisabilita());
  }

  @Test
  public void setEmail() {
    String email = "email@prova1.unisa.it";
    bean.setEmail(email);
    assertEquals(email, bean.getEmail());
  }

  @Test
  public void setTipoDisabilita() {
    String tipoDisabilita = "tipoDisabilitaProva";
    bean.setTipoDisabilita(tipoDisabilita);
    assertEquals(tipoDisabilita, bean.getTipoDisabilita());
  }

  @Test
  public void setSpecificheDisturbo() {
    String specificheDisturbo = "specificheDisturboProva";
    bean.setSpecificheDisturbo(specificheDisturbo);
    assertEquals(specificheDisturbo, bean.getSpecificheDisturbo());
  }

  @Test
  public void setOreDisponibili() {
    int oreDisponibili = 10;
    bean.setOreDisponibili(oreDisponibili);
    assertEquals(oreDisponibili, bean.getOreDisponibili());
  }

  @Test
  public void setPercentualeDisabilita() {
    int percentualeDisabilita = 60;
    bean.setPercentualeDisabilita(percentualeDisabilita);
    assertEquals(percentualeDisabilita, bean.getPercentualeDisabilita());
  }

  @Test
  public void studenteBean() {
    String email = "email@prova.unisa.it";
    String tipoDisabilita = "tipoDisabilita";
    String specificheDisturbo = "specificheDisturbo";
    int oreDisponibili = 10;
    int percentualeDisabilita = 60;
    StudenteBean bean =
        new StudenteBean(
            email, tipoDisabilita, specificheDisturbo, oreDisponibili, percentualeDisabilita);
    assertEquals(email, bean.getEmail());
    assertEquals(tipoDisabilita, bean.getTipoDisabilita());
    assertEquals(specificheDisturbo, bean.getSpecificheDisturbo());
    assertEquals(oreDisponibili, bean.getOreDisponibili());
    assertEquals(percentualeDisabilita, bean.getPercentualeDisabilita());
  }
}
