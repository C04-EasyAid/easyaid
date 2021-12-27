package control;

import model.bean.*;
import model.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        UserBean utenteTemporaneo= UserBean.getInstance();
        utenteTemporaneo.setNome(request.getParameter("nome"));
        utenteTemporaneo.setCognome(request.getParameter("cognome"));
        utenteTemporaneo.setEmail(request.getParameter("email"));
        utenteTemporaneo.setPassword(request.getParameter("password"));
        //Se l'utente loggato è personale amministrativo allora procedo all inserimento dell utente
        if(personaleAmministrativo!=null)
        {
            //PROVVISORIO TIPO INTERO!! Dalla request prendo il parametro id ed in base al valore registro l utente
            //1-studente 2-tutor 3-professore referente
            int tipoUtente= Integer.parseInt(request.getParameter("id"));
            try{
            switch (tipoUtente)
            {
                case 1: utenteTemporaneo.setRuolo("S");
                    StudenteBean studente =StudenteBean.getInstance();
                    if(!UserDAO.insertStudente(studente,utenteTemporaneo))
                    {
                        session.setAttribute("alertMsg","Errore nell'inserimento studente");
                        response.sendRedirect("./Registrazione.jsp");
                    }
                    break;
                case 2: utenteTemporaneo.setRuolo("T");
                    TutorBean tutor = TutorBean.getInstance();
                    if(!UserDAO.insertTutor(tutor,utenteTemporaneo))
                    {
                        session.setAttribute("alertMsg","Errore nell'inserimento tutor");
                        response.sendRedirect("./Home.jsp");
                    }
                    break;
                case 3: utenteTemporaneo.setRuolo("PR");
                    ProfessoreReferenteBean professoreReferente = ProfessoreReferenteBean.getInstance();
                    if(!UserDAO.insertProfessoreReferente(professoreReferente,utenteTemporaneo))
                    {
                        session.setAttribute("alertMsg","Errore nell'inserimento professore referente");
                        response.sendRedirect("./Home.jsp");
                    }
                    break;
            }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            session.setAttribute("alertMsg","Permessi non concessi all'utente");
            response.sendRedirect("./Home.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
