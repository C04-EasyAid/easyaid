package model.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Locale;
import lombok.*;

/**
 * Classe UserBean.
 *
 * @author Giovanni Toriello
 */

@Data
public class UserBean implements HttpSessionBindingListener {
  // Variabili dell'utente
  private String nome;
  private String cognome;
  private String email;
  private String password;
  private String ruolo;

  /**
   * Costruttore.
   *
   * @param nome
   * @param cognome
   * @param email
   * @param password
   * @param ruolo
   */
  public UserBean(String nome, String cognome, String email, String password, String ruolo) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
    this.ruolo = ruolo.toUpperCase(Locale.ROOT);
  }

  // Costruttore Vuoto
  public UserBean() {}

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
  public void valueBound(HttpSessionBindingEvent event) {
    System.out.println("-- HttpSessionBindingListener#valueBound() --");
    System.out.printf(
        "Aggiunto attributo alla sessione con il nome : %s, valore:%s %n",
        event.getName(), event.getValue());
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    System.out.println("-- HttpSessionBindingEvent#valueUnbound() --");
    System.out.printf(
        "Rimosso attributo alla sessione con il nome : %s, valore:%s %n",
        event.getName(), event.getValue());
  }
}
