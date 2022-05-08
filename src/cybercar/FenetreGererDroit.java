package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

/**
 * Fenetre pour gérer les droits des utilisateurs
 * @author Lagaillarde
 *
 */
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FenetreGererDroit() {

		setBounds(100, 100, 546, 312);
		contenuDeLaFenetre = new JPanel();
		contenuDeLaFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuDeLaFenetre);
		contenuDeLaFenetre.setLayout(null);

		JLabel gererLesDroitsEcrits = null;
		JLabel idEmployeEcrit = null;
		JLabel nouvelleFonctionEcrit = null;
		JLabel nouveauDepartementEcrit = null;
		JButton boutonValider = null;
		String[] fonctionEmploye = {"vendeur","employeRH","garagiste","employeFinance", "sans fonction"};
		String[] departementEmploye = {"vente","RH","garage", "finance"};

		String nomBDD = "cybercar";
		String username = "root";
		String motDePasseBDD = "";
		
		Font styleEcriture = new Font("Arial", Font.BOLD, 18);

		gererLesDroitsEcrits = new JLabel("Gérer les droits ");
		idEmployeEcrit = new JLabel("Id employé");
		nouvelleFonctionEcrit = new JLabel("Nouvelle fonction");
		nouveauDepartementEcrit = new JLabel("Nouveau département");

		boutonValider = new JButton("Valider");
		final JComboBox menuDeroulantFonction =  new JComboBox(fonctionEmploye);
		final JTextField barreIdEmploye = new JTextField();
		final JComboBox menuDeroulantDepartement = new JComboBox(departementEmploye);
		menuDeroulantFonction.setFont(styleEcriture);;

		barreIdEmploye.setFont(styleEcriture);
		gererLesDroitsEcrits.setFont(styleEcriture);
		idEmployeEcrit.setFont(styleEcriture);
		nouvelleFonctionEcrit.setFont(styleEcriture);
		boutonValider.setFont(styleEcriture);
		menuDeroulantDepartement.setFont(styleEcriture);
		nouveauDepartementEcrit.setFont(styleEcriture);

		gererLesDroitsEcrits.setBounds(149, 0, 148, 36);
		idEmployeEcrit.setBounds(10, 58, 115, 36);
		barreIdEmploye.setBounds(186, 60, 105, 36);
		nouvelleFonctionEcrit.setBounds(10, 125, 165, 36);		
		boutonValider.setBounds(398, 118, 122, 51);
		menuDeroulantFonction.setBounds(186, 122, 154, 42);
		menuDeroulantDepartement.setBounds(186, 192, 154, 42);
		nouveauDepartementEcrit.setBounds(10, 192, 165, 36);
		barreIdEmploye.setColumns(10);

		contenuDeLaFenetre.add(gererLesDroitsEcrits);
		contenuDeLaFenetre.add(idEmployeEcrit);
		contenuDeLaFenetre.add(barreIdEmploye);
		contenuDeLaFenetre.add(nouvelleFonctionEcrit);
		contenuDeLaFenetre.add(boutonValider);
		contenuDeLaFenetre.add(menuDeroulantFonction);
		contenuDeLaFenetre.add(menuDeroulantDepartement);
		contenuDeLaFenetre.add(nouveauDepartementEcrit);

		barreIdEmploye.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent appuyerTouche) {
				char caractere = appuyerTouche.getKeyChar();
				if(!(Character.isDigit(caractere)) || (caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE) || barreIdEmploye.getText().length() >= 3 ){
					appuyerTouche.consume();
					if(!((caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE))){
						java.awt.Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		});

		boutonValider.addActionListener(clickBoutton -> {

			ConnectionFactory connectionBDPourChangerFonction = new ConnectionFactory(nomBDD, username, motDePasseBDD);

			try {
				int choix = JOptionPane.showConfirmDialog(null,"Voulez vous modifier sa fonction/son département ?", "Confirmation",JOptionPane.YES_NO_OPTION);	
				if(choix==0) {
					connectionBDPourChangerFonction.requeteAFaire.addBatch(RequeteSQLCyberCar.UPDATE_FONCTION_UTILISATEUR_TABLE_EMPLOYE(barreIdEmploye.getText(), menuDeroulantFonction.getSelectedItem().toString()));
					connectionBDPourChangerFonction.requeteAFaire.addBatch(RequeteSQLCyberCar.UPDATE_FONCTION_UTILISATEUR_TABLE_LOGIN(barreIdEmploye.getText(), menuDeroulantFonction.getSelectedItem().toString()));
					connectionBDPourChangerFonction.requeteAFaire.addBatch(RequeteSQLCyberCar.UPDATE_DEPARTEMENT_UTILISATEUR_TABLE_EMPLOYE(barreIdEmploye.getText(), menuDeroulantDepartement.getSelectedItem().toString()));
					connectionBDPourChangerFonction.requeteAFaire.executeBatch();
				}

			} catch (SQLException requeteNonValide) {
				requeteNonValide.printStackTrace();
				JOptionPane.showMessageDialog(null, "Fonction dans l'entreprise non trouvable"); 
			}


		});
	}
}
