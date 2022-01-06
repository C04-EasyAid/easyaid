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

@WebServlet("/viewRichiesteServizio")
public class ViewRichiesteServizioServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewRichiesteServizioServlet";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    SupportoEsameDAO esameDAO = new SupportoEsameDAO();
    TutoratoDidatticoDAO tutoratoDAO = new TutoratoDidatticoDAO();
    if (userLoggato != null) {
      if (userLoggato.isTutor()) {
        try {
          List<SupportoEsameBean> listRichiesteSupportoEsame =
              esameDAO.doRetrieveRichiesteSupportoEsameNonAccettate();
          List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
              tutoratoDAO.doRetrieveRichiesteTutoratoDidatticoNonAccettate();
          session.setAttribute("richiesteEsamiNonAccettate", listRichiesteSupportoEsame);
          session.setAttribute("richiesteTutoratoNonAccettate", listRichiesteTutoratoDidattico);

          resp.sendRedirect("view/BachecaTutorPage.jsp");

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
