package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.UserBean;
import model.dao.IuserDao;
import model.dao.UserDao;
import other.MyLogger;

/**
 * Servlet che permette di effettuare il login.
 *
 * @author Roberto Tartaglia
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "LoginServlet";
  private IuserDao dao = new UserDao();

  public void setDao(IuserDao dao) {
    this.dao = dao;
  }

  public LoginServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean user = new UserBean();
    user.setEmail(request.getParameter("Email"));
    user.setPassword(request.getParameter("Password"));
    try {
      user = dao.doRetrieveUtente(user);
      if (user == null) {
        // Nessun utente nel sistema
        response.sendRedirect("view/LoginPage.jsp");
        session.setAttribute("alertMsg", "L'operazione non e' andata a buon fine");
      } else {
        session.setAttribute("utente", user);
        response.sendRedirect("view/HomePage.jsp");
      }
    } catch (Throwable e) {
      log.error(myClass, "Catturata eccezione nella Servlet", (Exception) e);
      session.setAttribute("alertMsg", "L'operazione non e' andata a buon fine");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
