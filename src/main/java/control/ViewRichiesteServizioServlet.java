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

@WebServlet("/viewRichiesteServizio")
public class ViewRichiesteServizioServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session=req.getSession();
        SupportoEsameDAO esameDAO=new SupportoEsameDAO();
        TutoratoDidatticoDAO tutoratoDAO=new TutoratoDidatticoDAO();

        try {
            List<SupportoEsameBean> listRichiesteSupportoEsame=esameDAO.doRetrieveRichiesteSupportoEsameNonAccettate();
            List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico=tutoratoDAO.doRetrieveRichiesteTutoratoDidatticoNonAccettate();
            session.setAttribute("richiesteEsamiNonAccettate",listRichiesteSupportoEsame);
            session.setAttribute("richiesteTutoratoNonAccettate",listRichiesteTutoratoDidattico);

            resp.sendRedirect("view/viewRichiesteServizio.jsp");

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