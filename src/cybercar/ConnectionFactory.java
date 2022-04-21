package cybercar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
		}

	}
}
//////////////////Fin//////////////////////////////
