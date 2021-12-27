package model.dao;

import model.bean.SupportoEsameBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupportoEsameDAO {


    public synchronized List<SupportoEsameBean> doRetriveAll() throws SQLException,ClassNotFoundException{
        Connection conn=null;
        String query="SELECT * FROM supporto_esame";
        List<SupportoEsameBean> list=new ArrayList<>();


        PreparedStatement stmt=null;

        try {
            conn = ConnectionPool.conn();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            SupportoEsameBean bean = new SupportoEsameBean();
            while (rs.next()) {
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalità_esame"));
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
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;

    }


    public synchronized List<SupportoEsameBean> doRetrieveAllByStudente(String emailStudente)  throws SQLException,ClassNotFoundException
    {
        Connection conn=null;
        String query="SELECT * FROM supporto_esame WHERE studente_email=?";
        PreparedStatement stmt=null;
        List<SupportoEsameBean> list=new ArrayList<>();
        SupportoEsameBean bean = new SupportoEsameBean();
        try
        {
            conn=ConnectionPool.conn();
            stmt=conn.prepareStatement(query);
            stmt.setString(1,emailStudente);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                bean.setId(rs.getInt("id"));
                bean.setData(rs.getString("data"));
                bean.setOra(rs.getString("ora"));
                bean.setDocente(rs.getString("docente"));
                bean.setModalitaEsame(rs.getString("modalità_esame"));
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
            stmt.close();
            if(conn!=null)
                conn.close();
        }

        return list;
    }
}

