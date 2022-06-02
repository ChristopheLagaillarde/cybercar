package cybercar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class FenetreVoirLogVente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuDeLaFenetre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(()-> {
			try {
				FenetreVoirLogVente maFenetreVoirLogVente = new FenetreVoirLogVente(args);
				maFenetreVoirLogVente.setVisible(true);
			} catch (Exception crashFenetre) {
				crashFenetre.printStackTrace();
				JOptionPane.showMessageDialog(null, "la fenetre voir log a crash");
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreVoirLogVente(String[] args) {
		setBounds(100, 100, 463, 318);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);
		
		JLabel logVenteEcrit = null;
		JTextPane espaceTexte = null;
		JScrollPane barreScroll = null;
		
		String logVenteChiffre = GererFichier.lireFichierLogVenteChiffre("logVente.cryp");

		logVenteEcrit = new JLabel("Log des ventes");
		espaceTexte = new JTextPane();
		
		espaceTexte.setText(logVenteChiffre);
		
		espaceTexte.setBounds(20, 52, 404, 198);
		logVenteEcrit.setBounds(156, 21, 138, 20);
		
		logVenteEcrit.setFont(new Font("Arial", Font.BOLD, 17));
		
		contenuDeLaFenetre.add(logVenteEcrit);
		contenuDeLaFenetre.add(logVenteEcrit);
		contenuDeLaFenetre.add(espaceTexte);

		barreScroll = new JScrollPane(espaceTexte);
		barreScroll.setBounds(10, 39, 424, 222);
		contenuDeLaFenetre.add(barreScroll);

	}

}
