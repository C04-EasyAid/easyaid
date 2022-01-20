package model.bean;

import java.util.Date;
import lombok.Data;

/**
 * Classe LezioneBean.
 *
 *  @author Serena Liguori
 *
 */

@Data
public class LezioneBean {
  // Variabili d'istanza
  private String luogo;
  private int id;
  private int tutorato;
  private String oraInizio;
  private String oraFine;
  private String tutor;
  private String insegnamento;
  private String emailstudente;
  private Date data;
  private boolean status;

  // Costruttore con id
  public LezioneBean (
      int id,
      int tutorato,
      String oraInizio,
      String oraFine,
      Date data,
      String tutor,
      String luogo,
      boolean status) {
    this.id = id;
    this.tutorato = tutorato;
    this.oraInizio = oraInizio;
    this.oraFine = oraFine;
    this.tutor = tutor;
    this.data = data;
    this.status = status;
  }
  // Costruttore
  public LezioneBean(
      int tutorato,
      String oraInizio,
      String oraFine,
      Date data,
      String tutor,
      String luogo,
      boolean status) {
    this.tutorato = tutorato;
    this.oraInizio = oraInizio;
    this.oraFine = oraFine;
    this.tutor = tutor;
    this.data = data;
    this.status = status;
  }
  // Costruttore vuoto

  public LezioneBean() {}



}
