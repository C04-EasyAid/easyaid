package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *@author Martina Giugliano
 *Servlet che permette di approvare una richiesta di servizio
 */
@WebServlet("/ApprovazioneRichiesta")
public class ApprovazioneRichiestaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserBean tutor = (UserBean) session.getAttribute("utente");
        TutoratoDidatticoBean tutorato = (TutoratoDidatticoBean) session.getAttribute("tutorato");
        SupportoEsameBean supporto = (SupportoEsameBean) session.getAttribute("supporto");
        TutoratoDidatticoDAO tutoratodao = new TutoratoDidatticoDAO();
        SupportoEsameDAO supportodao = new SupportoEsameDAO();
        if (tutorato != null){
            // tutoratodao.approvaRichiesta(tutorato.getId(), tutor.getEmail());
            // resp.sendRedirect("view/HomePage.jsp");
        }
        else if (supporto != null){
            // supportodao.approvaRichiesta(supporto.getId(), supporto.getEmail());
            // resp.sendRedirect("view/HomePage.jsp");
        }
        else {
            session.setAttribute("alertMsg", "L'operazione non è andata a buon fine");
            resp.sendRedirect("view/HomePage.jsp");
        }

    }
}
