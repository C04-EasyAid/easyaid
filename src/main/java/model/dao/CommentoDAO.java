package model.dao;

/*
@author Mariagiovanna Bianco
Classe CommentoDAO
 */
import model.bean.CommentoBean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static model.dao.ConnectionPool.conn;

public class CommentoDAO {
    public synchronized Collection<CommentoBean> doRetrieveCommento(int id)
            throws ClassNotFoundException, SQLException {
        Collection<CommentoBean> commenti = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "SELECT * FROM commento WHERE lezione=?";
        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            CommentoBean bean = null;
            while (rs.next()) {
                bean = new CommentoBean(rs.getInt("lezione"), rs.getInt("tutorato"), rs.getString("testo"), rs.getDate("data"), rs.getString("ora"), rs.getString("studente"), rs.getString("tutor"));
                commenti.add(bean);
            }
        } catch (SQLException e) {

        } finally {
            if(stmt!=null)
                stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return commenti;
    }

}