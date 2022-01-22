package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.IlezioneDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.LezioneDao;
import model.dao.TutoratoDidatticoDao;
import other.MyLogger;

/**
 * Servlet che permette di confermare una lezione.
 *
 * @author Mariagiovanna Bianco
 *
 */

@WebServlet("/ConfermaLezioneServlet")
public class ConfermaLezioneServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ConfermaLezioneServlet";
  private IlezioneDao lezioneDao = new LezioneDao();
  private ItutoratoDidatticoDao tutoratoDidatticoDao = new TutoratoDidatticoDao();

  public void setlezioneDao(IlezioneDao lezioneDao) {
    this.lezioneDao = lezioneDao;
  }

  public void settutoratodidatticoDao(ItutoratoDidatticoDao tutoratodidatticoDao) {
    this.tutoratoDidatticoDao = tutoratodidatticoDao;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    LezioneBean lezioneBean = (LezioneBean) session.getAttribute("lezione");
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user != null && user.isTutor()) {
      try {
        lezioneDao.confermaLezione(lezioneBean.getId());
        Collection<LezioneBean> lezioni =
            lezioneDao.doRetrieveLezioniCompletateById(lezioneBean.getTutorato());
        if (lezioneDao.countOre(lezioni, 0) == 0) {
          System.out.println("ueueue");
          tutoratoDidatticoDao.completaRichiesta(lezioneBean.getTutorato(), user.getEmail());
          session.setAttribute("alertMsg", "Richiesta Confermata");
          resp.sendRedirect("view/LezioniTutorPage.jsp");
        } else {
          session.setAttribute("alertMsg", "Lezione Confermata");
          resp.sendRedirect("view/LezioniTutorPage.jsp");
        }
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
      try {
        lezioneDao.confermaLezione(lezioneBean.getTutorato());
      } catch (SQLException e) {
        log.error(myClass, "Collegamento alla Servlet...", e);
        e.printStackTrace();
      }

    } else {
      session.setAttribute("alertMsg", "Utente non loggato");
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}
