package cybercar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;



public class Entrepot {

	private JFrame frame;
	private JTable Gestion_voiture;
	private JTextField textFieldMarque;
	private JTextField textFieldModele;
	private JTextField textFieldCouleur;
	private JTextField textFieldAnnee;
	private JTextField textFieldTransmission;
	private JTextField textFieldPays;
	private JTextField textFieldPrix;
	private JTextField textFieldEntrepot;
	private JTextField textFieldId1;
	private JTextField textFieldId;
	private JTextField textFieldMarque1;
	private JTextField textFieldModele1;
	private JTextField textFieldCouleur1;
	private JTextField textFieldAnnee1;
	private JTextField textFieldTransmission1;
	private JTextField textFieldPays1;
	private JTextField textFieldPrix1;
	private JTextField textFieldEntrepot1;
	private JTextField textFieldCarburant;
	private JTextField textFieldCarburant1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrepot window = new Entrepot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entrepot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 777, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des entrepot");
		lblNewLabel.setBounds(240, 20, 188, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choisir Entrepot:");
		lblNewLabel_1.setBounds(24, 70, 98, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Plaisance", "Port-Louis", "Baie du tombeau", "Plaisance"}));
		comboBox.setToolTipText("4");
		comboBox.setBounds(132, 66, 102, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Base de donn\u00E9e avec les vehicle d'un entrepot");
		lblNewLabel_2.setBounds(442, 20, 311, 66);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 97, 719, 399);
		frame.getContentPane().add(tabbedPane);
		
		JPanel pnl_voiture = new JPanel();
		tabbedPane.addTab("Gestion de voiture", null, pnl_voiture, null);
		pnl_voiture.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 694, 321);
		pnl_voiture.add(scrollPane);
		
		Gestion_voiture = new JTable();
		scrollPane.setColumnHeaderView(Gestion_voiture);
		
		JButton btn_1 = new JButton("Actualiser");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

			//	String Entrepot = comboBox.getSelectedItem().toString();
				
			//	if( Entrepot = "plaisance" != null != null ) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				//if (comboBox.getSelectedItem().equals("Plaisance"));
				if (comboBox.getSelectedItem() == "Plaisance");
				{
				
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11489524","sql11489524","AKWlgpbHDy");
						
						String sql1 = "Select * From sql11488330.voiture where Entrepôt = 'Plaisance' ";
						PreparedStatement stmt = conn.prepareStatement(sql1);
						ResultSet rs = stmt.executeQuery();
						
						Gestion_voiture.setModel(DbUtils.resultSetToTableModel(rs));
						
					
					} catch(Exception err) {
						System.out.println("Error! Not connected to database" +err);
					}
					
				}
				
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11489524","sql11489524","AKWlgpbHDy");
					
					String sql = "Select * From sql11489524.voiture";
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					Gestion_voiture.setModel(DbUtils.resultSetToTableModel(rs));
					
				
				} catch(Exception err) {
					System.out.println("Error! Not connected to database" +err);
				}
			}
			
			
			
			
			
		});
		btn_1.setBounds(599, 341, 105, 21);
		pnl_voiture.add(btn_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ajouter Voiture", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 704, 362);
		panel_1.add(contentPane);
		
		JButton btnValid = new JButton("Valider");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textFieldMarque.getText().isEmpty()){ 
					JOptionPane.showMessageDialog(null,"la marque ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
					
					
					if (textFieldModele.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"le modèle ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
						
						
					if (textFieldCouleur.getText().isEmpty()){
							JOptionPane.showMessageDialog(null,"la couleur ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
							
							if (textFieldAnnee.getText().isEmpty()){
								JOptionPane.showMessageDialog(null,"l'année ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
								
								if (textFieldTransmission.getText().isEmpty()){ 
									JOptionPane.showMessageDialog(null,"la transmission ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
								
									if (textFieldCarburant.getText().isEmpty()){ 
										JOptionPane.showMessageDialog(null,"le carburant ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
									
									if (textFieldPays.getText().isEmpty()){
										JOptionPane.showMessageDialog(null,"le pays ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
										
										
									if (textFieldPrix.getText().isEmpty()){
											JOptionPane.showMessageDialog(null,"le prix ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
											
											if (textFieldEntrepot.getText().isEmpty()){
												JOptionPane.showMessageDialog(null,"l'entrepot ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
							}
						}
					}
				}
							}
					}
				}
			}
				}
				
				
				
				
				
				
				
				
				String marque = textFieldMarque.getText();
				String modele = textFieldModele.getText();
				String couleur = textFieldCouleur.getText();
				String annee = textFieldAnnee.getText();
				String transmission = textFieldTransmission.getText();
				String carburant = textFieldCarburant.getText();
				String pays = textFieldPays.getText();
				String prix = textFieldPrix.getText();
				String entrepot = textFieldEntrepot.getText();
				
				

				
				       ///// control pour marque ////////
				        
				        if (true) {
				        	int count = 0;

				        	// checking capital letters
				        	for (int i = 65; i <= 90; i++) {

				        	// type casting
				        	char c = (char)i;

				        	String str2 = Character.toString(c);
				        	if (marque.contains(str2.substring(0,1))) {
				        	count = 1;
				        	}
				        	}
				        	if (count == 0) {
				        	//  throw new InvalidPasswordException(5);
				        		
				        		JOptionPane.showMessageDialog(null,"Le nom doit avoir une majuscule a la premier lettre ","Alert",JOptionPane.WARNING_MESSAGE);

				        	}
				        	}

				        
				        
				        if ((marque.contains("@") || marque.contains("#")
					              || marque.contains("!") || marque.contains("~")
					              || marque.contains("$") || marque.contains("%")
					              || marque.contains("^") || marque.contains("&")
					              || marque.contains("*") || marque.contains("(")
					              || marque.contains(")") || marque.contains("-")
					              || marque.contains("+") || marque.contains("/")
					              || marque.contains(":") || marque.contains(".")
					              || marque.contains(", ") || marque.contains("<")
					              || marque.contains(">") || marque.contains("?")
					              || marque.contains("|"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"La marque ne doit pas contenir de caracthere speciaux","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        if ((marque.contains("1") || marque.contains("2")
					              || marque.contains("3") || marque.contains("4")
					              || marque.contains("5") || marque.contains("6")
					              || marque.contains("7") || marque.contains("8")
					              || marque.contains("9") || marque.contains("0"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"La marque ne doit pas contenir des chiffre","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
				        
				        
				        
				        
				        
				        
				      ////////////////////////////////////// control pour transmission //////////////////////////////////////////////
				        
				        
				        
				        

				        if (true) {
				        	int count = 0;

				        	// checking capital letters
				        	for (int i = 65; i <= 90; i++) {

				        	// type casting
				        	char c = (char)i;

				        	String str2 = Character.toString(c);
				        	if (transmission.contains(str2.substring(0,1))) {
				        	count = 1;
				        	}
				        	}
				        	if (count == 0) {
				        	//  throw new InvalidPasswordException(5);
				        		
				        		JOptionPane.showMessageDialog(null,"Le prenom doit avoir une majuscule a la premier lettre ","Alert",JOptionPane.WARNING_MESSAGE);

				        	}
				        	}
				        
				        
				        if ((transmission.contains("@") || transmission.contains("#")
					              || transmission.contains("!") || transmission.contains("~")
					              || transmission.contains("$") || transmission.contains("%")
					              || transmission.contains("^") || transmission.contains("&")
					              || transmission.contains("*") || transmission.contains("(")
					              || transmission.contains(")") || transmission.contains("-")
					              || transmission.contains("+") || transmission.contains("/")
					              || transmission.contains(":") || transmission.contains(".")
					              || transmission.contains(", ") || transmission.contains("<")
					              || transmission.contains(">") || transmission.contains("?")
					              || transmission.contains("|"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"La transmission ne doit pas contenir de caracthere speciaux","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        if ((transmission.contains("1") || transmission.contains("2")
					              || transmission.contains("3") || transmission.contains("4")
					              || transmission.contains("5") || transmission.contains("6")
					              || transmission.contains("7") || transmission.contains("8")
					              || transmission.contains("9") || transmission.contains("0"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"La transmission ne doit pas contenir des chiffre","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
          ///// control pour carburant ////////
				        
				        if (true) {
				        	int count = 0;

				        	// checking capital letters
				        	for (int i = 65; i <= 90; i++) {

				        	// type casting
				        	char c = (char)i;

				        	String str2 = Character.toString(c);
				        	if (carburant.contains(str2.substring(0,1))) {
				        	count = 1;
				        	}
				        	}
				        	if (count == 0) {
				        	//  throw new InvalidPasswordException(5);
				        		
				        		JOptionPane.showMessageDialog(null,"Le carburant doit avoir une majuscule a la premier lettre ","Alert",JOptionPane.WARNING_MESSAGE);

				        	}
				        	}

				        
				        
				        if ((carburant.contains("@") || carburant.contains("#")
					              || carburant.contains("!") || carburant.contains("~")
					              || carburant.contains("$") || carburant.contains("%")
					              || carburant.contains("^") || carburant.contains("&")
					              || carburant.contains("*") || carburant.contains("(")
					              || carburant.contains(")") || carburant.contains("-")
					              || carburant.contains("+") || carburant.contains("/")
					              || carburant.contains(":") || carburant.contains(".")
					              || carburant.contains(", ") || carburant.contains("<")
					              || carburant.contains(">") || carburant.contains("?")
					              || carburant.contains("|"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"Le carburant ne doit pas contenir de caracthere speciaux","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        if ((carburant.contains("1") || carburant.contains("2")
					              || carburant.contains("3") || carburant.contains("4")
					              || carburant.contains("5") || carburant.contains("6")
					              || carburant.contains("7") || carburant.contains("8")
					              || carburant.contains("9") || carburant.contains("0"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"Le carburant doit pas contenir des chiffre","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
				        
				        
				        
				        
				        
				        
				      ////////////////////////////////////// control pour pays //////////////////////////////////////////////
				        
				        
				        
				        

				        if (true) {
				        	int count = 0;

				        	// checking capital letters
				        	for (int i = 65; i <= 90; i++) {

				        	// type casting
				        	char c = (char)i;

				        	String str2 = Character.toString(c);
				        	if (pays.contains(str2.substring(0,1))) {
				        	count = 1;
				        	}
				        	}
				        	if (count == 0) {
				        	//  throw new InvalidPasswordException(5);
				        		
				        		JOptionPane.showMessageDialog(null,"Le pays doit avoir une majuscule a la premier lettre ","Alert",JOptionPane.WARNING_MESSAGE);

				        	}
				        	}
				        
				        
				        if ((pays.contains("@") || pays.contains("#")
					              || pays.contains("!") || pays.contains("~")
					              || pays.contains("$") || pays.contains("%")
					              || pays.contains("^") || pays.contains("&")
					              || pays.contains("*") || pays.contains("(")
					              || pays.contains(")") || pays.contains("-")
					              || pays.contains("+") || pays.contains("/")
					              || pays.contains(":") || pays.contains(".")
					              || pays.contains(", ") || pays.contains("<")
					              || pays.contains(">") || pays.contains("?")
					              || pays.contains("|"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"Le pays ne doit pas contenir de caracthere speciaux","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				        
				        
				        if ((pays.contains("1") || pays.contains("2")
					              || pays.contains("3") || pays.contains("4")
					              || pays.contains("5") || pays.contains("6")
					              || pays.contains("7") || pays.contains("8")
					              || pays.contains("9") || pays.contains("0"))) {
					            // throw new InvalidPasswordException(4);
					        	
					        	JOptionPane.showMessageDialog(null,"Le pays ne doit pas contenir des chiffre","Alert",JOptionPane.WARNING_MESSAGE);

					        }     
				        
				
				
				
				
				
				
				
				
				
				JOptionPane.showMessageDialog(null,"Les données sont entrés dans la base de donné MySQL.", "Reussie", JOptionPane.WARNING_MESSAGE);
				
           Voiture voiture = new Voiture(marque,modele,couleur,annee,transmission,carburant,pays,prix,entrepot);
           
        // 
				
				try {
					DButilEntrepot.addCar(voiture);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null,"Reussie", "Les données sont entrés dans la base de donné MySQL.", JOptionPane.WARNING_MESSAGE);
					
				}
				
				}
		});
		btnValid.setBounds(577, 299, 85, 21);
		contentPane.add(btnValid);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(577, 330, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ajouter voiture");
		lblNewLabel_3.setBounds(236, 10, 100, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marque:");
		lblNewLabel_1_1.setBounds(32, 56, 100, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mod\u00E8le:");
		lblNewLabel_2_1.setBounds(32, 84, 85, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Couleur:");
		lblNewLabel_3_1.setBounds(32, 117, 85, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Ann\u00E9e de production:");
		lblNewLabel_4.setBounds(32, 151, 116, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Transmission:");
		lblNewLabel_5.setBounds(32, 184, 100, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pays de provenance:");
		lblNewLabel_6.setBounds(32, 233, 116, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Prix:");
		lblNewLabel_7.setBounds(32, 268, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Entrep\u00F4t:");
		lblNewLabel_8.setBounds(32, 291, 78, 13);
		contentPane.add(lblNewLabel_8);
		
		textFieldMarque = new JTextField();
		textFieldMarque.setColumns(10);
		textFieldMarque.setBounds(170, 53, 96, 19);
		contentPane.add(textFieldMarque);
		
		textFieldModele = new JTextField();
		textFieldModele.setColumns(10);
		textFieldModele.setBounds(170, 81, 96, 19);
		contentPane.add(textFieldModele);
		
		textFieldCouleur = new JTextField();
		textFieldCouleur.setColumns(10);
		textFieldCouleur.setBounds(170, 114, 96, 19);
		contentPane.add(textFieldCouleur);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setColumns(10);
		textFieldAnnee.setBounds(170, 148, 96, 19);
		contentPane.add(textFieldAnnee);
		
		textFieldTransmission = new JTextField();
		textFieldTransmission.setColumns(10);
		textFieldTransmission.setBounds(170, 181, 96, 19);
		contentPane.add(textFieldTransmission);
		
		textFieldPays = new JTextField();
		textFieldPays.setColumns(10);
		textFieldPays.setBounds(170, 230, 96, 19);
		contentPane.add(textFieldPays);
		
		textFieldPrix = new JTextField();
		textFieldPrix.setColumns(10);
		textFieldPrix.setBounds(170, 265, 96, 19);
		contentPane.add(textFieldPrix);
		
		textFieldEntrepot = new JTextField();
		textFieldEntrepot.setColumns(10);
		textFieldEntrepot.setBounds(170, 288, 96, 19);
		contentPane.add(textFieldEntrepot);
		
		JLabel lblNewLabel_11 = new JLabel("Type carburant:");
		lblNewLabel_11.setBounds(32, 210, 116, 13);
		contentPane.add(lblNewLabel_11);
		
		textFieldCarburant = new JTextField();
		textFieldCarburant.setBounds(170, 204, 96, 19);
		contentPane.add(textFieldCarburant);
		textFieldCarburant.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Modifier Voiture", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_2.setBounds(0, 10, 694, 360);
		panel_2.add(contentPane_2);
		
		JLabel lblNewLabel_10 = new JLabel("Modifier Voiture ");
		lblNewLabel_10.setBounds(201, 10, 114, 13);
		contentPane_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_1_3 = new JLabel("id voiture:");
		lblNewLabel_1_3.setBounds(33, 60, 72, 13);
		contentPane_2.add(lblNewLabel_1_3);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(133, 57, 96, 19);
		contentPane_2.add(textFieldId);
		
		JLabel lblNewLabel_2_2 = new JLabel("Marque:");
		lblNewLabel_2_2.setBounds(33, 89, 55, 13);
		contentPane_2.add(lblNewLabel_2_2);
		
		textFieldMarque1 = new JTextField();
		textFieldMarque1.setColumns(10);
		textFieldMarque1.setBounds(133, 86, 96, 19);
		contentPane_2.add(textFieldMarque1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mod\u00E8le:");
		lblNewLabel_3_2.setBounds(33, 119, 55, 13);
		contentPane_2.add(lblNewLabel_3_2);
		
		textFieldModele1 = new JTextField();
		textFieldModele1.setColumns(10);
		textFieldModele1.setBounds(133, 115, 96, 19);
		contentPane_2.add(textFieldModele1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Couleur:");
		lblNewLabel_4_1.setBounds(33, 154, 72, 13);
		contentPane_2.add(lblNewLabel_4_1);
		
		textFieldCouleur1 = new JTextField();
		textFieldCouleur1.setColumns(10);
		textFieldCouleur1.setBounds(133, 151, 96, 19);
		contentPane_2.add(textFieldCouleur1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Ann\u00E9e de production:");
		lblNewLabel_5_1.setBounds(21, 189, 108, 13);
		contentPane_2.add(lblNewLabel_5_1);
		
		textFieldAnnee1 = new JTextField();
		textFieldAnnee1.setColumns(10);
		textFieldAnnee1.setBounds(133, 186, 96, 19);
		contentPane_2.add(textFieldAnnee1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Transmission:");
		lblNewLabel_6_1.setBounds(33, 224, 72, 13);
		contentPane_2.add(lblNewLabel_6_1);
		
		textFieldTransmission1 = new JTextField();
		textFieldTransmission1.setColumns(10);
		textFieldTransmission1.setBounds(133, 221, 96, 19);
		contentPane_2.add(textFieldTransmission1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Pays de provenance");
		lblNewLabel_7_1.setBounds(33, 261, 96, 13);
		contentPane_2.add(lblNewLabel_7_1);
		
		textFieldPays1 = new JTextField();
		textFieldPays1.setColumns(10);
		textFieldPays1.setBounds(133, 258, 96, 19);
		contentPane_2.add(textFieldPays1);
		
		JButton btnNewButton_3 = new JButton("Valider");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (textFieldId.getText().isEmpty()){ 
					JOptionPane.showMessageDialog(null,"l'id ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
					
				
				if (textFieldMarque1.getText().isEmpty()){ 
					JOptionPane.showMessageDialog(null,"la marque ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
					
					
					if (textFieldModele1.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"le modèle ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
						
						
					if (textFieldCouleur1.getText().isEmpty()){
							JOptionPane.showMessageDialog(null,"la couleur ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
							
							if (textFieldAnnee1.getText().isEmpty()){
								JOptionPane.showMessageDialog(null,"l'année ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
								
								if (textFieldTransmission1.getText().isEmpty()){ 
									JOptionPane.showMessageDialog(null,"la transmission ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
								
									if (textFieldCarburant1.getText().isEmpty()){ 
										JOptionPane.showMessageDialog(null,"le carburant ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
									
									if (textFieldPays1.getText().isEmpty()){
										JOptionPane.showMessageDialog(null,"le pays ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
										
										
									if (textFieldPrix1.getText().isEmpty()){
											JOptionPane.showMessageDialog(null,"le prix ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
											
											if (textFieldEntrepot1.getText().isEmpty()){
												JOptionPane.showMessageDialog(null,"l'entrepot ne doit pas etre vide","Erreur ", JOptionPane.WARNING_MESSAGE); // Empeche les zone de saisie d'etre vide
							}
						}
					}
				}
							}
					}
				}
			}
				}
				}
				
				String marque = textFieldMarque1.getText();
				String modele = textFieldModele1.getText();
				String couleur = textFieldCouleur1.getText();
				String annee = textFieldAnnee1.getText();
				String transmission = textFieldTransmission1.getText();
				String carburant = textFieldCarburant1.getText();
				String pays = textFieldPays1.getText();
				String prix = textFieldPrix1.getText();
				String entrepot = textFieldEntrepot1.getText();
				String id_voiture = textFieldId.getText();
				
				JOptionPane.showMessageDialog(null,"Les données sont entrés dans la base de donnée MySQL.", "Reussie", JOptionPane.WARNING_MESSAGE);
				
           Voiture voiture = new Voiture(marque,modele,couleur,annee,transmission,carburant,pays,prix,entrepot);
				
           voiture.setid_voiture(id_voiture);
			
			try {
				DButilEntrepot.updateCar(voiture);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				JOptionPane.showMessageDialog(null,"Reussie", "Les données ont été modifié dans la base de donnée MySQL.", JOptionPane.WARNING_MESSAGE);
				
			
				
			}	
			}
		});
		btnNewButton_3.setBounds(421, 303, 85, 21);
		contentPane_2.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("Retour");
		btnNewButton_1_2.setBounds(421, 334, 85, 21);
		contentPane_2.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_8_1 = new JLabel("Prix:");
		lblNewLabel_8_1.setBounds(333, 89, 45, 13);
		contentPane_2.add(lblNewLabel_8_1);
		
		textFieldPrix1 = new JTextField();
		textFieldPrix1.setColumns(10);
		textFieldPrix1.setBounds(397, 86, 96, 19);
		contentPane_2.add(textFieldPrix1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Entrep\u00F4t:");
		lblNewLabel_9_1.setBounds(321, 119, 55, 13);
		contentPane_2.add(lblNewLabel_9_1);
		
		textFieldEntrepot1 = new JTextField();
		textFieldEntrepot1.setColumns(10);
		textFieldEntrepot1.setBounds(397, 116, 96, 19);
		contentPane_2.add(textFieldEntrepot1);
		
		textFieldCarburant1 = new JTextField();
		textFieldCarburant1.setBounds(397, 57, 96, 19);
		contentPane_2.add(textFieldCarburant1);
		textFieldCarburant1.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Type Carburant");
		lblNewLabel_12.setBounds(294, 60, 72, 13);
		contentPane_2.add(lblNewLabel_12);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Retirer Voiture", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 704, 362);
		panel_3.add(contentPane_1);
		
		JLabel lblNewLabel_9 = new JLabel("Retirer voiture");
		lblNewLabel_9.setBounds(228, 20, 139, 13);
		contentPane_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1_2 = new JLabel("Veuillez entrer l'id de la voiture:");
		lblNewLabel_1_2.setBounds(52, 102, 184, 13);
		contentPane_1.add(lblNewLabel_1_2);
		
		textFieldId1 = new JTextField();
		textFieldId1.setColumns(10);
		textFieldId1.setBounds(271, 99, 96, 19);
		contentPane_1.add(textFieldId1);
		
		JButton btnNewButton_2 = new JButton("Valider");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	String Id = textFieldId1.getText();
				
				Voiture voiture = new Voiture();
				
				 voiture.setid_voiture(Id);
				 
				 JOptionPane.showMessageDialog(null,"Les données sont supprimés de la base de donné MySQL.", "Reussie", JOptionPane.WARNING_MESSAGE);
			
		
				 
				 try {
						DButilEntrepot.deleteCar(voiture);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_2.setBounds(457, 285, 85, 21);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Retour");
		btnNewButton_1_1.setBounds(457, 332, 85, 21);
		contentPane_1.add(btnNewButton_1_1);
	
		
		
		
		
}
}



