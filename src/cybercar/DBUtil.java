package cybercar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBUtil {
	
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

	/**
	 * 
	 * @param employe
	 * @throws SQLException
	 */
	public static void addEmploye(Employe employe) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.ADD_EMPLOYE_QUERY);
		
		

		setPreparedStatementProperties(/*employe.getId(), */
									   employe.getNom(),			//1
									   employe.getPrenom(),			//1
									   employe.getNomJeuneFille(),	//2
									   employe.getAdresse(),		//3
									   employe.getLogin(),			//4
									   employe.getMotDePasse(),		//5
									   employe.getDepartement(),	//6
									   employe.getTelephone(),		//7
									   employe.getMail(),			//8
									   employe.getsConjugale(),		//9
									   employe.getNbEnfant(),		//10
									   employe.getaMedical(),		//11
									   employe.getFonction(),		//12
									   employe.getDateEmbauche(),	//13
									   employe.getSalaire(),		//14
									   employe.getNbConges(),		//15
									   employe.getNbCongesRestants(),//16
									   employe.getDateFin() );			//17
		
		
		
		
		
		preparedStatement.executeUpdate();

		closeConnections();
	}

	/**
	 * 
	 * @param employe
	 * @throws SQLException
	 */
	public static void updateEmploye(Employe employe) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.UPDATE_EMPLOYE_QUERY);

		

		setPreparedStatementProperties(employe.getId(), 
									   employe.getNom(),
									   employe.getPrenom(),
									   employe.getNomJeuneFille(),
									   employe.getAdresse(),
									   employe.getLogin(),
									   employe.getMotDePasse(),
									   employe.getDepartement(),
									   employe.getTelephone(),
									   employe.getMail(),
									   employe.getsConjugale(),
									   employe.getNbEnfant(),
									   employe.getaMedical(),
									   employe.getFonction(),
									   employe.getDateEmbauche(),
									   employe.getSalaire(),
									   employe.getNbConges(),
									   employe.getNbCongesRestants(),
									   employe.getDateFin());
		
		preparedStatement.executeUpdate();

		closeConnections();
	}

	/**
	 * 
	 * @param employe
	 * @throws SQLException
	 */
	public static void deleteEmploye(Employe employe) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.DELETE_EMPLOYE_QUERY);

		setPreparedStatementProperties(employe.getId());
		preparedStatement.executeUpdate();

		closeConnections();
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
//	public static List<Employe> getAllEmploye() throws SQLException {
//		connection = ConnectionFactory.getConnection();
//		preparedStatement = connection.prepareStatement(QueryStatement.SELECT_ALL_EMPLOYE_QUERY);
//		
//		resultSet = preparedStatement.executeQuery();
//		
//		employeList.clear();
//		
//		
//		while (resultSet.next()) {
//			Employe employe = new Employe();
//			
//			employe.setNom          	(resultSet.getString(1));
//			employe.setPrenom       	(resultSet.getString(2));
//			employe.setNomJeuneFille	(resultSet.getString(3));
//			employe.setAdresse			(resultSet.getString(4));
//			employe.setLogin			(resultSet.getString(5));;
//			employe.setMotDePasse		(resultSet.getString(6));
//			employe.setDepartement		(resultSet.getString(7));
//			employe.setTelephone		(resultSet.getInt(8));
//			employe.setMail				(resultSet.getString(9));
//			employe.setsConjugale		(resultSet.getString(10));
//			employe.setNbEnfant			(resultSet.getInt(11));
//			employe.setaMedical			(resultSet.getString(12));
//			employe.setFonction			(resultSet.getString(13));
//			employe.setDateEmbauche		(resultSet.getDate(14));
//			employe.setSalaire			(resultSet.getFloat(15));
//			employe.setNbEnfant			(resultSet.getInt(16));
//			employe.setNbConges			(resultSet.getInt(17));
//			employe.setNbCongesRestants	(resultSet.getInt(18));
//			employe.setDateFin			(resultSet.getDate(19));
//			
//			
//			
//			employeList.add(employe);
//		}
//
//		return employeList;
//	}

	/**
	 * 
	 * @throws SQLException
	 */
	private static void closeConnections() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	// @param variable length array of objects as employe properties
	/**
	 * 
	 * @param objArgs
	 * @throws SQLException
	 */
	private static void setPreparedStatementProperties(Object... objArgs) throws SQLException {
		for (int i = 0; i < objArgs.length; i++) {
			preparedStatement.setObject(i+1, objArgs);
		}
	}

}
