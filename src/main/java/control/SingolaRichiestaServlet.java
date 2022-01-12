package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;

/**
 * @author Martina Giugliano Servlet che permette di visualizzare una singola richiesta di servizio
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
      } if (request.getParameter("idSupporto") != null) {

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
      session.setAttribute("alertMsg","Permessi non concessi all'utente");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
