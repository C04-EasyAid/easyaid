package model.dao;

import model.bean.SupportoEsameBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martina Giugliano
 * DAO Supporto esame per gestire i dati del Database relativo al supporto esame.
 */

public class SupportoEsameDAO {

    /**
     * Metodo che restituisce tutte le richieste di Supporto Esame dal DB
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public synchronized List<SupportoEsameBean> doRetriveAll() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM supporto_esame";
        List<SupportoEsameBean> list=new ArrayList<>();


        PreparedStatement stmt=null;

        try {
            conn = ConnectionPool.conn();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SupportoEsameBean bean = new SupportoEsameBean();
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalita_esame"));
                bean.setEventualiAusili(rs.getString("eventuali_ausili"));
                bean.setTipoAssistenza(rs.getString("tipo_di_assistenza"));
                bean.setLuogo(rs.getString("luogo"));
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
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;

    }


    /**
     * Metodo che restituisce le richieste di supporto esame effettuate tramite e-mail studente.
     * @param emailStudente
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public synchronized List<SupportoEsameBean> doRetrieveAllByStudente(String emailStudente)  throws SQLException,ClassNotFoundException
    {
        Connection conn=null;
        String query="SELECT * FROM supporto_esame WHERE studente_email=?";
        PreparedStatement stmt=null;
        List<SupportoEsameBean> list=new ArrayList<>();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            stmt.setString(1,emailStudente);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                SupportoEsameBean bean = new SupportoEsameBean();
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalita_esame"));
                bean.setEventualiAusili(rs.getString("eventuali_ausili"));
                bean.setTipoAssistenza(rs.getString("tipo_di_assistenza"));
                bean.setLuogo(rs.getString("luogo"));
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
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;
    }

    /**
     * Metodo per restituire le richieste accettate da un tutor
     * @param emailTutor:e-mail del tutor che ha accettato la richiesta di supporto esame
     * @return la lista delle richieste di supporto esame accettate dal tutor
     * @throws SQLException:Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<SupportoEsameBean> doRetrieveAllByTutor(String emailTutor) throws SQLException,ClassNotFoundException
    {
        Connection conn=null;
        String query="SELECT * FROM supporto_esame WHERE tutor_email=?";
        PreparedStatement stmt=null;
        List<SupportoEsameBean> list=new ArrayList<>();

        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            stmt.setString(1,emailTutor);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                SupportoEsameBean bean = new SupportoEsameBean();
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalita_esame"));
                bean.setEventualiAusili(rs.getString("eventuali_ausili"));
                bean.setTipoAssistenza(rs.getString("tipo_di_assistenza"));
                bean.setLuogo(rs.getString("luogo"));
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
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;




    }

    /**
     * Metodo che restituisce la lista delle richieste di supporto esame completate da tutti i tutor nel sistema
     * @return la lista delle richieste di supporto esame completate dai tutor
     * @throws SQLException::Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<SupportoEsameBean> doRetrieveAllRichiesteSupportoEsameCompletate() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM supporto_esame WHERE status=2";
        PreparedStatement stmt=null;
        List<SupportoEsameBean> list=new ArrayList<>();

        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                SupportoEsameBean bean = new SupportoEsameBean();
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalita_esame"));
                bean.setEventualiAusili(rs.getString("eventuali_ausili"));
                bean.setTipoAssistenza(rs.getString("tipo_di_assistenza"));
                bean.setLuogo(rs.getString("luogo"));
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
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;

    }


    /**
     * Metodo che restituisce la lista di tutte le richieste di supporto esame non ancora accettate da nessun tutor
     * @return la lista di tutte le richieste di supporto esame non ancora accettate da nessun tutor
     * @throws SQLException :Eccezione accesso al db
     * @throws ClassNotFoundException:eccezione classe non trovata
     */
    public synchronized List<SupportoEsameBean> doRetrieveRichiesteSupportoEsameNonAccettate() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM supporto_esame WHERE status=0";
        PreparedStatement stmt=null;
        List<SupportoEsameBean> list=new ArrayList<>();

        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                SupportoEsameBean bean = new SupportoEsameBean();
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalita_esame"));
                bean.setEventualiAusili(rs.getString("eventuali_ausili"));
                bean.setTipoAssistenza(rs.getString("tipo_di_assistenza"));
                bean.setLuogo(rs.getString("luogo"));
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
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;



    }



}

