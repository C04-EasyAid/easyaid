package model.bean;

import lombok.Data;

/**
 * Classe TutorBean.
 *
 * @author Roberto Tartaglia Classe TutorBean
 */

@Data
public class TutorBean {
  private String emailTutor;
  private String dipartimento;
  private String qualifica;
  private int oreSvolte;
  private int oreDisponibili;

  /** Costruttore. */
  public TutorBean(
      String emailTutor, String dipartimento, String qualifica, int oreSvolte, int oreDisponibili) {
    this.emailTutor = emailTutor;
    this.dipartimento = dipartimento;
    this.qualifica = qualifica;
    this.oreSvolte = oreSvolte;
    this.oreDisponibili = oreDisponibili;
  }

  /** Costruttore Vuoto. */
  public TutorBean() {}
}
