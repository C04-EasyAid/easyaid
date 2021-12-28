package model.bean;

import java.util.Date;

public class CommentoBean {
    //variabili di istanza
    private int lezione, tutorato;
    private String testo,ora, studente, tutor;
    private Date data;

    //Costruttore
    public CommentoBean(int lezione, int tutorato, String testo, Date data, String ora, String studente, String tutor) {
        this.lezione = lezione;
        this.tutorato = tutorato;
        this.testo = testo;
        this.data = data;
        this.ora = ora;
        this.studente = studente;
        this.tutor = tutor;

    }

    //Costruttore vuoto
    public CommentoBean() {
    }

    //Metodi
    public int getLezione() {
        return lezione;
    }

    public void setLezione(int lezione) {
        this.lezione = lezione;
    }

    public int getTutorato() {
        return tutorato;
    }

    public void setTutorato(int tutorato) {
        this.tutorato = tutorato;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getStudente() {
        return studente;
    }

    public void setStudente(String studente) {
        this.studente = studente;
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
}
