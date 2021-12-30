package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/viewRichiesteAccettate")
public class ViewRichiesteAccettateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        SupportoEsameDAO esameDAO=new SupportoEsameDAO();
        TutoratoDidatticoDAO tutoratoDAO=new TutoratoDidatticoDAO();
        //questo verrà poi preso dalla sessione
        String email="lorenzorossi1@studenti.unisa.it";

        try {
            List<SupportoEsameBean> listRichiesteSupportoEsame=esameDAO.doRetrieveAllByTutor(email);
            List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico=tutoratoDAO.doRetrieveAllByTutor(email);
            session.setAttribute("richiesteEsamiAccettate",listRichiesteSupportoEsame);
            session.setAttribute("richiesteTutoratoAccettate",listRichiesteTutoratoDidattico);

            resp.sendRedirect("view/RichiesteAccettatePage.jsp");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
