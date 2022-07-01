package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.utility.LoginUtility;
import it.betacom.security.AlgoritmoMD5;

@WebServlet("/controlloAdmin")
public class ControlloAdmin extends HttpServlet {
	private static final long serialVersionUID = -4756704292690882364L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codAdmin = request.getParameter("admin");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		HttpSession session = request.getSession();
		
		String adminpass = null;
		
		int tentativi = (Integer) session.getAttribute("tentativi");
		if (tentativi >= 5)
			response.sendRedirect("troppitentativi.jsp");
			
		if (codAdmin != null && password != null) {
			try {

				LoginUtility lu = new LoginUtility();
				adminpass = lu.getAdminPass(codAdmin);

				if (adminpass != null) {
					if (adminpass.equals(password)) {

						session.setAttribute("admin", codAdmin);
						session.setAttribute("nome", lu.getAdminNom(codAdmin));
						session.removeAttribute("tentativi");
						response.sendRedirect("paginaPrincipale.jsp");

					} else {
						 
						if(session.getAttribute("tentativi") == null) {
							tentativi =1;
							session.setAttribute("tentativi", tentativi);
						}
							
						else {
							tentativi = (Integer) session.getAttribute("tentativi") + 1 ;
							if (tentativi >= 5) {
								response.sendRedirect("troppitentativi.jsp");
							}else {
								session.setAttribute("tentativi", tentativi);
							}
								
							
							
							
						}
						response.sendRedirect("accessoNegato.jsp");
					}

				} else {
					response.sendRedirect("accessoNegato.jsp");
				}

			} catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
