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

/*
@author Serena Liguori
Classe LezioneDAO
 */
public class LezioneDAO {
    //Metodo che restitiusce una lezione in base all'id passato come parametro
    public static synchronized Collection<LezioneBean> doRetrieveLezione(int id)
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
            LezioneBean bean = null;
            while (rs.next()) {
                bean=new LezioneBean(rs.getInt("id"),rs.getInt("tutorato"),rs.getString("ora_inizio"), rs.getString("ora_fine"), rs.getDate("data"), rs.getString("tutor"), rs.getBoolean("status"));
                lezioni.add(bean);
            }
        } catch (SQLException e) {

        } finally {
            if(stmt!=null)
                stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return lezioni;
    }
    public static synchronized LezioneBean doRetrieveLezioneById(int id)
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        LezioneBean bean = null;
        PreparedStatement stmt = null;
        String query = "SELECT * FROM lezione WHERE id=?";
        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bean=new LezioneBean(rs.getInt("id"),rs.getInt("tutorato"),rs.getString("ora_inizio"), rs.getString("ora_fine"), rs.getDate("data"), rs.getString("tutor"), rs.getBoolean("status"));
            }
        } catch (SQLException e) {

        } finally {
            if(stmt!=null)
                stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return bean;
    }
    public static synchronized Collection<LezioneBean> doRetrieveLezioneByStudente(String studente)
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Collection<LezioneBean> lezioni = new ArrayList<>();
        PreparedStatement stmt = null;
        String query = "SELECT * from lezione L inner join tutorato_didattico T inner join studente s where L.tutorato = T.idtutorato_didattico AND s.email_studente = T.studente_email AND s.email_studente =?";
        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,studente);
            LezioneBean lezione = new LezioneBean();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lezione = new LezioneBean(rs.getInt("id"),rs.getInt("tutorato"),rs.getString("ora_inizio"), rs.getString("ora_fine"), rs.getDate("data"), rs.getString("tutor"), rs.getBoolean("status"));
                lezione.setInsegnamento(rs.getString("insegnamento"));
                lezioni.add(lezione);
            }
        } catch (SQLException e) {

        } finally {
            if(stmt!=null)
                stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return lezioni;
    }
    public static synchronized Collection<LezioneBean> doRetrieveLezioneByTutor(String tutor)
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Collection<LezioneBean> lezioni = new ArrayList<>();
        PreparedStatement stmt = null;
        String query = "SELECT * from lezione L inner join tutorato_didattico T inner join tutor v where L.tutorato = T.idtutorato_didattico AND v.email_tutor = T.tutor_email AND v.email_tutor=? ";
        try {
            conn = conn();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tutor);
            LezioneBean lezione = new LezioneBean();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lezione = new LezioneBean(rs.getInt("id"),rs.getInt("tutorato"),rs.getString("ora_inizio"), rs.getString("ora_fine"), rs.getDate("data"), rs.getString("tutor"), rs.getBoolean("status"));
                lezione.setInsegnamento(rs.getString("insegnamento"));
                lezioni.add(lezione);
            }
        } catch (SQLException e) {

        } finally {
            if(stmt!=null)
                stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
        return lezioni;
    }

}