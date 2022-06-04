package cybercar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

/*
 * Contient toutes les fonctions qui mobilise des fichiers
 */
public class GererFichier {

	/**
	 * Fonction permettant de sauvegarder les tentatives de connection dans un fichier log et les crypter avec une clé symétrique
	 * (Blowfish)
	 * @param addresseDuFichier
	 * @param LoginUtilise
	 * @param connectionReussite
	 * @throws IOException
	 */
	static void sauvegarderLoginDansFichierLog(String addresseDuFichier, String loginUtilise, Boolean connectionReussite) {
		DateTimeFormatter heureEtDateDuLogin = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime maintenant = LocalDateTime.now();  
		BufferedWriter ouvreFluxEcrireDansFichierLogLogin = null;
		File fichierLogLogin = null;
		FileWriter ecrireDansFichierLogLogin = null;
		String motDePasse = "uSD*m$n3Vab^@HDy";
		String adresseFichierContenantCle = "src\\cybercar\\cleSymetrique.ks";
		String logConnectionChiffre = null;
		String logConnection = null;

		fichierLogLogin = new File(addresseDuFichier);
		try {
			ecrireDansFichierLogLogin = new FileWriter(fichierLogLogin,true);
		} catch (IOException echecEcritureDansFichier) {
			JOptionPane.showMessageDialog(null, " erreur au niveau du log");

		}
		ouvreFluxEcrireDansFichierLogLogin = new BufferedWriter(ecrireDansFichierLogLogin);
		logConnection = "Date : " + heureEtDateDuLogin.format(maintenant) + "\nLogin utilisé : " + loginUtilise + "\nConnection réussite : " + connectionReussite;

		try {
			Key clefSymetrique = GererCleCryptographie.recuperationCleSymetrique(adresseFichierContenantCle, motDePasse);
			logConnectionChiffre = ApiBlowfish.encryptInString(logConnection, clefSymetrique);
		} catch (Exception erreurCryptage) {

		}

		try {
			ouvreFluxEcrireDansFichierLogLogin.write(logConnectionChiffre);
		}
		catch(Exception erreurLog) {
			erreurLog.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur au niveau de l'écriture du log");
		}
		finally {
			try  {
				ouvreFluxEcrireDansFichierLogLogin.close();

				if(ecrireDansFichierLogLogin != null) {
					ecrireDansFichierLogLogin.close();
				}

			}

			catch(Exception erreurLog) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fermeture du flux de l'écriture du log");
				erreurLog.printStackTrace();

			}
		}
	}


	/**
	 * Fonction permettant de sauvegarder les ventes réalisé dans un fichier crypté avec une clé asymétrique (RSA)
	 * @param addresseDuFichier
	 * @param LoginUtilise
	 * @param connectionReussite
	 * @throws IOException
	 */
	static void sauvegarderVenteDansFichierLog(String addresseDuFichier, String idEmploye, String idVoiture, String idClient) {
		DateTimeFormatter heureEtDateDeLaVente = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime maintenant = LocalDateTime.now();  
		BufferedWriter ouvreFluxEcrireDansFichierLogVente = null;
		File fichierLogVente = null;
		FileWriter ecrireDansFichierLogVente = null;
		String logVenteChiffre = null;
		String logVente = null;

		fichierLogVente = new File(addresseDuFichier);
		try {
			ecrireDansFichierLogVente = new FileWriter(fichierLogVente,true);
		} catch (IOException echecEcritureDansFichier) {
			JOptionPane.showMessageDialog(null, " erreur au niveau du log");

		}
		ouvreFluxEcrireDansFichierLogVente = new BufferedWriter(ecrireDansFichierLogVente);
		logVente = "\n\nDate : " + heureEtDateDeLaVente.format(maintenant) + "\nIdEmployé : " + idEmploye + "\nIdVoiture : " + idVoiture + "\nIdClient : " + idClient;
		try {
			PublicKey clePublic = GererCleCryptographie.recupererClePubliqueDansFichier("src\\cybercar\\clePublique.ks");
			logVenteChiffre = GererCleCryptographie.crypteMessageAvecClePublique(logVente,clePublic);
		} catch (Exception echecGenerationCleRSA) {
			JOptionPane.showMessageDialog(null, "La clé RSA n'a pas pu être généré");
		}

		try {
			ouvreFluxEcrireDansFichierLogVente.write(logVenteChiffre);
			ouvreFluxEcrireDansFichierLogVente.newLine();
		}
		catch(Exception erreurLog) {
			JOptionPane.showMessageDialog(null, "Erreur au niveau de l'écriture du log");
			erreurLog.printStackTrace();
		}
		finally {
			try  {
				ouvreFluxEcrireDansFichierLogVente.close();

				if(ecrireDansFichierLogVente != null) {
					ecrireDansFichierLogVente.close();
				}

			}

			catch(Exception erreurLog) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fermeture du flux de l'écriture du log");

			}
		}
	}

	static String lireFichierLogVenteChiffre(String adresseFichierLogVentre) {
		String ligneActuel = "";
		File fichierLogVente = null;
		FileReader lireDansFichierLogVente = null;
		BufferedReader ouvreFluxLireDansFichierLogVente = null;
		String logVenteDechiffre = "";

		try {
			fichierLogVente = new File(adresseFichierLogVentre);
			lireDansFichierLogVente = new FileReader(fichierLogVente);
			ouvreFluxLireDansFichierLogVente =  new BufferedReader(lireDansFichierLogVente); 
			while ((ligneActuel = ouvreFluxLireDansFichierLogVente.readLine()) != null){ 
				logVenteDechiffre += GererCleCryptographie.decrypteMessageAvecCleRSA(ligneActuel,GererCleCryptographie.recupererClePriveDansFichier("src\\cybercar\\clePrive.ks"));
			}

			ouvreFluxLireDansFichierLogVente.close();
			lireDansFichierLogVente.close();

		} catch (IOException ErreurRecuperationTexteCrypte) {
			JOptionPane.showMessageDialog(null, "Le log des vente crypte n'a pas pu être récupéré");
		}

		return logVenteDechiffre;
	}
}
