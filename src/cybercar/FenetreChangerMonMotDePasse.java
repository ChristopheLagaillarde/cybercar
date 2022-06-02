package cybercar;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

/**
 * Fenetre permettant de changer le mot de passe de l'utilisateur
 * @author Lagaillarde
 *
 */
public class FenetreChangerMonMotDePasse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuDeLaFenetre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetreChangerMonMotDePasse maFenetreChangerMonMotDePasse = new FenetreChangerMonMotDePasse(args);
				maFenetreChangerMonMotDePasse.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre changer mot de passe");
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreChangerMonMotDePasse(String[] args) {
		setBounds(100, 100, 549, 322);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);
		JLabel MdpEcrit = null;
		JLabel nouveauMdpEcrit = null;
		JLabel ResaisirNouveauMdpEcrit = null;
		JButton boutonValider = null;
		
		Font styleEcriture = new Font("Arial", Font.BOLD, 18);


		MdpEcrit = new JLabel("MDP actuel");
		nouveauMdpEcrit = new JLabel("Nouveau MDP");
		ResaisirNouveauMdpEcrit = new JLabel("Resaisir Nouveau MDP");
		final JTextField barreMdp = new JPasswordField();;
		final JTextField barreSaisirNouveauMdp = new JPasswordField();;
		final JTextField barreResaisirNouveauMdp = new JPasswordField();;
		boutonValider = new JButton("Valider");

		MdpEcrit.setFont(styleEcriture);
		nouveauMdpEcrit.setFont(styleEcriture);
		ResaisirNouveauMdpEcrit.setFont(styleEcriture);
		boutonValider.setFont(styleEcriture);
		barreMdp.setFont(styleEcriture);
		barreSaisirNouveauMdp.setFont(styleEcriture);
		barreResaisirNouveauMdp.setFont(styleEcriture);
		
		barreMdp.setColumns(10);
		barreSaisirNouveauMdp.setColumns(10);
		barreResaisirNouveauMdp.setColumns(10);

		MdpEcrit.setBounds(92, 44, 151, 42);
		nouveauMdpEcrit.setBounds(92, 100, 151, 42);
		ResaisirNouveauMdpEcrit.setBounds(47, 155, 226, 42);
		barreMdp.setBounds(283, 50, 208, 42);
		barreSaisirNouveauMdp.setBounds(283, 102, 208, 42);
		barreResaisirNouveauMdp.setBounds(283, 155, 208, 42);
		boutonValider.setBounds(213, 230, 127, 42);

		contenuDeLaFenetre.add(MdpEcrit);
		contenuDeLaFenetre.add(nouveauMdpEcrit);
		contenuDeLaFenetre.add(ResaisirNouveauMdpEcrit);
		contenuDeLaFenetre.add(barreMdp);
		contenuDeLaFenetre.add(barreSaisirNouveauMdp);		
		contenuDeLaFenetre.add(barreResaisirNouveauMdp);
		contenuDeLaFenetre.add(boutonValider);

		boutonValider.addActionListener((clickBoutton -> {
			if(!(GererMdp.estUnBonMdp(barreSaisirNouveauMdp.getText()))) {
				JOptionPane.showMessageDialog(null, "Mot de passe faible, il faut 16 caractères, dont au moins 1 majuscule, 1 minuscule et 1 caractère spécial");
			}
			else {
				if(barreSaisirNouveauMdp.getText().equals(barreResaisirNouveauMdp.getText())) {
					String motDePasseHashe = Hash.hashage(barreSaisirNouveauMdp.getText(), "SHA3-256");
					String ancienMotDePasseHashe = Hash.hashage(barreMdp.getText(), "SHA3-256");

					String nomBDD = "sql11497241";
					String username = "sql11497241";
					String motDePasseBDD = "9B2cyk9VAv";
					ConnectionFactory connectionPourChangerMdp = new ConnectionFactory(nomBDD,username, motDePasseBDD);
					ResultSet resultatSelectMdp = null;
					String motDePasseActuelDansbdd = null;

					try {
						int choix = JOptionPane.showConfirmDialog(null,"Voulez vous vraiement modifier votre mot de passe", "Confirmation",JOptionPane.YES_NO_OPTION);	
						if(choix==0) {
							resultatSelectMdp = connectionPourChangerMdp.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_MDP_UTILISATEUR(args));
							while(resultatSelectMdp.next()) {
								motDePasseActuelDansbdd = resultatSelectMdp.getString("motDePasse");
							}
							resultatSelectMdp.close();
							if(motDePasseActuelDansbdd.equals(ancienMotDePasseHashe)) {
								connectionPourChangerMdp.requeteAFaire.addBatch(RequeteSQLCyberCar.UPDATE_MDP_UTILISATEUR_TABLE_LOGIN(args, motDePasseHashe));
								connectionPourChangerMdp.requeteAFaire.addBatch(RequeteSQLCyberCar.UPDATE_MDP_UTILISATEUR_TABLE_EMPLOYE(args, motDePasseHashe));
								connectionPourChangerMdp.requeteAFaire.executeBatch();
								JOptionPane.showMessageDialog(null, "Mot de passe modifié");
							}
							else {
								JOptionPane.showMessageDialog(null, "Mot de passe actuel incorrecte");
							}
						}
					} catch (SQLException echecChangementMotDepasse) {
						JOptionPane.showMessageDialog(null, "Erreur lors du changement du mot de passe");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "La resaisie du mot de passe est distincte");
				}

			}
		}
				));

	}
}
