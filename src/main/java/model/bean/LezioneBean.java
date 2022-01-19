package model.bean;

import lombok.Data;

import java.util.Date;
/*
@author Serena Liguori
Classe LezioneBean
 */
@Data
public class LezioneBean {
  // Variabili d'istanza
  private String luogo;
  private int id, tutorato;
  private String oraInizio, oraFine, tutor, insegnamento, emailStudente;
  private Date data;
  private boolean status;
  // Costruttore con id
  public LezioneBean(
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

  // Metodi

}
