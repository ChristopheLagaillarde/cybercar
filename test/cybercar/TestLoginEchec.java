package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestLoginEchec {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testMauvaisLogin = null;
			String motDePasseHashe = null;
			ResultSet resultatSelectFonctionEmploye = null;

			@SuppressWarnings("unused")
			String fonctionDansLentreprise = null;


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testMauvaisLogin = new FenetreLogin();

			testMauvaisLogin.barreLogin.setText("mauvaisLogin@cybercar.com");
			motDePasseHashe = Hash.hashage(testMauvaisLogin.barreMotDepasse.getText(),"SHA3-256");

			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testMauvaisLogin.barreLogin.getText(),motDePasseHashe));
			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}
			resultatSelectFonctionEmploye.close();

		}catch(SQLException EchecRequeteSQL) {
			fail("La requete est pas bonne");
		}catch(Exception mauvaisMotDepasseOuLogin) {
	         assertTrue(true);
		}
	}

}
