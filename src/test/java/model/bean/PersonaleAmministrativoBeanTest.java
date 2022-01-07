package model.bean;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.bean.PersonaleAmministrativoBean;

/**
 * @author Riccardo Polidoro
 * Classe di test per la classe PersonaleAmministrativoBean
 */
public class PersonaleAmministrativoBeanTest
{
    private final String email="email@prova.unisa.it";
    private final PersonaleAmministrativoBean bean=new PersonaleAmministrativoBean();
    @BeforeEach
    public void beforeEach()
    {
        bean.setEmailPersonaleAmministrativo(email);
    }


    @Test
    public void getEmail()
    {
        assertEquals(email,bean.getEmailPersonaleAmministrativo());
    }

    @Test
    public void setEmail()
    {
        String email="email@prova.unisa.it";
        bean.setEmailPersonaleAmministrativo(email);
        assertEquals(email,bean.getEmailPersonaleAmministrativo());
    }

    @Test
    public void PersonaleAmministrativoBean()
    {
        String email="email@prova.unisa.it";
        PersonaleAmministrativoBean bean=new PersonaleAmministrativoBean(email);
        assertEquals(email,bean.getEmailPersonaleAmministrativo());
    }


}
