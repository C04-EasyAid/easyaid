package model.bean;

import lombok.*;

/**
 * Classe ProfessoreReferenteBean.
 *
 * @author Giovanni Toriello
 */

@Data
public class ProfessoreReferenteBean {
  // Variabili del professore referente
  private String email, dipartimento;

  /**
   * Costruttore
   *
   * @param email
   * @param dipartimento
   */
  public ProfessoreReferenteBean(String email, String dipartimento) {
    this.email = email;
    this.dipartimento = dipartimento;
  }

  // Costruttore Vuoto
  public ProfessoreReferenteBean() {}
}
