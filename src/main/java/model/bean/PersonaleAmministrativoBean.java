package model.bean;

import lombok.Data;

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
