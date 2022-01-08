package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
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
        TutoratoDidatticoDAO dao = new TutoratoDidatticoDAO();
        try {
          TutoratoDidatticoBean tutorato = dao.doRetriveById(idTutorato);
          session.setAttribute("tutorato", tutorato);
          response.sendRedirect("view/RichiestaPage.jsp");
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
      } else if (request.getParameter("idSupporto") != null) {
        SupportoEsameDAO dao = new SupportoEsameDAO();
        idSupporto = Integer.parseInt(request.getParameter("idSupporto"));
        try {
          SupportoEsameBean supporto = dao.doRetriveById(idSupporto);
          session.setAttribute("supporto", supporto);
          response.sendRedirect("view/RichiestaPage.jsp");
        } catch (SQLException | ClassNotFoundException e) {
          log.error(myClass, "Catturata eccezione nella Servlet", e);
          e.printStackTrace();
        }
      } else {
        session.setAttribute("alertMsg", "Impossibile aprire il richiesta");
        response.sendRedirect("view/BachecaTutorPage.jsp");
      }
    } else {
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
