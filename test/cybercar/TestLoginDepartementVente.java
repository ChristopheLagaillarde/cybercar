package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginDepartementVente {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginDepartementVente = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginDepartementVente = new FenetreLogin();

			testLoginDepartementVente.barreLogin.setText("vendeur@cybercar.com");
			testLoginDepartementVente.barreMotDepasse.setText("11111111");
			motDePasseHashe = Hash.hashage(testLoginDepartementVente.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginDepartementVente.barreLogin.getText(),motDePasseHashe));

			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}

			if(fonctionDansLentreprise.equals("vendeur")) {
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
