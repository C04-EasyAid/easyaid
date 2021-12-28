package model.bean;

public class SupportoEsameBean {
    private int id;
    private String data;
    private String ora;
    private int oreRichieste;
    private String docente;
    private String modalitaEsame;
    private String eventualiAusili;
    private String tipoAssistenza;
    private int status;
    private String insegnamento;
    private String commento;
    private String luogo;
    private String dipartimento;
    private String studenteEmail;
    private String tutorEmail;
    private String profEmail;


    public SupportoEsameBean() {
    }

    public SupportoEsameBean(int id, String data, String ora, int oreRichieste, String docente, String modalitaEsame, String eventualiAusili, String tipoAssistenza, int status, String insegnamento, String commento, String luogo, String dipartimento, String studenteEmail, String tutorEmail, String profEmail) {
        this.id = id;
        this.data = data;
        this.ora = ora;
        this.oreRichieste = oreRichieste;
        this.docente = docente;
        this.modalitaEsame = modalitaEsame;
        this.eventualiAusili = eventualiAusili;
        this.tipoAssistenza = tipoAssistenza;
        this.status = status;
        this.insegnamento = insegnamento;
        this.commento = commento;
        this.luogo = luogo;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getOreRichieste() {
        return oreRichieste;
    }

    public void setOreRichieste(int oreRichieste) {
        this.oreRichieste = oreRichieste;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getModalitaEsame() {
        return modalitaEsame;
    }

    public void setModalitaEsame(String modalitaEsame) {
        this.modalitaEsame = modalitaEsame;
    }

    public String getEventualiAusili() {
        return eventualiAusili;
    }

    public void setEventualiAusili(String eventualiAusili) {
        this.eventualiAusili = eventualiAusili;
    }

    public String getTipoAssistenza() {
        return tipoAssistenza;
    }

    public void setTipoAssistenza(String tipoAssistenza) {
        this.tipoAssistenza = tipoAssistenza;
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

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
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
