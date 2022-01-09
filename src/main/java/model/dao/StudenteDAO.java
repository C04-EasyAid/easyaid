package model.dao;

import static model.dao.ConnectionPool.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import model.bean.StudenteBean;
import model.bean.UserBean;



/**
 *  @author Giovanni Toriello Classe StudenteDAO
 *
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

    } catch (SQLException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    } finally {
      if (stmt != null) stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return bean;
  }

  // Metodo che restituisce true se è lo studente è stato inserito
  public synchronized boolean insertStudente(StudenteBean s, UserBean b) throws SQLException {
    boolean studente = false;
    UserDAO userDao = new UserDAO();
    if (userDao.insertUtente(b)) {
      Connection conn = null;
      String query = "INSERT INTO studente VALUES (?,?,?,?,?)";
      PreparedStatement stmt = null;
      try {
        conn = ConnectionPool.conn();
        stmt = conn.prepareStatement(query);
        // Setta i paremetri nella query
        stmt.setString(1, s.getEmail());
        stmt.setString(2, s.getTipoDisabilita());
        stmt.setString(3, s.getSpecificheDisturbo());
        stmt.setInt(4, s.getPercentualeDisabilita());
        stmt.setInt(5, s.getOreDisponibili());
        // Esegue la query
        ResultSet rs = null;
        studente = stmt.executeUpdate() == 1;
        conn.commit();
      } catch (SQLException e) {
        studente = false;
        e.printStackTrace();
        // Chiude la connessione se è diverso da null
      } finally {
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      }
    }
    return studente;
  }
}
