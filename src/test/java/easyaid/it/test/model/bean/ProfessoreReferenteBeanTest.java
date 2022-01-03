package easyaid.it.test.model.bean;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.bean.ProfessoreReferenteBean;

/**
 * @author Riccardo Polidoro
 * Classe di test per la classe ProfessoreReferenteBean
 */
public class ProfessoreReferenteBeanTest
{
    private final String email="email@prova.unisa.it";
    private final String dipartimento="dipartimento";
    private final ProfessoreReferenteBean bean=new ProfessoreReferenteBean();

    @BeforeEach
    public void beforeEach()
    {
        bean.setEmail(email);
        bean.setDipartimento(dipartimento);
    }

    @Test
    public void getEmail()
    {
        assertEquals(email,bean.getEmail());
    }

    @Test
    public void getDipartimento()
    {
        assertEquals(dipartimento,bean.getDipartimento());
    }

    @Test
    public void setEmail()
    {
        String email="email@prova.unisa.it";
        bean.setEmail(email);
        assertEquals(email,bean.getEmail());
    }

    @Test
    public void setDipartimento()
    {
        String dipartimento="dipartimento";
        bean.setDipartimento(dipartimento);
        assertEquals(dipartimento,bean.getDipartimento());
    }

    @Test
    public void ProfessoreReferenteBean()
    {
      String email="email@prova.unisa.it";
      String dipartimento="dipartimento";
      ProfessoreReferenteBean bean=new ProfessoreReferenteBean(email,dipartimento);
      assertEquals(email,bean.getEmail());
      assertEquals(dipartimento,bean.getDipartimento());
    }




}
