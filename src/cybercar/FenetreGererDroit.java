package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class FenetreGererDroit extends JFrame {

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
				FenetreGererDroit frame = new FenetreGererDroit();
				frame.setVisible(true);
			} catch (Exception crashFenetreGererDroit) {
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreGererDroit() {
		setBounds(100, 100, 450, 300);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);

		JLabel gererLesDroitsEcrits = new JLabel("Gérer les droits ");
		gererLesDroitsEcrits.setFont(new Font("Arial", Font.BOLD, 18));
		gererLesDroitsEcrits.setBounds(149, 0, 148, 36);
		contenuDeLaFenetre.add(gererLesDroitsEcrits);
	}

}
