package model.dao;

import model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.dao.ConnectionPool.conn;

public class UserBeanDAO {
  // Metodo che restituisce l'utente dal database
  public static synchronized UserBean doRetrieve(UserBean b)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM utente WHERE email = ? AND password = ?";
    UserBean user = null;
    PreparedStatement stmt = null;
    // Se riesce a connettersi la connessione è != da null entra nello statement
    try{
      conn = conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, b.getEmail());
      stmt.setString(2, b.getPassword());
      ResultSet rs = stmt.executeQuery();
      // Se trova l'utente lo crea con tutti gli attributi
      if (rs.next()) {
        user = UserBean.getInstance();
        user.setNome(rs.getString("nome"));
        user.setCognome(rs.getString("cognome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("nome"));
        user.setRuolo(rs.getString("ruolo"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      stmt.close();
      if(conn!=null){
        conn.close();
      }
    }
    return user;
  }


}
