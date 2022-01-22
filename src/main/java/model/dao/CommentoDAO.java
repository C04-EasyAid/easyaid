package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import model.bean.CommentoBean;

import static model.dao.ConnectionPool.conn;

/**
 * Classe CommentoDAO.
 *
 * @author Mariagiovanna Bianco
 */

public class CommentoDAO implements ICommentoDAO {
  // Metodo che restituisce il commento
  @Override
  public synchronized Collection<CommentoBean> doRetrieveCommento(int id)
      throws ClassNotFoundException, SQLException {
    Collection<CommentoBean> commenti = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "SELECT * FROM commento WHERE lezione=?";
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      CommentoBean bean = null;
      while (rs.next()) {
        bean =
            new CommentoBean(
                rs.getInt("lezione"),
                rs.getInt("tutorato"),
                rs.getString("testo"),
                rs.getDate("data"),
                rs.getString("ora"),
                rs.getString("studente"),
                rs.getString("tutor"));
        bean.setId(rs.getInt("id"));
        commenti.add(bean);
      }
      stmt.close();
      conn.close();
    } catch (SQLException e) {
       e.printStackTrace();
    }


    return commenti;
  }

  // Metodo che restituisce un booleano
  // true=commento inserito
  // false=commento non inserito
  @Override
  public synchronized boolean insertCommentoTutor(int lezione, String msg, String emailMittente)
      throws SQLException {
    boolean result = false;
    LezioneDAO dao = new LezioneDAO();
    Connection conn = null;
    PreparedStatement stmt = null;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    String ora = dtf.format(LocalDateTime.now());
    String data = String.valueOf(LocalDate.now());
    int idTutorato = dao.doRetrieveTutoratoByLezione(lezione);
    String query =
        "INSERT INTO easyaid.commento " +
                "(lezione, tutorato, testo, data, ora, tutor) VALUES (?,?,?,?,?,?);";
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, lezione);
      stmt.setInt(2, idTutorato);
      stmt.setString(3, msg);
      stmt.setString(4, data);
      stmt.setString(5, ora);
      stmt.setString(6, emailMittente);

      result = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();

    } catch (SQLException e) {
      result = false;
    }


    return result;
  }

  // Metodo che restituisce un booleano
  // true=commento inserito
  // false=commento non inserito
  @Override
  public synchronized boolean insertCommentoStudente(int lezione, String msg, String emailMittente)
      throws SQLException {
    boolean result = false;
    LezioneDAO dao = new LezioneDAO();
    Connection conn = null;
    PreparedStatement stmt = null;
    GregorianCalendar today = new GregorianCalendar();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    String ora = dtf.format(LocalDateTime.now());
    String data = String.valueOf(LocalDate.now());
    int idTutorato = dao.doRetrieveTutoratoByLezione(lezione);
    String query =
        "INSERT INTO easyaid.commento" +
                " (lezione, tutorato, testo, data, ora, studente) VALUES (?,?,?,?,?,?);";
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, lezione);
      stmt.setInt(2, idTutorato);
      stmt.setString(3, msg);
      stmt.setString(4, data);
      stmt.setString(5, ora);
      stmt.setString(6, emailMittente);
      result = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      result = false;
    }
    return result;
  }

  @Override
  public synchronized boolean deleteCommento(CommentoBean b) throws SQLException {
    boolean delete = false;
    Connection conn = null;
    String query = "DELETE FROM commento WHERE id = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, b.getId());
      delete = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return delete;
  }
}
