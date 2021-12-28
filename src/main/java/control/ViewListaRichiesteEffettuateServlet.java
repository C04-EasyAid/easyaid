package control;

import model.bean.StudenteBean;
import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


//Servlet che permette di restituire la lista delle richieste effettuate allo studente
public class ViewListaRichiesteEffettuateServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        HttpSession session=req.getSession();
        StudenteBean bean= (StudenteBean) session.getAttribute("studente");
        SupportoEsameDAO esameDAO=new SupportoEsameDAO();
        TutoratoDidatticoDAO tutoratoDAO=new TutoratoDidatticoDAO();
        if(bean!=null)//controllo sulla sessione:verifica che lo studente è loggato nel sistema
        {
            try {
                List<SupportoEsameBean> listRichiesteSupportoEsame=esameDAO.doRetrieveAllByStudente(bean.getEmail());
                List<TutoratoDidatticoBean> listRichiesteTutoratoDidattico=tutoratoDAO.doRetrieveAllByStudente(bean.getEmail());
                session.setAttribute("richiesteEsami",listRichiesteSupportoEsame);
                session.setAttribute("richiesteTutorato",listRichiesteTutoratoDidattico);

                resp.sendRedirect("./richiesteeffettuate.jsp");

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
        else
        {//se lo studente non è loggato,non può vedere la lista delle richieste effettuate,viene reindirizzato alla home page
            session.setAttribute("alertMsg","Permessi non concessi all'utente");
            resp.sendRedirect("./Home.jsp");
        }


    }
}
