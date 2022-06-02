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

import java.sql.ResultSet;
import java.sql.SQLException;

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
		GererFichier.sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
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
		Font styleEcriture = new Font("Arial", Font.BOLD, 18);

		loginText = new JLabel("login");
		motDePasseText = new JLabel("MDP");
		barreLogin = new JTextField();
		boutonSeConnecter = new JButton("Se Connecter");
		barreMotDePasse = new JPasswordField();

		loginText.setFont(styleEcriture);
		motDePasseText.setFont(styleEcriture);
		boutonSeConnecter.setFont(styleEcriture);

		loginText.setBounds(44, 22, 56, 20);
		motDePasseText.setBounds(41, 59, 87, 20);
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
					GererFichier.sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), true);
				}

				else if(fonctionDansLentreprise != null) {
					accedeASonDepartement(args, fonctionDansLentreprise);
				}

				else {
					JOptionPane.showMessageDialog(null, "Login ou mots de passe incorrecte");
					GererFichier.sauvegarderLoginDansFichierLog(adresseFichierLog, "intru@cybercar.com", false);
				}
			}

			catch(Exception loginOuMotDePasseIncorrecte) {
				GererFichier.sauvegarderLoginDansFichierLog(adresseFichierLog, barreLogin.getText(), false);
			}

		});

	}

}
