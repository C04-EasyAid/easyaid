package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.StudenteBean;
import model.bean.SupportoEsameBean;
import model.bean.UserBean;
import model.dao.IStudenteDAO;
import model.dao.ISupportoEsameDAO;
import model.dao.StudenteDAO;
import model.dao.SupportoEsameDAO;
import other.MyLogger;

/**
 * Servlet che permette l'inserimento di una richiesta di supporto esame all'interno del DB.
 *
 * @author Riccardo Polidoro
 */

@WebServlet("/inserisciSupporto")
public class InserimentoRichiestaSupportoServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "InserimentoRichiestaSupportoServlet";

  public void setsupportoesameDao(ISupportoEsameDAO dao) {
    this.dao = dao;
  }

  public void setstudenteDao(IStudenteDAO studenteDao ) { this.studenteDao = studenteDao; }

  private ISupportoEsameDAO dao = new SupportoEsameDAO();
  private IStudenteDAO studenteDao = new StudenteDAO();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = req.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
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
        StudenteBean studente = studenteDao.doRetrieveByEmail(user.getEmail());
        if(Integer.parseInt(req.getParameter("ore_richieste"))<studente.getOreDisponibili()){
        if (!dao.InserimentoSupportoEsame(bean)) {
          session.setAttribute("alertMsg", "L’operazione non è andata a buon fine.");
          resp.sendRedirect("view/RichiediServizioPage.jsp");
        } else {
          studenteDao.updateOreDisponibili(Integer.parseInt(req.getParameter("ore_richieste")),user.getEmail());
          session.setAttribute(
              "alertMsg", "Richiesta di servizio di supporto esame inserita con successo!");

          resp.sendRedirect("view/RichiediServizioPage.jsp");
        }
        }else{
          session.setAttribute("alertMsg", "L’operazione non è andata a buon fine.");
          resp.sendRedirect("view/RichiediServizioPage.jsp");
        }

      } catch (SQLException e) {
        log.error(myClass, "Catturata eccezione nella Servlet", e);
      }
    } else {
      session.setAttribute("alertMsg", "Permessi non concessi all'utente");
      resp.sendRedirect("view/HomePage.jsp");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}
