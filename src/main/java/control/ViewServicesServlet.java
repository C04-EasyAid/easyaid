package control;

import model.bean.StudenteBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Riccardo Polidoro
 * Servlet per restituire la lista dei servizi allo studente
 */
public class ViewServicesServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session=req.getSession();
        StudenteBean bean= (StudenteBean) session.getAttribute("studente");

        if(bean!=null)
        resp.sendRedirect("./viewservicesjsp");
        else
        {
            session.setAttribute("alertMsg","Permessi non concessi all'utente");
            resp.sendRedirect("./Home.jsp");
        }
    }
}
