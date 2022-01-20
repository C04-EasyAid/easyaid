package model.bean;

import lombok.*;

/**
 *  Classe PersonaleAmministrativoBean
 *
 * @author Roberto Tartaglia
 * 
 * */
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
