package control;

import java.io.IOException;
import javax.servlet.ServletException;
import model.bean.StudenteBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisualizzaServiziTest {
  private ViewServicesServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() {
    servlet = new ViewServicesServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void testVisualizzaServizi1() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    StudenteBean bean = new StudenteBean();

    request.getSession().setAttribute("studente", bean);

    servlet.doGet(request, response);

    assertEquals("view/RichiediServizioPage.jsp", response.getRedirectedUrl());
  }

  @Test
  void testVisualizzaServizi2() throws ServletException, IOException {
    MockitoAnnotations.initMocks(this);
    StudenteBean bean = new StudenteBean();

    servlet.doGet(request, response);

    assertEquals("Permessi non concessi all'utente", request.getSession().getAttribute("alertMsg"));
  }
}
