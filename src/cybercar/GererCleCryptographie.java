package cybercar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

public class GererCleCryptographie {
	
	private static String encoder(byte[] donne) {
		return Base64.getEncoder().encodeToString(donne);
	}
	/**
	 * Encrypte un message avec la cle RSA
	 * @param message
	 * @param cleRsa
	 * @return message crypté en String
	 */
	public static String crypteMessageAvecClePublique(String message, PublicKey clePublique) {
		byte[] messageEnByte = message.getBytes(StandardCharsets.UTF_8);
		try {
			Cipher cryptage = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cryptage.init(Cipher.ENCRYPT_MODE, clePublique);
			byte[] messageCrypteEnByte = cryptage.doFinal(messageEnByte);
			return encoder(messageCrypteEnByte);

		} catch (InvalidKeyException cleNonValide) {
			JOptionPane.showMessageDialog(null, "Clé non valide");
		} catch (NoSuchAlgorithmException algorithmeInexistant) {
			JOptionPane.showMessageDialog(null, "Algorithme non valide");
		} catch (NoSuchPaddingException paddingNonExistant) {
			JOptionPane.showMessageDialog(null, "Padding non existant");
		} catch (IllegalBlockSizeException tailledeBlockNonConforme) {
			JOptionPane.showMessageDialog(null, "Taille de block non conforme");
		} catch (BadPaddingException mauvaisPadding) {
			JOptionPane.showMessageDialog(null, "Mauvais padding");
		}					
		return null;
	}
	
	static byte[] decoder(String donne) {
		return Base64.getDecoder().decode(donne);
	}

	/**
	 * Encrypte un message avec la cle RSA
	 * @param message
	 * @param cleRsa
	 * @return message crypté en String
	 */
	public static String decrypteMessageAvecCleRSA(String messageCrypte, PrivateKey clePrive) {
		byte[] messageEncrypteEnByte = decoder(messageCrypte);
		try {
			Cipher decryptage = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			decryptage.init(Cipher.DECRYPT_MODE, clePrive);
			byte[] messageDecrypteEnByte = decryptage.doFinal(messageEncrypteEnByte);
			return new String (messageDecrypteEnByte, "UTF8");

		} catch (InvalidKeyException cleNonValide) {
			cleNonValide.printStackTrace();
			JOptionPane.showMessageDialog(null, "Clé non valide");
		} catch (NoSuchAlgorithmException algorithmeInexistant) {
			JOptionPane.showMessageDialog(null, "Algorithme non valide");
		} catch (NoSuchPaddingException paddingNonExistant) {
			JOptionPane.showMessageDialog(null, "Padding non existant");
		} catch (IllegalBlockSizeException tailledeBlockNonConforme) {
			JOptionPane.showMessageDialog(null, "Taille de block non conforme");
		} catch (BadPaddingException mauvaisPadding) {
			JOptionPane.showMessageDialog(null, "Mauvais padding");
			mauvaisPadding.printStackTrace();
		} catch (UnsupportedEncodingException ecodingIndisponible) {
			JOptionPane.showMessageDialog(null, "Encoding indisponible");
		}					
		return null;
	}

	/**
	 * Sauvegarde la clé de chiffrement utilisé dans un fichier
	 * @param cleUtilise
	 * @param motDePasse
	 * @param adresseFichierCle
	 */
	public static void sauvegardeCleSymetriqueUtilise(Key cleUtilise, String motDePasse, String adresseFichierCle) {
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
	public static Key recuperationCleSymetrique(String adresseFichierCle, String motDePasse) {
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

	/**
	 * Permet la sauvegarde de la clé asymétrique dans un fichier
	 * @param addresseDuFichierClePublic
	 * @param addresseDuFichierClePrive
	 * @param cleRsa
	 * @throws IOException
	 */
	static void sauvegarderDansFichierCleAsymetrique(String addresseDuFichierClePublic, String addresseDuFichierClePrive, KeyPair cleRsa) throws IOException {
		byte[] cleRsaPublic = cleRsa.getPublic().getEncoded();
		byte[] cleRsaPrive = cleRsa.getPrivate().getEncoded();

		try {
			FileOutputStream ouvreFluxFichierClePublic = new FileOutputStream(addresseDuFichierClePublic);
			DataOutputStream ouvreFluxEcrireDataFichierClePublic = new DataOutputStream(ouvreFluxFichierClePublic);

			ouvreFluxEcrireDataFichierClePublic.write(cleRsaPublic);

			ouvreFluxEcrireDataFichierClePublic.close();
			ouvreFluxFichierClePublic.close();

			FileOutputStream ouvreFluxFichierClePrive = new FileOutputStream(addresseDuFichierClePrive);
			DataOutputStream ouvreFluxEcrireDataFichierClePrive = new DataOutputStream(ouvreFluxFichierClePrive);

			ouvreFluxEcrireDataFichierClePrive.write(cleRsaPrive);

			ouvreFluxEcrireDataFichierClePrive.close();
			ouvreFluxFichierClePrive.close();

		}catch(IOException erreurEcritureFichier) {
			JOptionPane.showMessageDialog(null, "Echec de la sauvegarde des clés privé/publiques");
		}
	}

	/**
	 * Fonction qui permet de récupérer la clé privé
	 * @param adresseFichierClePublic
	 * @param adresseFichierClePrive
	 * @return
	 */
	static PrivateKey recupererClePriveDansFichier(String adresseFichierClePrive) {
		File  fichierClePrive = null;
		byte[] ClePrive = null;

		try {
			fichierClePrive =  new File(adresseFichierClePrive);
			FileInputStream lireFichierClePrive= new FileInputStream(fichierClePrive);
			DataInputStream ouvreFluxLireDataFihierClePrive=  new DataInputStream(lireFichierClePrive); 

			ClePrive = ouvreFluxLireDataFihierClePrive.readAllBytes();

			ouvreFluxLireDataFihierClePrive.close();
			lireFichierClePrive.close();

		} catch (IOException erreurLectureFichier) {
			JOptionPane.showMessageDialog(null, "Le fichier contenant la cle n'a pas pu être lu");
		}
		
		try {
			return ApiRSA.turnByteArraySkInPrivateKey(ClePrive);
		} catch (Exception echecGenerationClePublique) {
			JOptionPane.showMessageDialog(null, "La clé publique n'a pas pu être récupéré");
			echecGenerationClePublique.printStackTrace();
		}
		return null;
	}
	
	static PublicKey recupererClePubliqueDansFichier(String adresseFichierClePublique) {
		File  fichierClePublique = null;
		byte[] ClePublique = null;

		try {
			fichierClePublique =  new File(adresseFichierClePublique);
			FileInputStream lireFichierClePublique= new FileInputStream(fichierClePublique);
			DataInputStream ouvreFluxLireDataFihierClePublique=  new DataInputStream(lireFichierClePublique); 

			ClePublique = ouvreFluxLireDataFihierClePublique.readAllBytes();

			ouvreFluxLireDataFihierClePublique.close();
			lireFichierClePublique.close();

		} catch (IOException erreurLectureFichier) {
			JOptionPane.showMessageDialog(null, "Le fichier contenant la cle n'a pas pu être lu");
		}
		
		try {
			return ApiRSA.turnByteArrayPkInPublicKey(ClePublique);
		} catch (Exception echecGenerationClePublique) {
			JOptionPane.showMessageDialog(null, "La clé publique n'a pas pu être récupéré");
			echecGenerationClePublique.printStackTrace();
		}
		return null;
	}
}
