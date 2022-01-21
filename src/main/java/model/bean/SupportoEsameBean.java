package model.bean;

import lombok.*;

/**
 * Classe SupportoEsameBean.
 *
 * @author Martina Giugliano Classe Supporto Esame
 **/
@Data
public class SupportoEsameBean {
  private int id;
  private String data;
  private String ora;
  private int oreRichieste;
  private String docente;
  private String modalitaEsame;
  private String eventualiAusili;
  private String tipoAssistenza;
  private int status;
  private String insegnamento;
  private String commento;
  private String luogo;
  private String dipartimento;
  private String studenteEmail;
  private String tutorEmail;
  private String profEmail;

  /** Costruttore vuoto. */
  public SupportoEsameBean() {}

  /** Costruttore. */
  public SupportoEsameBean(
      int id,
      String data,
      String ora,
      int oreRichieste,
      String docente,
      String modalitaEsame,
      String eventualiAusili,
      String tipoAssistenza,
      int status,
      String insegnamento,
      String commento,
      String luogo,
      String dipartimento,
      String studenteEmail,
      String tutorEmail,
      String profEmail) {
    this.id = id;
    this.data = data;
    this.ora = ora;
    this.oreRichieste = oreRichieste;
    this.docente = docente;
    this.modalitaEsame = modalitaEsame;
    this.eventualiAusili = eventualiAusili;
    this.tipoAssistenza = tipoAssistenza;
    this.status = status;
    this.insegnamento = insegnamento;
    this.commento = commento;
    this.luogo = luogo;
    this.dipartimento = dipartimento;
    this.studenteEmail = studenteEmail;
    this.tutorEmail = tutorEmail;
    this.profEmail = profEmail;
  }
}
