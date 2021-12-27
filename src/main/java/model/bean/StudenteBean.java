package model.bean;

public class StudenteBean {
  // Istanza della classe
  private static StudenteBean studentBean = null;
  // Variabili dell'utente
  private String email, tipoDisabilita, specificheDisturbo;
  private int oreDisponibili, percentualeDisabilita;
  // Costruttore privato in accordo al Design Pattern Singleton
  private StudenteBean(
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

  private StudenteBean() {}
  // Metodo per l'accesso all'istanza della classe
  public static StudenteBean getInstance() {
    // Se l'istanza è nulla crea l'oggetto
    if (studentBean == null) {
      studentBean = new StudenteBean();
    }
    return studentBean;
  }
  // Getter and Setter
  public String getEmail() {
    return email;
  }

  public StudenteBean setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getTipoDisabilita() {
    return tipoDisabilita;
  }

  public StudenteBean setTipoDisabilita(String tipoDisabilita) {
    this.tipoDisabilita = tipoDisabilita;
    return this;
  }

  public String getSpecificheDisturbo() {
    return specificheDisturbo;
  }

  public StudenteBean setSpecificheDisturbo(String specificheDisturbo) {
    this.specificheDisturbo = specificheDisturbo;
    return this;
  }

  public int getOreDisponibili() {
    return oreDisponibili;
  }

  public StudenteBean setOreDisponibili(int oreDisponibili) {
    this.oreDisponibili = oreDisponibili;
    return this;
  }

  public int getPercentualeDisabilita() {
    return percentualeDisabilita;
  }

  public StudenteBean setPercentualeDisabilita(int percentualeDisabilita) {
    this.percentualeDisabilita = percentualeDisabilita;
    return this;
  }
}
