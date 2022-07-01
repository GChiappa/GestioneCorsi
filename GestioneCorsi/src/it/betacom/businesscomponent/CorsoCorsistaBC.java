package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsoCorsistaIdGenerator;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(CorsoCorsista cc) throws ClassNotFoundException, IOException, SQLException {
		cc.setCodCorsoCorsista(CorsoCorsistaIdGenerator.getInstance().getNextId());
		CorsoCorsistaDAO.getFactory().create(cc, conn);

	}

	public void delete(long id) throws SQLException {
		CorsoCorsistaDAO.getFactory().delete(id, conn);
	}

	public void deleteCorso(long cod) throws SQLException {
		CorsoCorsistaDAO.getFactory().deleteCorso(cod, conn);
	}

}
