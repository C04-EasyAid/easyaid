package control;

import model.bean.StudenteBean;
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
import java.sql.SQLException;
import java.util.List;

/**
 * @author Riccardo Polidoro Servlet che permette di restituire la lista delle richieste effettuate
 *     allo studente
 */
@WebServlet("/ListaRichieste")
public class ViewListaRichiesteEffettuateServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "ListaRichiesteServlet";
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass,"Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean bean = (UserBean) session.getAttribute("utente");
    SupportoEsameDAO supportoDao=new SupportoEsameDAO();
    TutoratoDidatticoDAO tutoratoDao=new TutoratoDidatticoDAO();
    if (bean != null) {
      try {
        List<SupportoEsameBean> listRichiesteSupportoEsame =
           supportoDao.doRetrieveAllByStudente(bean.getEmail());
        List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
            tutoratoDao.doRetrieveAllByStudente(bean.getEmail());
        session.setAttribute("richiesteEsami", listRichiesteSupportoEsame);
        session.setAttribute("richiesteTutorato", listRichiesteTutoratoDidattico);

        resp.sendRedirect("view/ListaRichiesteEffettuatePage.jsp");

      } catch (SQLException e) {
        log.error(myClass,"Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        log.error(myClass,"Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }
}
