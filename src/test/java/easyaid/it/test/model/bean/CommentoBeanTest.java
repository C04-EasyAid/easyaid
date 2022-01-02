package easyaid.it.test.model.bean;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.bean.CommentoBean;

import java.util.Date;

/**
 * @author Riccardo Polidoro
 * Classe di test pe la classe CommentoBean
 */
public class CommentoBeanTest
{
    private final int lezione=1;
    private final int tutorato=1;
    private final String testo="commento";
    private final String ora="12:21";
    private final String studente="studente";
    private final String tutor="";
    private final Date data=new Date();
    private final CommentoBean bean=new CommentoBean();

    @BeforeEach
    public void beforeEach()
    {
        bean.setLezione(lezione);
        bean.setTutorato(tutorato);
        bean.setTesto(testo);
        bean.setOra(ora);
        bean.setStudente(studente);
        bean.setTutor(tutor);
        bean.setData(data);
    }

     @Test
     public void getLezione()
     {
     assertEquals(lezione,bean.getLezione());
     }

     @Test
     public void getTutorato()
     {
     assertEquals(tutorato,bean.getTutorato());
     }

     @Test
     public void getTesto()
     {
         assertEquals(testo,bean.getTesto());
     }

     @Test
     public void getOra()
     {
       assertEquals(ora,bean.getOra());
     }

     @Test
     public void getStudente()
     {
         assertEquals(studente,bean.getStudente());
     }

     @Test
     public void getTutor()
     {
         assertEquals(tutor,bean.getTutor());
     }

     @Test
     public void setLezione()
     {
         int lezione=1;
         bean.setLezione(lezione);
         assertEquals(lezione,bean.getLezione());
     }

     @Test
     public void setTutorato()
     {
         int tutorato=1;
         bean.setTutorato(tutorato);
         assertEquals(tutorato,bean.getTutorato());
     }

     @Test
     public void setTesto()
     {
         String testo="commento";
         bean.setTesto(testo);
         assertEquals(testo,bean.getTesto());
     }

     @Test
     public void setOra()
     {
         String ora="12:21";
         bean.setOra(ora);
         assertEquals(ora,bean.getOra());
     }

     @Test
     public void setStudente()
     {
         String studente="studente";
         bean.setStudente(studente);
         assertEquals(studente,bean.getStudente());
     }

     @Test
     public void setTutor()
     {
         String tutor="";
         bean.setTutor(tutor);
         assertEquals(tutor,bean.getTutor());
     }

     @Test
     public void setData()
     {
         Date data=new Date();
         bean.setData(data);
         assertEquals(data,bean.getData());
     }

     @Test
     public void CommentoBean()
     {
         int lezione=1;
         int tutorato=1;
         String testo="commento";
         String ora="12:21";
         String studente="studente";
         String tutor="";
         Date data=new Date();
         CommentoBean bean=new CommentoBean(lezione,tutorato,testo,data,ora,studente,tutor);
         assertEquals(lezione,bean.getLezione());
         assertEquals(tutorato,bean.getTutorato());
         assertEquals(testo,bean.getTesto());
         assertEquals(data,bean.getData());
         assertEquals(ora,bean.getOra());
         assertEquals(studente,bean.getStudente());
         assertEquals(tutor,bean.getTutor());


     }




}
