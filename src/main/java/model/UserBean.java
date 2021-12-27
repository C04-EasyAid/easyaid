package model;

import java.util.Locale;

public class UserBean {
  // Istanza della classe
  private static UserBean userBean = null;
  // Variabili dell'utente
  public String nome, cognome, email, password, ruolo;

  // Costruttore privato in accordo al Design Pattern Singleton
  private UserBean(String nome, String cognome, String email, String password, String ruolo) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.ruolo = ruolo.toUpperCase(Locale.ROOT);
  }

  public UserBean() {}

  // Metodo per l'accesso all'istanza della classe
  public static UserBean getInstance() {
    // Se l'istanza è nulla crea l'oggetto
    if (userBean == null) {
      userBean = new UserBean();
    }
    return userBean;
  }

  // Getter and Setter
  public String getRuolo() {
    return ruolo;
  }

  public UserBean setRuolo(String ruolo) {
    this.ruolo = ruolo;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserBean setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserBean setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public UserBean setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getCognome() {
    return cognome;
  }

  public UserBean setCognome(String cognome) {
    this.cognome = cognome;
    return this;
  }
  // Restituisce vero se l'utente è uno Studente
  public boolean isStudente() {
    boolean isStudent = false;
    if (this.getRuolo().equals("S")) {
      isStudent = true;
    }
    return isStudent;
  }
  // Restituisce vero se l'utente è un Tutor
  public boolean isTutor() {
    boolean isTutor = false;
    if (this.getRuolo().equals("T")) {
      isTutor = true;
    }
    return isTutor;
  }
  // Restituisce vero se l'utente è un Professore Referente
  public boolean isProfessoreReferente() {
    boolean isProf = false;
    if (this.getRuolo().equals("P")) {
      isProf = true;
    }
    return isProf;
  }
  // Restituisce vero se l'utente è un Personale Amministrativo
  public boolean isPersonaleAmministrativo() {
    boolean isPers = false;
    if (this.getRuolo().equals("PA")) {
      isPers = true;
    }
    return isPers;
  }

  @Override
  public String toString() {
    return "UserBean{"
        + "nome='"
        + nome
        + '\''
        + ", cognome='"
        + cognome
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + ", ruolo='"
        + ruolo
        + '\''
        + '}';
  }
}
