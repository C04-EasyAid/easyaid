package model.bean;
/**
 * @author Roberto Tartaglia
 * Classe TutorBean
 */
public class TutorBean {
    private String emailTutor;
    private String dipartimento;
    private  String qualifica;
    private int oreSvolte;
    private int oreDisponibili;

    /**
     * Costruttore
     * @param emailTutor
     * @param dipartimento
     * @param qualifica
     * @param oreSvolte
     * @param oreDisponibili
     */
    public TutorBean(String emailTutor, String dipartimento, String qualifica, int oreSvolte, int oreDisponibili) {
        this.emailTutor = emailTutor;
        this.dipartimento = dipartimento;
        this.qualifica = qualifica;
        this.oreSvolte = oreSvolte;
        this.oreDisponibili = oreDisponibili;
    }

    /**
     * Costruttore Vuoto
     */
    public TutorBean(){

    }

    /**
     * Metodo che restituisce l'email del tutor
     * @return
     */
    public String getEmailTutor() {
        return emailTutor;
    }

    /**
     * Metodo che setta l'email del tutor
     * @param emailTutor
     */
    public void setEmailTutor(String emailTutor) {
        this.emailTutor = emailTutor;
    }

    /**
     * Metodo che restituisce il dipartimento del tutor
     * @return
     */
    public String getDipartimento() {
        return dipartimento;
    }

    /**
     * Metodo che setta il dipartimento del tutor
     * @param dipartimento
     */
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    /**
     * Metodo che restituisce la qualifica del tutor
     * @return
     */
    public String getQualifica() {
        return qualifica;
    }

    /**
     * Metodo che setta la qualifica del tutor
     * @param qualifica
     */
    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    /**
     * Metodo che restituisce le ore svolte dal tutor
     * @return
     */
    public int getOreSvolte() {
        return oreSvolte;
    }

    /**
     * Metodo che setta le ore svolte dal tutor
     * @param oreSvolte
     */
    public void setOreSvolte(int oreSvolte) {
        this.oreSvolte = oreSvolte;
    }

    /**
     * Metodo che restituisce le ore disponibili del tutor
     * @return
     */
    public int getOreDisponibili() {
        return oreDisponibili;
    }

    /**
     * Metodo che setta le ore disponibili del tutor
     * @param oreDisponibili
     */
    public void setOreDisponibili(int oreDisponibili) {
        this.oreDisponibili = oreDisponibili;
    }
}
