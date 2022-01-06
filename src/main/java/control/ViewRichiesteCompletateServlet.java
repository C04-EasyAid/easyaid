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

@WebServlet("/viewRichiesteCompletate")
public class ViewRichiesteCompletateServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewRichiesteCompletateServlet";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null) {
      if (userLoggato.isProfessoreReferente()) {
        SupportoEsameDAO esameDAO = new SupportoEsameDAO();
        TutoratoDidatticoDAO tutoratoDAO = new TutoratoDidatticoDAO();
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
        resp.sendRedirect("view/HomePage.jsp");
      }
    } else {
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }
}
