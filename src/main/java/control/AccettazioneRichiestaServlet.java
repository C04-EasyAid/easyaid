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
import model.dao.IsupportoEsameDao;
import model.dao.ItutorDao;
import model.dao.ItutoratoDidatticoDao;
import model.dao.SupportoEsameDao;
import model.dao.TutorDao;
import model.dao.TutoratoDidatticoDao;
import other.MyLogger;

/**
 * Servlet che permette di accettare una richiesta di servizio.
 *
 * @author Martina Giugliano
 */
@WebServlet("/AccettazioneRichiesta")
public class AccettazioneRichiestaServlet extends HttpServlet {
  private ItutoratoDidatticoDao tutoratodao = new TutoratoDidatticoDao();
  private IsupportoEsameDao supportodao = new SupportoEsameDao();
  private ItutorDao tutordao = new TutorDao();
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "AccettazioneRichiestaServlet";

  public void setTutoratodao(ItutoratoDidatticoDao tutoratodao) {
    this.tutoratodao = tutoratodao;
  }

  public void setSupportodao(IsupportoEsameDao supportodao) {
    this.supportodao = supportodao;
  }

  public void setTutordao(ItutorDao tutordao) {
    this.tutordao = tutordao;
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
    int oreDisponibilitutor = 0;

    try {
      oreDisponibilitutor = tutordao.doRetrieveByEmail(tutor.getEmail()).getOreDisponibili();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    if (tutorato != null && tutorato.getOreRichieste() < oreDisponibilitutor) {
      try {
        tutoratodao.accettaRichiesta(tutorato.getId(), tutor.getEmail(), commento);
        tutordao.updateOreDisponibili(tutorato.getOreRichieste(), tutor.getEmail());
        session.setAttribute("alertMsg", "Richiesta accettata con successo");
        resp.sendRedirect("viewRichiesteServizio.jsp");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
        resp.sendRedirect("viewRichiesteServizio.jsp");
        e.printStackTrace();
      }
    }
    if (supporto != null && supporto.getOreRichieste() < oreDisponibilitutor) {
      try {
        supportodao.accettaRichiesta(supporto.getId(), tutor.getEmail(), commento);
        session.setAttribute("alertMsg", "Richiesta accettata con successo");
        resp.sendRedirect("viewRichiesteServizio");
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
        resp.sendRedirect("viewRichiesteServizio");
        e.printStackTrace();
      }
    }
  }
}
