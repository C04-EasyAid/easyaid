package model.bean;

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


    public TutoratoDidatticoBean() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOreDisponibili() {
        return oreDisponibili;
    }

    public void setOreDisponibili(String oreDisponibili) {
        this.oreDisponibili = oreDisponibili;
    }

    public String getDateDisponibili() {
        return dateDisponibili;
    }

    public void setDateDisponibili(String dateDisponibili) {
        this.dateDisponibili = dateDisponibili;
    }

    public int getOreRichieste() {
        return oreRichieste;
    }

    public void setOreRichieste(int oreRichieste) {
        this.oreRichieste = oreRichieste;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInsegnamento() {
        return insegnamento;
    }

    public void setInsegnamento(String insegnamento) {
        this.insegnamento = insegnamento;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String getStudenteEmail() {
        return studenteEmail;
    }

    public void setStudenteEmail(String studenteEmail) {
        this.studenteEmail = studenteEmail;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }


}
