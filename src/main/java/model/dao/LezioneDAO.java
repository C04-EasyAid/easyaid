package model.dao;

import model.bean.LezioneBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static model.dao.ConnectionPool.conn;

/*
@author Serena Liguori
Classe LezioneDAO
 */
public class LezioneDAO {
  // Metodo che restitiusce una lezione in base all'id passato come parametro
  public synchronized LezioneBean doRetrieveLezioneById(int id)
      throws ClassNotFoundException, SQLException {
    Connection conn = null;
    LezioneBean bean = null;
    PreparedStatement stmt = null;
    String query =
        "SELECT * from easyaid.lezione L inner join tutorato_didattico T where L.tutorato = T.idtutorato_didattico AND L.tutorato ="
            + id;
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        bean =
            new LezioneBean(
                rs.getInt("id"),
                rs.getInt("tutorato"),
                rs.getString("ora_inizio"),
                rs.getString("ora_fine"),
                rs.getDate("data"),
                rs.getString("tutor"),
                rs.getBoolean("status"));
        bean.setInsegnamento(rs.getString("insegnamento"));
        bean.setEmailStudente(rs.getString("studente_email"));
      }
    } catch (SQLException e) {

    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return bean;
  }


  //Metodo che restituisce le lezione tramite l'id del tutorato
  public synchronized Collection<LezioneBean> doRetrieveAllLezioniById(int id)
      throws ClassNotFoundException, SQLException {
    Connection conn = null;
    LezioneBean bean = null;
    PreparedStatement stmt = null;
    Collection<LezioneBean> lezioni = new ArrayList<>();
    String query =
        "SELECT * from easyaid.lezione L inner join tutorato_didattico T where L.tutorato = T.idtutorato_didattico AND L.tutorato ="
            + id;
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        bean =
            new LezioneBean(
                rs.getInt("id"),
                rs.getInt("tutorato"),
                rs.getString("ora_inizio"),
                rs.getString("ora_fine"),
                rs.getDate("data"),
                rs.getString("tutor"),
                rs.getBoolean("status"));
        bean.setInsegnamento(rs.getString("insegnamento"));
        bean.setEmailStudente(rs.getString("studente_email"));
        lezioni.add(bean);
      }
    } catch (SQLException e) {

    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return lezioni;
  }
  // Metodo che restituisce tutte le lezioni di un determinato studente il quale è stato passato
  // come parametro
  public synchronized Collection<LezioneBean> doRetrieveLezioneByStudente(String studente)
      throws ClassNotFoundException, SQLException {
    Connection conn = null;
    Collection<LezioneBean> lezioni = new ArrayList<>();
    PreparedStatement stmt = null;
    String query =
        "SELECT * from lezione L inner join tutorato_didattico T inner join studente s where L.tutorato = T.idtutorato_didattico AND s.email_studente = T.studente_email AND s.email_studente =?";
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, studente);
      LezioneBean lezione = new LezioneBean();
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        lezione =
            new LezioneBean(
                rs.getInt("id"),
                rs.getInt("tutorato"),
                rs.getString("ora_inizio").substring(0, 5),
                rs.getString("ora_fine").substring(0, 5),
                rs.getDate("data"),
                rs.getString("tutor"),
                rs.getBoolean("status"));
        lezione.setInsegnamento(rs.getString("insegnamento"));
        lezione.setEmailStudente(rs.getString("studente_email"));
        lezioni.add(lezione);
      }
    } catch (SQLException e) {

    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return lezioni;
  }

  // Metodo che restituisce tutte le lezioni di un determinato tutor il quale è stato passato come
  // parametro
  public synchronized Collection<LezioneBean> doRetrieveLezioneByTutor(String tutor)
      throws ClassNotFoundException, SQLException {
    Connection conn = null;
    Collection<LezioneBean> lezioni = new ArrayList<>();
    PreparedStatement stmt = null;
    String query =
        "SELECT * from lezione L inner join tutorato_didattico T inner join tutor v where L.tutorato = T.idtutorato_didattico AND v.email_tutor = T.tutor_email AND v.email_tutor=? ";
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, tutor);
      LezioneBean lezione = new LezioneBean();
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        lezione =
            new LezioneBean(
                rs.getInt("id"),
                rs.getInt("tutorato"),
                rs.getString("ora_inizio").substring(0, 5),
                rs.getString("ora_fine").substring(0, 5),
                rs.getDate("data"),
                rs.getString("tutor"),
                rs.getBoolean("status"));
        lezione.setInsegnamento(rs.getString("insegnamento"));
        lezione.setEmailStudente(rs.getString("studente_email"));
        lezioni.add(lezione);
      }
    } catch (SQLException e) {

    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return lezioni;
  }

  //Metodi che restituisce l'id del tutorato dalla lezione
  public synchronized int doRetrieveTutoratoByLezione(int lezione) throws SQLException {
    int idTutorato = 0;
    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "SELECT tutorato FROM lezione WHERE id = ?";
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, lezione);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        idTutorato = rs.getInt("tutorato");
      }
    } catch (SQLException e) {

    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return idTutorato;
  }
//Metodo che restituisce un booleano
// true = Se la somma delle ore delle lezioni è uguali alle ore richieste
// false = Se la somma delle ore delle lezioni non è uguali alle ore richieste
  private synchronized boolean countOre(Collection<LezioneBean> lezioni) throws SQLException, ClassNotFoundException {
    boolean uguale = false;
    int count = 0;
    List<LezioneBean> lezioniS = (List<LezioneBean>) lezioni;
    TutoratoDidatticoDAO dao = new TutoratoDidatticoDAO();
    int idTutorato = doRetrieveTutoratoByLezione(lezioniS.get(0).getId());
    int oreRichieste = dao.doRetriveById(idTutorato).getOreRichieste();
    for (LezioneBean x : lezioni) {
      String oraInizio = x.getOraInizio();
      String oraFine = x.getOraFine();
      int g = 0;
      long t = 0;
      SimpleDateFormat dateParser = new SimpleDateFormat("HH:mm");
      {
        try {
          Date inizio = dateParser.parse(oraInizio);
          Date fine = dateParser.parse(oraFine);
          t = fine.getTime() - inizio.getTime();
          int minutes = (int) ((t / 1000) / 60);
          g = minutes / 60;

        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
      count+= g;
    }
    if(count==oreRichieste){
      uguale=true;
    }
    return uguale;
  }

}
