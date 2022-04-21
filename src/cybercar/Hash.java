package cybercar;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;
/**
 * Regroupe les fonctions de hashage
 * @author Lagaillarde
 *
 */
public class Hash {
	
	private Hash() {
		
	}

	/**
	 * Hash le mot de passe avec MD5
	 * @param phrasseAHasher
	 * @param algo
	 * @return motDepasseHashe
	 */
	static String hashage(String phrasseAHasher, String algo) {
		byte[] donneeOctet = phrasseAHasher.getBytes();
		byte[] condenser = null;
		MessageDigest monHash = null;

		try {
			monHash = MessageDigest.getInstance(algo);
		} catch (NoSuchAlgorithmException algoInexistant) {
			JOptionPane.showMessageDialog(null, "Echec du hashage, l'algorithme choisi n'existe pas");

		}

		if(monHash != null) {
			monHash.update(donneeOctet);
			condenser = monHash.digest();
		}
		
		return 	new BigInteger(condenser).toString(16);

	}



}
