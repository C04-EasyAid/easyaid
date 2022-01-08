package model.bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.bean.LezioneBean;

import java.util.Date;

/** @author Riccardo Polidoro Classe di test per la classe LezioneBean */
public class LezioneBeanTest {
  private final int id = 1;
  private final int tutorato = 1;
  private final String oraInizio = "10:00";
  private final String oraFine = "12:00";
  private final String tutor = "tutor";
  private final String insegnamento = "insegnamento";
  private final Date data = new Date();
  private final boolean status = true;
  private final LezioneBean bean = new LezioneBean();

  @BeforeEach
  public void beforeEach() {
    bean.setId(id);
    bean.setTutorato(tutorato);
    bean.setOraInizio(oraInizio);
    bean.setOraFine(oraFine);
    bean.setTutor(tutor);
    bean.setInsegnamento(insegnamento);
    bean.setData(data);
    bean.setStatus(status);
  }

  @Test
  public void getId() {
    assertEquals(id, bean.getId());
  }

  @Test
  public void getTutorato() {
    assertEquals(tutorato, bean.getTutorato());
  }

  @Test
  public void getOraInizio() {
    assertEquals(oraInizio, bean.getOraInizio());
  }

  @Test
  public void getOraFine() {
    assertEquals(oraFine, bean.getOraFine());
  }

  @Test
  public void getTutor() {
    assertEquals(tutor, bean.getTutor());
  }

  @Test
  public void getInsegnamento() {
    assertEquals(insegnamento, bean.getInsegnamento());
  }

  @Test
  public void getData() {
    assertEquals(data, bean.getData());
  }

  @Test
  public void getStatus() {
    assertEquals(status, bean.isStatus());
  }

  @Test
  public void setId() {
    int id = 1;
    bean.setId(id);
    assertEquals(id, bean.getId());
  }

  @Test
  public void setTutorato() {
    int tutorato = 1;
    bean.setTutorato(tutorato);
    assertEquals(tutorato, bean.getTutorato());
  }

  @Test
  public void setOraInizio() {
    String oraInizio = "10:00";
    bean.setOraInizio(oraInizio);
    assertEquals(oraInizio, bean.getOraInizio());
  }

  @Test
  public void setOraFine() {
    String oraFine = "12:00";
    bean.setOraFine(oraFine);
    assertEquals(oraFine, bean.getOraFine());
  }

  @Test
  public void setTutor() {
    String tutor = "tutor";
    bean.setTutor(tutor);
    assertEquals(tutor, bean.getTutor());
  }

  @Test
  public void setInsegnamento() {
    String insegnamento = "insegnamento";
    bean.setInsegnamento(insegnamento);
    assertEquals(insegnamento, bean.getInsegnamento());
  }

  @Test
  public void setData() {
    Date data = new Date();
    bean.setData(data);
    assertEquals(data, bean.getData());
  }

  @Test
  public void setStatus() {
    boolean status = true;
    bean.setStatus(status);
    assertEquals(status, bean.isStatus());
  }

  @Test
  public void LezioneBean() {
    int id = 1;
    int tutorato = 1;
    String oraInizio = "10:00";
    String oraFine = "12:00";
    String tutor = "tutor";
    Date data = new Date();
    boolean status = true;
    LezioneBean bean = new LezioneBean(tutorato, oraInizio, oraFine, data, tutor, status);

    assertEquals(tutorato, bean.getTutorato());
    assertEquals(oraInizio, bean.getOraInizio());
    assertEquals(oraFine, bean.getOraFine());
    assertEquals(tutor, bean.getTutor());
    assertEquals(data, bean.getData());
    assertEquals(status, bean.isStatus());
  }

  @Test
  public void LezioneBean1() {
    int id = 1;
    int tutorato = 1;
    String oraInizio = "10:00";
    String oraFine = "12:00";
    String tutor = "tutor";
    Date data = new Date();
    boolean status = true;
    LezioneBean bean = new LezioneBean(id, tutorato, oraInizio, oraFine, data, tutor, status);

    assertEquals(id, bean.getId());
    assertEquals(tutorato, bean.getTutorato());
    assertEquals(oraInizio, bean.getOraInizio());
    assertEquals(oraFine, bean.getOraFine());
    assertEquals(tutor, bean.getTutor());
    assertEquals(data, bean.getData());
    assertEquals(status, bean.isStatus());
  }
}
