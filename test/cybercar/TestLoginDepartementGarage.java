package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginDepartementGarage {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginDepartementGarage = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginDepartementGarage = new FenetreLogin();

			testLoginDepartementGarage.barreLogin.setText("garagiste@cybercar.com");
			testLoginDepartementGarage.barreMotDepasse.setText("44444444");
			motDePasseHashe = Hash.hashage(testLoginDepartementGarage.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginDepartementGarage.barreLogin.getText(),motDePasseHashe));

			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}

			if(fonctionDansLentreprise.equals("garagiste")) {
				assertTrue(true);
			}

			else {
				fail("mauvaise fonction dans l'entreprise");
			}

		}catch(SQLException EchecRequeteSQL) {
			fail("La requete est pas bonne");
		}catch(Exception mauvaisMotDepasseOuLogin) {
			fail("Le test a echouer");
		}
	}	

}
