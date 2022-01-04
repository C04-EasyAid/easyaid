package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import model.bean.UserBean;
import model.dao.UserDAO;

/**
 * @author Roberto Tartaglia
 * Servlet che permette di effettuare il login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    HttpSession session = request.getSession();
    UserBean user = new UserBean();
    UserDAO dao=new UserDAO();
    user.setEmail(request.getParameter("Email"));
    user.setPassword(request.getParameter("Password"));
    try {
      user = dao.doRetrieveUtente(user);
      if (user == null) {
        // Nessun utente nel sistema
        response.sendRedirect("view/LoginPage.jsp");
      }
      else
      {
        session.setAttribute("utente", user);
        response.sendRedirect("view/HomePage.jsp");
      }
    } catch (Throwable e) {
      session.setAttribute("alertMsg", "Errore, ritorno alla Login Page");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
