package cybercar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FenetreVoirLog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetreVoirLog frame = new FenetreVoirLog();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreVoirLog() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logLoginEcrit = new JLabel("Log des log in");
		logLoginEcrit.setBounds(156, 21, 138, 20);
		logLoginEcrit.setFont(new Font("Arial", Font.BOLD, 17));
		contentPane.add(logLoginEcrit);
	}
}
