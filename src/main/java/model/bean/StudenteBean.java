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

  public static StudenteBean getStudentBean() {
    return studentBean;
  }

  public static void setStudentBean(StudenteBean studentBean) {
    StudenteBean.studentBean = studentBean;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTipoDisabilita() {
    return tipoDisabilita;
  }

  public void setTipoDisabilita(String tipoDisabilita) {
    this.tipoDisabilita = tipoDisabilita;
  }

  public String getSpecificheDisturbo() {
    return specificheDisturbo;
  }

  public void setSpecificheDisturbo(String specificheDisturbo) {
    this.specificheDisturbo = specificheDisturbo;
  }

  public int getOreDisponibili() {
    return oreDisponibili;
  }

  public void setOreDisponibili(int oreDisponibili) {
    this.oreDisponibili = oreDisponibili;
  }

  public int getPercentualeDisabilita() {
    return percentualeDisabilita;
  }

  public void setPercentualeDisabilita(int percentualeDisabilita) {
    this.percentualeDisabilita = percentualeDisabilita;
  }
}
