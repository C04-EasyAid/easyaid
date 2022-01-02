package control;

import model.bean.LezioneBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.LezioneDAO;
import model.dao.StudentDAO;
import model.dao.TutorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/LezioniServlet")
public class LezioniServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("utente");
        if (user != null) {
            if (user.isStudente()) {
                StudenteBean bean = null;
                try {
                    bean = StudentDAO.doRetrieveByEmail(user.getEmail());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (bean != null) {
                    try {
                        ArrayList<LezioneBean> lista =
                                (ArrayList<LezioneBean>) LezioneDAO.doRetrieveLezioneByStudente(bean.getEmail());
                        session.setAttribute("listaLezioni", lista);
                        response.sendRedirect("view/LezioniStudentePage.jsp");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(user.isTutor()){
                TutorBean bean = null;
                try {
                    bean = TutorDAO.doRetrieveByEmail(user.getEmail());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (bean != null) {
                    try {
                        ArrayList<LezioneBean> lista =
                                (ArrayList<LezioneBean>) LezioneDAO.doRetrieveLezioneByTutor(bean.getEmailTutor());
                        session.setAttribute("listaLezioni", lista);
                        response.sendRedirect("view/LezioniTutorPage.jsp");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }else if(user == null){
            response.sendRedirect("view/LoginPage.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
