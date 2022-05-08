package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementRH {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementRH = null;

			testLoginDepartementRH = new FenetreLogin(null);

			testLoginDepartementRH.barreLogin.setText("employeRH@cybercar.com");
			testLoginDepartementRH.barreMotDePasse.setText("33333333");

			if(testLoginDepartementRH.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementRH.barreMotDePasse.getText(),"SHA3-256")).equals("employeRH")) {
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
