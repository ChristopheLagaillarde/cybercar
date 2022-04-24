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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.WindowConstants;

/**
 * Fenetre permettant de se connecter � l'application CyberCar
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
			ouvreFluxEcrireDansFichierLogLogin.write("Login utilis� : " + loginUtilise);
			ouvreFluxEcrireDansFichierLogLogin.newLine();
			ouvreFluxEcrireDansFichierLogLogin.write("Connection r�ussite : " + connectionReussite);

		}
		catch(Exception erreurLog) {
			JOptionPane.showMessageDialog(null, "Erreur au niveau de l'�criture du log");
		}
		finally {
			try  {
				ouvreFluxEcrireDansFichierLogLogin.close();

				if(ecrireDansFichierLogLogin != null) {
					ecrireDansFichierLogLogin.close();
				}

			}

			catch(Exception erreurLog) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fermeture du flux de l'�criture du log");

			}
		}
	}
	
	void accedeASonDepartement(String fonctionDansLentreprise) {
		if(fonctionDansLentreprise.equals("vendeur")) {
			FenetreVendeur.main(null);
		}
		
		if(fonctionDansLentreprise.equals("AdminSystem")) {
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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	JTextField barreLogin;
	private JTextField barreMotDepasse;

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
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fen�tre");
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
		barreMotDepasse = new JPasswordField();

		loginText.setFont(new Font(font, Font.BOLD, 13));
		motDePasseText.setFont(new Font(font, Font.BOLD, 13));
		boutonSeConnecter.setFont(new Font(font, Font.BOLD, 16));


		loginText.setBounds(44, 22, 56, 20);
		motDePasseText.setBounds(10, 64, 87, 20);
		barreLogin.setBounds(105, 21, 146, 26);
		barreMotDepasse.setBounds(105, 58, 146, 26);
		boutonSeConnecter.setBounds(105, 95, 146, 37);

		barreLogin.setColumns(10);
		barreMotDepasse.setColumns(10);

		panelPrincipal.add(loginText);
		panelPrincipal.add(motDePasseText);
		panelPrincipal.add(barreLogin);
		panelPrincipal.add(barreMotDepasse);
		panelPrincipal.add(boutonSeConnecter);

		boutonSeConnecter.addActionListener(e -> {
			String fonctionDansLentreprise = null;
			String donnePriveEtSensible = "";
			String motDePasseHashe = null;

			ConnectionFactory connectionBDPourLogin = null;
			ConnectionFactory connectionBDPourVerifierSiPremierConnection = null;

			ResultSet resultatSelectFonctionEmploye = null;
			ResultSet resultatSelectPremierConnection  = null;


			connectionBDPourLogin = new ConnectionFactory("CyberCar","root","");

			try {
				// Hashage du mot de passe
				motDePasseHashe = Hash.hashage(barreMotDepasse.getText(),"SHA3-256");

				// Recherche de la fonction de l'employe
				resultatSelectFonctionEmploye = connectionBDPourLogin.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectLaFonctionDeLutilisateur(barreLogin.getText(),motDePasseHashe));
				while(resultatSelectFonctionEmploye.next()) {
					fonctionDansLentreprise = resultatSelectFonctionEmploye.getString("fonction");
				}
				resultatSelectFonctionEmploye.close();

				// Donne fen�tre donn�e priv�e et sensible si c'est la 1er connection
				connectionBDPourVerifierSiPremierConnection = new ConnectionFactory("CyberCar","root","");
				resultatSelectPremierConnection = connectionBDPourVerifierSiPremierConnection.requeteAFaire.executeQuery(RequeteSQLCyberCar.selectDonnePersoEtPriveUtilisateur(barreLogin.getText()));

				while(resultatSelectPremierConnection.next()) {
					donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("civilite"));
					donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("nomDeJeuneFille"));
					donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("situationConjugale"));
					donnePriveEtSensible = donnePriveEtSensible.concat(resultatSelectPremierConnection.getString("entecedantMedicale"));
				} 

				if(donnePriveEtSensible.equals("")) {
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
