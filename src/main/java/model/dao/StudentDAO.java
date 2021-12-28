package model.dao;

import model.bean.StudenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import static model.dao.ConnectionPool.conn;

public class StudentDAO {
  //Metodo che restituisce lo studente
  public synchronized StudenteBean doRetrieveByEmail(String email) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "SELECT * FROM studente where email_studente = ?";
    StudenteBean bean = new StudenteBean();
    //Se la connessione è != null, entra nello statement
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

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      // Chiude la connessione se è diverso da null
    } finally {
      stmt.close();
      if (conn != null) {
        conn.close();
      }
    }
    return bean;
  }
}
