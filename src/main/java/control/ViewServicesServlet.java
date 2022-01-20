package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.StudenteBean;
import other.MyLogger;

/**
 * Servlet per restituire la lista dei servizi allo studente.
 *
 *  @author Riccardo Polidoro
 *
 */
@WebServlet("/viewServices")
public class ViewServicesServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewServicesServlet";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    StudenteBean bean = (StudenteBean) session.getAttribute("studente");

    if (bean != null) {
      resp.sendRedirect("view/RichiediServizioPage.jsp");
    }
    else {
      session.setAttribute("alertMsg", "Permessi non concessi all'utente");
      resp.sendRedirect("view/HomePage.jsp");
    }
  }
}
