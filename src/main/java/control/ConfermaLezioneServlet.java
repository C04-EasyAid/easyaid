package control;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.ILezioneDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.LezioneDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;


@WebServlet("/ConfermaLezioneServlet")
public class ConfermaLezioneServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ConfermaLezioneServlet";
  private ILezioneDAO lezioneDAO = new LezioneDAO();
  private ITutoratoDidatticoDAO tutoratoDidatticoDAO = new TutoratoDidatticoDAO();

  public void setLezioneDAO(ILezioneDAO lezioneDAO) {
    this.lezioneDAO = lezioneDAO;
  }

  public void setTutoratoDidatticoDAO(ITutoratoDidatticoDAO tutoratoDidatticoDAO) {
    this.tutoratoDidatticoDAO = tutoratoDidatticoDAO;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    LezioneBean lezioneBean = (LezioneBean) session.getAttribute("lezione");
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user != null&& user.isTutor()) {
      try {
        lezioneDAO.confermaLezione(lezioneBean.getId());
        Collection<LezioneBean> lezioni =
            lezioneDAO.doRetrieveLezioniCompletateById(lezioneBean.getTutorato());
        if (lezioneDAO.countOre(lezioni, 0) == 0) {
          System.out.println("ueueue");
          tutoratoDidatticoDAO.completaRichiesta(lezioneBean.getTutorato(), user.getEmail());
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
        lezioneDAO.confermaLezione(lezioneBean.getTutorato());
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
    super.doPost(req, resp);
  }
}