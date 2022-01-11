package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewRichiesteAccettate")
public class ViewRichiesteAccettateServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewRichiesteAccettateServlet";
  private ISupportoEsameDAO supportoDao = new SupportoEsameDAO();
  private ITutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();

  public void setSupportoDao(ISupportoEsameDAO supportoDao) {
    this.supportoDao = supportoDao;
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

    if (userLoggato != null && userLoggato.isTutor()) {
      try {
        List<SupportoEsameBean> listRichiesteSupportoEsame =
            supportoDao.doRetrieveAllByTutor(userLoggato.getEmail());
        List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
            tutoratoDao.doRetrieveAllByTutor(userLoggato.getEmail());
        session.setAttribute("richiesteEsamiAccettate", listRichiesteSupportoEsame);
        session.setAttribute("richiesteTutoratoAccettate", listRichiesteTutoratoDidattico);

        session.setAttribute("alertMsg","Operazione riuscita con successo!");
        resp.sendRedirect("view/RichiesteAccettatePage.jsp");

      } catch (SQLException | ClassNotFoundException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      session.setAttribute("alertMsg","Permessi non concessi all'utente");
      resp.sendRedirect("view/HomePage.jsp");
    }
  }
}
