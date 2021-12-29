package control;

import model.bean.LezioneBean;
import model.bean.TutorBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.LezioneDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/*
@author Serena Liguori
Servlet che permette di visualizzare le lezioni
 */
public class LezioniServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("studente");
      TutoratoDidatticoBean bean = (TutoratoDidatticoBean) session.getAttribute("tutorato");
      LezioneDAO dao = new LezioneDAO();
      if (bean != null) {
        try {
          ArrayList<LezioneBean> lista =
              (ArrayList<LezioneBean>) dao.doRetrieveLezione(bean.getId());
          session.setAttribute("listaLezioni", lista);
        if (user != null) {
          response.sendRedirect("viewLezioniStudente.jsp");
          }
        else{
            response.sendRedirect("viewLezioniTutor.jsp");
        }
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
