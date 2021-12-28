package model.dao;

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
        String query = "SELECT * FROM lezione WHERE lezione=?";

        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            CommentoBean bean = null;
            while (rs.next()) {
                bean =
                        new CommentoBean(
                                rs.getInt("lezione"), rs.getInt("tutorato"), rs.getString("testo"), rs.getDate("data"), rs.getString("ora"), rs.getString("studente"), rs.getString("tutor"));
                commenti.add(bean);
            }
        } catch (SQLException e) {

        } finally {
            stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return commenti;
    }
}
