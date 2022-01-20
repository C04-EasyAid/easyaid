package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.ICommentoDAO;
import model.dao.ILezioneDAO;
import other.MyLogger;

/**
 * Servlet che permette di visualizzare la singola lezione.
 *
 * @author Mariagiovanna Bianco
 *
 */
@WebServlet("/SingolaLezione")
public class SingolaLezioneServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "SingolaLezioneServlet";
  private ILezioneDAO lezioneDao = new LezioneDAO();
  private ICommentoDAO commentiDao = new CommentoDAO();

  public void setLezioneDao(ILezioneDAO lezioneDao) {
    this.lezioneDao = lezioneDao;
  }

  public void setCommentiDao(ICommentoDAO commentiDao) {
    this.commentiDao = commentiDao;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null && (userLoggato.isStudente() || userLoggato.isTutor())) {
      String idLezione = request.getParameter("lezione");
      int id = Integer.parseInt(idLezione);
      try {
        LezioneBean lezione = lezioneDao.doRetrieveLezioneById(id);
        Collection<CommentoBean> commenti = commentiDao.doRetrieveCommento(lezione.getId());
        session.setAttribute("lezione", lezione);
        session.setAttribute("listaCommenti", commenti);
        response.sendRedirect("view/LezionePage.jsp");

      } catch (ClassNotFoundException | SQLException e) {
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
