package model.bean;

public class StudenteBean {
  // Istanza della classe
  private static StudenteBean studentBean = null;
  // Variabili dell'utente
  private String email, tipoDisabilità, specificheDisturbo;
  private int oreDisponibili, percentualeDisabilità;
  // Costruttore privato in accordo al Design Pattern Singleton
  private StudenteBean(
      String email,
      String tipoDisabilità,
      String specificheDisturbo,
      int oreDisponibili,
      int percentualeDisabilità) {
    this.email = email;
    this.tipoDisabilità = tipoDisabilità;
    this.specificheDisturbo = specificheDisturbo;
    this.oreDisponibili = oreDisponibili;
    this.percentualeDisabilità = percentualeDisabilità;
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

  public String getTipoDisabilità() {
    return tipoDisabilità;
  }

  public StudenteBean setTipoDisabilità(String tipoDisabilità) {
    this.tipoDisabilità = tipoDisabilità;
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

  public int getPercentualeDisabilità() {
    return percentualeDisabilità;
  }

  public StudenteBean setPercentualeDisabilità(int percentualeDisabilità) {
    this.percentualeDisabilità = percentualeDisabilità;
    return this;
  }
}
