package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementAdminSystem {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementAdminSystem = null;

			testLoginDepartementAdminSystem = new FenetreLogin(null);

			testLoginDepartementAdminSystem.barreLogin.setText("adminSystem@cybercar.com");
			testLoginDepartementAdminSystem.barreMotDePasse.setText("22222222");

			if(testLoginDepartementAdminSystem.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementAdminSystem.barreMotDePasse.getText(),"SHA3-256")).equals("adminSystem")) {
				assertTrue(true);
			}

			else {
				fail("mauvaise fonction dans l'entreprise");
			}

		}
		catch(Exception mauvaisMotDepasseOuLogin) {
			fail("Le test a echouer");
		}
	}

}

