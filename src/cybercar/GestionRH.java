package CyberCar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTabbedPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * 
 * @author keneth
 *
 */
public class GestionRH {

	 JFrame secondFrame;
	 
	 private static Connection conn;
		private static PreparedStatement pst;
		private static ResultSet rst = null;
	 
	private JTextField textNom;
	private JTextField textMedical;
	private JTextField textNbEnfant;
	private JTextField textConjugale;
	private JTextField textMail;
	
	private JTextField textTelephone;
	public JTextField textNomJeuneFille;
	private JTextField textLogin;
	public JPasswordField passwordField;
	private JTextField textAdresse;
	
	private JTextField textPrenom;
	private JTextField textCongesRestant;
	private JTextField textNombreConges;
	private JTextField textSalaire;
	
	private JComboBox<Object> departementBox;
	private JDateChooser dateFin;
	private JDateChooser dateEmbauche;
	
	String[] departement = {"Administration", "Marketing Ventes", "Comptabilité et Finance","Ressources Humaines","Garage & Réparation"};
	String[] fonctionList= {"vendeur", "garagiste","recruteur"};
	
	private JRadioButton rdbtnMonsieur;
	private JRadioButton rdbtnMadame_1;
	private JPanel panel_2;
	private JComboBox<Object> fonctionBox;
	
	public String 
					nomTxt, 
					prenomTxt,
					medicalTxt,
					civilite,
					conjugaleTxt,
					mailTxt,
					jeuneFilleTxt,
					loginTxt,
					adresseTxt,
					fonctionTxt,
					departementTxt,
					passWordTxt, nbCongeTxt, congeRestantTxt, 
					nbEnfatntTxt,salaireTxt,dateEmbaucheTxt, dateFinTxt,telTxt;
	
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel panel_1;
	private JTable table;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionRH window = new GestionRH();
					window.secondFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionRH() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		secondFrame = new JFrame();
		secondFrame.getContentPane().setBackground(new Color(25, 25, 112));
		secondFrame.setBounds(100, 100, 1299, 787);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(462, 10, 365, 82);
		panel_3.setBackground(Color.ORANGE);
		secondFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("GESTION DES  EMPLOYES");
		lblNewLabel_8.setBounds(37, 10, 286, 51);
		panel_3.add(lblNewLabel_8);
		lblNewLabel_8.setBackground(new Color(255, 200, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 74, 1265, 654);
		secondFrame.getContentPane().add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(34, 41, 161, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(34, 158, 161, 27);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblAdresse);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(34, 195, 161, 27);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(34, 245, 161, 27);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblMotDePasse);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(34, 83, 161, 27);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblPrnom);
		
		textNom = new JTextField();
		textNom.setBounds(194, 46, 161, 28);
		panel_1.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9partement");
		lblNewLabel_1.setBounds(34, 303, 112, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Civilit\u00E9");
		lblNewLabel_1_1.setBounds(37, 11, 65, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_1_1_2.setBounds(34, 353, 112, 20);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Mail");
		lblNewLabel_1_1_3.setBounds(34, 393, 112, 20);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Situation conugale");
		lblNewLabel_1_1_4.setBounds(34, 437, 140, 20);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Nombre d'enfant");
		lblNewLabel_1_1_5.setBounds(34, 486, 140, 20);
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Ant\u00E9cedant medical");
		lblNewLabel_1_1_6.setBounds(34, 530, 177, 20);
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_6);
		
		textMedical = new JTextField();
		textMedical.setBounds(194, 522, 161, 27);
		panel_1.add(textMedical);
		textMedical.setColumns(10);
		
		textNbEnfant = new JTextField();
		textNbEnfant.setBounds(194, 486, 161, 23);
		panel_1.add(textNbEnfant);
		textNbEnfant.setColumns(10);
		
		textConjugale = new JTextField();
		textConjugale.setBounds(194, 430, 161, 27);
		panel_1.add(textConjugale);
		textConjugale.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(194, 392, 161, 27);
		panel_1.add(textMail);
		textMail.setColumns(10);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(194, 352, 161, 27);
		panel_1.add(textTelephone);
		textTelephone.setColumns(10);
		
		textLogin = new JTextField();
		textLogin.setBounds(194, 195, 161, 27);
		panel_1.add(textLogin);
		textLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 245, 161, 26);
		panel_1.add(passwordField);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(194, 161, 161, 26);
		panel_1.add(textAdresse);
		textAdresse.setColumns(10);
		
		rdbtnMonsieur = new JRadioButton("M.");
		rdbtnMonsieur.setBounds(141, 10, 54, 23);
		rdbtnMonsieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMonsieur.isSelected() /*&& rdbtnMadame.isSelected()*/) {
					rdbtnMadame_1.setSelected(false);
					panel_2.setVisible(false);
					civilite = "monsieur";
					jeuneFilleTxt	= "";
					
					
					
				}
			}
		});
		
		
		rdbtnMonsieur.setBackground(new Color(230, 230, 250));
		rdbtnMonsieur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(rdbtnMonsieur);
		
		
		
		rdbtnMadame_1 = new JRadioButton("Mme");
		rdbtnMadame_1.setBounds(194, 10, 103, 21);
		rdbtnMadame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMadame_1.isSelected()) {
					rdbtnMonsieur.setSelected(false);
					panel_2.setVisible(true);
					civilite = "madame";
				
					
					
				}
				
				
				
			}
		});
		
		
		
		rdbtnMadame_1.setBackground(new Color(230, 230, 250));
		rdbtnMadame_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(rdbtnMadame_1);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(194, 86, 161, 26);
		panel_1.add(textPrenom);
		textPrenom.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(21, 120, 335, 39);
		panel_2.setBackground(new Color(230, 230, 250));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de jeune fille");
		lblNewLabel_1_1_1.setBackground(new Color(230, 230, 250));
		lblNewLabel_1_1_1.setBounds(10, 10, 140, 20);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textNomJeuneFille = new JTextField();
		textNomJeuneFille.setBounds(175, 10, 158, 23);
		panel_2.add(textNomJeuneFille);
		textNomJeuneFille.setColumns(10);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(286, 250, 29, 21);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Fonction");
		lblNewLabel_2.setBounds(444, 46, 121, 27);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date d'embauche");
		lblNewLabel_3.setBounds(443, 92, 148, 18);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salaire");
		lblNewLabel_4.setBounds(444, 129, 161, 27);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de cong\u00E9s");
		lblNewLabel_5.setBounds(444, 180, 198, 27);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cong\u00E9s restants");
		lblNewLabel_6.setBounds(444, 230, 161, 27);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date de fin de contrat");
		lblNewLabel_7.setBounds(444, 284, 183, 27);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_7);
		
		textCongesRestant = new JTextField();
		textCongesRestant.setBounds(635, 230, 166, 27);
		textCongesRestant.setColumns(10);
		panel_1.add(textCongesRestant);
		
		textNombreConges = new JTextField();
		textNombreConges.setBounds(635, 180, 166, 27);
		textNombreConges.setColumns(10);
		panel_1.add(textNombreConges);
		
		textSalaire = new JTextField();
		textSalaire.setBounds(635, 132, 166, 27);
		textSalaire.setColumns(10);
		panel_1.add(textSalaire);
		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.setBounds(444, 530, 177, 63);
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				nomTxt			=	textNom      		.getText();
				prenomTxt		=	textPrenom   		.getText();
				adresseTxt		=	textAdresse			.getText();
				loginTxt		=	textLogin			.getText();
				medicalTxt		=	textMedical  		.getText();
		//		passWordTxt		=   new String(passwordField.getPassword());
				passWordTxt		=   passwordField.getText();
				conjugaleTxt	=	textConjugale		.getText();
				mailTxt			=	textMail			.getText();				
				nbEnfatntTxt	=	textNbEnfant		.getText();				
				telTxt			= 	textTelephone		.getText();
				nbCongeTxt		= 	textNombreConges	.getText();
				congeRestantTxt	= 	textCongesRestant	.getText(); 
				dateFinTxt		= 	sdf.format(dateFin.getDate());
				dateEmbaucheTxt	= 	sdf.format(dateEmbauche.getDate());
				salaireTxt		= 	textSalaire			.getText();
				
				if (rdbtnMadame_1.isSelected()) {
					
					jeuneFilleTxt	=	textNomJeuneFille	.getText();
				}
				
				
				Employe emp		= new Employe(nomTxt, prenomTxt, adresseTxt, loginTxt,	passWordTxt, departementTxt, civilite, 	jeuneFilleTxt, telTxt, mailTxt,
											  conjugaleTxt, nbEnfatntTxt, medicalTxt,   fonctionTxt, dateEmbaucheTxt, salaireTxt, nbCongeTxt, congeRestantTxt, dateFinTxt ); 
						
				System.out.println(nomTxt +"\n"+ prenomTxt+"\n"+  adresseTxt+"\n"+loginTxt +"\n"+ passWordTxt
						+"\n"+ departementTxt+"\n"+  civilite+"\n"+jeuneFilleTxt +"\n"+ telTxt +"\n"+ mailTxt
						+"\n"+ conjugaleTxt+"\n"+  nbEnfatntTxt+"\n"+medicalTxt +"\n"+ fonctionTxt +"\n"+ dateEmbaucheTxt
						+"\n"+ salaireTxt+"\n"+medicalTxt +"\n"+ nbCongeTxt +"\n"+ congeRestantTxt +"\n"+ dateFinTxt);
				
						try {
						DBUtil.addEmploye(emp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
					
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 127));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_2);
		
		dateEmbauche = new JDateChooser();
		dateEmbauche.setBounds(635, 92, 166, 27);
		panel_1.add(dateEmbauche);
		
		dateFin = new JDateChooser();
		dateFin.setBounds(637, 284, 166, 27);
		panel_1.add(dateFin);
		
		departementBox = new JComboBox<Object>(departement);
		departementBox.setBounds(194, 302, 161, 27);
		departementBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==departementBox) {
					departementTxt= (String) departementBox.getSelectedItem();
					System.out.println(departementTxt);
					
					
					}
			}
		});
		panel_1.add(departementBox);
		
		fonctionBox = new JComboBox<Object>(fonctionList);
		fonctionBox.setBounds(635, 49, 166, 27);
		fonctionBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if( e.getSource()==fonctionBox  ) {
					fonctionTxt = (String) fonctionBox.getSelectedItem();
					System.out.println(fonctionTxt);
					}
			}
		});
		panel_1.add(fonctionBox);
		
		tabbedPane.addTab("Nouveau employé", panel_1);
		
		JButton btnNouveaEmploye = new JButton("Nouveau employ\u00E9");
		btnNouveaEmploye.setBounds(-174, -14, 121, 38);
		panel_1.add(btnNouveaEmploye);
		btnNouveaEmploye.setBackground(new Color(210, 180, 140));
		btnNouveaEmploye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField textiD = new JTextField();
		textiD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id = textiD.getText();					
				try {
					
		conn = ConnectionFactory.getConnection();		
		pst = conn.prepareStatement("SELECT nom, prenom, adresse, login, motDePasse, nomDeJeuneFille, telephone, mail, situationConjugale, nombreEnfants, entecedantMedicale,  dateEmbauche, salaire, nombreConge, nombreCongeRestant, dateFinContrat, departement, fonction from employe where id_employé= ?");
		pst.setString(1, id);	
		rst= pst.executeQuery();
		
				if(rst.next()==true) {
							
							nomTxt			= rst.getString(1);
							prenomTxt		= rst.getString(2);
							adresseTxt		= rst.getString(3);
							loginTxt		= rst.getString(4);
							passWordTxt 	= rst.getString(5);
							jeuneFilleTxt	= rst.getString(6);
							telTxt			= rst.getString(7);
							mailTxt 		= rst.getString(8);
							conjugaleTxt 	= rst.getString(9);
							nbEnfatntTxt	= rst.getString(10);
							medicalTxt 		= rst.getString(11);
							dateEmbaucheTxt = rst.getString(12);
							salaireTxt 		= rst.getString(13);
							nbCongeTxt  	= rst.getString(14);
							congeRestantTxt = rst.getString(15);
							dateFinTxt  	= rst.getString(16);
							departementTxt= rst.getString(17);
							int deptId = 0;
							fonctionTxt = rst.getString(18);
							int fonctionId = 0;
							
							for (int i = 0; i < departement.length; i++) {
								if(departement[i].equals(departementTxt)) {
									deptId = i;
								}
							}
							

							for (int i = 0; i < fonctionList.length; i++) {
								if(fonctionList[i].equals(fonctionTxt)) {
									fonctionId = i;
								}
							}
							
							Date dateEm = new SimpleDateFormat("yyyy-MM-dd").parse(dateEmbaucheTxt);
							
							dateEmbauche.setDate(dateEm);
							
							departementBox.setSelectedIndex(deptId);
							fonctionBox.setSelectedIndex(fonctionId);
							
							textNom				.setText(nomTxt);
							textPrenom			.setText(prenomTxt);
							textAdresse			.setText(adresseTxt);
							textLogin			.setText(loginTxt);
							textNomJeuneFille	.setText(jeuneFilleTxt);
							passwordField		.setText(passWordTxt);
							textTelephone		.setText(telTxt);
							textMail			.setText(mailTxt);
							textConjugale		.setText(conjugaleTxt);
							textNbEnfant		.setText(nbEnfatntTxt);
							textSalaire			.setText(salaireTxt);
							textNombreConges	.setText(nbCongeTxt);
							textCongesRestant	.setText(congeRestantTxt);
							textMedical			.setText(medicalTxt);
							dateEmbauche		.setDateFormatString(dateEmbaucheTxt);
							dateFin				.setDateFormatString(dateFinTxt);
			
				}else {
					textNom.setText("");
					textPrenom.setText("");
					textAdresse.setText("");
					textLogin.setText("");
					passwordField.setText("");
					textTelephone.setText("");
					textMail.setText("");
					textConjugale.setText("");
					textNbEnfant.setText("");
					textSalaire.setText("");
					textNombreConges.setText("");
					textCongesRestant.setText("");
					textMedical.setText("");
				}
							
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
			}
		});
		textiD.setBounds(755, 464, 96, 39);
		panel_1.add(textiD);
		textiD.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("ID employ\u00E9 :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(635, 467, 110, 39);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Aplliquer la Modification");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				nomTxt			=	textNom      		.getText();
				prenomTxt		=	textPrenom   		.getText();
				adresseTxt		=	textAdresse			.getText();
				loginTxt		=	textLogin			.getText();
				medicalTxt		=	textMedical  		.getText();
		//		passWordTxt		=   new String(passwordField.getPassword());
				passWordTxt		=   passwordField.getText();
				conjugaleTxt	=	textConjugale		.getText();
				mailTxt			=	textMail			.getText();				
				nbEnfatntTxt	=	textNbEnfant		.getText();				
				telTxt			= 	textTelephone		.getText();
				nbCongeTxt		= 	textNombreConges	.getText();
				congeRestantTxt	= 	textCongesRestant	.getText(); 
				dateFinTxt		= 	sdf.format(dateFin.getDate());
				dateEmbaucheTxt	= 	sdf.format(dateEmbauche.getDate());
				salaireTxt		= 	textSalaire			.getText();
				
				if (rdbtnMadame_1.isSelected()) {
					
					jeuneFilleTxt	=	textNomJeuneFille	.getText();
				}
				
				Employe employe		= new Employe(nomTxt, prenomTxt, adresseTxt, loginTxt,	passWordTxt, departementTxt, civilite, 	jeuneFilleTxt, telTxt, mailTxt,
						conjugaleTxt, nbEnfatntTxt, medicalTxt,   fonctionTxt, dateEmbaucheTxt, salaireTxt, nbCongeTxt, congeRestantTxt, dateFinTxt ); 
				
				String id_employé = textiD.getText();
				employe.setId(id_employé);
				
				System.out.println("1-" +nomTxt +"\n2-"+ prenomTxt+"\n3-"+  adresseTxt+"\n4-"+loginTxt +"\n5-"+ passWordTxt
						+"\n6-"+ departementTxt+"\n7-"+  civilite+"\n8-"+jeuneFilleTxt +"\n9-"+ telTxt +"\n10-"+ mailTxt
						+"\n11-"+ conjugaleTxt+"\n12-"+  nbEnfatntTxt+"\n13-"+medicalTxt +"\n14-"+ fonctionTxt +"\n15-"+ dateEmbaucheTxt
						+"\n16-"+ salaireTxt+"\n17-"+medicalTxt +"\n18-"+ nbCongeTxt +"\n19-"+ congeRestantTxt +"\n20-"+ dateFinTxt);
				
						try {
						DBUtil.updateEmploye(employe);
						System.out.println("La modification EST faite");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(662, 531, 251, 68);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer l'employ\u00E9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Employe  emp = new Employe();
								
								
								String id = textiD.getText();
								emp.setId(id);
								
								try {
									DBUtil.deleteEmploye(emp);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(945, 531, 252, 68);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Liste employé", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Actualiser");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conn = ConnectionFactory.getConnection();		
//					nom, prenom, , login, telephone, mail, nombreConge, nombreCongeRestant
					pst = conn.prepareStatement("SELECT id_employé, nom, prenom, mail, adresse, telephone, departement, fonction, salaire, nombreConge, nombreCongeRestant from employe");
						 
					rst= pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rst)); 
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(977, 58, 220, 42);
		panel_4.add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 132, 1164, 470);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_10 = new JLabel("LISTE DES EMPLOYES");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(50, 58, 205, 55);
		panel_4.add(lblNewLabel_10);

		
	}
}
