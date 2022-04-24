package cybercar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPremierConnection {

	@Test
	void test() {
		try {
			FenetreLogin testLoginPremierConnection = null;

			testLoginPremierConnection = new FenetreLogin();

			testLoginPremierConnection.barreLogin.setText("nouveau@cybercar.com");
			testLoginPremierConnection.barreMotDePasse.setText("77777777");


			if(testLoginPremierConnection.PremierConnectionAuCompte()) {
				assertTrue(true);
			}
			else {
				fail("Le test a échoué");
			}

		}catch(Exception mauvaisMotDepasseOuLogin) {
			mauvaisMotDepasseOuLogin.printStackTrace();
			fail("Le test a echouer");
		}
	}

}
