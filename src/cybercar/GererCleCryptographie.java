package cybercar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class GererCleCryptographie {
	/**
	 * Sauvegarde la clé de chiffrement utilisé dans un fichier
	 * @param cleUtilise
	 * @param motDePasse
	 * @param adresseFichierCle
	 */
	public static void sauvegardeCleUtilise(Key cleUtilise, String motDePasse, String adresseFichierCle) {
		File fichierContenantCle = new File(adresseFichierCle);
		try {
			KeyStore stockageCle = KeyStore.getInstance("JCEKS");
			stockageCle.load(null, null);
			if(!fichierContenantCle.exists()) {
				stockageCle.load(null,null);
			}
			stockageCle.setKeyEntry("cleStocke", cleUtilise, motDePasse.toCharArray(), null);
			OutputStream fluxEcriture = new FileOutputStream(adresseFichierCle);
			stockageCle.store(fluxEcriture, motDePasse.toCharArray());
			fluxEcriture.close();

		} catch (KeyStoreException erreurStockageCle) {
			erreurStockageCle.printStackTrace();
		} catch (NoSuchAlgorithmException algorithmeNonTrouvable) {
			algorithmeNonTrouvable.printStackTrace();
		} catch (CertificateException erreurCertificat) {
			erreurCertificat.printStackTrace();
		} catch (IOException erreurFichier) {
			erreurFichier.printStackTrace();
		}

	}

	/**
	 * Répère la clé symétrique contenu dans un fichier
	 * @param adresseFichierCle
	 * @param motDePasse
	 * @return cleContenuDansFichier
	 */
	public static Key recuperationCle(String adresseFichierCle, String motDePasse) {
		try {
			KeyStore stockageCle = KeyStore.getInstance("JCEKS");
			InputStream fluxLecture = new FileInputStream(adresseFichierCle);

			stockageCle.load(fluxLecture,motDePasse.toCharArray());
			Key cleContenuDansFichier = (Key) stockageCle.getKey("cleStocke", motDePasse.toCharArray());
			fluxLecture.close();
			return cleContenuDansFichier;
		}
		catch(Exception echecrecuperationCle) {
			echecrecuperationCle.printStackTrace();
		}
		return null;
	}
}
