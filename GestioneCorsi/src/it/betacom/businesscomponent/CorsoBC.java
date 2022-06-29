package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dbaccess.DBAccess;

import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;
import it.betacom.businesscomponent.model.Corso;

public class CorsoBC {

	private Connection conn;

	public CorsoBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void CreateorUpdate(Corso corso) throws SQLException, ClassNotFoundException, IOException {
		try {
			if (corso.getCodCorso() > 0)
				CorsoDAO.getFactory().update(corso, conn);
			else {
				corso.setCodCorso(CorsoIdGenerator.getInstance().getNextId());
				CorsoDAO.getFactory().create(corso, conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public Corso[] getCorsi() throws SQLException {
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return corsi;
	}

	public Corso getById(long id) throws SQLException {

		return CorsoDAO.getFactory().findById(id, conn);

	}

	public void delete(long id) throws SQLException {
		try {
			CorsoDAO.getFactory().delete(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}
}
