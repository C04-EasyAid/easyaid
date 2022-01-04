package control;

import model.bean.SupportoEsameBean;
import model.bean.UserBean;
import model.dao.SupportoEsameDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/inserisciSupporto")
/**
 * @author Riccardo Polidoro Servlet che permette l'inserimento di una richiesta di supporto esame
 *     all'interno del DB
 */
public class InserimentoRichiestaSupportoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    SupportoEsameDAO dao=new SupportoEsameDAO();
    if (user.isStudente()) {
      SupportoEsameBean bean = new SupportoEsameBean();
      bean.setDipartimento(req.getParameter("dipartimento"));
      bean.setInsegnamento(req.getParameter("insegnamento"));
      bean.setData(req.getParameter("data"));
      bean.setOra(req.getParameter("ora"));
      bean.setOreRichieste(Integer.parseInt(req.getParameter("ore_richieste")));
      bean.setDocente(req.getParameter("docente"));
      bean.setLuogo(req.getParameter("luogo"));
      bean.setModalitaEsame(req.getParameter("modalita_esame"));
      bean.setTipoAssistenza(req.getParameter("tipo_di_assistenza"));
      bean.setEventualiAusili(req.getParameter("eventuali_ausili"));
      bean.setStudenteEmail(user.getEmail());
      try {
        if(!dao.InserimentoSupportoEsame(bean)){
        session.setAttribute("alertMsg", "L’operazione non è andata a buon fine.");
         resp.sendRedirect("view/HomePage.jsp");
        }
      } catch (SQLException e) {
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
