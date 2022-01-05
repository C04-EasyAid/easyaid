package control;

import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.TutoratoDidatticoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/inserisciTutorato")
/**
  @author Riccardo Polidoro Servlet che permette l'inserimento di una richiesta di tutorato
 *     didattico nel DB
 */
public class InserimentoRichiestaTutoratoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user.isStudente()) {
      TutoratoDidatticoBean bean = new TutoratoDidatticoBean();
      bean.setDateDisponibili(req.getParameter("date_disponibili"));
      bean.setOreDisponibili(req.getParameter("ore_disponibili"));
      bean.setOreRichieste(Integer.parseInt(req.getParameter("ore_richieste")));
      bean.setInsegnamento(req.getParameter("insegnamento"));
      bean.setDipartimento(req.getParameter("dipartimento"));
      bean.setStudenteEmail(user.getEmail());
      // bean.setDocente(req.getParameter("docente");
      // if (!TutoratoDidatticoDAO.inserimentoTutorato(bean)) {
      // session.setAttribute("alertMsg", "L’operazione non è andata a buon fine.");
      // resp.sendRedirect("view/HomePage.jsp");
      // }
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
