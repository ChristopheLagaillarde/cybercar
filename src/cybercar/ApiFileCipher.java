/*/////////////////En tête////////////////////////////
 * Programme : APIFileCipher
 *
 * Description : Ce programme permet de chiffrer et
 *               déchiffrer un fichier texte au choix.
 *          
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 27/11/2021
 *        
 *///////////////////////////////////////////////////

// Déclaration des bibliotheques de fonctions...
package cybercar;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;

//////////////////Début//////////////////////////////
public class ApiFileCipher {
	
	/**
	 * Chiffre un fichier texte avec Blowfish
	 * @param nomDuFichierAchiffrer: un String du nom du fichier
	 * @param adresseFichierChiffer à chiffrer : Un String
	 * @param clefSymetrique
	 * @return void
	 */

	public static void chiffrerFichierTexte(String nomFichierAChiffrer, String adresseFichierChiffre, Key cleSymetrique) {
		String adresseFichierAChiffrer = "C://Users/Lagaillarde/eclipse-workspace-Java/Blowfish/src/" + nomFichierAChiffrer + ".txt"; 
		byte[] byteDuFichierAChiffrer = null;
		byte[] byteDuFichierChiffre = null;

		
		File fichierAChiffrer = new File(adresseFichierAChiffrer);
		try {
			FileInputStream lireFichierAChiffrer = new FileInputStream(fichierAChiffrer);
			DataInputStream ouvreFluxLireDataFichierAChiffrer=  new DataInputStream(lireFichierAChiffrer); 

			byteDuFichierAChiffrer = ouvreFluxLireDataFichierAChiffrer.readAllBytes();

			ouvreFluxLireDataFichierAChiffrer.close();
			lireFichierAChiffrer.close();
			
			
		} catch (FileNotFoundException fichierInexistant) {
			System.err.println("Le fichier n'existe pas");
			
		} catch (IOException echecDuChiffrement) {
			System.err.println("Le chiffrement a échoué");
		}

		
		try {
			byteDuFichierChiffre = ApiBlowfish.encryptInByte(byteDuFichierAChiffrer, cleSymetrique);
		} catch (Exception echecApiBlowfish) {
			System.err.println("ApiBlowfish : L'encryptage ne fonctionne pas");
		}	
		
		
		try {
			FileOutputStream ouvreFluxFichierChiffre = new FileOutputStream(adresseFichierChiffre);
			DataOutputStream ouvreFluxEcrireDataFichierChiffre = new DataOutputStream(ouvreFluxFichierChiffre);

			ouvreFluxEcrireDataFichierChiffre.write(byteDuFichierChiffre);

			ouvreFluxEcrireDataFichierChiffre.close();
			ouvreFluxFichierChiffre.close();
			
		} catch (FileNotFoundException fichierInexistant) {
			System.err.println("Le fichier n'existe pas");
		}
		catch (IOException echecDuDechiffrement) {
			System.err.println("Le dechiffrement a échoué");
		}
	
	}
	
	/**
	 * Déchiffre un fichier texte crypté avec Blowfish
	 * @param addresseFichierADechiffrer: un String de l'adresse du fichier à déchiffrer
	 * @param clefSymetrique
	 * @return texteFichierDecrypteEnString : un String du texte déchiffré
	 */
	
	public static String dechiffrerFichierTexte(String addresseFichierADechiffrer, Key cleSymetrique) {
		String texteFichierDecrypteEnByte = "";
		try {
			File fichierCrypte = new File(addresseFichierADechiffrer);
			FileReader lireFichierCrypte = new FileReader(fichierCrypte);
			BufferedReader ouvreFluxLireDataFichierCrypte=  new BufferedReader(lireFichierCrypte); 

			texteFichierDecrypteEnByte = ouvreFluxLireDataFichierCrypte.readLine();
		
			ouvreFluxLireDataFichierCrypte.close();
			lireFichierCrypte.close();
			
			
			try {
				texteFichierDecrypteEnByte = ApiBlowfish.decryptInString(texteFichierDecrypteEnByte, cleSymetrique);
			} catch (Exception erreurDecryptage) {
				erreurDecryptage.printStackTrace();
				System.err.println("Echec du décryptage");
			}
			
			
		}catch (FileNotFoundException fichierInexistant) {
			System.err.println("Le fichier crypté n'existe pas");
			
		}catch (IOException echecDuChiffrement) {
			System.err.println("Le déchiffrement a échoué");
		}
				
		return new String(texteFichierDecrypteEnByte);
	}

}
//////////////////Fin//////////////////////////////
