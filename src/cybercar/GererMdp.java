package cybercar;

/**
 * Les fonctions pour gérer les mots de passe
 * @author Lagaillarde
 *
 */
public class GererMdp {
	
	/**
	 * Fonction qui dit si le caractère est une majuscule
	 * @param caractere
	 * @return Si c'est une majuscule ou pas
	 */
	public static boolean estUneLettreMajuscule(char caractere) {
		return (caractere >= 'A' && caractere <= 'Z');
	}

	/**
	 * Fonction qui dit si le caractère est une minuscule
	 * @param caractere
	 * @return Si c'est une minuscule ou pas
	 */
	public static boolean estUneLettreMinuscule(char caractere) {
		return (caractere >= 'a' && caractere <= 'z');
	}
	
	/**
	 * Fonction qui dit si le caractère est un chiffre
	 * @param caractere
	 * @return Si c'est un chiffre ou pas
	 */
	public static boolean estUnChiffre(char caractere) {

		return (caractere >= '0' && caractere <= '9');
	}

	/**
	 * Fonction qui dit si le string est un bon mot de passe
	 * @param motDePasse
	 * @return Si c'est un bon mot de passe ou pas
	 */
	public static boolean estUnBonMdp(String motDePasse) {
		if (motDePasse.length() < 16) return false;

		int nombreDeLettreMajuscule = 0;
		int nombreDeLettreMinuscule = 0;
		int nombreDeCaractereSpeciaux = 0;
		int nombreDeChiffre = 0;

		for (int i = 0; i < motDePasse.length(); i++) {

			char caractere = motDePasse.charAt(i);

			if (estUnChiffre(caractere)) {
				nombreDeChiffre++;
			}
			else if (estUneLettreMajuscule(caractere)) {
				nombreDeLettreMajuscule++;
			}
			else if (estUneLettreMinuscule(caractere)) {
				nombreDeLettreMinuscule++;
			}

			else {
				nombreDeCaractereSpeciaux++;
			}

		}
		return (nombreDeLettreMajuscule >= 1 && nombreDeChiffre >= 1 && nombreDeLettreMinuscule >= 1 && nombreDeCaractereSpeciaux >= 1);
	}

}
