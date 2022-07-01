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
		if (codAdmin != null && password != null) {
			try {

				LoginUtility lu = new LoginUtility();
				adminpass = lu.getadminpass(codAdmin);

				if (adminpass != null) {
					if (adminpass.equals(password)) {

						session.setAttribute("admin", codAdmin);
						session.setAttribute("nome", lu.getadminname(codAdmin));
						session.removeAttribute("tentativi");
						response.sendRedirect("paginaPrincipale.jsp");

					} else {
						int tentativi = 1;
						if(session.getAttribute("tentativi") == null)
							session.setAttribute("tentativi", tentativi);
						else {
							String t = (String) session.getAttribute("tentativi");
							tentativi = Integer.parseInt(t) + 1;
							session.setAttribute("tentativi", tentativi);
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
