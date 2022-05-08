package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementSI {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementSI = null;

			testLoginDepartementSI = new FenetreLogin(null);

			testLoginDepartementSI.barreLogin.setText("employeSI@cybercar.com");
			testLoginDepartementSI.barreMotDePasse.setText("66666666");

			if(testLoginDepartementSI.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementSI.barreMotDePasse.getText(),"SHA3-256")).equals("employeSI")) {
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

