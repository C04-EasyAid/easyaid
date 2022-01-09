package control;

import model.bean.LezioneBean;
import model.bean.StudenteBean;
import model.bean.TutorBean;
import model.bean.UserBean;
import model.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LezioniTest {
    private LezioniServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new LezioniServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
    @Test
    void testViewLezioni1() throws ServletException, IOException, SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        ILezioneDAO lezioneDao = mock(LezioneDAO.class);
        IStudenteDAO studenteDao = mock(StudenteDAO.class);
        ITutorDAO tutorDao = mock(TutorDAO.class);
        ITutoratoDidatticoDAO tutoratoDidatticoDao = mock(TutoratoDidatticoDAO.class);
        StudenteBean studenteBean = new StudenteBean();
        UserBean userBean= new UserBean();
        servlet.setLezioneDao(lezioneDao);
        servlet.setStudenteDao(studenteDao);
        servlet.setTutoratoDidatticoDAO(tutoratoDidatticoDao);
        servlet.setTutorDao(tutorDao);
        userBean.setEmail("lorenzorossi1@studenti.unisa.it");
        userBean.setPassword("Lorenzo#rossi1");
        userBean.setRuolo("S");
        when(studenteDao.doRetrieveByEmail(userBean.getEmail())).thenReturn(studenteBean);
        Collection<LezioneBean> list= new ArrayList<>();
        list.add(new LezioneBean());
        list.add(new LezioneBean());
        list.add(new LezioneBean());
        request.getSession().setAttribute("utente", userBean);
        when(lezioneDao.doRetrieveLezioneByStudente(userBean.getEmail())).thenReturn(list);
        request.getSession().setAttribute("listaLezioni", list);
        servlet.doGet(request,response);
        assertEquals("view/LezioniStudentePage.jsp", response.getRedirectedUrl());
    }

    }