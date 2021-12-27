package model.bean;

public class ProfessoreReferenteBean {
  // Variabili del professore referente
  private String email, dipartimento;

    public ProfessoreReferenteBean(String email, String dipartimento) {
        this.email = email;
        this.dipartimento = dipartimento;
    }
    public ProfessoreReferenteBean(){

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

