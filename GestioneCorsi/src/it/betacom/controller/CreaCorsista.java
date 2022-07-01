package it.betacom.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.facade.AdminFacade;
import it.betacom.businesscomponent.model.Corsista;

@WebServlet("/creaCorsista")
public class CreaCorsista extends HttpServlet {
	private static final long serialVersionUID = 8408699687314200531L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String precedenti = request.getParameter("precedentiFormativi");

		System.out.println(nome + cognome + precedenti);

		if (nome != null && cognome != null && precedenti != null) {
			try {
				Corsista c = new Corsista();
				c.setCodCorsista(0);
				c.setNome(nome);
				c.setCognome(cognome);
				c.setPrecedentiFormativi(precedenti);

				AdminFacade.getInstance().createCorsista(c);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			session.removeAttribute("creazione");
			response.sendRedirect("gestioneCorsisti.jsp");
		} else {
			session.setAttribute("creazione", "valore nullo");
			response.sendRedirect("paginaPrincipale.jsp");
		}

	}

}
