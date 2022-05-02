package cybercar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	 * Create the frame.
	 */
	public FenetreVoirLog() {
		setBounds(100, 100, 450, 300);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);

		JLabel logLoginEcrit = new JLabel("Log des log in");
		logLoginEcrit.setBounds(156, 21, 138, 20);
		logLoginEcrit.setFont(new Font("Arial", Font.BOLD, 17));
		contenuDeLaFenetre.add(logLoginEcrit);
		
		JTextPane txtpnV = new JTextPane();
		txtpnV.setText("v4");
		txtpnV.setBounds(24, 41, 400, 198);
		contenuDeLaFenetre.add(txtpnV);
	}
}
