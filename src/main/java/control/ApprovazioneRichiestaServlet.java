package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

/**
 * Servlet che permette di approvare una richiesta di servizio.
 *
 * @author Martina Giugliano
 *
 */

@WebServlet("/ApprovazioneRichiesta")
public class ApprovazioneRichiestaServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ApprovazioneRichiestaServlet";
  ITutoratoDidatticoDAO tutoratodao = new TutoratoDidatticoDAO();
  ISupportoEsameDAO supportodao = new SupportoEsameDAO();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

  public void setTutoratodao(ITutoratoDidatticoDAO tutoratodao) {
    this.tutoratodao = tutoratodao;
  }

  public void setSupportodao(ISupportoEsameDAO supportodao) {
    this.supportodao = supportodao;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean prof = (UserBean) session.getAttribute("utente");
    TutoratoDidatticoBean tutorato = (TutoratoDidatticoBean) session.getAttribute("tutorato");
    SupportoEsameBean supporto = (SupportoEsameBean) session.getAttribute("supporto");
    if (tutorato != null) {
      try {
        tutoratodao.approvaRichiesta(tutorato.getId(), prof.getEmail());
        session.setAttribute("alertMsg", "Richiesta approvata con successo");
        resp.sendRedirect("view/HomePage.jsp");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else if (supporto != null) {
      try {
        supportodao.approvaRichiesta(supporto.getId(), prof.getEmail());
        session.setAttribute("alertMsg", "Richiesta approvata con successo");
        resp.sendRedirect("view/HomePage.jsp");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }

    } else {
      session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
      resp.sendRedirect("view/HomePage.jsp");
    }
  }
}
