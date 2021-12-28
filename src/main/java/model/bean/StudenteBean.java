package model.bean;
/**
 * @author Giovanni Toriello
 * Classe StudenteBean
 */
public class StudenteBean {

  // Variabili dell'utente
  private String email, tipoDisabilita, specificheDisturbo;
  private int oreDisponibili, percentualeDisabilita;

  /**
   * Costruttore
   * @param email
   * @param tipoDisabilita
   * @param specificheDisturbo
   * @param oreDisponibili
   * @param percentualeDisabilita
   */
  public StudenteBean(
      String email,
      String tipoDisabilita,
      String specificheDisturbo,
      int oreDisponibili,
      int percentualeDisabilita) {
    this.email = email;
    this.tipoDisabilita = tipoDisabilita;
    this.specificheDisturbo = specificheDisturbo;
    this.oreDisponibili = oreDisponibili;
    this.percentualeDisabilita = percentualeDisabilita;
  }

  /**
   * Costruttore vuoto
   */
  public StudenteBean() {}

  /**
   * Metodo che restituisce l'email dello studente
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   * Metodo che setta l'email dello studente
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Metodo che restituisce il tipo di disabilità dello studente
   * @return
   */
  public String getTipoDisabilita() {
    return tipoDisabilita;
  }

  /**
   * Metodo che setta il tipo di disabilità dello studente
   * @param tipoDisabilita
   */
  public void setTipoDisabilita(String tipoDisabilita) {
    this.tipoDisabilita = tipoDisabilita;
  }

  /**
   * Metodo Che restituisce le specifiche di disturbo dello studente
   * @return
   */
  public String getSpecificheDisturbo() {
    return specificheDisturbo;
  }

  /**
   * Metodo che setta le specifiche di disturbo dello studente
   * @param specificheDisturbo
   */
  public void setSpecificheDisturbo(String specificheDisturbo) {
    this.specificheDisturbo = specificheDisturbo;
  }

  /**
   * Metodo che restituisce le ore disponibili dello studente
   * @return
   */
  public int getOreDisponibili() {
    return oreDisponibili;
  }

  /**
   * Metodo he setta le ore disponibili dello studente
   * @param oreDisponibili
   */
  public void setOreDisponibili(int oreDisponibili) {
    this.oreDisponibili = oreDisponibili;
  }

  /**
   * Metodo che restituisce la percentuale di disabilità dello studente
   * @return
   */
  public int getPercentualeDisabilita() {
    return percentualeDisabilita;
  }

  /**
   * Metodo che setta la percentuale di disabilità dello studente
   * @param percentualeDisabilita
   */
  public void setPercentualeDisabilita(int percentualeDisabilita) {
    this.percentualeDisabilita = percentualeDisabilita;
  }
}
