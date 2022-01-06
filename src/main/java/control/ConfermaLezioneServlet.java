package control;

import model.bean.LezioneBean;
import model.bean.UserBean;
import model.dao.LezioneDAO;
import model.dao.TutoratoDidatticoDAO;
import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
@WebServlet("/ConfermaLezioneServlet")
public class ConfermaLezioneServlet extends HttpServlet {
    private static MyLogger log = MyLogger.getInstance();
    private static String myClass = "ConfermaLezioneServlet";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(myClass, "Collegamento alla Servlet...");
        HttpSession session = req.getSession();
        LezioneBean lezioneBean = (LezioneBean) session.getAttribute("lezione");
        UserBean user = (UserBean) session.getAttribute("utente");
        if (user != null) {
            LezioneDAO lezioneDAO = new LezioneDAO();
            TutoratoDidatticoDAO tutoratoDidatticoDAO = new TutoratoDidatticoDAO();
            try {
                lezioneDAO.confermaLezione(lezioneBean.getId());
                Collection<LezioneBean> lezioni = lezioneDAO.doRetrieveLezioniCompletateById(lezioneBean.getTutorato());
                if(lezioneDAO.countOre(lezioni)==0){
                    tutoratoDidatticoDAO.completaRichiesta(lezioneBean.getId(),user.getEmail());
                }else{
                    resp.sendRedirect("view/LezioniTutorPage.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                lezioneDAO.confermaLezione(lezioneBean.getTutorato());
            } catch (SQLException e) {
                log.error(myClass, "Collegamento alla Servlet...",e);
                e.printStackTrace();
            }


        }else{
            session.setAttribute("alertMsg","Utente non loggato");
            resp.sendRedirect("view/LoginPage.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
