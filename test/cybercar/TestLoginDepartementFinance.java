package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginDepartementFinance {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginDepartementFinance = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginDepartementFinance = new FenetreLogin();

			testLoginDepartementFinance.barreLogin.setText("employeFinance@cybercar.com");
			testLoginDepartementFinance.barreMotDepasse.setText("55555555");
			motDePasseHashe = Hash.hashage(testLoginDepartementFinance.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginDepartementFinance.barreLogin.getText(),motDePasseHashe));

			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}

			if(fonctionDansLentreprise.equals("employeFinance")) {
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


