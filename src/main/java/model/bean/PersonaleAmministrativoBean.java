package model.bean;

/**
 * @author Roberto Tartaglia
 * Classe PersonaleAmministrativoBean
 */
public class PersonaleAmministrativoBean {
    private String emailPersonaleAmministrativo;

    /**
     * Costruttore
     * @param emailPersonaleAmministrativo
     */
    public PersonaleAmministrativoBean(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }

    /**
     * Costruttore Vuoto
     */
    public PersonaleAmministrativoBean() {
    }

    /**
     * Metodo che restituisce l'email del personale amministrativo
     * @return
     */

    public String getEmailPersonaleAmministrativo() {
        return emailPersonaleAmministrativo;
    }

    /**
     * Metodo che setta l'email del personale amministrativo
     * @param emailPersonaleAmministrativo
     */
    public void setEmailPersonaleAmministrativo(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }
}
