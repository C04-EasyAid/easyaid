package model.bean;

import java.util.Locale;

public class UserBean {
  // Variabili dell'utente
  public String nome, cognome, email, password, ruolo;

  public UserBean(String nome, String cognome, String email, String password, String ruolo) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.ruolo = ruolo.toUpperCase(Locale.ROOT);
  }

  public UserBean() {
  }

  // Getter and Setter

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRuolo() {
    return ruolo;
  }

  public void setRuolo(String ruolo) {
    this.ruolo = ruolo;
  }

  // Restituisce vero se l'utente è uno Studente
  public boolean isStudente() {
    boolean isStudent = this.getRuolo().equals("S");
    return isStudent;
  }
  // Restituisce vero se l'utente è un Tutor
  public boolean isTutor() {
    boolean isTutor = this.getRuolo().equals("T");
    return isTutor;
  }
  // Restituisce vero se l'utente è un Professore Referente
  public boolean isProfessoreReferente() {
    boolean isProf = this.getRuolo().equals("P");
    return isProf;
  }
  // Restituisce vero se l'utente è un Personale Amministrativo
  public boolean isPersonaleAmministrativo() {
    boolean isPers = this.getRuolo().equals("PA");
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
