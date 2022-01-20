package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.TutoratoDidatticoBean;

/**
 * Classe TutoratoDidatticoDAO.
 *
 * @author Martina Giugliano
 */
public class TutoratoDidatticoDAO implements itutoratodidatticoDao {

  /**
   * Metodo che restituisce le richieste di Tutorato Didattico effettuate tramite e-mail studente.
   *
   * @param emailStudente
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  @Override
  public synchronized List<TutoratoDidatticoBean> doRetrieveAllByStudente(String emailStudente)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutorato_didattico WHERE studente_email=?";
    PreparedStatement stmt = null;
    List<TutoratoDidatticoBean> list = new ArrayList<>();

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailStudente);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
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
        bean.setDocente(rs.getString("docente"));
        list.add(bean);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
       stmt.close();
       conn.close();

    return list;
  }

  /**
   * Metodo per restituire le richieste accettate da un tutor
   *
   * @param emailTutor:e-mail del tutor che ha accettato la richiesta di supporto esame
   * @return la lista delle richieste di tutorato didattico accettate dal tutor
   * @throws SQLException:Eccezione accesso al db
   * @throws ClassNotFoundException:eccezione classe non trovata
   */
  @Override
  public synchronized List<TutoratoDidatticoBean> doRetrieveAllByTutor(String emailTutor)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutorato_didattico WHERE tutor_email=?";
    PreparedStatement stmt = null;
    List<TutoratoDidatticoBean> list = new ArrayList<>();
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailTutor);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
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
        bean.setDocente(rs.getString("docente"));
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
   * Metodo che restituisce la lista delle richieste di tutorato didattico completate da tutti i
   * tutor nel sistema.
   *
   * @return la lista delle richieste di tutorato didattico completate dai tutor
   * @throws SQLException::Eccezione accesso al db
   * @throws ClassNotFoundException:eccezione classe non trovata
   */
  @Override
  public synchronized List<TutoratoDidatticoBean>
      doRetrieveAllRichiesteTutoratoDidatticoCompletate()
          throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutorato_didattico WHERE status=2";
    PreparedStatement stmt = null;
    List<TutoratoDidatticoBean> list = new ArrayList<>();

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
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
        bean.setDocente(rs.getString("docente"));
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
   * Metodo che restituisce la lista di tutte le richieste di tutorato didattico non ancora
   * accettate da nessun tutor
   *
   * @return la lista di tutte le richieste di tutorato didattico non ancora accettate da nessun
   *     tutor
   * @throws SQLException :Eccezione accesso al db
   * @throws ClassNotFoundException:eccezione classe non trovata
   */
  @Override
  public synchronized List<TutoratoDidatticoBean> doRetrieveRichiesteTutoratoDidatticoNonAccettate()
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutorato_didattico WHERE status=0";
    PreparedStatement stmt = null;
    List<TutoratoDidatticoBean> list = new ArrayList<>();

    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
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
        bean.setDocente(rs.getString("docente"));
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
  public synchronized TutoratoDidatticoBean doRetriveById(int id)
      throws SQLException, ClassNotFoundException {
    Connection conn = null;
    String query = "SELECT * FROM tutorato_didattico where idtutorato_didattico=?";
    PreparedStatement stmt = null;
    TutoratoDidatticoBean bean = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        bean = new TutoratoDidatticoBean();
        bean.setId(id);
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
        bean.setDocente(rs.getString("docente"));
      }
      conn.commit();

      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return bean;
  }

  @Override
  public boolean InserimentoTutoratoDidattico(TutoratoDidatticoBean Bean) throws SQLException {
    boolean inserimento = false;
    Connection con = null;
    String query =
        "INSERT INTO tutorato_didattico(date_disponibili, ore_disponibili, ore_richieste, insegnamento, dipartimento, studente_email, status, docente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement stmt = null;
    try {
      con = ConnectionPool.conn();
      stmt = con.prepareStatement(query);
      stmt.setString(1, Bean.getDateDisponibili());
      stmt.setString(2, Bean.getOreDisponibili());
      stmt.setInt(3, Bean.getOreRichieste());
      stmt.setString(4, Bean.getInsegnamento());
      stmt.setString(5, Bean.getDipartimento());
      stmt.setString(6, Bean.getStudenteEmail());
      stmt.setInt(7, 0);
      stmt.setString(8, Bean.getDocente());
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
    String query =
        "UPDATE tutorato_didattico SET status=1,commento=?,tutor_email=? WHERE idtutorato_didattico=?";
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
  public synchronized boolean approvaRichiesta(int idTutorato, String emailProf)
      throws SQLException {
    boolean isUpdated = false;
    Connection conn = null;
    String query =
        "UPDATE tutorato_didattico SET status=3,prof_refe_email=? WHERE idtutorato_didattico=?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailProf);
      stmt.setInt(2, idTutorato);
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
  public synchronized boolean completaRichiesta(int idTutorato, String emailTutor)
      throws SQLException {
    boolean isUpdated = false;
    Connection conn = null;
    String query =
        "UPDATE tutorato_didattico SET status=2,tutor_email=? WHERE idtutorato_didattico=?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setString(1, emailTutor);
      stmt.setInt(2, idTutorato);
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
  public synchronized boolean deleteTutorato(TutoratoDidatticoBean t) throws SQLException {
    boolean delete = false;
    Connection conn = null;
    String query = "DELETE FROM tutorato_didattico WHERE idtutorato_didattico = ?";
    PreparedStatement stmt = null;
    try {
      conn = ConnectionPool.conn();
      stmt = conn.prepareStatement(query);
      stmt.setInt(1, t.getId());
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
