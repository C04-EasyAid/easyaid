package control;

        import model.bean.LezioneBean;
        import model.bean.UserBean;
        import model.dao.LezioneDAO;
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
        import java.util.Date;

/*
 @author Mriagiovanna Bianco
 Servlet che permette di inserire una nuova lezione
 */

@WebServlet("/InserimentoLezione")
public class InserimentoNuovaLezioneServlet extends HttpServlet {
    private static MyLogger log = MyLogger.getInstance();
    private static String myClass = "InserimentoLezioneServlet";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info(myClass, "Collegamento alla Servlet...");
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("utente");
        if (user != null) {
            LezioneDAO lezioneDAO = new LezioneDAO();
            int idTutorato = Integer.parseInt(request.getParameter("idTutorato"));
            String oraInizio = request.getParameter("oraInizio");
            String oraFine = request.getParameter("oraFine");
            String data = request.getParameter("data");
            SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date =dateParser.parse(data);
                LezioneBean lezioneBean = new LezioneBean();
                lezioneBean.setTutorato(idTutorato);
                lezioneBean.setTutor(user.getEmail());
                lezioneBean.setOraInizio(oraInizio);
                lezioneBean.setOraFine(oraFine);
                lezioneBean.setData(date);
                lezioneDAO.insertNewLezione(lezioneBean);
                session.setAttribute("alertMsg","Lezione Inserita");
                response.sendRedirect("view/LezioniTutorPage.jsp");
            } catch (ParseException | SQLException e) {
                log.error(myClass, "Collegamento alla Servlet...",e);
                e.printStackTrace();
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}