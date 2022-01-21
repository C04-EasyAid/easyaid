package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.TutorBean;

/**
 * Classe TutorDAO.
 *
 * @author Roberto Tartaglia
 */

public class TutorDAO implements ITutorDAO {
  @Override
  public synchronized TutorBean doRetrieveByEmail(String email)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutor WHERE email_tutor = '" + email + "'";
    TutorBean tutor = new TutorBean();
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        tutor.setEmailTutor(email);
        tutor.setDipartimento(rs.getString("dipartimento"));
        tutor.setOreDisponibili(rs.getInt("ore_disponibili"));
        tutor.setOreSvolte(rs.getInt("ore_svolte"));
        tutor.setQualifica(rs.getString("qualifica"));
      }
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return tutor;
  }

  /**
   * Metodo per aggiornare le ore disponibili di un tutor che accetta una richiesta di supporto.
   * @param oreRichieste: le ore della richiesta di tutorato didattico/supporto esame.
   * @param emailTutor: l'email del tutor per cui aggiornare le ore disponibili.
   * @return true = l'operazione è andata a buon fine,false altrimenti.
   * @throws SQLException
   */

  @Override
  public synchronized boolean updateOreDisponibili(int oreRichieste, String emailTutor) throws SQLException {
    boolean updated = false;
    Connection conn = null;
    String query = "UPDATE tutor SET ore_disponibili=ore_disponibili-? WHERE email_tutor = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, oreRichieste);
      stmt.setString(2, emailTutor);

      updated = stmt.executeUpdate() == 1;
      conn.commit();


      stmt.close();
      conn.close();
    } catch (SQLException e) {
      updated = true;
      e.printStackTrace();
    }

     return updated;
  }

  /**
   * Metodo che aggiorna le ore svolte di un tutor per una richiesta completata.
   * @param oreRichieste: le ore della richiesta di tutorato didattico/supporto esame.
   * @param emailTutor: l'email del tutor per cui aggiornare le ore disponibili.
   * @return true = l'operazione è andata a buon fine,false altrimenti.
   * @throws SQLException
   */

  @Override
  public synchronized boolean updateOreSvolte(int oreRichieste, String emailTutor) throws SQLException {
    boolean updated = false;
    Connection conn = null;
    String query = "UPDATE tutor SET ore_svolte=ore_svolte-? WHERE email_tutor = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, oreRichieste);
      stmt.setString(2, emailTutor);

      updated = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      updated = true;
      e.printStackTrace();
    }

    return updated;
  }






}
