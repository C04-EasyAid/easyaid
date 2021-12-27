package model.bean;

public class PersonaleAmministrativoBean {
    private String emailPersonaleAmministrativo;
    private static PersonaleAmministrativoBean personaleAmministrativoBean = null;

    private PersonaleAmministrativoBean(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }

    public PersonaleAmministrativoBean() {
    }

    public static PersonaleAmministrativoBean getInstance() {
        // Se l'istanza è nulla crea l'oggetto
        if (personaleAmministrativoBean == null) {
            personaleAmministrativoBean = new PersonaleAmministrativoBean();
        }
        return personaleAmministrativoBean;
    }

    public String getEmailPersonaleAmministrativo() {
        return emailPersonaleAmministrativo;
    }

    public void setEmailPersonaleAmministrativo(String emailPersonaleAmministrativo) {
        this.emailPersonaleAmministrativo = emailPersonaleAmministrativo;
    }
}
