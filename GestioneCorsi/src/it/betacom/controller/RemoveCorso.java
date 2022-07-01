package it.betacom.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.businesscomponent.facade.AdminFacade;

@WebServlet("/removeCorso")
public class RemoveCorso extends HttpServlet {
	private static final long serialVersionUID = -5008957264973591374L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String id = request.getParameter("corso");
			if (id != null)
				AdminFacade.getInstance().deleteCorso(Long.valueOf(id));
			;
			response.sendRedirect("gestioneCorsi.jsp");

		} catch (SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
