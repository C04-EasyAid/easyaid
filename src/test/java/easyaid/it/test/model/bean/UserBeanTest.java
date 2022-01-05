package easyaid.it.test.model.bean;
import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.bean.UserBean;

/**
 * @author Riccardo Polidoro
 * Classe di test per la classe UserBean
 */
public class UserBeanTest
{
    private final String nome="Aldo";
    private final String cognome="Baglio";
    private final String email="email@test.unisa.it";
    private final String password="password";
    private final String ruolo="ruolo";
    private final UserBean bean=new UserBean();


    @BeforeEach
    public void beforeEach()
    {
        bean.setNome(nome);
        bean.setCognome(cognome);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRuolo(ruolo);
    }

    @Test
    public void getNome()
    {
        assertEquals(nome,bean.getNome());
    }

    @Test
    public void getCognome()
    {
        assertEquals(cognome,bean.getCognome());
    }

    @Test
    public void getEmail()
    {
        assertEquals(email,bean.getEmail());
    }

    @Test
    public void getPassword()
    {
        assertEquals(password,bean.getPassword());
    }

    @Test
    public void getRuolo()
    {
        assertEquals(ruolo,bean.getRuolo());
    }

    @Test
    public void setNome()
    {
        String nome="nome";
        bean.setNome(nome);
        assertEquals(nome,bean.getNome());
    }

    @Test
    public void setCognome()
    {
        String cognome="cognome";
        bean.setCognome(cognome);
        assertEquals(cognome,bean.getCognome());
    }

    @Test
    public void setEmail()
    {
        String email="email@prova.unisa.it";
        bean.setEmail(email);
        assertEquals(email,bean.getEmail());
    }

    @Test
    public void setPassword()
    {
        String password="password";
        bean.setPassword(password);
        assertEquals(password,bean.getPassword());
    }

    @Test
    public void setRuolo()
    {
        String ruolo="ruolo";
        bean.setRuolo(ruolo);
        assertEquals(ruolo,bean.getRuolo());
    }

    @Test
    public void isStudente()
    {
        String ruolo="S";
        bean.setRuolo(ruolo);
        assertEquals(true,bean.isStudente());
    }

    @Test
    public void isTutor()
    {
        String ruolo="T";
        bean.setRuolo(ruolo);
        assertEquals(true,bean.isTutor());
    }

    @Test
    public void isProfessoreReferente()
    {
        String ruolo="P";
        bean.setRuolo(ruolo);
        assertEquals(true,bean.isProfessoreReferente());
    }

    @Test
    public void isPersonaleAmministrativo()
    {
        String ruolo="PA";
        bean.setRuolo(ruolo);
        assertEquals(true,bean.isPersonaleAmministrativo());
    }

    @Test
    public void UserBean()
    {
        String nome="nome";
        String cognome="cognome";
        String email="email@prova.unisa.it";
        String password="password";
        String ruolo="RUOLO";
        UserBean bean=new UserBean(nome,cognome,email,password,ruolo);

        assertEquals(nome,bean.getNome());
        assertEquals(cognome,bean.getCognome());
        assertEquals(email,bean.getEmail());
        assertEquals(password,bean.getPassword());
        assertEquals(ruolo,bean.getRuolo());
    }

    @Test
    public void toStringTest()
    {
        String nome="nome";
        String cognome="cognome";
        String email="email@prova.unisa.it";
        String password="password";
        String ruolo="RUOLO";
        UserBean bean=new UserBean(nome,cognome,email,password,ruolo);

        String string= "UserBean{"
                + "nome='"
                + nome
                + '\''
                + ", cognome='"
                + cognome
                + '\''
                + ", email='"
                + email
                + '\''
                + ", password='"
                + password
                + '\''
                + ", ruolo='"
                + ruolo
                + '\''
                + '}';
        assertEquals(string,bean.toString());
    }

}