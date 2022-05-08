package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.security.Key;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.WindowConstants;

/**
 * Fenetre permettant de se connecter à l'application CyberCar
 * @author Lagaillarde
 *
 */
public class FenetreLogin extends JFrame {

	String adresseFichierLog = "logLogin.cryp";
	String nomBDD = "cybercar";
	String username = "root";
	String motDePasseBDD = "";

	/**
	 * Fonction permettant dans sauvegarder les tentatives de connection dans un fichier log
	 * @param addresseDuFichier
	 * @param LoginUtilise
	 * @param connectionReussite
	 * @throws IOException
	 */
	void sauvegarderLoginDansFichierLog(String addresseDuFichier, String loginUtilise, Boolean connectionReussite) {
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
			Key clefSymetrique = GererCleCryptographie.recuperationCle(adresseFichierContenantCle, motDePasse);
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

			}
		}
	}

	/**
	 * Renvoie vers le bon département
	 * @param fonctionDansLentreprise
	 */
	void accedeASonDepartement(String[] args, String fonctionDansLentreprise) {
		
		if(fonctionDansLentreprise.equals("vendeur")) {
			FenetreVendeur.main(args);
		}

		if(fonctionDansLentreprise.equals("adminSystem")) {
			FenetreAdminSystem.main(args);
		}

		if(fonctionDansLentreprise.equals("employeRH")) {
			GestionRH.main(args);
		}

		if(fonctionDansLentreprise.equals("garagiste")) {
			Entrepot.main(args);
		}

		if(fonctionDansLentreprise.equals("employeFinance")) {
			FenetreFinance.main(args);
		}

		if(fonctionDansLentreprise.equals("employeSI")) {
			FenetreSI.main(args);
		}
		sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
		FenetreLogin.this.dispose();
	}
	
	/**
	 * Permet de récuperer l'id de l'employe dans l'entreprise
	 * @param loginDeLemploye
	 * @return idEmploye
	 */
	String idDeLEmployeDansLEntreprise(String loginDeLemploye) {
		ResultSet resultatSelectIdEmploye = null;
		ConnectionFactory connectionBDPourRecupererIdEmploye = null;
		
		connectionBDPourRecupererIdEmploye = new ConnectionFactory(nomBDD, username, motDePasseBDD);
		try {
			resultatSelectIdEmploye = connectionBDPourRecupererIdEmploye.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_ID_EMPLOYE(barreLogin.getText()));
			while(resultatSelectIdEmploye.next()) {
				loginDeLemploye = resultatSelectIdEmploye.getString("id_employé");
			}
			resultatSelectIdEmploye.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erreur lors de la recherde de l'id de l'employé");
		}
		return loginDeLemploye;
	}

	/**
	 * cherche la fonction de l'employé dans la base de donnée
	 * @param motDePasseHashe
	 * @return fonctionDansLEntreprise la fonction dans l'entreprise
	 */
	String fonctionDeLEmployeDansLEntreprise(String motDePasseHashe){
		String fonctionDansLEntreprise = null;
		ConnectionFactory connectionBDPourVerifierFonctionEtPrendreIdEmploye = null;
		ResultSet resultatSelectFonctionEmploye = null;

		connectionBDPourVerifierFonctionEtPrendreIdEmploye = new ConnectionFactory(nomBDD, username, motDePasseBDD);

		try {
			resultatSelectFonctionEmploye = connectionBDPourVerifierFonctionEtPrendreIdEmploye.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_LA_FONCTION_DE_LUTILISATEUR(barreLogin.getText(),motDePasseHashe));
			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLEntreprise = resultatSelectFonctionEmploye.getString("fonction");
			}
			resultatSelectFonctionEmploye.close();
			
		} catch (SQLException requeteNonValide) {
			requeteNonValide.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fonction dans l'entreprise non trouvable"); 
		}

		return fonctionDansLEntreprise;
	}

	/**
	 *  Dit si il s'agit de la première connection de l'employé
	 * @return la valeur booléeene (première connection ou pas)
	 */
	Boolean premierConnectionAuCompte() {
		ConnectionFactory connectionBDPourVerifierSiPremierConnection = null;
		ResultSet resultatSelectPremierConnection  = null;
		String donnePriveEtSensible = "";

		barreLogin.getText();

		try {
			connectionBDPourVerifierSiPremierConnection = new ConnectionFactory(nomBDD,username,motDePasseBDD);

			resultatSelectPremierConnection = connectionBDPourVerifierSiPremierConnection.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_DONNEE_PERSO_ET_PRIVE_UTILISATEUR(barreLogin.getText(), Hash.hashage(barreMotDePasse.getText(),"SHA3-256")));

			while(resultatSelectPremierConnection.next()) {
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("civilite"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("nomDeJeuneFille"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("situationConjugale"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("antecedantMedicale"));
			}
		} catch (SQLException requeteNonValde) {
			JOptionPane.showMessageDialog(null, "erreur recherche si 1er connection");
		} 
		return donnePriveEtSensible.equals(" A remplirA remplirA remplirA remplir"); 
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	JTextField barreLogin;
	JTextField barreMotDePasse;
	

	/**
	 * Le main de FenetreLogin 
	 * @param args le parametre du main
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				FenetreLogin maFenetrePourLogin = null;
				maFenetrePourLogin = new FenetreLogin(args);
				maFenetrePourLogin.setVisible(true);

			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre");
			}



		});
	}

	/**
	 * Create the frame.
	 * @param args 
	 */
	public FenetreLogin(String[] args) {

		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 198);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Login");
		this.setLocationRelativeTo(null);

		JLabel loginText = null;
		JLabel motDePasseText = null;
		JButton boutonSeConnecter = null;
		String font = "Tahoma";

		loginText = new JLabel("login");
		motDePasseText = new JLabel("mot de passe");
		barreLogin = new JTextField();
		boutonSeConnecter = new JButton("Se Connecter");
		barreMotDePasse = new JPasswordField();

		loginText.setFont(new Font(font, Font.BOLD, 13));
		motDePasseText.setFont(new Font(font, Font.BOLD, 13));
		boutonSeConnecter.setFont(new Font(font, Font.BOLD, 16));

		loginText.setBounds(44, 22, 56, 20);
		motDePasseText.setBounds(10, 64, 87, 20);
		barreLogin.setBounds(105, 21, 146, 26);
		barreMotDePasse.setBounds(105, 58, 146, 26);
		boutonSeConnecter.setBounds(105, 95, 146, 37);

		barreLogin.setColumns(10);
		barreMotDePasse.setColumns(10);

		panelPrincipal.add(loginText);
		panelPrincipal.add(motDePasseText);
		panelPrincipal.add(barreLogin);
		panelPrincipal.add(barreMotDePasse);
		panelPrincipal.add(boutonSeConnecter);

		boutonSeConnecter.addActionListener(clickBoutton -> {
			String fonctionDansLentreprise = null;

			try {
				fonctionDansLentreprise = fonctionDeLEmployeDansLEntreprise(Hash.hashage(barreMotDePasse.getText(),"SHA3-256"));
				args[0] = idDeLEmployeDansLEntreprise(barreLogin.getText());
				
				if(Boolean.TRUE.equals((premierConnectionAuCompte()))) {
					FenetreDonnePriveEtSensible.main(args);
					FenetreLogin.this.dispose();
					sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
				}

				else if(fonctionDansLentreprise != null) {
					accedeASonDepartement(args, fonctionDansLentreprise);
				}

				else {
					JOptionPane.showMessageDialog(null, "Login ou mots de passe incorrecte");
					sauvegarderLoginDansFichierLog(adresseFichierLog, "intru@cybercar.com", false);
				}
			}

			catch(Exception loginOuMotDePasseIncorrecte) {
				sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), false);
			}

		});

	}

}
