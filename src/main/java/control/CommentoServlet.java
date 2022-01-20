package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.LezioneBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.commentodao;
import model.dao.icommentoDao;
import model.dao.istudenteDao;
import model.dao.itutorDao;
import model.dao.studenteDao;
import model.dao.TutorDAO;
import other.MyLogger;


/**
 * Servlet che permette di inserire i commenti per una lezione.
 *
 * @author Serena Liguori
 */

@WebServlet("/CommentoServlet")
public class CommentoServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "CommentoServlet";
  private icommentoDao daoC = new commentodao();
  private itutorDao daoT = new TutorDAO();
  private istudenteDao daoS = new studenteDao();

  public void setDaoC(icommentoDao daoC) {
    this.daoC = daoC;
  }

  public void setDaoT(itutorDao daoT) {
    this.daoT = daoT;
  }

  public void setDaoS(istudenteDao daoS) {
    this.daoS = daoS;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    session.removeAttribute("commento");

    if (user != null) {
      String msg = request.getParameter("commento");
      LezioneBean lezione = (LezioneBean) session.getAttribute("lezione");
      if (msg != null && msg.length() <= 250 && msg.length() > 1 && lezione.getId() != 0) {
        if (user.isStudente()) {
          StudenteBean bean = null;
          try {
            bean = daoS.doRetrieveByEmail(user.getEmail());
          } catch (SQLException e) {
            e.printStackTrace();
          }
          if (bean != null) {
            try {
              daoC.insertCommentoStudente(lezione.getId(), msg, bean.getEmail());
              session.setAttribute("listaCommenti", daoC.doRetrieveCommento(lezione.getId()));
              session.setAttribute("alertMsg", "Commento inserito con successo");
              response.sendRedirect("view/LezionePage.jsp");
            } catch (SQLException | ClassNotFoundException e) {
              e.printStackTrace();
            }
          }
        } else if (user.isTutor()) {
          TutorBean bean = null;
          try {
            bean = daoT.doRetrieveByEmail(user.getEmail());
          } catch (SQLException | ClassNotFoundException e) {
            log.error(myClass, "Catturata eccezione nella Servlet", e);
            e.printStackTrace();
          }
          if (bean != null) {
            try {
              daoC.insertCommentoTutor(lezione.getId(), msg, bean.getEmailTutor());
              session.setAttribute("listaCommenti", daoC.doRetrieveCommento(lezione.getId()));
              session.setAttribute("alertMsg", "Commento inserito con successo");
              response.sendRedirect("view/LezionePage.jsp");
            } catch (SQLException | ClassNotFoundException e) {
              log.error(myClass, "Catturata eccezione nella Servlet", e);
              e.printStackTrace();
            }
          }
        }
      } else if (msg == null || lezione.getId() == 0) {

        try {
          session.setAttribute("alertMsg", "Operazione non andata a buon fine");
          session.setAttribute("listaCommenti", daoC.doRetrieveCommento(lezione.getId()));
        } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
        }
        response.sendRedirect("view/LezionePage.jsp");
      } else {
        response.sendRedirect("view/LezionePage.jsp");
      }
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
