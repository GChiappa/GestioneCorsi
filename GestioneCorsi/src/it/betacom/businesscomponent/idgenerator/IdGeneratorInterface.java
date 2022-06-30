package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.SQLException;

public interface IdGeneratorInterface {

	long getNextId() throws ClassNotFoundException, SQLException, IOException;

}
