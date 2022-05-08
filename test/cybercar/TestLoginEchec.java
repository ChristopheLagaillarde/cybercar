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

			String fonctionDansLentreprise = "";


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testMauvaisLogin = new FenetreLogin(null);

			testMauvaisLogin.barreLogin.setText("mauvaisLogin@cybercar.com");
			testMauvaisLogin.barreMotDePasse.setText("mauvaisMDP");

			

			motDePasseHashe = Hash.hashage(testMauvaisLogin.barreMotDePasse.getText(),"SHA3-256");

			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_LA_FONCTION_DE_LUTILISATEUR(testMauvaisLogin.barreLogin.getText(),motDePasseHashe));
			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
			}
			resultatSelectFonctionEmploye.close();
			
			if(fonctionDansLentreprise.isEmpty()) {
				assertTrue(true);
			}
			else {
				fail("La requete a réussi");
			}

		}catch(SQLException EchecRequeteSQL) {
			fail("La requete est pas bonne");
		}catch(Exception mauvaisMotDepasseOuLogin) {
			fail("La requete est pas bonne");
		}
	}

}
