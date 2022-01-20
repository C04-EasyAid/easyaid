package model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import model.bean.CommentoBean;
import org.junit.jupiter.api.Test;



class CommentoDAOTest {

  private final commentodao commentoDao = new commentodao();


    @Test
    void doRetrieveCommento() throws SQLException, ClassNotFoundException {
      Collection<CommentoBean> list = new ArrayList<>();
      list.add(new CommentoBean());

      Collection<CommentoBean> result = commentoDao.doRetrieveCommento(13);

      assertEquals(list.size(),result.size());

    }

    @Test
    void insertCommentoTutor1() throws SQLException, ClassNotFoundException {

      String emailTutor = "mdibianco45@studenti.unisa.it";
      String testo = "Perfetto.Ci vediamo a lezione!";
      int lezione = 11;


      assertEquals(true,commentoDao.insertCommentoTutor(lezione,testo,emailTutor));

      ArrayList<CommentoBean> list = (ArrayList<CommentoBean>) commentoDao.doRetrieveCommento(lezione);
      CommentoBean commento = list.get(list.size()-1);
      commentoDao.deleteCommento(commento);

    }
  @Test
  void insertCommentoTutor2() throws SQLException, ClassNotFoundException {
    String emailTutor = "mdibianco45@studenti.unisa.it";
    String testo = "Perfetto.Ci vediamo a lezione!";
    int lezione = 0;


    assertEquals(false,commentoDao.insertCommentoTutor(lezione,testo,emailTutor));



  }

    @Test
    void insertCommentoStudente1() throws SQLException, ClassNotFoundException {

      String emailStudente = "fneri34@studenti.unisa.it";
      String testo = "Perfetto.Ci vediamo a lezione!";
      int lezione = 11;


      assertEquals(true,commentoDao.insertCommentoStudente(lezione,testo,emailStudente));
      ArrayList<CommentoBean> list = (ArrayList<CommentoBean>) commentoDao.doRetrieveCommento(lezione);
      CommentoBean commento = list.get(list.size()-1);
      commentoDao.deleteCommento(commento);

    }

  @Test
  void insertCommentoStudente2() throws SQLException, ClassNotFoundException {

    String emailStudente = "fneri34@studenti.unisa.it";
    String testo = "Perfetto.Ci vediamo a lezione!";
    int lezione = 0;


    assertEquals(false,commentoDao.insertCommentoStudente(lezione,testo,emailStudente));


  }

    @Test
    void deleteCommento1() throws SQLException, ClassNotFoundException {

      String emailStudente = "fneri34@studenti.unisa.it";
      String testo = "Perfetto.Ci vediamo a lezione!";
      int lezione = 11;


      commentoDao.insertCommentoStudente(lezione,testo,emailStudente);
      ArrayList<CommentoBean> list = (ArrayList<CommentoBean>) commentoDao.doRetrieveCommento(lezione);
      CommentoBean commento = list.get(list.size()-1);
      assertEquals(true,commentoDao.deleteCommento(commento));


    }

  @Test
  void deleteCommento2() throws SQLException, ClassNotFoundException {

    String emailStudente = "fneri34@studenti.unisa.it";
    String testo = "Perfetto.Ci vediamo a lezione!";
    int lezione = 0;


    commentoDao.insertCommentoStudente(lezione,testo,emailStudente);
    CommentoBean commento = new CommentoBean();
    assertEquals(false,commentoDao.deleteCommento(commento));


  }
}