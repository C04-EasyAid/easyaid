package control;

import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.CommentoDAO;
import model.dao.LezioneDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/*
@author Mariagiovanna Bianco
Servlet che permette di visualizzare la singola lezione
 */
@WebServlet("/SingolaLezione")
public class SingolaLezioneServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    UserBean userLoggato = (UserBean) session.getAttribute("utente");
    if (userLoggato != null) {
      if (request.getParameter("lezione") != null) {
        String idLezione = request.getParameter("lezione");
        int id = Integer.parseInt(idLezione);
        try {
          LezioneBean lezione = new LezioneBean();
          lezione = LezioneDAO.doRetrieveLezioneById(id);
          Collection<CommentoBean> commenti = new ArrayList<>();
          commenti = CommentoDAO.doRetrieveCommento(lezione.getId());
          session.setAttribute("lezione", lezione);
          session.setAttribute("listaCommenti", commenti);
          response.sendRedirect("view/LezionePage.jsp");

        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      response.sendRedirect("view/LoginPage.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
