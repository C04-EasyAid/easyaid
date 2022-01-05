package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
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
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ViewRichiesteAccettateServlet";
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass,"Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    SupportoEsameDAO supportoDao=new SupportoEsameDAO();
    TutoratoDidatticoDAO tutoratoDao=new TutoratoDidatticoDAO();
    if (userLoggato != null && userLoggato.isTutor()) {
      try {
        List<SupportoEsameBean> listRichiesteSupportoEsame =
            supportoDao.doRetrieveAllByTutor(userLoggato.getEmail());
        List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico = tutoratoDao.doRetrieveAllByTutor(userLoggato.getEmail());
        session.setAttribute("richiesteEsamiAccettate", listRichiesteSupportoEsame);
        session.setAttribute("richiesteTutoratoAccettate", listRichiesteTutoratoDidattico);

        resp.sendRedirect("view/RichiesteAccettatePage.jsp");

      } catch (SQLException e) {
        log.error(myClass,"Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        log.error(myClass,"Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      resp.sendRedirect("view/HomePage.jsp");
    }
  }
}
