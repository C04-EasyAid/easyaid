package control;

import model.dao.ProfessoreReferenteDAO;
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

@WebServlet(name = "UserProfile", urlPatterns = "/UserProfile")
public class ProfiloUtenteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("usrEmail")!=null && request.getParameter("ruolo")!=null)
        {
            String email=request.getParameter("usrEmail");
            String ruolo=request.getParameter("ruolo");
            switch (ruolo)
            {
                case "T":
                    try {
                        session.setAttribute("usrProfile", TutorDAO.doRetrieveByEmail(email));
                        response.sendRedirect("view/UserViewPage.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "S":
                    try {
                        session.setAttribute("usrProfile", StudentDAO.doRetrieveByEmail(email));
                        response.sendRedirect("view/UserViewPage.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "PR":
                    try {
                        session.setAttribute("usrProfile", ProfessoreReferenteDAO.doRetrieveByEmail(email));
                        response.sendRedirect("view/UserViewPage.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
