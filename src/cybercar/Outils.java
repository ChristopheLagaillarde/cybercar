package cybercar;

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
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;


public class Outils {

	 JFrame secondFrame;
	 
	private JTextField textNom;
	private JTextField textMedical;
	private JTextField textNbEnfant;
	private JTextField textConjugale;
	private JTextField textMail;
	
	private JTextField textTelephone;
	private JTextField textNomJeuneFille;
	private JTextField textLogin;
	private JPasswordField passwordField;
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
	
	private String 
					nomTxt, 
					prenomTxt,
					medicalTxt,
					conjugaleTxt,
					mailTxt,
					jeuneFilleTxt="null",
					loginTxt,
					adresseTxt,
					fonctionTxt,
					departementTxt,
					passWordTxt;
	
	
	private int nbCongeTxt, congeRestantTxt, nbEnfatntTxt,telTxt;
	private float salaireTxt;
	private Date dateEmbaucheTxt, dateFinTxt;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Outils window = new Outils();
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
	public Outils() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		secondFrame = new JFrame();
		secondFrame.getContentPane().setBackground(new Color(25, 25, 112));
		secondFrame.setBounds(100, 100, 1069, 740);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 50, 203, 632);
		secondFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNouveaEmploye = new JButton("Nouveau employ\u00E9");
		btnNouveaEmploye.setBackground(new Color(210, 180, 140));
		btnNouveaEmploye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNouveaEmploye.setBounds(10, 10, 189, 38);
		panel.add(btnNouveaEmploye);
		
		JButton btnNewButton = new JButton("Gestionnaire salaire");
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 167, 189, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Liste employ\u00E9");
		btnNewButton_1.setBackground(new Color(210, 180, 140));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 78, 183, 38);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(223, 50, 908, 632);
		secondFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 41, 161, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdresse.setBounds(34, 158, 161, 27);
		panel_1.add(lblAdresse);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(34, 195, 161, 27);
		panel_1.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMotDePasse.setBounds(34, 245, 161, 27);
		panel_1.add(lblMotDePasse);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom.setBounds(34, 83, 161, 27);
		panel_1.add(lblPrnom);
		
		textNom = new JTextField();
		textNom.setBounds(194, 46, 161, 28);
		panel_1.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9partement");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(34, 303, 112, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Civilit\u00E9");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(37, 11, 65, 20);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(34, 353, 112, 20);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Mail");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(34, 393, 112, 20);
		panel_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Situation conugale");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(34, 437, 140, 20);
		panel_1.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Nombre d'enfant");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_5.setBounds(34, 486, 140, 20);
		panel_1.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Ant\u00E9cedant medical");
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_6.setBounds(34, 530, 177, 20);
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
		textLogin.setBounds(194, 201, 161, 21);
		panel_1.add(textLogin);
		textLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 250, 161, 21);
		panel_1.add(passwordField);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(194, 161, 161, 26);
		panel_1.add(textAdresse);
		textAdresse.setColumns(10);
		
		rdbtnMonsieur = new JRadioButton("M.");
		rdbtnMonsieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMonsieur.isSelected() /*&& rdbtnMadame.isSelected()*/) {
					rdbtnMadame_1.setSelected(false);
					panel_2.setVisible(false);
					
					
					
				}
			}
		});
		
		
		rdbtnMonsieur.setBackground(new Color(230, 230, 250));
		rdbtnMonsieur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMonsieur.setBounds(141, 10, 54, 23);
		panel_1.add(rdbtnMonsieur);
		
		
		
		rdbtnMadame_1 = new JRadioButton("Mme");
		rdbtnMadame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMadame_1.isSelected()) {
					rdbtnMonsieur.setSelected(false);
					panel_2.setVisible(true);
					
				}
				
				
				
			}
		});
		
		
		
		rdbtnMadame_1.setBackground(new Color(230, 230, 250));
		rdbtnMadame_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMadame_1.setBounds(194, 10, 103, 21);
		panel_1.add(rdbtnMadame_1);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(194, 86, 161, 26);
		panel_1.add(textPrenom);
		textPrenom.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(21, 120, 335, 39);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(286, 250, 29, 21);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Fonction");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(444, 46, 121, 27);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date d'embauche");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(443, 92, 148, 18);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salaire");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(444, 129, 161, 27);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de cong\u00E9s");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(444, 180, 198, 27);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cong\u00E9s restants");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(444, 230, 161, 27);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date de fin de contrat");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(444, 284, 183, 27);
		panel_1.add(lblNewLabel_7);
		
		textCongesRestant = new JTextField();
		textCongesRestant.setColumns(10);
		textCongesRestant.setBounds(635, 237, 166, 20);
		panel_1.add(textCongesRestant);
		
		textNombreConges = new JTextField();
		textNombreConges.setColumns(10);
		textNombreConges.setBounds(635, 187, 166, 20);
		panel_1.add(textNombreConges);
		
		textSalaire = new JTextField();
		textSalaire.setColumns(10);
		textSalaire.setBounds(635, 139, 166, 20);
		panel_1.add(textSalaire);
		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				nomTxt			=textNom.getText();
				prenomTxt		=textPrenom.getText();
				medicalTxt		=textMedical.getText();
				conjugaleTxt	=textConjugale.getText();
				mailTxt			=textMail.getText();
				jeuneFilleTxt	=textNomJeuneFille.getText();
				loginTxt		=textLogin.getText();
				adresseTxt		=textAdresse.getText();
				
				
				passWordTxt		= new String(passwordField.getPassword());
				
				
				
				
				nbEnfatntTxt	=Integer.parseInt(textNbEnfant.getText());
				telTxt			=Integer.parseInt(textTelephone.getText());
				
				nbCongeTxt		=Integer.parseInt(textNombreConges.getText());
				congeRestantTxt	=Integer.parseInt( textCongesRestant.getText()); 
				
				if(e.getSource()==departementBox) {
					departementTxt= (String) departementBox.getSelectedItem();
					
					}
				
				if( e.getSource()==fonctionBox  ) {
					fonctionTxt = (String) fonctionBox.getSelectedItem();
					}
					
				
				dateFinTxt		=dateFin.getDate();
				dateEmbaucheTxt	= dateEmbauche.getDate();
				
				System.out.println(departementTxt);
				salaireTxt		= Float.parseFloat(textSalaire.getText());
				
				
				Employe emp		= new Employe(nomTxt, prenomTxt, jeuneFilleTxt, adresseTxt, loginTxt, passWordTxt,
											departementTxt, telTxt, mailTxt, conjugaleTxt, nbEnfatntTxt, medicalTxt,
											fonctionTxt, dateEmbaucheTxt, salaireTxt, nbCongeTxt, congeRestantTxt,
											dateFinTxt);
				
				try {
					DBUtil.addEmploye(emp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 127));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(637, 393, 171, 55);
		panel_1.add(btnNewButton_2);
		
		dateEmbauche = new JDateChooser();
		dateEmbauche.setBounds(635, 92, 166, 27);
		panel_1.add(dateEmbauche);
		
		dateFin = new JDateChooser();
		dateFin.setBounds(637, 284, 166, 27);
		panel_1.add(dateFin);
		
		departementBox = new JComboBox<Object>(departement);
		departementBox.setBounds(194, 302, 161, 27);
		panel_1.add(departementBox);
		
		fonctionBox = new JComboBox<Object>(fonctionList);
		fonctionBox.setBounds(635, 49, 166, 27);
		panel_1.add(fonctionBox);
		
	}
}
