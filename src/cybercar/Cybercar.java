package cybercar;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * L'ERP CyberCar permettant la gestion des stocks de voiture
 * des clients et des ressources humaines
 * date Aremplir
 * @author Lagaillarde
 * @version 1.0
 * 
 */
public class Cybercar {

	public static void main(String[] args) {
		 try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); //com.jtattoo.plaf.acryl.AcrylLookAndFeel
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException erreurThemeJtattoo) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau du thème Jtatoo");
			}
		 FenetreLogin.main(args);
		
	}

}
