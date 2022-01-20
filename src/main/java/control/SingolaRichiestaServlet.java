package control;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.bean.SupportoEsameBean;
import model.dao.SupportoEsameDAO;
import model.bean.TutoratoDidatticoBean;
import model.dao.TutoratoDidatticoDAO;
import model.bean.UserBean;
import other.MyLogger;

/**
 * Servlet che permette di visualizzare una singola richiesta di servizio
 *
 * @author Martina Giugliano
 */
@WebServlet("/SingolaRichiestaServlet")
public class SingolaRichiestaServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "SingolaRichiestaServlet";
  @Serial private static final long serialVersionUID = 1L;
  private ITutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();
  private ISupportoEsameDAO supportoDao = new SupportoEsameDAO();

  public void setTutoratoDao(ITutoratoDidatticoDAO tutoratoDao) {
    this.tutoratoDao = tutoratoDao;
  }

  public void setSupportoDao(ISupportoEsameDAO supportoDao) {
    this.supportoDao = supportoDao;
  }

  public SingolaRichiestaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    int idTutorato;
    int idSupporto;
    session.removeAttribute("supporto");
    session.removeAttribute("tutorato");
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null) {
      if (request.getParameter("idTutorato") != null) {
        idTutorato = Integer.parseInt(request.getParameter("idTutorato"));

        try {
          TutoratoDidatticoBean tutorato = tutoratoDao.doRetriveById(idTutorato);
          session.setAttribute("tutorato", tutorato);
          response.sendRedirect("view/RichiestaPage.jsp");
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
      if (request.getParameter("idSupporto") != null) {

        idSupporto = Integer.parseInt(request.getParameter("idSupporto"));
        try {
          SupportoEsameBean supporto = supportoDao.doRetriveById(idSupporto);
          session.setAttribute("supporto", supporto);
          response.sendRedirect("view/RichiestaPage.jsp");
        } catch (SQLException | ClassNotFoundException e) {
          log.error(myClass, "Catturata eccezione nella Servlet", e);
          e.printStackTrace();
        }
      }
    } else {
      session.setAttribute("alertMsg", "Permessi non concessi all'utente");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
