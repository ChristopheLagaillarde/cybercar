package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class FenetreConfirmationVente extends JFrame {

	public void afficherVoiture(DefaultTableModel tableauVoitureBackend) {
		ConnectionFactory connectionBDPourAfficherVoiture = null;
		ResultSet resultatSelectVoiture = null;
		Object[] donneeDe1Voiture = new Object[11];

		connectionBDPourAfficherVoiture = new ConnectionFactory(nomBDD, username, motDePasseBDD);
		try {
			resultatSelectVoiture = connectionBDPourAfficherVoiture.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_TOUTES_VOITURES());
			while(resultatSelectVoiture.next()) {
				donneeDe1Voiture[0] =  resultatSelectVoiture.getString("id_voiture");
				donneeDe1Voiture[1] =  resultatSelectVoiture.getString("Marque");
				donneeDe1Voiture[2] =  resultatSelectVoiture.getString("Modèle");
				donneeDe1Voiture[3] =  resultatSelectVoiture.getString("Couleur");
				donneeDe1Voiture[4] =  resultatSelectVoiture.getString("Année_de_production");
				donneeDe1Voiture[5] =  resultatSelectVoiture.getString("Transmission");
				donneeDe1Voiture[6] =  resultatSelectVoiture.getString("Type_de_carburant");
				donneeDe1Voiture[7] =  resultatSelectVoiture.getString("Date_de_livraison");
				donneeDe1Voiture[8] =  resultatSelectVoiture.getString("Pays_de_provenance");
				donneeDe1Voiture[9] =  resultatSelectVoiture.getString("Prix");
				donneeDe1Voiture[10] = resultatSelectVoiture.getString("Entrepôt");
				tableauVoitureBackend.addRow(donneeDe1Voiture);
			}
		} catch (SQLException echecRequeteSelectVoiture) {
			JOptionPane.showMessageDialog(null, "Echec de la requete pour selectionner toutes les voitures");
			echecRequeteSelectVoiture.printStackTrace();
		}		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenuFenetre;
	String nomBDD = "cybercar";//"sql11497241";
	String username = "root";//"sql11497241";
	String motDePasseBDD = "";//"9B2cyk9VAv";
	private JTable tableauVoiture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetreConfirmationVente maFenetreConfirmationVente = new FenetreConfirmationVente(args);
				maFenetreConfirmationVente.setVisible(true);
			} catch (Exception crashFenetre) {
				JOptionPane.showMessageDialog(null,"La fenetre confirmation vente a crash");
				crashFenetre.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreConfirmationVente(String[] args) {
		setBounds(100, 100, 836, 478);
		setTitle("Vente voiture");
		contenuFenetre = new JPanel();
		contenuFenetre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenuFenetre);
		contenuFenetre.setLayout(null);

		Font styleEcriture = new Font("Arial", Font.BOLD, 18);


		JLabel idClientEcrit = null;
		JLabel idVoitureEcrit = null;
		JButton boutonValider = null;

		idClientEcrit = new JLabel("ID client");
		idVoitureEcrit = new JLabel("ID voiture");
		boutonValider = new JButton("Valider");
		final JTextField barreIdClient = new JTextField();
		final JTextField barreIdVoiture = new JTextField();

		idClientEcrit.setFont(styleEcriture);
		idVoitureEcrit.setFont(styleEcriture);
		boutonValider.setFont(styleEcriture);
		barreIdClient.setFont(styleEcriture);
		barreIdVoiture.setFont(styleEcriture);

		idClientEcrit.setBounds(22, 14, 102, 29);
		idVoitureEcrit.setBounds(263, 14, 85, 29);
		boutonValider.setBounds(614, 14, 110, 29);
		barreIdClient.setBounds(104, 18, 102, 20);
		barreIdVoiture.setBounds(358, 18, 85, 20);

		barreIdClient.setColumns(10);
		barreIdVoiture.setColumns(10);

		contenuFenetre.add(idClientEcrit);
		contenuFenetre.add(idVoitureEcrit);
		contenuFenetre.add(boutonValider);
		contenuFenetre.add(barreIdClient);
		contenuFenetre.add(barreIdVoiture);

		JScrollPane barreDeDefilement = new JScrollPane();
		barreDeDefilement.setBounds(10, 53, 789, 375);
		contenuFenetre.add(barreDeDefilement);

		// Affiche le tableau, doit être dans cette ordre sinon ne marche pas
		Object[]  titre = {"id_voiture","Marque","Modèle","Couleur","Année_de_production","Transmission","Type_de_carburant","Date_de_livraison","Pays_de_provenance", "Prix", "Entrepôt"};
		DefaultTableModel tableauVoitureBackend = new DefaultTableModel();
		tableauVoitureBackend.setColumnIdentifiers(titre);
		tableauVoiture = new JTable(tableauVoitureBackend);
		barreDeDefilement.setViewportView(tableauVoiture);	
		afficherVoiture(tableauVoitureBackend);

		barreIdClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent appuyerTouche) {
				char caractere = appuyerTouche.getKeyChar();
				if(!(Character.isDigit(caractere)) || (caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE) || barreIdClient.getText().length() >= 3 ){
					appuyerTouche.consume();
					if(!((caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE))){
						java.awt.Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		});

		barreIdVoiture.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent appuyerTouche) {
				char caractere = appuyerTouche.getKeyChar();
				if(!(Character.isDigit(caractere)) || (caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE) || barreIdVoiture.getText().length() >= 3 ){
					appuyerTouche.consume();
					if(!((caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE))){
						java.awt.Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		});

		boutonValider.addActionListener(clickBouton ->{

			try {
				ConnectionFactory connectionBDPourConfirmerVente = null;	

				int choix = JOptionPane.showConfirmDialog(null,"Voulez vous vraiement éffectuer cette vente ?", "Confirmation",JOptionPane.YES_NO_OPTION);	
				if(choix==0) {
					GererFichier.sauvegarderVenteDansFichierLog("logVente.cryp", args[0], barreIdVoiture.getText(), barreIdClient.getText());
					String donneFacure[] = {barreIdClient.getText(), args[0], barreIdVoiture.getText()};
					GenereFacturePdf.main(donneFacure);
					connectionBDPourConfirmerVente = new ConnectionFactory(nomBDD, username, motDePasseBDD);
					if(!GenereFacturePdf.nomPrenomClient(barreIdClient.getText())[0].equals("Client inexistant")) {
						connectionBDPourConfirmerVente.requeteAFaire.executeUpdate(RequeteSQLCyberCar.DELETE_VOITURE_TABLE_VOITURE(barreIdVoiture.getText()));				
						tableauVoitureBackend.setRowCount(0);
						afficherVoiture(tableauVoitureBackend); 
					}

				}
			} catch (Exception requeteNonValide) {
				requeteNonValide.printStackTrace();
				JOptionPane.showMessageDialog(null, "Echec requete confirmation vente"); 
				requeteNonValide.printStackTrace();
			}
		});

	}
}
