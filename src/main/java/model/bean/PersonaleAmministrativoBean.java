package model.bean;

import lombok.*;

/** @author Roberto Tartaglia Classe PersonaleAmministrativoBean */
@Data
public class PersonaleAmministrativoBean {
  private String emailPersonaleAmministrativo;

  /**
   * Costruttore
   *
   * @param emailPersonaleAmministrativo
   */
  public PersonaleAmministrativoBean(String emailPersonaleAmministrativo) {
    this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
  }

  /** Costruttore Vuoto */
  public PersonaleAmministrativoBean() {}
}
