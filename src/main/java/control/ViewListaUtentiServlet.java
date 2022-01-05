package control;

import model.bean.UserBean;
import model.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/** @author Roberto Tartaglia Servlet che permette di effettuare il logout */
@WebServlet(name = "ViewListaUsers", urlPatterns = "/ViewListaUsers")
public class ViewListaUtentiServlet extends HttpServlet {
  public ViewListaUtentiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    UserDAO userDao=new UserDAO();
    if (userLoggato != null && userLoggato.isPersonaleAmministrativo()) {
      try {
        session.setAttribute("usrList",userDao.doRetrieveAll());
        response.sendRedirect("view/ListaUtentiPage.jsp");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      response.sendRedirect("view/HomePage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
