package cybercar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Cette class permet de se connecter � une base de donn�e.
 * Date : 08/11/2021
 * @author Lagaillarde
 * @version : 1.0
 */
public class ConnectionFactory {

	//Attributs
	Connection connectionABD;
	ResultSet resultatRequete;
	Statement requeteAFaire;

	@SuppressWarnings("unused")
	private static String driverClassName;
	private static String connectionUrl;
	private static String dbUser;
	private static String dbPassword;

	// M�thodes
	/**
	 * g�n�re la connection avec la base de donn�e
	 * @param nomBD le nom de la base de donn�e
	 * @param username le nom d'utilisateur li� a la base de donn�e
	 * @param pwd le mot de passe pour acc�der � la base de donn�
	 */
	public ConnectionFactory(String nomBD, String username, String pwd){
		try {
			this.connectionABD= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ nomBD,username,pwd);
			this.requeteAFaire = this.connectionABD.createStatement();

		} catch (SQLException echecDeConnection) {
			JOptionPane.showMessageDialog(null, "Echec de connection � la BD");
			echecDeConnection.printStackTrace();
		}

	}

	private final static Properties dbProperties = new Properties();
	static{
		try(InputStream input = new FileInputStream("src/cybercar/dbconfig.properties")){
			dbProperties.load(input);

			driverClassName = dbProperties.getProperty("driver-class-name");
			connectionUrl = dbProperties.getProperty("connection-url");
			dbUser = dbProperties.getProperty("user");
			dbPassword = dbProperties.getProperty("password");
		}catch(IOException ioex){
			ioex.printStackTrace(); 
		}

	}
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
		return conn;
	}
}
//////////////////Fin//////////////////////////////
