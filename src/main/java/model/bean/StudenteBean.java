package model.bean;

import lombok.Data;

/**
 * Classe StudenteBean.
 *
 * @author Giovanni Toriello
 * */
@Data
public class StudenteBean {

  // Variabili dell'utente
  private String email;
  private String tipoDisabilita;
  private String specificheDisturbo;
  private int oreDisponibili;
  private int percentualeDisabilita;

  /**Costruttore. */
  public StudenteBean(
      String email,
      String tipoDisabilita,
      String specificheDisturbo,
      int oreDisponibili,
      int percentualeDisabilita) {
    this.email = email;
    this.tipoDisabilita = tipoDisabilita;
    this.specificheDisturbo = specificheDisturbo;
    this.oreDisponibili = oreDisponibili;
    this.percentualeDisabilita = percentualeDisabilita;
  }

  /**Costruttore vuoto. */
  public StudenteBean() {}
}
