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
 * Servlet che permette di accettare una richiesta di servizio.
 *
 * @author Martina Giugliano
 *
 */
@WebServlet("/AccettazioneRichiesta")
public class AccettazioneRichiestaServlet extends HttpServlet {
  private ITutoratoDidatticoDAO tutoratodao = new TutoratoDidatticoDAO();
  private ISupportoEsameDAO supportodao = new SupportoEsameDAO();
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "AccettazioneRichiestaServlet";

  public void setTutoratodao(ITutoratoDidatticoDAO tutoratodao) {
    this.tutoratodao = tutoratodao;
  }

  public void setSupportodao(ISupportoEsameDAO supportodao) {
    this.supportodao = supportodao;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean tutor = (UserBean) session.getAttribute("utente");
    String commento = req.getParameter("commento");
    TutoratoDidatticoBean tutorato = (TutoratoDidatticoBean) session.getAttribute("tutorato");
    SupportoEsameBean supporto = (SupportoEsameBean) session.getAttribute("supporto");

    if (tutorato != null) {
      try {
        tutoratodao.accettaRichiesta(tutorato.getId(), tutor.getEmail(), commento);
        session.setAttribute("alertMsg", "Richiesta accettata con successo");
        resp.sendRedirect("view/HomePage.jsp");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
        resp.sendRedirect("view/HomePage.jsp");
        e.printStackTrace();
      }
    }
    if (supporto != null) {
      try {
        supportodao.accettaRichiesta(supporto.getId(), tutor.getEmail(), commento);
        session.setAttribute("alertMsg", "Richiesta accettata con successo");
        resp.sendRedirect("view/HomePage.jsp");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
        resp.sendRedirect("view/HomePage.jsp");
        e.printStackTrace();
      }
    }
  }
}
