package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.CommentoDao;
import model.dao.IcommentoDao;
import model.dao.IstudenteDao;
import model.dao.ItutorDao;
import model.dao.StudenteDao;
import model.dao.TutorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



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
  void testInserimentoCommentoTutor()
          throws ServletException, IOException, SQLException, ClassNotFoundException {
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

    IcommentoDao commentoDao = new CommentoDao();
    ItutorDao tutorDao = new TutorDao();
    servlet.setDaoC(commentoDao);
    servlet.setDaoT(tutorDao);
    servlet.doGet(request, response);

    assertEquals(
        "Commento inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));


    List<CommentoBean> list = (List<CommentoBean>) commentoDao.doRetrieveCommento(lezione.getId());
    CommentoBean commento = list.get(list.size() - 1);
    commentoDao.deleteCommento(commento);
  }

  @Test
  void testInserimentoCommentoStudente()
          throws ServletException, IOException, SQLException, ClassNotFoundException {
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

    IcommentoDao commentoDao = new CommentoDao();
    IstudenteDao studenteDao = new StudenteDao();
    servlet.setDaoC(commentoDao);
    servlet.setDaoS(studenteDao);
    servlet.doGet(request, response);

    assertEquals(
        "Commento inserito con successo",
        Objects.requireNonNull(request.getSession()).getAttribute("alertMsg"));


    List<CommentoBean> list = (List<CommentoBean>) commentoDao.doRetrieveCommento(lezione.getId());
    CommentoBean commento = list.get(list.size() - 1);
    commentoDao.deleteCommento(commento);

  }
}
