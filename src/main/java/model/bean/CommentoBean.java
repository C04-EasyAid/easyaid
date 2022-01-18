package model.bean;

/*
@author Mariagiovanna Bianco
Classe CommentoBean
 */
import lombok.*;

import java.util.Date;

@Data
public class CommentoBean {
  // variabili di istanza
  private int lezione, tutorato,id;
  private String testo, ora, studente, tutor;
  private Date data;

  // Costruttore
  public CommentoBean(
      int lezione,
      int tutorato,
      String testo,
      Date data,
      String ora,
      String studente,
      String tutor) {
    this.lezione = lezione;
    this.tutorato = tutorato;
    this.testo = testo;
    this.data = data;
    this.ora = ora;
    this.studente = studente;
    this.tutor = tutor;
  }

  // Costruttore vuoto
  public CommentoBean() {}
}
