package control;

import model.bean.*;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
@author Martina Giugliano
 */

class CommentoIntegrationTest {
  private CommentoServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new CommentoServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testInserimentoCommentoTutor() throws ServletException, IOException, SQLException, ClassNotFoundException {
    UserBean userBean = new UserBean();

    userBean.setEmail("lorenzorossi1@studenti.unisa.it");
    userBean.setPassword("Lorenzo#rossi1");
    userBean.setRuolo("T");

    LezioneBean lezione = new LezioneBean();
    lezione.setId(13);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("lezione", lezione);
    String msg = "Ok,Ci sarò!";
    request.setParameter("commento", msg);

    ICommentoDAO commentoDao = new CommentoDAO();
    ITutorDAO tutorDao = new TutorDAO();
    servlet.setDaoC(commentoDao);
    servlet.setDaoT(tutorDao);
    servlet.doGet(request, response);

    assertEquals(
        "Commento inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));


    List<CommentoBean> list = (List<CommentoBean>) commentoDao.doRetrieveCommento(lezione.getId());
    CommentoBean commento = list.get(list.size()-1);
    commentoDao.deleteCommento(commento);
  }

  @Test
  void testInserimentoCommentoStudente() throws ServletException, IOException, SQLException, ClassNotFoundException {
    UserBean userBean = new UserBean();

    userBean.setEmail("abaglio9@studenti.unisa.it");
    userBean.setPassword("Aldo#Baglio45");
    userBean.setRuolo("S");

    LezioneBean lezione = new LezioneBean();
    lezione.setId(13);
    request.getSession().setAttribute("utente", userBean);
    request.getSession().setAttribute("lezione", lezione);
    String msg = "Ok,Ci sarò!";
    request.setParameter("commento", msg);

    ICommentoDAO commentoDao = new CommentoDAO();
    IStudenteDAO studenteDAO = new StudenteDAO();
    servlet.setDaoC(commentoDao);
    servlet.setDaoS(studenteDAO);
    servlet.doGet(request, response);

    assertEquals(
        "Commento inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));


    List<CommentoBean> list = (List<CommentoBean>) commentoDao.doRetrieveCommento(lezione.getId());
    CommentoBean commento = list.get(list.size()-1);
    commentoDao.deleteCommento(commento);

  }
}
