package cybercar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * A MODIFIER/REMPLACER PLUS TARD
 * Fenetre pour le departement RH
 * @author Lagaillarde
 *
 */
public class FenetreFinance extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuDeLaFenetre;

	/**
	 * Le main de FenetreRH
	 * @param args Le parametre du main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				FenetreFinance moduleFinance = null;
				moduleFinance = new FenetreFinance(args);
				moduleFinance.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau de la fenêtre");

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreFinance(String[] args) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);
		
		JButton boutonVoirLogVente = null;
		
		Font styleEcriture = new Font("Arial", Font.BOLD, 18);
		
		boutonVoirLogVente = new JButton("Voir log vente");
		
		boutonVoirLogVente.setFont(styleEcriture);
		
		boutonVoirLogVente.setBounds(53, 201, 298, 49);
		
		contenuDeLaFenetre.add(boutonVoirLogVente);
		
		boutonVoirLogVente.addActionListener(clickBouton ->{
			FenetreVoirLogVente.main(args);
		});


	}
}