package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.ILezioneDAO;
import model.dao.LezioneDAO;
import other.MyLogger;



/*
@author Mariagiovanna Bianco
Servlet che permette di inserire una nuova lezione
*/

@WebServlet("/InserimentoLezione")
public class InserimentoNuovaLezioneServlet extends HttpServlet {
  private static final MyLogger log = MyLogger.getInstance();
  private static final String myClass = "InserimentoLezioneServlet";
  private ILezioneDAO lezioneDAO=new LezioneDAO();

  public void setLezioneDAO(ILezioneDAO lezioneDAO) {
    this.lezioneDAO = lezioneDAO;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    log.info(myClass, "Collegamento alla Servlet...");
    HttpSession session = request.getSession();
    UserBean user = (UserBean) session.getAttribute("utente");
    if (user != null) {
      int idTutorato = Integer.parseInt(request.getParameter("idTutorato"));
      String oraInizio = request.getParameter("oraInizio");
      String oraFine = request.getParameter("oraFine");
      String data = request.getParameter("data");
      SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date date = dateParser.parse(data);
        LezioneBean lezioneBean = new LezioneBean();
        lezioneBean.setTutorato(idTutorato);
        lezioneBean.setTutor(user.getEmail());
        lezioneBean.setOraInizio(oraInizio);
        lezioneBean.setOraFine(oraFine);
        lezioneBean.setData(date);
        Collection<LezioneBean> lezioni = lezioneDAO.doRetrieveLezioniCompletateById(idTutorato);
        lezioni.add(lezioneBean);
        if (lezioneDAO.countOre(lezioni, idTutorato) <= 1) {
          lezioneDAO.insertNewLezione(lezioneBean);
          session.setAttribute("alertMsg", "Lezione Inserita");
          response.sendRedirect(request.getContextPath() + "/LezioniServlet");
        } if (lezioneDAO.countOre(lezioni, idTutorato) == 2) {
          session.setAttribute("alertMsg", "La lezione supera le ore richieste");
          response.sendRedirect("view/LezioniTutorPage.jsp");
        }
      } catch (ParseException | SQLException | ClassNotFoundException e) {
        log.error(myClass, "Collegamento alla Servlet...", e);
        e.printStackTrace();
      }
    } else {
      request.getSession().setAttribute("alertMsg","Permessi non concessi all'utente");
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }
}

