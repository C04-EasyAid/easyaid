package model.dao;

import static model.dao.ConnectionPool.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import model.bean.StudenteBean;

/**
 * Classe StudenteDAO.
 *
 * @author Giovanni Toriello
 */

public class StudenteDAO implements IStudenteDAO {
  // Metodo che restituisce lo studente
  @Override
  public synchronized StudenteBean doRetrieveByEmail(String email) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "SELECT * FROM studente where email_studente = ?";
    StudenteBean bean = new StudenteBean();
    // Se la connessione è != null, entra nello statement
    try {
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email.toLowerCase(Locale.ROOT));
      ResultSet rs = stmt.executeQuery();
      // Se trova lo studente lo crea con tutti gli attributi
      if (rs.next()) {
        bean.setEmail(email);
        bean.setTipoDisabilita(rs.getString("tipo_di_disabilita"));
        bean.setSpecificheDisturbo(rs.getString("specifiche_disturbo"));
        bean.setPercentualeDisabilita(rs.getInt("percentuale_disabilita"));
        bean.setOreDisponibili(rs.getInt("ore_disponibili"));
      }
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bean;
  }

  /**
   * Metodo che aggiorane le ore disponibili di uno studente quando effettua una richiesta di servizio.
   * @param oreRichieste: le ore richieste per il servizio di tutorato/supporto esame.
   * @param emailStudente: l'email dello studente che ha richiesto il servizio.
   * @return true= se l'operazione è andata a buon fine,else altrimenti.
   * @throws SQLException
   */

  @Override
  public synchronized boolean updateOreDisponibili(int oreRichieste,String emailStudente) throws SQLException {
    boolean updated = false;
    Connection conn = null;
    String query = "UPDATE studente SET ore_disponibili=ore_disponibili-? WHERE email_studente = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, oreRichieste);
      stmt.setString(2, emailStudente);

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
