package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * CE CODE EST A REMPLACER PAR CELUI DE KENETH
 * La fenetre qui apparait si les donn�es priv�es
 * et sensibles ne sont pas pr�sent dans la base 
 * de donn�e, elle permet de les donner, ils seront
 * crypt� et stock� dans la base de donn�e
 * @author Lagaillarde
 *
 */
public class FenetreDonnePriveEtSensible extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Le main de FenetreDonnePriveEtSensible
	 * @param args Les parametre du main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetreDonnePriveEtSensible fenetreInsersionDonnePersoEtSensible = null;
				fenetreInsersionDonnePersoEtSensible = new FenetreDonnePriveEtSensible();
				fenetreInsersionDonnePersoEtSensible.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "La fen�tre des donn�e perso et sensibles a un probl�me");

			}

		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreDonnePriveEtSensible() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Donne perso et sensible");
		lblNewLabel.setBounds(181, 75, 191, 61);
		contentPane.add(lblNewLabel);
	}
}
