<%--
  Created by IntelliJ IDEA.
  User: 130309
  Date: 02/01/2022
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



    <!-- Responsive offcanvas body START -->
    <nav class="navbar navbar-light navbar-expand-xl mx-0">
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
             aria-labelledby="offcanvasNavbarLabel">
            <!-- Offcanvas body -->
            <div class="offcanvas-body p-3 p-xl-0">
                <div class="bg-dark border rounded-3 pb-0 p-3 w-100">
                    <!-- Dashboard menu -->
                    <div class="list-group list-group-dark list-group-borderless">
                        <a class="list-group-item" href="ListaUtentiPage.jsp"><i
                                class="bi bi-ui-checks-grid fa-fw me-2"></i>Dashboard</a>
                        <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=Studente"><i
                                class="bi bi-person-fill fa-fw me-2"></i>Inserimento Studente</a>
                        <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=Tutor"><i
                                class="bi bi-mortarboard-fill fa-fw me-2"></i>Inserimento Tutor</a>
                        <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=ProfessoreReferente"><i
                                class="bi bi-pencil-fill fa-fw me-2"></i>Inserimento Professore</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>


