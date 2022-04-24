package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginDepartementSI {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginDepartementSI = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginDepartementSI = new FenetreLogin();

			testLoginDepartementSI.barreLogin.setText("employeSI@cybercar.com");
			testLoginDepartementSI.barreMotDepasse.setText("66666666");
			motDePasseHashe = Hash.hashage(testLoginDepartementSI.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginDepartementSI.barreLogin.getText(),motDePasseHashe));

			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}

			if(fonctionDansLentreprise.equals("employeSI")) {
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
