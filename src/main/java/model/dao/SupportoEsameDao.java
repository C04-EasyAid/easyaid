package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.SupportoEsameBean;

/**
 * Classe SupportoEsameDAO.
 *
 * @author Martina Giugliano
 */
public class SupportoEsameDao implements IsupportoEsameDao {

  /**
   * Metodo che restituisce le richieste di supporto esame effettuate tramite e-mail studente.
   *
   * @param emailStudente
   *       email dello studente.
   * @return
   *        lista di richieste di supporto esame.
   * @throws SQLException
   *                     errore nell'acceso al db.
   * @throws ClassNotFoundException
   *                               errore della classe non trovata.
   */
  @Override
  public synchronized List<SupportoEsameBean> doRetrieveAllByStudente(String emailStudente)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM supporto_esame WHERE studente_email=?";
    PreparedStatement stmt = null;
    List<SupportoEsameBean> list = new ArrayList<>();
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailStudente);
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

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return list;
  }

  /**
   * Metodo per restituire le richieste accettate da un tutor.
   *
   * @return
   *        la lista delle richieste di supporto esame accettate dal tutor.
   * @throws SQLException
   *        eccezione accesso al db.
   * @throws ClassNotFoundException
   *         eccezione classe non trovata.
   */
  @Override
  public synchronized List<SupportoEsameBean> doRetrieveAllByTutor(String emailTutor)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM supporto_esame WHERE tutor_email=?";
    PreparedStatement stmt = null;
    List<SupportoEsameBean> list = new ArrayList<>();

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailTutor);
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

      stmt.close();
      conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  /**
   * Metodo che restituisce la lista delle richieste di supporto esame completate da tutti i tutor
   * nel sistema.
   *
   * @return
   *        la lista delle richieste di supporto esame completate dai tutor.
   * @throws SQLException
   *        eccezione accesso al db.
   * @throws ClassNotFoundException
   *        eccezione classe non trovata.
   */
  @Override
  public synchronized List<SupportoEsameBean> doRetrieveAllRichiesteSupportoEsameCompletate()
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM supporto_esame WHERE status=2";
    PreparedStatement stmt = null;
    List<SupportoEsameBean> list = new ArrayList<>();

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

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return list;
  }

  /**
   * Metodo che restituisce la lista di tutte le richieste di supporto esame non ancora accettate da
   * nessun tutor.
   *
   * @return
   *        la lista di tutte le richieste di supporto esame non ancora accettate da nessun tutor.
   * @throws SQLException
   *        eccezione accesso al db.
   * @throws ClassNotFoundException
   *        eccezione classe non trovata.
   */
  @Override
  public synchronized List<SupportoEsameBean> doRetrieveRichiesteSupportoEsameNonAccettate()
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM supporto_esame WHERE status=0";
    PreparedStatement stmt = null;
    List<SupportoEsameBean> list = new ArrayList<>();

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

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  @Override
  public synchronized SupportoEsameBean doRetriveById(int id)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM supporto_esame where id=?";
    SupportoEsameBean bean = null;
    PreparedStatement stmt = null;

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        bean = new SupportoEsameBean();
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
      }

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return bean;
  }

  @Override
  public synchronized boolean inserimentoSupportoEsame(SupportoEsameBean bean) throws SQLException {
    boolean inserimento = false;
    Connection con = null;
    String query =
        "INSERT INTO supporto_esame"
                + "(data, ora, ore_richieste, docente, "
                + "modalita_esame, eventuali_ausili, "
                + "tipo_di_assistenza, insegnamento, luogo, dipartimento, "
                + "studente_email, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement stmt = null;
    try {
      con = ConnectionPool.conn();
      stmt = con.prepareStatement(query);
      stmt.setString(1, bean.getData());
      stmt.setString(2, bean.getOra());
      stmt.setInt(3, bean.getOreRichieste());
      stmt.setString(4, bean.getDocente());
      stmt.setString(5, bean.getModalitaEsame());
      stmt.setString(6, bean.getEventualiAusili());
      stmt.setString(7, bean.getTipoAssistenza());
      stmt.setString(8, bean.getInsegnamento());
      stmt.setString(9, bean.getLuogo());
      stmt.setString(10, bean.getDipartimento());
      stmt.setString(11, bean.getStudenteEmail());
      stmt.setInt(12, 0);
      inserimento = stmt.executeUpdate() == 1;
      con.commit();

      stmt.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
      inserimento = false;
    }

    return inserimento;
  }

  @Override
  public synchronized boolean accettaRichiesta(int idSupporto, String emailTutor, String commento)
      throws SQLException {
    boolean isUpdated = false;
    Connection conn = null;
    String query = "UPDATE supporto_esame SET status=1,commento=?,tutor_email=? WHERE id=?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, commento);
      stmt.setString(2, emailTutor);
      stmt.setInt(3, idSupporto);
      isUpdated = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return isUpdated;
  }

  @Override
  public synchronized boolean approvaRichiesta(int idSupporto, String emailProf)
      throws SQLException {
    boolean isUpdated = false;
    Connection conn = null;
    String query = "UPDATE supporto_esame SET status=3,prof_refe_email=? WHERE id=?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailProf);
      stmt.setInt(2, idSupporto);
      isUpdated = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return isUpdated;
  }

  @Override
  public synchronized boolean deleteSupporto(SupportoEsameBean s) throws SQLException {
    boolean delete = false;
    Connection conn = null;
    String query = "DELETE FROM supporto_esame WHERE id = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, s.getId());
      delete = stmt.executeUpdate() == 1;
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return delete;
  }
}
