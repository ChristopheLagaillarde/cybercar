package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementFinance {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementFinance = null;

			testLoginDepartementFinance = new FenetreLogin();

			testLoginDepartementFinance.barreLogin.setText("employeFinance@cybercar.com");
			testLoginDepartementFinance.barreMotDePasse.setText("55555555");

			if(testLoginDepartementFinance.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementFinance.barreMotDePasse.getText(),"SHA3-256")).equals("employeFinance")) {
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


