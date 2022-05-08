package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import javax.swing.JButton;
import java.awt.Font;
/**
 * Fenetre vendeur permettant aux vendeur d'effectuer des ventes etc
 * @author Lagaillarde
 *
 */
public class FenetreVendeur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JButton boutonModifierMDP_1;

	/**
	 * Le main de FenetreRH
	 * @param args Le parametre du main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				FenetreVendeur moduleVendeur = null;
				moduleVendeur = new FenetreVendeur(args);
				moduleVendeur.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre");

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreVendeur(String[] args) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton boutonConfirmerVente = null;
		JButton boutonModifierMDP = null;

		boutonConfirmerVente = new JButton("Confirmer une vente");
		boutonModifierMDP = new JButton("Modifier mon mot de passe");

		boutonConfirmerVente.setFont(new Font("Arial", Font.BOLD, 18));
		boutonModifierMDP.setFont(new Font("Arial", Font.BOLD, 18));

		boutonConfirmerVente.setBounds(33, 11, 366, 42);
		boutonModifierMDP.setBounds(33, 192, 366, 42);

		panelPrincipal.add(boutonConfirmerVente);
		panelPrincipal.add(boutonModifierMDP);

		boutonConfirmerVente.addActionListener((clickBoutton -> 
		FenetreConfirmationVente.main(args)
				));

		boutonModifierMDP.addActionListener((clickBoutton -> 
		FenetreChangerMonMotDePasse.main(args)
				));
	}
}
