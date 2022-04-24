package cybercar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestPremierConnection {

	@Test
	void test() {
		try {
			ConnectionFactory connectionBDPourLogin = null;	
			FenetreLogin testLoginPremierConnection = null;
			String motDePasseHashe = null;
			@SuppressWarnings("unused")
			ResultSet resultatSelectFonctionEmploye = null;
			@SuppressWarnings("unused")
			String fonctionDansLentreprise = null;
			ConnectionFactory connectionBDPourVerifierSiPremierConnection = null;
			ResultSet resultatSelectPremierConnection  = null;
			String donnePriveEtSensible = "";


			connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
			testLoginPremierConnection = new FenetreLogin();

			testLoginPremierConnection.barreLogin.setText("nouveauEmployeFinance@cybercar.com");
			testLoginPremierConnection.barreMotDepasse.setText("77777777");
			motDePasseHashe = Hash.hashage(testLoginPremierConnection.barreMotDepasse.getText(),"SHA3-256");
			resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(testLoginPremierConnection.barreLogin.getText(),motDePasseHashe));

			// Donne fenêtre donnée privée et sensible si c'est la 1er connection
			connectionBDPourVerifierSiPremierConnection = new ConnectionFactory("CyberCar","root","");
			resultatSelectPremierConnection = connectionBDPourVerifierSiPremierConnection.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectDonnePersoEtPriveUtilisateur(testLoginPremierConnection.barreLogin.getText()));

			while(resultatSelectPremierConnection.next()) {
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("civilite"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("nomDeJeuneFille"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("situationConjugale"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("entecedantMedicale"));
			} 
			
			if(donnePriveEtSensible.equals("")) {
				assertTrue(true);
			}
			else {
				fail("Le test a échoué");
			}
			


		}catch(SQLException EchecRequeteSQL) {
			fail("La requete est pas bonne");
		}catch(Exception mauvaisMotDepasseOuLogin) {
			mauvaisMotDepasseOuLogin.printStackTrace();
			fail("Le test a echouer");
		}
	}

}
