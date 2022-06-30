package it.betacom.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.businesscomponent.facade.AdminFacade;
import it.betacom.businesscomponent.model.Corso;
 
@WebServlet("/createCorso")
public class createCorso extends HttpServlet {
 
	private static final long serialVersionUID = -5347182008070757099L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corso corso = getCorso(request);
		if (corso!= null) {
			try {
				AdminFacade.getInstance(). 
				
			}catch(DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException( exc.getMessage());
				
			}
			response.sendRedirect("admin/gestisciArticoli,jsp");
			
		}
	}
	
	private Corso getCorso (HttpServletRequest request) {
		
		Corso corso = null;
		try {
			long id = Long.valueOf(request.getParameter("id"));
			String nomeCorso = request.getParameter("nomeCorso");
			String codDocente = request.getParameter("codDocente");
			Date dataInizio = Date.parse( request.getParameter("dataInizio")) ;
			
			
			corso = new Corso();
			corso.setCodCorso(id);
			corso.setCodDocente(codDocente);	
			corso.setFineCorso(dataFine);
			corso.setInizioCorso(dataInizio);
			corso.setNome(nomeCorso);
			
		} catch (Exception exc) {
			exc.printStackTrace();
			
		}
		return corso;
		
	}
	}

}
