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
 * Servlet che permette di visualizzare le richieste di servizio.
 *
 * @author Riccardo Polidoro
 */
@WebServlet("/viewRichiesteServizio")
public class ViewRichiesteServizioServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewRichiesteServizioServlet";
  private ISupportoEsameDAO esameDao = new SupportoEsameDAO();
  private ITutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();

  public void setEsameDao(ISupportoEsameDAO esameDao) {
    this.esameDao = esameDao;
  }

  public void setTutoratoDao(ITutoratoDidatticoDAO tutoratoDao) {
    this.tutoratoDao = tutoratoDao;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null) {
      if (userLoggato.isTutor()) {
        try {
          List<SupportoEsameBean> listRichiesteSupportoEsame =
              esameDao.doRetrieveRichiesteSupportoEsameNonAccettate();
          List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
              tutoratoDao.doRetrieveRichiesteTutoratoDidatticoNonAccettate();
          session.setAttribute("richiesteEsamiNonAccettate", listRichiesteSupportoEsame);
          session.setAttribute("richiesteTutoratoNonAccettate", listRichiesteTutoratoDidattico);

          resp.sendRedirect("view/BachecaTutorPage.jsp");

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
