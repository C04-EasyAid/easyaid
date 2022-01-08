package model.bean;

import lombok.*;

/** @author Martina Giugliano Classe Tutorato Didattico */
@Data
public class TutoratoDidatticoBean {
  private int id;
  private String dateDisponibili;
  private String oreDisponibili;
  private int oreRichieste;
  private String commento;
  private int status;
  private String insegnamento;
  private String dipartimento;
  private String studenteEmail;
  private String tutorEmail;
  private String profEmail;

  /** Costruttore vuoto. */
  public TutoratoDidatticoBean() {}

  /**
   * Costruttore.
   *
   * @param id
   * @param dateDisponibili
   * @param oreDisponibili
   * @param oreRichieste
   * @param commento
   * @param status
   * @param insegnamento
   * @param dipartimento
   * @param studenteEmail
   * @param tutorEmail
   * @param profEmail
   */
  public TutoratoDidatticoBean(
      int id,
      String dateDisponibili,
      String oreDisponibili,
      int oreRichieste,
      String commento,
      int status,
      String insegnamento,
      String dipartimento,
      String studenteEmail,
      String tutorEmail,
      String profEmail) {
    this.id = id;
    this.dateDisponibili = dateDisponibili;
    this.oreDisponibili = oreDisponibili;
    this.oreRichieste = oreRichieste;
    this.commento = commento;
    this.status = status;
    this.insegnamento = insegnamento;
    this.dipartimento = dipartimento;
    this.studenteEmail = studenteEmail;
    this.tutorEmail = tutorEmail;
    this.profEmail = profEmail;
  }
}
