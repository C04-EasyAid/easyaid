package model.bean;

import java.util.Date;

public class LezioneBean {
  // Variabili d'istanza
  private int tutorato;
  private String oraInizio, oraFine, tutor;
  private Date data;
  private boolean status;

  // Costruttore
  public LezioneBean(
      int tutorato, String oraInizio, String oraFine, Date data, String tutor, boolean status) {
    this.tutorato = tutorato;
    this.oraInizio = oraInizio;
    this.oraFine = oraFine;
    this.tutor = tutor;
    this.data = data;
    this.status = status;
  }
  // Costruttore vuoto

  public LezioneBean() {

  }

  // Metodi
  public int getTutorato() {
    return tutorato;
  }

  public void setTutorato(int tutorato) {
    this.tutorato = tutorato;
  }

  public String getOraInizio() {
    return oraInizio;
  }

  public void setOraInizio(String oraInizio) {
    this.oraInizio = oraInizio;
  }

  public String getOraFine() {
    return oraFine;
  }

  public void setOraFine(String oraFine) {
    this.oraFine = oraFine;
  }

  public String getTutor() {
    return tutor;
  }

  public void setTutor(String tutor) {
    this.tutor = tutor;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
