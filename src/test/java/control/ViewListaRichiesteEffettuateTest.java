package control;

import model.bean.SupportoEsameBean;
import model.bean.TutoratoDidatticoBean;
import model.bean.UserBean;
import model.dao.ISupportoEsameDAO;
import model.dao.ITutoratoDidatticoDAO;
import model.dao.SupportoEsameDAO;
import model.dao.TutoratoDidatticoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ViewListaRichiesteEffettuateTest
{
     private ViewListaRichiesteEffettuateServlet servlet;
     private MockHttpServletRequest request;
     private MockHttpServletResponse response;

     @BeforeEach
     void setUp(){
       servlet = new ViewListaRichiesteEffettuateServlet();
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();
     }


     //L'utente loggato alla piattaforma è uno studente e può vedere la lista delle richieste effettuate
    @Test
    void testViewListarichiesteEffettuate1() throws SQLException, ClassNotFoundException, ServletException, IOException {
      MockitoAnnotations.initMocks(this);
      ITutoratoDidatticoDAO tutoratoDao = mock(TutoratoDidatticoDAO.class);
      ISupportoEsameDAO supportoDao = mock(SupportoEsameDAO.class);

      servlet.setSupportoDao(supportoDao);
      servlet.setTutoratoDao(tutoratoDao);

      UserBean studente = new UserBean();
      studente.setEmail("abaglio9@studenti.unisa.it");
      studente.setRuolo("S");
      request.getSession().setAttribute("utente",studente);

      List<SupportoEsameBean> listSupporto = new ArrayList<>();
      listSupporto.add(new SupportoEsameBean());
      listSupporto.add(new SupportoEsameBean());
      listSupporto.add(new SupportoEsameBean());

      List<TutoratoDidatticoBean> listTutorato = new ArrayList<>();
      listTutorato.add(new TutoratoDidatticoBean());
      listTutorato.add(new TutoratoDidatticoBean());
      listTutorato.add(new TutoratoDidatticoBean());

      when(tutoratoDao.doRetrieveAllByStudente(studente.getEmail())).thenReturn(listTutorato);
      when(supportoDao.doRetrieveAllByStudente(studente.getEmail())).thenReturn(listSupporto);

      request.getSession().setAttribute("richiesteEsami",listSupporto);
      request.getSession().setAttribute("richiesteTutorato",listTutorato);

      servlet.doGet(request,response);

      assertEquals("view/ListaRichiesteEffettuatePage.jsp",response.getRedirectedUrl());
    }

    //L'utente non è loggato all'interno della piattaforma
  @Test
  void testViewListarichiesteEffettuate2() throws SQLException, ClassNotFoundException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);

    servlet.doGet(request,response);

    assertEquals("view/LoginPage.jsp",response.getRedirectedUrl());
  }

  //L'utente loggato non è uno  studente
  @Test
  void testViewListarichiesteEffettuate3() throws SQLException, ClassNotFoundException, ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    UserBean studente = new UserBean();
    studente.setEmail("lorenzorossi1@studenti.unisa.it");
    studente.setRuolo("T");
    request.getSession().setAttribute("utente",studente);

    servlet.doGet(request,response);

    assertEquals("view/LoginPage.jsp",response.getRedirectedUrl());
  }
}