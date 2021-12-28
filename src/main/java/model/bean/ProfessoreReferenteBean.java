package model.bean;

/**
 * @author Giovanni Toriello
 * Classe ProfessoreReferenteBean
 */
public class ProfessoreReferenteBean {
  // Variabili del professore referente
  private String email, dipartimento;

    /**
     * Costruttore
     * @param email
     * @param dipartimento
     */
    public ProfessoreReferenteBean(String email, String dipartimento) {
        this.email = email;
        this.dipartimento = dipartimento;
    }

    /**
     * Costruttore Vuoto
     */
    public ProfessoreReferenteBean(){

    }

    /**
     * Metodo che restituisce l'email del professore referente
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo che setta l'email del professore referente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo che restituisce il dipartimento del professore referente
     * @return
     */
    public String getDipartimento() {
        return dipartimento;
    }

    /**
     * Metodo che setta il dipartimento del professore referente
     * @param dipartimento
     */
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }
}

