package cybercar;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DButilEntrepot {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;
	private static List<Voiture> listVoiture = new ArrayList<Voiture>();

	public static void addCar(Voiture voiture) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.ADD_CAR_QUERY);

		setPreparedStatementProperties(voiture.getMarque(), 
									   voiture.getModèle(),
									   voiture.getCouleur(), 
									   voiture.getAnnée_de_production(),
									   voiture.getTransmission(),
									   voiture.getType_de_carburant(),
									   voiture.getPays_de_provenance(),
									   voiture.getPrix(),
									   voiture.getEntrepôt());
		preparedStatement.executeUpdate();

		closeConnections();
	}  
	
      
	
	
	

	public static void updateCar(Voiture voiture) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.UPDATE_CAR_QUERY);

		setPreparedStatementProperties(voiture.getMarque(),
				                       voiture.getModèle(),
				                       voiture.getCouleur(), 
				                       voiture.getAnnée_de_production(),
				                       voiture.getTransmission(),
				                       voiture.getType_de_carburant(),
				                       voiture.getPays_de_provenance(),
				                       voiture.getPrix(),
				                       voiture.getEntrepôt(),
									   voiture.getid_voiture());
		preparedStatement.executeUpdate();

		closeConnections();
	}

	public static void deleteCar(Voiture voiture) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.DELETE_CAR_QUERY);

		setPreparedStatementProperties(voiture.getid_voiture());
		preparedStatement.executeUpdate();

		closeConnections();
	}

	public static List<Voiture> getAllCars() throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.CHECK_QUERY);
		
		resultSet = preparedStatement.executeQuery();
		
		listVoiture.clear();
		
		while (resultSet.next()) {
			Voiture voiture = new Voiture();
				voiture.setid_voiture(resultSet.getString(1));
				voiture.setMarque(resultSet.getString(2));
				voiture.setModèle(resultSet.getString(3));
				voiture.setCouleur(resultSet.getString(4));
				voiture.setAnnée_de_production(resultSet.getString(5));
				voiture.setTransmission(resultSet.getString(6));
				voiture.setType_de_carburant(resultSet.getString(7));
				voiture.setPays_de_provenance(resultSet.getString(8));
				voiture.setPrix(resultSet.getString(9));
				voiture.setEntrepôt(resultSet.getString(10));
			listVoiture.add(voiture);
		}

		return listVoiture;
	}

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

	// @param variable length array of strings as student properties
	private static void setPreparedStatementProperties(String... strArgs) throws SQLException {
		for (int i = 0; i < strArgs.length; i++) {
			preparedStatement.setString(i + 1, strArgs[i]);
		}
	}
}


