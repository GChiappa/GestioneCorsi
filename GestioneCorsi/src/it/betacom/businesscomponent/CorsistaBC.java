package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {

	private Connection conn;

	public CorsistaBC() throws ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corsista corsista) throws SQLException, ClassNotFoundException, IOException {
		if (corsista.getCodCorsista() == 0) {
			corsista.setCodCorsista(CorsistaIdGenerator.getInstance().getNextId());
			CorsistaDAO.getFactory().create(corsista, conn);
		}
		else
			CorsistaDAO.getFactory().update(corsista, conn);
	}

	public void delete(long cod) throws SQLException {
		CorsistaDAO.getFactory().delete(cod, conn);
	}

	public Corsista findById(long cod) throws SQLException {
		return CorsistaDAO.getFactory().findById(cod, conn);
	}

	public Corsista[] getAll() throws SQLException {
		return CorsistaDAO.getFactory().getAll(conn);
	}

	public int getNumeroCorsisti() throws SQLException {
		 
		return CorsistaDAO.getFactory().getNumCorsisti(conn);
	}

}
