package model.bean;

import lombok.*;

/**
 * ClasseTutoratoDidatticoBean.
 *
 * @author Martina Giugliano
 */

@Data
public class TutoratoDidatticoBean {
  private int id;
  private String docente;
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

  // Costruttore vuoto
  public TutoratoDidatticoBean() {}

  /**
   * Costruttore.
   *
   * @param id id del tutorato
   * @param dateDisponibili le date disponibili inserite dallo tudente
   * @param oreDisponibili le ore in cui lo studente è disponibile
   * @param oreRichieste le ore di tutorato didattico richieste dallo studente
   * @param commento il commento inserito dal tutor che ha accettato la richiesta di tutorato
   * @param status lo status della richiesta di tutorato:0=non
   *     accettata,1=accettata,2=completata,3=approvata
   * @param insegnamento l'insegnamento per il quale si richiede il turato
   * @param dipartimento il dipartimento presso il quale lo studente è iscritto
   * @param studenteEmail l'e-mail dello studente che fa richiesta di tutorato
   * @param tutorEmail l'e-mail del tutor che ha accettato la richiesta
   * @param profEmail l'e-mail del professore referente che approvato la richiesta
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
      String profEmail,
      String docente) {
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
    this.docente = docente;
  }
}
