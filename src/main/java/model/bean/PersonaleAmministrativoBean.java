package model.bean;

import lombok.*;

/**
 *  Classe PersonaleAmministrativoBean.
 *
 * @author Roberto Tartaglia
 *
 * */
@Data
public class PersonaleAmministrativoBean {
  private String emailPersonaleAmministrativo;

  public PersonaleAmministrativoBean(String emailPersonaleAmministrativo) {
    this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
  }

  // Costruttore Vuoto
  public PersonaleAmministrativoBean() {}
}
