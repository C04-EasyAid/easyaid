package model.bean;

import java.util.Date;
import lombok.*;

/**
 * Classe CommentoBean.
 *
 * @author Mariagiovanna Bianco
 */

@Data
public class CommentoBean {
  // variabili di istanza
  private int lezione;
  private int tutorato;
  private int id;
  private String testo;
  private String ora;
  private String studente;
  private String tutor;
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
