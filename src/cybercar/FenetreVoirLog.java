package cybercar;

import java.awt.EventQueue;
import java.awt.Font;
import java.security.Key;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class FenetreVoirLog extends JFrame {

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
				FenetreVoirLog laFenetreVoirLog = new FenetreVoirLog();
				laFenetreVoirLog.setVisible(true);
			} catch (Exception crashFenetreLog) {

			}

		});
	}

	/**
	 * Create the frame.;
	 */
	public FenetreVoirLog() {
		String motDePasse = "uSD*m$n3Vab^@HDy";
		String adresseFichierContenantCle = "src\\cybercar\\cleSymetrique.ks";
		Key cleSymetrique = GererCleCryptographie.recuperationCle(adresseFichierContenantCle, motDePasse);
		String messageDechiffre = ApiFileCipher.dechiffrerFichierTexte("logLogin.cryp",cleSymetrique);
	
	 	messageDechiffre = messageDechiffre.replaceAll("[^a-zA-Z0-9/:�@. ]", "\n");  
	 	messageDechiffre = messageDechiffre.replaceAll("\n\n\n", "\n\n");  



		setBounds(100, 100, 450, 300);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);

		JLabel logLoginEcrit = new JLabel("Log des log in");
		logLoginEcrit.setBounds(156, 21, 138, 20);
		logLoginEcrit.setFont(new Font("Arial", Font.BOLD, 17));
		contenuDeLaFenetre.add(logLoginEcrit);

		JTextPane textPane = new JTextPane();
		textPane.setText(messageDechiffre);
		textPane.setBounds(20, 52, 404, 198);
		contenuDeLaFenetre.add(textPane);

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(10, 39, 424, 222);
		contenuDeLaFenetre.add(scrollPane);

	}
}
