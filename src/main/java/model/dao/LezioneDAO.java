package model.dao;

import model.bean.LezioneBean;
import model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static model.dao.ConnectionPool.conn;

public class LezioneDAO {
    public synchronized Collection<LezioneBean> doRetrieveLezione(int id)
            throws ClassNotFoundException, SQLException {
        Collection<LezioneBean> lezioni = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "SELECT * FROM lezione WHERE tutorato=?";

        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            LezioneBean bean = new LezioneBean();
            while (rs.next()) {
                bean=new LezioneBean(rs.getInt("tutorato"),rs.getString("ora_inizio"), rs.getString("ora_fine"), rs.getDate("data"), rs.getString("tutor"), rs.getBoolean("status"));
                lezioni.add(bean);
            }
        } catch (SQLException e) {

        } finally {
            stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return lezioni;
    }


}
