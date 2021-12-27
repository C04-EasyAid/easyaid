package model.bean;

public class TutorBean {
    private String emailTutor;
    private String dipartimento;
    private  String qulifica;
    private int oreSvolte;
    private int oreDisponibili;
    private static TutorBean tutorBean = null;
    private TutorBean() {
    }

    private TutorBean(String emailTutor, String dipartimento, String qulifica, int oreSvolte, int oreDisponibili) {
        this.emailTutor = emailTutor;
        this.dipartimento = dipartimento;
        this.qulifica = qulifica;
        this.oreSvolte = oreSvolte;
        this.oreDisponibili = oreDisponibili;
    }

    public static TutorBean getInstance() {
        // Se l'istanza è nulla crea l'oggetto
        if (tutorBean == null) {
            tutorBean = new TutorBean();
        }
        return tutorBean;
    }

    public String getEmailTutor() {
        return emailTutor;
    }

    public void setEmailTutor(String emailTutor) {
        this.emailTutor = emailTutor;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String getQulifica() {
        return qulifica;
    }

    public void setQulifica(String qulifica) {
        this.qulifica = qulifica;
    }

    public int getOreSvolte() {
        return oreSvolte;
    }

    public void setOreSvolte(int oreSvolte) {
        this.oreSvolte = oreSvolte;
    }

    public int getOreDisponibili() {
        return oreDisponibili;
    }

    public void setOreDisponibili(int oreDisponibili) {
        this.oreDisponibili = oreDisponibili;
    }
}
