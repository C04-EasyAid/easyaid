package model.bean;

/**
 * @author Martina Giugliano
 * Classe Supporto Esame
 */
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

    /**
     * Costruttore vuoto.
     */
    public SupportoEsameBean() {
    }

    /**
     * Costruttore.
     * @param id
     * @param data
     * @param ora
     * @param oreRichieste
     * @param docente
     * @param modalitaEsame
     * @param eventualiAusili
     * @param tipoAssistenza
     * @param status
     * @param insegnamento
     * @param commento
     * @param luogo
     * @param dipartimento
     * @param studenteEmail
     * @param tutorEmail
     * @param profEmail
     */
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

    /**
     * Metodo che restituisce l'id del supporto esame.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che setta l'id del supporto esame.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che restituisce la data del supporto esame.
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * Metodo che setta la data del supporto esame.
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Metodo che restituisce l'ora del supporto esame.
     * @return
     */
    public String getOra() {
        return ora;
    }

    /**
     * Metodo che setta l'ora del supporto esame.
     * @param ora
     */
    public void setOra(String ora) {
        this.ora = ora;
    }

    /**
     * Metodo che restituisce le ore richieste del supporto esame.
     * @return
     */
    public int getOreRichieste() {
        return oreRichieste;
    }

    /**
     * Metodo che setta le ore richieste del supporto esame.
     * @param oreRichieste
     */
    public void setOreRichieste(int oreRichieste) {
        this.oreRichieste = oreRichieste;
    }

    /**
     * Metodo che restituisce il docente del supporto esame.
     * @return
     */
    public String getDocente() {
        return docente;
    }

    /**
     * Metodo che setta il docente del supporto esame.
     * @param docente
     */
    public void setDocente(String docente) {
        this.docente = docente;
    }

    /**
     * Metodo che restituisce la modalità d'esame del supporto esame.
     * @return
     */
    public String getModalitaEsame() {
        return modalitaEsame;
    }

    /**
     * Metodo che setta la modalità d'esame del supporto esame.
     * @param modalitaEsame
     */
    public void setModalitaEsame(String modalitaEsame) {
        this.modalitaEsame = modalitaEsame;
    }

    /**
     * Metodo che restituisce gli eventuali ausili del supporto esame.
     * @return
     */
    public String getEventualiAusili() {
        return eventualiAusili;
    }

    /**
     * Metodo che setta gli eventuali ausili del supporto esame.
     * @param eventualiAusili
     */
    public void setEventualiAusili(String eventualiAusili) {
        this.eventualiAusili = eventualiAusili;
    }

    /**
     * Metodo che restituisce il tipo di Assistenza del supporto esame.
     * @return
     */
    public String getTipoAssistenza() {
        return tipoAssistenza;
    }

    /**
     * Metodo che setta il tipo di assistenza del supporto esame.
     * @param tipoAssistenza
     */
    public void setTipoAssistenza(String tipoAssistenza) {
        this.tipoAssistenza = tipoAssistenza;
    }

    /**
     * Metodo che restituisce lo status del supporto esame.
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Metodo che setta lo status del supporto esame.
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Metodo che restituisce l'insegnamento del supporto esame.
     * @return
     */
    public String getInsegnamento() {
        return insegnamento;
    }

    /**
     *Metodo che setta l'insegnamento del supporto esame.
     * @param insegnamento
     */
    public void setInsegnamento(String insegnamento) {
        this.insegnamento = insegnamento;
    }

    /**
     * Metodo che restituisce un commento del supporto esame.
     * @return
     */
    public String getCommento() {
        return commento;
    }

    /**
     * Metodo che setta un commento del supporto esame.
     * @param commento
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    /**
     * Metodo che restituisce un luogo del supporto esame.
     * @return
     */
    public String getLuogo() {
        return luogo;
    }

    /**
     * Metodo che setta un luogo del supporto esame.
     * @param luogo
     */
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    /**
     * Metodo che restituisce un dipartimento del supporto esame.
     * @return
     */
    public String getDipartimento() {
        return dipartimento;
    }

    /**
     * Metodo che setta un dipartimento del supporto esame.
     * @param dipartimento
     */
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    /**
     * Metodo che restituisce l'email di uno studente del supporto esame.
     * @return
     */
    public String getStudenteEmail() {
        return studenteEmail;
    }

    /**
     * Metodo che setta l'email di uno studente del supporto esame.
     * @param studenteEmail
     */
    public void setStudenteEmail(String studenteEmail) {
        this.studenteEmail = studenteEmail;
    }

    /**
     * Metodo che restituisce l'email di un tutor del supporto esame.
     * @return
     */
    public String getTutorEmail() {
        return tutorEmail;
    }

    /**
     * Metodo che setta l'email di un tutor del supporto esame.
     * @param tutorEmail
     */
    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    /**
     * Metodo che restituisce l'email di un professore referente del supporto esame.
     * @return
     */
    public String getProfEmail() {
        return profEmail;
    }

    /**
     * Metodo che setta l'email di un professore referente del supporto esame.
     * @param profEmail
     */
    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }
}
