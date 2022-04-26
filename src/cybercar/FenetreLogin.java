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

	String adresseFichierLog = "C://Users/Lagaillarde/eclipse-workspace-java/cybercar/src/cybercar/logLogin.txt";

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

		fichierLogLogin = new File(addresseDuFichier);
		try {
			ecrireDansFichierLogLogin = new FileWriter(fichierLogLogin,true);
		} catch (IOException echecEcritureDansFichier) {
			JOptionPane.showMessageDialog(null, " erreur au niveau du log");

		}
		ouvreFluxEcrireDansFichierLogLogin = new BufferedWriter(ecrireDansFichierLogLogin);

		try {
			ouvreFluxEcrireDansFichierLogLogin.newLine();     
			ouvreFluxEcrireDansFichierLogLogin.newLine();
			ouvreFluxEcrireDansFichierLogLogin.write("Date : " + heureEtDateDuLogin.format(maintenant));
			ouvreFluxEcrireDansFichierLogLogin.newLine();
			ouvreFluxEcrireDansFichierLogLogin.write("Login utilisé : " + loginUtilise);
			ouvreFluxEcrireDansFichierLogLogin.newLine();
			ouvreFluxEcrireDansFichierLogLogin.write("Connection réussite : " + connectionReussite);

		}
		catch(Exception erreurLog) {
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
	void accedeASonDepartement(String fonctionDansLentreprise) {
		if(fonctionDansLentreprise.equals("vendeur")) {
			FenetreVendeur.main(null);
		}

		if(fonctionDansLentreprise.equals("adminSystem")) {
			FenetreAdminSystem.main(null);
		}

		if(fonctionDansLentreprise.equals("employeRH")) {
			FenetreRH.main(null);
		}

		if(fonctionDansLentreprise.equals("garagiste")) {
			FenetreGaragiste.main(null);
		}

		if(fonctionDansLentreprise.equals("employeFinance")) {
			FenetreFinance.main(null);
		}

		if(fonctionDansLentreprise.equals("employeSI")) {
			FenetreSI.main(null);
		}
		sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
		FenetreLogin.this.dispose();
	}

	/**
	 * cherche la fonction de l'employé dans la base de donnée
	 * @param motDePasseHashe
	 * @return fonctionDansLEntreprise la fonction dans l'entreprise
	 */
	String fonctionDeLEmployeDansLEntreprise(String motDePasseHashe) {
		String fonctionDansLEntreprise = null;
		ConnectionFactory connectionBDPourVerifierFonction = null;
		ResultSet resultatSelectFonctionEmploye = null;

		connectionBDPourVerifierFonction = new ConnectionFactory("sql11488251","sql11488251","GNqb534jQy");
		
		try {
			resultatSelectFonctionEmploye = connectionBDPourVerifierFonction.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(barreLogin.getText(),motDePasseHashe));
			
			while(resultatSelectFonctionEmploye.next()) {
				fonctionDansLEntreprise = resultatSelectFonctionEmploye.getString("fonction");
			}
			resultatSelectFonctionEmploye.close();

		} catch (SQLException requeteNonValide) {
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
			connectionBDPourVerifierSiPremierConnection = new ConnectionFactory("sql11488251","sql11488251","GNqb534jQy");

			resultatSelectPremierConnection = connectionBDPourVerifierSiPremierConnection.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectDonnePersoEtPriveUtilisateur(barreLogin.getText(), Hash.hashage(barreMotDePasse.getText(),"SHA3-256")));
			
			while(resultatSelectPremierConnection.next()) {
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("civilite"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("nomDeJeuneFille"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("situationConjugale"));
				donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("entecedantMedicale"));
			}
		} catch (SQLException requeteNonValde) {
			JOptionPane.showMessageDialog(null, "Fonction dans l'entreprise non trouvable");
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
				maFenetrePourLogin = new FenetreLogin();
				maFenetrePourLogin.setVisible(true);

			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre");
			}



		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreLogin() {

		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 198);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Login");

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

				if(Boolean.TRUE.equals((premierConnectionAuCompte()))) {
					FenetreDonnePriveEtSensible.main(null);
					FenetreLogin.this.dispose();
					sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
				}

				else if(fonctionDansLentreprise != null) {
					accedeASonDepartement(fonctionDansLentreprise);
				}

				else {
					JOptionPane.showMessageDialog(null, "Login ou mots de passe incorrecte");
					sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), false);
				}
			}

			catch(Exception loginOuMotDePasseIncorrecte) {
				sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), false);
			}

		});

	}

}
