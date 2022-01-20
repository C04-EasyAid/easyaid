package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

/**
 * Servlet che permette di visualizzare le richieste completate.
 *
 * @author Riccardo Polidoro
 *
 */

@WebServlet("/viewRichiesteCompletate")
public class ViewRichiesteCompletateServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewRichiesteCompletateServlet";
  private ISupportoEsameDAO esameDAO = new SupportoEsameDAO();
  private ITutoratoDidatticoDAO tutoratoDAO = new TutoratoDidatticoDAO();

  public void setEsameDAO(ISupportoEsameDAO esameDAO) {
    this.esameDAO = esameDAO;
  }

  public void setTutoratoDAO(ITutoratoDidatticoDAO tutoratoDAO) {
    this.tutoratoDAO = tutoratoDAO;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null) {
      if (userLoggato.isProfessoreReferente()) {

        try {
          List<SupportoEsameBean> listRichiesteSupportoEsame =
              esameDAO.doRetrieveAllRichiesteSupportoEsameCompletate();
          List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
              tutoratoDAO.doRetrieveAllRichiesteTutoratoDidatticoCompletate();
          session.setAttribute("richiesteEsamiCompletate", listRichiesteSupportoEsame);
          session.setAttribute("richiesteTutoratoCompletate", listRichiesteTutoratoDidattico);

          resp.sendRedirect("view/RichiesteCompletatePage.jsp");

        } catch (SQLException | ClassNotFoundException e) {
          log.error(myClass, "Catturata eccezione nella Servlet", e);
          e.printStackTrace();
        }
      } else {
        session.setAttribute("alertMsg", "Permessi non concessi all'utente");
        resp.sendRedirect("view/HomePage.jsp");
      }
    } else {
      session.setAttribute("alertMsg", "Permessi non concessi all'utente");
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }
}
