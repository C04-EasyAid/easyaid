package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
import model.dao.ItutoratoDidatticoDao;
import model.dao.SupportoEsameDao;
import model.dao.TutoratoDidatticoDao;
import other.MyLogger;

/**
 * Servlet che permette di restituire la lista delle richieste effettuate allo studente.
 *
 * @author Riccardo Polidoro
 */

@WebServlet("/ListaRichieste")
public class ViewListaRichiesteEffettuateServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "ListaRichiesteServlet";
  private IsupportoEsameDao supportoDao = new SupportoEsameDao();
  private ItutoratoDidatticoDao tutoratoDao = new TutoratoDidatticoDao();

  public void setSupportoDao(IsupportoEsameDao supportoDao) {
    this.supportoDao = supportoDao;
  }

  public void setTutoratoDao(ItutoratoDidatticoDao tutoratoDao) {
    this.tutoratoDao = tutoratoDao;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean bean = (UserBean) session.getAttribute("utente");

    if (bean != null && bean.isStudente()) {
      try {
        List<SupportoEsameBean> listRichiesteSupportoEsame =
            supportoDao.doRetrieveAllByStudente(bean.getEmail());
        List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
            tutoratoDao.doRetrieveAllByStudente(bean.getEmail());
        session.setAttribute("richiesteEsami", listRichiesteSupportoEsame);
        session.setAttribute("richiesteTutorato", listRichiesteTutoratoDidattico);

        resp.sendRedirect("view/ListaRichiesteEffettuatePage.jsp");

      } catch (SQLException | ClassNotFoundException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      req.getSession().setAttribute("alertMsg", "Permessi non concessi all'utente");
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }
}
