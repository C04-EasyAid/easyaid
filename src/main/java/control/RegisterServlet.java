package control;

import model.bean.*;
import model.dao.ProfessoreReferenteDAO;
import model.dao.StudenteDAO;
import model.dao.TutorDAO;
import model.dao.UserDAO;
import other.MyLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Roberto Tartaglia
 * Servlet che permette di effettuare la registrazione
 * di un utente all interno del sistema
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static MyLogger log = MyLogger.getInstance();
    private static String myClass = "RegisterServlet";
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info(myClass,"Collegamento alla Servlet...");
        HttpSession session = request.getSession();
        UserBean utenteLoggato= (UserBean)session.getAttribute("utente");
        UserBean utenteTemporaneo= new UserBean();
        utenteTemporaneo.setNome(request.getParameter("nome"));
        utenteTemporaneo.setCognome(request.getParameter("cognome"));
        utenteTemporaneo.setEmail(request.getParameter("email"));
        utenteTemporaneo.setPassword(request.getParameter("password"));
        String ruolo = request.getParameter("ruolo");
        int tipoUtente = 0;
        if(ruolo.equals("Studente")){
        utenteTemporaneo.setRuolo("S");
        tipoUtente = 1;
        }
        if(ruolo.equals("Professore Referente")){
            utenteTemporaneo.setRuolo("P");
            tipoUtente = 3;
        }
        if(ruolo.equals("Tutor")){
            utenteTemporaneo.setRuolo("T");
            tipoUtente = 2;
        }
        if(utenteLoggato!=null)
        {
            //PROVVISORIO TIPO INTERO!! Dalla request prendo il parametro id ed in base al valore registro l utente
            //1-studente 3-tutor 2-professore referente
            try{
                switch (tipoUtente) {
                    case 1 -> {
                        System.out.println(utenteTemporaneo);
                        StudenteBean studente = new StudenteBean();
                        studente.setOreDisponibili(Integer.parseInt(request.getParameter("oreDisponibiliStudente")));
                        studente.setPercentualeDisabilita(Integer.parseInt(request.getParameter("percentualeDisabilita")));
                        studente.setEmail(utenteTemporaneo.getEmail());
                        studente.setTipoDisabilita(request.getParameter("tipoDisabilita"));
                        studente.setSpecificheDisturbo(request.getParameter("specificheDisturbo"));
                        StudenteDAO dao=new StudenteDAO();
                        if (!dao.insertStudente(studente,utenteTemporaneo)) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento studente");
                            response.sendRedirect("view/HomePage.jsp");
                        }
                        else{
                            session.setAttribute("alertMsg", "Studente inserito con successo");
                            response.sendRedirect("view/RegistraUtentePage.jsp?inserimento=Studente");
                        }
                    }
                    case 2 -> {
                        TutorBean tutor = new TutorBean();
                        tutor.setQualifica(request.getParameter("qualifica"));
                        tutor.setDipartimento(request.getParameter("dipartimentoTutor"));
                        tutor.setEmailTutor(utenteTemporaneo.getEmail());
                        tutor.setOreDisponibili(Integer.parseInt(request.getParameter("oreDisponibiliTutor")));
                        tutor.setOreSvolte(0);
                        TutorDAO dao=new TutorDAO();
                        if (!dao.insertTutor(tutor, utenteTemporaneo)) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento tutor");
                            response.sendRedirect("view/HomePage.jsp");
                        }
                        else{
                            session.setAttribute("alertMsg", "Tutor inserito con successo");
                            response.sendRedirect("view/RegistraUtentePage.jsp?inserimento=Tutor");
                        }
                    }
                    case 3 -> {
                        ProfessoreReferenteBean professoreReferente = new ProfessoreReferenteBean();
                        professoreReferente.setEmail(utenteTemporaneo.getEmail());
                        professoreReferente.setDipartimento(request.getParameter("dipartimentoProf"));
                        ProfessoreReferenteDAO dao=new ProfessoreReferenteDAO();
                        if (!dao.insertProfessoreReferente(professoreReferente, utenteTemporaneo)) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento professore referente");
                            response.sendRedirect("view/HomePage.jsp");
                        }
                        else{
                            session.setAttribute("alertMsg", "Professore Referente inserito con successo");
                            response.sendRedirect("view/RegistraUtentePage.jsp?inserimento=Professore Referente");
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + tipoUtente);
                }
            }
            catch (Exception e)
            {
                log.error(myClass,"Catturata eccezione nella Servlet", e);
                session.setAttribute("alertMsg", "Errore nell'inserimento professore referente");
                response.sendRedirect("view/HomePage.jsp");
                e.printStackTrace();
            }
        }
        else{
        session.setAttribute("alertMsg","Permessi non concessi all'utente");
        response.sendRedirect("view/HomePage.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
