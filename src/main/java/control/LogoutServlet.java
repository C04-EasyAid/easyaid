package control;

import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet che permette di effettuare il logout.
 *
 * @author Roberto Tartaglia
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "LogoutServlet";

  public LogoutServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    session.invalidate();
    response.sendRedirect("view/LoginPage.jsp");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
