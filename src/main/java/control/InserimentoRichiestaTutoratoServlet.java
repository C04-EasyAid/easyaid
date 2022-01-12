package control;

import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ITutoratoDidatticoDAO;
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

@WebServlet("/inserisciTutorato")
/*
 * @author Riccardo Polidoro Servlet che permette l'inserimento di una richiesta di tutorato
 *     didattico nel DB
 */
public class InserimentoRichiestaTutoratoServlet extends HttpServlet {
  private static MyLogger log = MyLogger.getInstance();
  private static String myClass = "InserimentoRichiestaTutoratoServlet";

  public void setDao(ITutoratoDidatticoDAO dao) {
    this.dao = dao;
  }

  private ITutoratoDidatticoDAO dao = new TutoratoDidatticoDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user.isStudente()) {
      TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
      bean.setDateDisponibili(req.getParameter("date_disponibili"));
      bean.setOreDisponibili(req.getParameter("ore_disponibili"));
      bean.setOreRichieste(Integer.parseInt(req.getParameter("ore_richieste")));
      bean.setInsegnamento(req.getParameter("insegnamento"));
      bean.setDipartimento(req.getParameter("dipartimento"));
      bean.setDocente(req.getParameter("docente"));
      bean.setStudenteEmail(user.getEmail());
      // bean.setDocente(req.getParameter("docente");
      try {
        if (!dao.InserimentoTutoratoDidattico(bean)) {
          session.setAttribute("alertMsg", "L’operazione non è andata a buon fine.");
          resp.sendRedirect("view/HomePage.jsp");
        } else {
          session.setAttribute(
                  "alertMsg", "Richiesta di servizio di tutorato didattico inserita con successo!");
          resp.sendRedirect("view/HomePage.jsp");
        }
      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
        e.printStackTrace();
      }
    } else {
      session.setAttribute("alertMsg", "Permessi non concessi all'utente");
      resp.sendRedirect("view/HomePage.jsp");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    super.doPost(req, resp);
  }
}