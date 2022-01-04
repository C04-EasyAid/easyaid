package model.bean;

/**
 * @author Martina Giugliano
 * Classe Tutorato Didattico
 */
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

    /**
     * Costruttore vuoto.
     */
    public TutoratoDidatticoBean() {
    }

    /**
     * Costruttore.
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
    public TutoratoDidatticoBean(int id, String dateDisponibili, String oreDisponibili, int oreRichieste, String commento, int status, String insegnamento, String dipartimento, String studenteEmail, String tutorEmail, String profEmail) {
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

    /**
     * Metodo che restituisce l'id del tutorato didattico.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che setta l'id del tutorato didattico.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che restituisce le ore disponibili del tutorato didattico.
     * @return
     */
    public String getOreDisponibili() {
        return oreDisponibili;
    }

    /**
     * Metodo che setta le ore disponibili del tutorato didattico.
     * @param oreDisponibili
     */
    public void setOreDisponibili(String oreDisponibili) {
        this.oreDisponibili = oreDisponibili;
    }

    /**
     * Metodo che restituisce le date disponibili del tutorato didattico.
     * @return
     */
    public String getDateDisponibili() {
        return dateDisponibili;
    }

    /**
     * Metodo che setta le date disponibili del tutorato didattico.
     * @param dateDisponibili
     */
    public void setDateDisponibili(String dateDisponibili) {
        this.dateDisponibili = dateDisponibili;
    }

    /**
     * Metodo che restituisce le ore richieste del tutorato didattico.
     * @return
     */
    public int getOreRichieste() {
        return oreRichieste;
    }

    /**
     * Metodo che setta le ore richieste del tutorato didattico.
     * @param oreRichieste
     */
    public void setOreRichieste(int oreRichieste) {
        this.oreRichieste = oreRichieste;
    }

    /**
     * Metodo che restituisce un commento del tutorato didattico.
     * @return
     */
    public String getCommento() {
        return commento;
    }

    /**
     * Metodo che setta un commento del tutorato didattico.
     * @param commento
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    /**
     * Metodo che restituisce lo status del tutorato didattico.
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Metodo che setta lo status del tutorato didattico.
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Metodo che restituisce l'insegnamento del tutorato didattico.
     * @return
     */
    public String getInsegnamento() {
        return insegnamento;
    }

    /**
     * Metodo che setta l'insegnamento del tutorato didattico.
     * @param insegnamento
     */
    public void setInsegnamento(String insegnamento) {
        this.insegnamento = insegnamento;
    }

    /**
     * Metodo che restituisce il dipartimento del tutorato didattico.
     * @return
     */
    public String getDipartimento() {
        return dipartimento;
    }

    /**
     * Metodo che setta il dipartimento del tutorato didattico.
     * @param dipartimento
     */
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    /**
     * Metodo che restituisce l'email di uno studente del tutorato didattico.
     * @return
     */
    public String getStudenteEmail() {
        return studenteEmail;
    }

    /**
     * Metodo che setta l'email di uno studente del tutorato didattico.
     * @param studenteEmail
     */
    public void setStudenteEmail(String studenteEmail) {
        this.studenteEmail = studenteEmail;
    }

    /**
     * Metodo che restituisce l'email di un tutor del tutorato didattico.
     * @return
     */
    public String getTutorEmail() {
        return tutorEmail;
    }

    /**
     * Metodo che setta l'email di un tutor del tutorato didattico.
     * @param tutorEmail
     */
    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    /**
     * Metodo che restituisce l'email di un professore referente del tutorato didattico.
     * @return
     */
    public String getProfEmail() {
        return profEmail;
    }

    /**
     * Metodo che setta l'email di un professore referente del tutorato didattico.
     * @param profEmail
     */
    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }


}
