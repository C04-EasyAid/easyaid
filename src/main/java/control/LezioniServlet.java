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
import model.bean.LezioneBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.ILezioneDAO;
import model.dao.IStudenteDAO;
import model.dao.ITutorDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.LezioneDAO;
import model.dao.StudenteDAO;
import model.dao.TutorDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

/**
 * Servlet che permette di visualizzare le lezioni.
 *
 * @author Serena Liguori
 */
@WebServlet(name = "LezioniServlet", urlPatterns = "/LezioniServlet")
public class LezioniServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "LezioniServlet";
  private ILezioneDAO lezioneDao = new LezioneDAO();
  private IStudenteDAO studenteDao = new StudenteDAO();
  private ITutoratoDidatticoDAO tutoratodidatticoDao = new TutoratoDidatticoDAO();
  private ITutorDAO tutorDao = new TutorDAO();

  public void setLezioneDao(ILezioneDAO lezioneDao) {
    this.lezioneDao = lezioneDao;
  }

  public void setStudenteDao(IStudenteDAO studenteDao) {
    this.studenteDao = studenteDao;
  }

  public void settutoratodidatticodao(ITutoratoDidatticoDAO tutoratodidatticoDao) {
    this.tutoratodidatticoDao = tutoratodidatticoDao;
  }

  public void setTutorDao(ITutorDAO tutorDao) {
    this.tutorDao = tutorDao;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user != null && (user.isStudente() || user.isTutor())) {
      if (user.isStudente()) {
        StudenteBean bean = null;
        try {
          bean = studenteDao.doRetrieveByEmail(user.getEmail());
        } catch (SQLException e) {
          e.printStackTrace();
        }
        try {
          Collection<LezioneBean> lista = lezioneDao.doRetrieveLezioneByStudente(bean.getEmail());
          session.setAttribute("listaLezioni", lista);
          response.sendRedirect("view/LezioniStudentePage.jsp");
        } catch (ClassNotFoundException | SQLException e) {
          log.error(myClass, "Catturata eccezione nella Servlet", e);
          e.printStackTrace();
        }
      }
      if (user.isTutor()) {
        TutorBean bean = null;
        try {
          bean = tutorDao.doRetrieveByEmail(user.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
        try {
          Collection<LezioneBean> lista = lezioneDao.doRetrieveLezioneByTutor(bean.getEmailTutor());
          session.setAttribute("listaLezioni", lista);
          session.setAttribute(
              "richiesteTutorato", tutoratodidatticoDao.doRetrieveAllByTutor(bean.getEmailTutor()));
          response.sendRedirect("view/LezioniTutorPage.jsp");
        } catch (ClassNotFoundException | SQLException e) {
          log.error(myClass, "Catturata eccezione nella Servlet", e);
          e.printStackTrace();
        }
      }
    } else {
      request
          .getSession()
          .setAttribute(
              "alertMsg", "L'utente non ha i permessi necessari per accedere alla pagina!");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
