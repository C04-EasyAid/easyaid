package control;

import model.bean.UserBean;
import model.dao.ProfessoreReferenteDAO;
import model.dao.StudentDAO;
import model.dao.TutorDAO;
import model.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserProfile", urlPatterns = "/UserProfile")
public class ProfiloUtenteServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    ProfessoreReferenteDAO professoreDao=new ProfessoreReferenteDAO();
    TutorDAO tutorDao=new TutorDAO();
    StudentDAO studenteDao=new StudentDAO();
    if (userLoggato != null && userLoggato.isPersonaleAmministrativo()) {
      if (request.getParameter("usrEmail") != null && request.getParameter("ruolo") != null) {
        String email = request.getParameter("usrEmail");
        String ruolo = request.getParameter("ruolo");
        switch (ruolo) {
          case "T":
            try {
              session.setAttribute("usrProfile", tutorDao.doRetrieveByEmail(email));
              session.setAttribute("utenteSelezionato", UserDAO.doRetrieveUtenteByEmail(email));
              session.setAttribute("ruolo", ruolo);
              response.sendRedirect("view/UserPage.jsp");
            } catch (Exception e) {
              e.printStackTrace();
            }
            break;
          case "S":
            try {
              session.setAttribute("usrProfile",studenteDao.doRetrieveByEmail(email));
              session.setAttribute("utenteSelezionato", UserDAO.doRetrieveUtenteByEmail(email));
              session.setAttribute("ruolo", ruolo);
              response.sendRedirect("view/UserPage.jsp");
            } catch (Exception e) {
              e.printStackTrace();
            }
            break;
          case "P":
            try {
              session.setAttribute("usrProfile", professoreDao.doRetrieveByEmail(email));
              session.setAttribute("utenteSelezionato", UserDAO.doRetrieveUtenteByEmail(email));
              session.setAttribute("ruolo", ruolo);
              response.sendRedirect("view/UserPage.jsp");
            } catch (Exception e) {
              e.printStackTrace();
            }
            break;
        }
      } else response.sendRedirect("view/ListaUtentiPage.jsp");
    }else{
        response.sendRedirect("view/HomePage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
