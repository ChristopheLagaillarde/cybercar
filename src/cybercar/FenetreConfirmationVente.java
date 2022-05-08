package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FenetreConfirmationVente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuFenetre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetreConfirmationVente maFenetreConfirmationVente = new FenetreConfirmationVente();
				maFenetreConfirmationVente.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null,"La fenetre confirmation vente a crash");
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreConfirmationVente() {
		setBounds(100, 100, 450, 300);
		contenuFenetre = new JPanel();
		contenuFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuFenetre);
		contenuFenetre.setLayout(null);
		
		Font styleEcriture = new Font("Arial", Font.BOLD, 18);


		JLabel idClientEcrit = null;
		JLabel idVoitureEcrit = null;
		JButton boutonValider = null;
		JTextField barreIdClient = null;
		JTextField barreIDVoiture = null;

		idClientEcrit = new JLabel("ID client");
		idVoitureEcrit = new JLabel("ID voiture");
		boutonValider = new JButton("Valider");
		barreIdClient = new JTextField();
		barreIDVoiture = new JTextField();

		idClientEcrit.setFont(styleEcriture);
		idVoitureEcrit.setFont(styleEcriture);
		boutonValider.setFont(styleEcriture);
		barreIdClient.setFont(styleEcriture);
		barreIDVoiture.setFont(styleEcriture);
		
		idClientEcrit.setBounds(95, 51, 102, 29);
		idVoitureEcrit.setBounds(95, 136, 102, 29);
		boutonValider.setBounds(170, 202, 152, 48);
		barreIdClient.setBounds(207, 49, 141, 37);
		barreIDVoiture.setBounds(207, 134, 141, 37);
		
		barreIdClient.setColumns(10);
		barreIDVoiture.setColumns(10);
		
		contenuFenetre.add(idClientEcrit);
		contenuFenetre.add(idVoitureEcrit);
		contenuFenetre.add(boutonValider);
		contenuFenetre.add(barreIdClient);
		contenuFenetre.add(barreIDVoiture);
		
		boutonValider.addActionListener(clickBouton ->{
			// Sauvegarde log
			// Requete SQL
		});
		
	}
}
