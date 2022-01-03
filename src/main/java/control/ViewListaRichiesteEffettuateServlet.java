package control;

import model.bean.StudenteBean;
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;

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

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    UserBean bean = (UserBean) session.getAttribute("utente");
    if (bean != null) {
      try {
        List<SupportoEsameBean> listRichiesteSupportoEsame =
            SupportoEsameDAO.doRetrieveAllByStudente(bean.getEmail());
        List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico =
            TutoratoDidatticoDAO.doRetrieveAllByStudente(bean.getEmail());
        session.setAttribute("richiesteEsami", listRichiesteSupportoEsame);
        session.setAttribute("richiesteTutorato", listRichiesteTutoratoDidattico);

        resp.sendRedirect("view/ListaRichiesteEffettuatePage.jsp");

      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    } else {
      resp.sendRedirect("view/LoginPage.jsp");
    }
  }
}
