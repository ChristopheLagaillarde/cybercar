package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


import java.awt.Font;
/**
 * A MODIFIER/REMPLACER PLUS TARD
 * Fenetre pour le departement RH
 * @author Lagaillarde
 *
 */
public class FenetreSI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	/**
	 * Le main de FenetreRH
	 * @param args Le parametre du main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				FenetreSI moduleSI = null;
				moduleSI = new FenetreSI();
				moduleSI.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fen?tre");

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreSI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel informatiqueEcrit = new JLabel("Informatique");
		informatiqueEcrit.setFont(new Font("Tahoma", Font.PLAIN, 27));
		informatiqueEcrit.setBounds(174, 113, 173, 86);
		panelPrincipal.add(informatiqueEcrit);
	}

}
