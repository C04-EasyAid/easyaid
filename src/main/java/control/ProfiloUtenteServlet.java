package control;

import model.bean.UserBean;
import model.dao.ProfessoreReferenteDAO;
import model.dao.StudenteDAO;
import model.dao.TutorDAO;
import model.dao.UserDAO;
import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Giovanni Toriello
 * Servlet che permette di visualizzare il profilo utente
 */
@WebServlet(name = "UserProfile", urlPatterns = "/UserProfile")
public class ProfiloUtenteServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ProfiloUtenteServlet";
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass,"Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    ProfessoreReferenteDAO professoreDao=new ProfessoreReferenteDAO();
    TutorDAO tutorDao=new TutorDAO();
    StudenteDAO studenteDao=new StudenteDAO();
    UserDAO userdao = new UserDAO();
    if (userLoggato != null && userLoggato.isPersonaleAmministrativo()) {
      if (request.getParameter("usrEmail") != null) {
        String email = request.getParameter("usrEmail");
        try {
          UserBean userBean = userdao.doRetrieveUtenteByEmail(email);
          String ruolo = userBean.getRuolo();
          switch (ruolo) {
            case "T":
              try {
                session.setAttribute("usrProfile", tutorDao.doRetrieveByEmail(email));
                session.setAttribute("utenteSelezionato", userdao.doRetrieveUtenteByEmail(email));
                session.setAttribute("ruolo", ruolo);
                response.sendRedirect("view/UserPage.jsp");
              } catch (Exception e) {
                log.error(myClass,"Catturata eccezione nella Servlet", e);
                e.printStackTrace();
              }
              break;
            case "S":
              try {
                session.setAttribute("usrProfile",studenteDao.doRetrieveByEmail(email));
                session.setAttribute("utenteSelezionato", userdao.doRetrieveUtenteByEmail(email));
                session.setAttribute("ruolo", ruolo);
                response.sendRedirect("view/UserPage.jsp");
              } catch (Exception e) {
                log.error(myClass,"Catturata eccezione nella Servlet", e);
                e.printStackTrace();
              }
              break;
            case "P":
              try {
                session.setAttribute("usrProfile", professoreDao.doRetrieveByEmail(email));
                session.setAttribute("utenteSelezionato", userdao.doRetrieveUtenteByEmail(email));
                session.setAttribute("ruolo", ruolo);
                response.sendRedirect("view/UserPage.jsp");
              } catch (Exception e) {
                log.error(myClass,"Catturata eccezione nella Servlet", e);
                e.printStackTrace();
              }
              break;
          }
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
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
