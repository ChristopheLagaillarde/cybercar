package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLoginDepartementVente {

	@Test
	void test() {
		try {
			FenetreLogin testLoginDepartementVente = null;


			testLoginDepartementVente = new FenetreLogin();

			testLoginDepartementVente.barreLogin.setText("vendeur@cybercar.com");
			testLoginDepartementVente.barreMotDePasse.setText("11111111");

			if(testLoginDepartementVente.fonctionDeLEmployeDansLEntreprise(Hash.hashage(testLoginDepartementVente.barreMotDePasse.getText(),"SHA3-256")).equals("vendeur")) {
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
