package control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public LoginServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        /*try {
            UserBean user=new UserBean();
            user.setEmail(request.getParameter("Email"));
            user.setPassword(request.getParameter("Password"));
            user=UserDAO.doRetrieve(user);
            if(user==null)
            {
                //Nessun utente nel sistema
                response.sendRedirect("./LoginPage.jsp");
            }
            if(user.isStudente()) {
                session.setAttribute("studente", user);
                response.sendRedirect("./Home.jsp");
            }
            else if(user.isTutor())
            {
                session.setAttribute("tutor", user);
                response.sendRedirect("./Home.jsp");
            }
            else if(user.isProfessoreReferente())
            {
                session.setAttribute("professore", user);
                response.sendRedirect("./Home.jsp");
            }
            else if(user.isPersonaleAmministrativo())
            {
                session.setAttribute("admin", user);
                response.sendRedirect("./Home.jsp");
            }
        }
        catch(Throwable e)
        {
            session.setAttribute("alertMsg","Errore, ritorno alla Login Page");
            response.sendRedirect("./LoginPage.jsp");
        }*/
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}