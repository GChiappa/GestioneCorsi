package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CommentoDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Commento;

public class CommentoBC {

	private Connection conn;

	public CommentoBC() throws ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Commento commento) throws SQLException, ClassNotFoundException, IOException {
		if (commento.getIdCommento() == 0) {
			// TODO CommentoIdGenerator
			// CommentoDAO.getFactory().create(commento, conn);
		}
		else
			CommentoDAO.getFactory().update(commento, conn);
	}

	public void delete(long cod) throws SQLException {
		CommentoDAO.getFactory().delete(cod, conn);
	}
	
	public void deleteCorso(long cod) throws SQLException {
		CommentoDAO.getFactory().deleteCorso(cod, conn);
	}

	public Commento[] getAll() throws SQLException {
		return CommentoDAO.getFactory().getAll(conn);
	}

}
