package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.utility.loginUtility;
import it.betacom.security.AlgoritmoMD5;

 
@WebServlet("/ControlloAdmin")
public class ControlloAdmin extends HttpServlet {
 

	private static final long serialVersionUID = -4756704292690882364L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codAdmin= request.getParameter("admin");

		String password= AlgoritmoMD5.convertiMD5(request.getParameter("password") );
		
		HttpSession session = request.getSession();
		String userpass= null;
		String adminpass = null;
		if(codAdmin != null && password!=null) {
			try {
				
				loginUtility lu = new loginUtility();
				adminpass= lu.getadminpass(codAdmin);
				 
				 
				   if (adminpass!= null)   {
					 if(adminpass.equals(password)) {
						 session.setAttribute("admin", codAdmin);
						 response.sendRedirect("paginaprincipale.jsp");
					 }else {
						 response.sendRedirect("accessonegato.jsp");
					 }				 
				  
			} else {
				response.sendRedirect("accessonegato.jsp");
			}
				 
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
			
		}
		
	}
	}

}
