package model.dao;

import model.bean.TutoratoDidatticoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martina Giugliano
 * DAO Tutorato didattico per gestire i dati del Database relativo al tutorato didattico.
 */

public class TutoratoDidatticoDAO {


    /**
     * Metodo che restituisce tutte le richieste di Tutorato Didattico dal DB.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public synchronized List<TutoratoDidatticoBean> doRetriveAll() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM tutorato_didattico";
        List<TutoratoDidatticoBean> list=new ArrayList<>();


        PreparedStatement stmt=null;

        try {
            conn = ConnectionPool.conn();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
            while (rs.next()) {
                bean.setId(rs.getInt("idtutorato_didattico"));
                bean.setDateDisponibili(rs.getString("date_disponibili"));
                bean.setOreDisponibili(rs.getString("ore_disponibili"));
                bean.setOreRichieste(rs.getInt("ore_richieste"));
                bean.setCommento(rs.getString("commento"));
                bean.setStatus(rs.getInt("status"));
                bean.setInsegnamento(rs.getString("insegnamento"));
                bean.setDipartimento(rs.getString("dipartimento"));
                bean.setStudenteEmail(rs.getString("studente_email"));
                bean.setTutorEmail(rs.getString("tutor_email"));
                bean.setProfEmail(rs.getString("prof_refe_email"));
                list.add(bean);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;

    }


    /**
     * Metodo che restituisce le richieste di Tutorato Didattico effettuate tramite e-mail studente.
     * @param emailStudente
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public synchronized List<TutoratoDidatticoBean> doRetrieveAllByStudente(String emailStudente)  throws SQLException,ClassNotFoundException
    {
        Connection conn=null;
        String query="SELECT * FROM tutorato_didattico WHERE studente_email=?";
        PreparedStatement stmt=null;
        List<TutoratoDidatticoBean> list=new ArrayList<>();
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            stmt.setString(1,emailStudente);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                bean.setId(rs.getInt("idtutorato_didattico"));
                bean.setDateDisponibili(rs.getString("date_disponibili"));
                bean.setOreDisponibili(rs.getString("ore_disponibili"));
                bean.setOreRichieste(rs.getInt("ore_richieste"));
                bean.setCommento(rs.getString("commento"));
                bean.setStatus(rs.getInt("status"));
                bean.setInsegnamento(rs.getString("insegnamento"));
                bean.setDipartimento(rs.getString("dipartimento"));
                bean.setStudenteEmail(rs.getString("studente_email"));
                bean.setTutorEmail(rs.getString("tutor_email"));
                bean.setProfEmail(rs.getString("prof_refe_email"));
                list.add(bean);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;
    }

    /**
     * Metodo per restituire le richieste accettate da un tutor
     * @param emailTutor:e-mail del tutor che ha accettato la richiesta di supporto esame
     * @return la lista delle richieste di tutorato didattico accettate dal tutor
     * @throws SQLException:Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<TutoratoDidatticoBean> doRetrieveAllByTutor(String emailTutor) throws SQLException,ClassNotFoundException
    {
        Connection conn=null;
        String query="SELECT * FROM tutorato_didattico WHERE tutor_email=?";
        PreparedStatement stmt=null;
        List<TutoratoDidatticoBean> list=new ArrayList<>();
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            stmt.setString(1,emailTutor);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                bean.setId(rs.getInt("idtutorato_didattico"));
                bean.setDateDisponibili(rs.getString("date_disponibili"));
                bean.setOreDisponibili(rs.getString("ore_disponibili"));
                bean.setOreRichieste(rs.getInt("ore_richieste"));
                bean.setCommento(rs.getString("commento"));
                bean.setStatus(rs.getInt("status"));
                bean.setInsegnamento(rs.getString("insegnamento"));
                bean.setDipartimento(rs.getString("dipartimento"));
                bean.setStudenteEmail(rs.getString("studente_email"));
                bean.setTutorEmail(rs.getString("tutor_email"));
                bean.setProfEmail(rs.getString("prof_refe_email"));
                list.add(bean);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;
    }

    /**
     * Metodo che restituisce la lista delle richieste di tutorato didattico completate da tutti i tutor nel sistema.
     * @return la lista delle richieste di tutorato didattico completate dai tutor
     * @throws SQLException::Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<TutoratoDidatticoBean> doRetrieveAllRichiesteTutoratoDidatticoCompletate() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM tutorato_didattico WHERE status=2";
        PreparedStatement stmt=null;
        List<TutoratoDidatticoBean> list=new ArrayList<>();
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                bean.setId(rs.getInt("idtutorato_didattico"));
                bean.setDateDisponibili(rs.getString("date_disponibili"));
                bean.setOreDisponibili(rs.getString("ore_disponibili"));
                bean.setOreRichieste(rs.getInt("ore_richieste"));
                bean.setCommento(rs.getString("commento"));
                bean.setStatus(rs.getInt("status"));
                bean.setInsegnamento(rs.getString("insegnamento"));
                bean.setDipartimento(rs.getString("dipartimento"));
                bean.setStudenteEmail(rs.getString("studente_email"));
                bean.setTutorEmail(rs.getString("tutor_email"));
                bean.setProfEmail(rs.getString("prof_refe_email"));
                list.add(bean);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;

    }

    /**
     * Metodo che restituisce la lista di tutte le richieste di tutorato didattico non ancora accettate da nessun tutor
     * @return la lista di tutte le richieste di tutorato didattico non ancora accettate da nessun tutor
     * @throws SQLException :Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<TutoratoDidatticoBean> doRetrieveRichiesteTutoratoDidatticoNonAccettate() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM tutorato_didattico WHERE status=0";
        PreparedStatement stmt=null;
        List<TutoratoDidatticoBean> list=new ArrayList<>();
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                bean.setId(rs.getInt("idtutorato_didattico"));
                bean.setDateDisponibili(rs.getString("date_disponibili"));
                bean.setOreDisponibili(rs.getString("ore_disponibili"));
                bean.setOreRichieste(rs.getInt("ore_richieste"));
                bean.setCommento(rs.getString("commento"));
                bean.setStatus(rs.getInt("status"));
                bean.setInsegnamento(rs.getString("insegnamento"));
                bean.setDipartimento(rs.getString("dipartimento"));
                bean.setStudenteEmail(rs.getString("studente_email"));
                bean.setTutorEmail(rs.getString("tutor_email"));
                bean.setProfEmail(rs.getString("prof_refe_email"));
                list.add(bean);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;



    }

}

