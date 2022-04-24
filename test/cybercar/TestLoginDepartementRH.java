package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginDepartementRH {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginDepartementRH = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginDepartementRH = new FenetreLogin();

			testLoginDepartementRH.barreLogin.setText("employeRH@cybercar.com");
			testLoginDepartementRH.barreMotDepasse.setText("33333333");
			motDePasseHashe = Hash.hashage(testLoginDepartementRH.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginDepartementRH.barreLogin.getText(),motDePasseHashe));

			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}

			if(fonctionDansLentreprise.equals("employeRH")) {
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
