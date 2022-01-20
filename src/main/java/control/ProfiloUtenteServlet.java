package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.UserBean;
import model.dao.iprofessorereferenteDao;
import model.dao.istudenteDao;
import model.dao.itutorDao;
import model.dao.iuserDao;
import model.dao.professorereferenteDao;
import model.dao.studenteDao;
import model.dao.TutorDAO;
import model.dao.UserDAO;
import other.MyLogger;

/**
 * Servlet che permette di visualizzare il profilo utente.
 *
 * @author Giovanni Toriello
 *
 */

@WebServlet(name = "UserProfile", urlPatterns = "/UserProfile")
public class ProfiloUtenteServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ProfiloUtenteServlet";
  private itutorDao tutorDao = new TutorDAO();
  private istudenteDao studenteDao = new studenteDao();
  private iuserDao userdao = new UserDAO();
  private iprofessorereferenteDao professoreDao = new professorereferenteDao();

  public void setTutorDao(itutorDao tutorDao) {
    this.tutorDao = tutorDao;
  }

  public void setStudenteDao(istudenteDao studenteDao) {
    this.studenteDao = studenteDao;
  }

  public void setUserdao(iuserDao userdao) {
    this.userdao = userdao;
  }

  public void setProfessoreDao(iprofessorereferenteDao professoreDao) {
    this.professoreDao = professoreDao;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");

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
                log.error(myClass, "Catturata eccezione nella Servlet", e);
                e.printStackTrace();
              }
              break;
            case "S":
              try {
                session.setAttribute("usrProfile", studenteDao.doRetrieveByEmail(email));
                session.setAttribute("utenteSelezionato", userdao.doRetrieveUtenteByEmail(email));
                session.setAttribute("ruolo", ruolo);
                response.sendRedirect("view/UserPage.jsp");
              } catch (Exception e) {
                log.error(myClass, "Catturata eccezione nella Servlet", e);
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
                log.error(myClass, "Catturata eccezione nella Servlet", e);
                e.printStackTrace();
              }
              break;
            default: System.out.println("Nessuno dei casi di switch");
            break;
          }
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }

      } else {
        request.getSession().setAttribute("alertMsg", "Operazione non andata a buon fine");
        response.sendRedirect("view/ListaUtentiPage.jsp");
      }
    } else {
      request.getSession().setAttribute("alertMsg", "Permessi non concessi all'utente");
      response.sendRedirect("view/HomePage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
