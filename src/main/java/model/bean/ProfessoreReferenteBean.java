package model.bean;

public class ProfessoreReferenteBean {
    // Istanza della classe
    private static ProfessoreReferenteBean profBean = null;
    // Variabili del professore
    private String email, dipartimento;

    private ProfessoreReferenteBean(String email, String dipartimento) {
        this.email = email;
        this.dipartimento = dipartimento;
    }
    private ProfessoreReferenteBean(){}
    // Metodo per l'accesso all'istanza della classe
    public static ProfessoreReferenteBean getInstance() {
        // Se l'istanza è nulla crea l'oggetto
        if (profBean == null) {
            profBean = new ProfessoreReferenteBean();
        }
        return profBean;
    }

    public static ProfessoreReferenteBean getProfBean() {
        return profBean;
    }

    public static void setProfBean(ProfessoreReferenteBean profBean) {
        ProfessoreReferenteBean.profBean = profBean;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }
}
