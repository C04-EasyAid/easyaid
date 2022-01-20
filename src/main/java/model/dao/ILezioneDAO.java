package model.dao;

import java.sql.SQLException;
import java.util.Collection;
import model.bean.LezioneBean;

/**
 * Classe ILezioneDAO.
 *
 * @author Serena Liguori
 */

public interface ILezioneDAO {
  // Metodo che restitiusce una lezione in base all'id passato come parametro
  LezioneBean doRetrieveLezioneById(int id) throws ClassNotFoundException, SQLException;

  Collection<LezioneBean> doRetrieveLezioniById(int id) throws ClassNotFoundException, SQLException;

  Collection<LezioneBean> doRetrieveLezioniCompletateById(int id)
      throws ClassNotFoundException, SQLException;

  // Metodo che restituisce tutte le lezioni di un determinato studente il quale è stato passato
  // come parametro
  Collection<LezioneBean> doRetrieveLezioneByStudente(String studente)
      throws ClassNotFoundException, SQLException;

  // Metodo che restituisce tutte le lezioni di un determinato tutor il quale è stato passato come
  // parametro
  Collection<LezioneBean> doRetrieveLezioneByTutor(String tutor)
      throws ClassNotFoundException, SQLException;

  int doRetrieveTutoratoByLezione(int lezione) throws SQLException;

  // Metodo che restituisce un booleano
  // true = Se la somma delle ore delle lezioni sono uguali alle ore richieste
  // false = Se la somma delle ore delle lezioni non sono uguali alle ore richieste
  int countOre(Collection<LezioneBean> lezioni, int idTutorato)
      throws SQLException, ClassNotFoundException;

  boolean insertNewLezione(LezioneBean lezione) throws SQLException;

  // Metodo che conferma la lezione avvenuta
  boolean confermaLezione(int idLezione) throws SQLException;

  boolean deleteLezione(LezioneBean l) throws SQLException;
}
