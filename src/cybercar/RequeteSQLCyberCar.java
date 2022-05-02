package cybercar;

public class RequeteSQLCyberCar {
	
	private RequeteSQLCyberCar(){
		
	}

	public static final String SELECT_LA_FONCTION_DE_LUTILISATEUR(String login, String motDePasseHashe) {
		return "SELECT fonction FROM login WHERE mail = '" + login + "' AND motDePasse = '"+ motDePasseHashe +"';";
	}
	
	public static final String SELECT_DONNEE_PERSO_ET_PRIVE_UTILISATEUR(String login, String motDePasseHashe) {
		return "SELECT login, civilite,nomDeJeuneFille,situationConjugale,nombreEnfants,antecedantMedicale FROM employe WHERE login = '"+ login + "' AND motDePasse = '"+ motDePasseHashe + "' ;";
	}
}
