package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Le menu principal de l'admin système
 * Il peut aller voir les logs et aller gérer les droits
 * @author Lagaillarde
 *
 */
public class FenetreAdminSystem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuDeLaFenetre;

	/**
	 * Le main de FenetreAdminSystem
	 * @param args Le parametre du main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				FenetreAdminSystem moduleAdminSystem = null;
				moduleAdminSystem = new FenetreAdminSystem(args);
				moduleAdminSystem.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre");

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreAdminSystem(String[] args) {

		JLabel adminSystemEcrit = null;
		JButton boutonGererLesDroits = null;
		JButton boutonVoirLog = null;
		JButton boutonChangerMonMotDePasse = null;

		contenuDeLaFenetre = new JPanel();
		adminSystemEcrit = new JLabel("Admin Systeme");
		boutonGererLesDroits = new JButton("Gérer les droits des utilisateurs");
		boutonVoirLog = new JButton("Voir log");
		boutonChangerMonMotDePasse = new JButton("Changer mon mot de passe");

		
		contenuDeLaFenetre.setLayout(null);
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		adminSystemEcrit.setFont(new Font("Tahoma", Font.PLAIN, 27));
		adminSystemEcrit.setBounds(95, 0, 262, 86);
		boutonGererLesDroits.setBounds(29, 82, 382, 41);
		boutonVoirLog.setBounds(29, 145, 382, 41);
		boutonChangerMonMotDePasse.setBounds(29, 209, 382, 41);


		contenuDeLaFenetre.add(adminSystemEcrit);
		contenuDeLaFenetre.add(boutonGererLesDroits);
		contenuDeLaFenetre.add(boutonVoirLog);
		contenuDeLaFenetre.add(boutonChangerMonMotDePasse);


		boutonGererLesDroits.addActionListener((clickBoutton -> 
			FenetreGererDroit.main(args)
		));


		boutonVoirLog.addActionListener((clickBoutton -> 
			FenetreVoirLog.main(args)
		));
		
		boutonChangerMonMotDePasse.addActionListener((clickBoutton -> 
		FenetreChangerMonMotDePasse.main(args)
	));
		
	}
}
