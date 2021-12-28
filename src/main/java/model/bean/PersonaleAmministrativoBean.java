package model.bean;

public class PersonaleAmministrativoBean {
    private String emailPersonaleAmministrativo;

    public PersonaleAmministrativoBean(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }

    public PersonaleAmministrativoBean() {
    }


    public String getEmailPersonaleAmministrativo() {
        return emailPersonaleAmministrativo;
    }

    public void setEmailPersonaleAmministrativo(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }
}
