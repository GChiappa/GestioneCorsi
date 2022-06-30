package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Docente;

public class DocenteBC {
	private Connection conn;

	public DocenteBC() throws ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docente findByCod(String cod) throws SQLException {
		return DocenteDAO.getFactory().findByCod(cod, conn);
	}

}
