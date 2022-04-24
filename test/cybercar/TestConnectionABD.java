package cybercar;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestConnectionABD {

	@Test
	void test() {
		ConnectionFactory connectionBDPourLogin = null;	
		connectionBDPourLogin = new ConnectionFactory("Cybercar","root","");
		
		try {
			connectionBDPourLogin.connectionABD.isClosed();
		} catch (SQLException echecDeConnection) {
			fail("echec de connection");
		}
	}

}
