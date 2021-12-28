package control;

import model.bean.CommentoBean;
import model.bean.LezioneBean;
import model.dao.CommentoDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/*
@author Mariagiovanna Bianco
Servlet che permette di visualizzare la lista dei commenti della lezione
 */
public class CommentiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LezioneBean bean= (LezioneBean) session.getAttribute("lezione");
        CommentoDAO dao= new CommentoDAO();
        if(bean!=null){
            try {
                ArrayList<CommentoBean> lista= (ArrayList<CommentoBean>) dao.doRetrieveCommento(bean.getId());
                session.setAttribute("listaCommenti", lista);
                response.sendRedirect("viewCommenti.jsp");

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
