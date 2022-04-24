package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementGarage {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementGarage = null;

			testLoginDepartementGarage = new FenetreLogin();

			testLoginDepartementGarage.barreLogin.setText("garagiste@cybercar.com");
			testLoginDepartementGarage.barreMotDePasse.setText("44444444");

			if(testLoginDepartementGarage.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementGarage.barreMotDePasse.getText(),"SHA3-256")).equals("garagiste")) {
				assertTrue(true);
			}

			else {
				fail("mauvaise fonction dans l'entreprise");
			}

		}catch(Exception mauvaisMotDepasseOuLogin) {
			fail("Le test a echouer");
		}
	}	

}
