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
 * Servlet che permette di visualizzare la lista di utenti.
 *
 *  @author Roberto Tartaglia
 *
 */
@WebServlet(name = "ViewListaUsers", urlPatterns = "/ViewListaUsers")
public class ViewListaUtentiServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ViewListaUtentiServlet";
  private IuserDao userDao = new UserDao();

  public void setUserDao(IuserDao userDao) {
    this.userDao = userDao;
  }

  public ViewListaUtentiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");

    if (userLoggato != null && userLoggato.isPersonaleAmministrativo()) {
      try {
        session.setAttribute("usrList", userDao.doRetrieveAll());
        response.sendRedirect("view/ListaUtentiPage.jsp");
      } catch (Exception e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      request.getSession().setAttribute("alertMsg", "Permessi non concessi all'utente");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
