package control;

import model.bean.*;
import model.dao.UserDAO;

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
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PersonaleAmministrativoBean personaleAmministrativo= (PersonaleAmministrativoBean)session.getAttribute("admin");
        //Creo il bean dell utente che andrà inserito nel DB
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
            tipoUtente = 2;
        }
        if(ruolo.equals("Tutor")){
            utenteTemporaneo.setRuolo("T");
            tipoUtente = 3;
        }
        //Se l'utente loggato è personale amministrativo allora procedo all inserimento dell utente
        //if(personaleAmministrativo!=null)
        //{
            System.out.println("ueueueue");
            //PROVVISORIO TIPO INTERO!! Dalla request prendo il parametro id ed in base al valore registro l utente
            //1-studente 2-tutor 3-professore referente
            try{
                switch (tipoUtente) {
                    case 1 -> {
                        System.out.println(utenteTemporaneo);
                        StudenteBean studente = new StudenteBean();
                        studente.setOreDisponibili(Integer.parseInt(request.getParameter("oreDisponibiliStudente")));
                        int percentuale = Integer.parseInt(request.getParameter("percentualeDisabilita"));
                        studente.setPercentualeDisabilita(percentuale);
                        studente.setEmail(utenteTemporaneo.getEmail());
                        studente.setTipoDisabilita(request.getParameter("tipoDisabilita"));
                        studente.setSpecificheDisturbo(request.getParameter("specificheDisturbo"));
                        boolean result = UserDAO.insertStudente(studente,utenteTemporaneo);
                        if (!result) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento studente");
                            response.sendRedirect("view/Home.jsp");
                        }
                        break;
                    }
                    case 2 -> {
                        TutorBean tutor = new TutorBean();
                        tutor.setQualifica(request.getParameter("qualifica"));
                        tutor.setDipartimento(request.getParameter("dipartimentoTutor"));
                        tutor.setEmailTutor(utenteTemporaneo.getEmail());
                        tutor.setOreDisponibili(Integer.parseInt(request.getParameter("oreDisponibiliTutor")));
                        tutor.setOreSvolte(0);
                        if (!UserDAO.insertTutor(tutor, utenteTemporaneo)) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento tutor");
                            response.sendRedirect("view/Home.jsp");
                        }
                        break;
                    }
                    case 3 -> {
                        ProfessoreReferenteBean professoreReferente = new ProfessoreReferenteBean();
                        professoreReferente.setEmail(utenteTemporaneo.getEmail());
                        professoreReferente.setDipartimento(request.getParameter("dipartimentoProf"));
                        if (!UserDAO.insertProfessoreReferente(professoreReferente, utenteTemporaneo)) {
                            session.setAttribute("alertMsg", "Errore nell'inserimento professore referente");
                            response.sendRedirect("view/Home.jsp");
                        }
                        break;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + tipoUtente);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
       // }
        //else
        //{
            session.setAttribute("alertMsg","Permessi non concessi all'utente");
            response.sendRedirect("view/Home.jsp");
       // }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
