package model.bean;

public class TutorBean {
    private String emailTutor;
    private String dipartimento;
    private  String qualifica;
    private int oreSvolte;
    private int oreDisponibili;
    private static TutorBean tutorBean = null;
    private TutorBean() {
    }

    private TutorBean(String emailTutor, String dipartimento, String qualifica, int oreSvolte, int oreDisponibili) {
        this.emailTutor = emailTutor;
        this.dipartimento = dipartimento;
        this.qualifica = qualifica;
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

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
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
