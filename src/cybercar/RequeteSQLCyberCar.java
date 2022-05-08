package cybercar;

public class RequeteSQLCyberCar {
	
	private RequeteSQLCyberCar(){
		
	}

	public static final String SELECT_LA_FONCTION_DE_LUTILISATEUR(String login, String motDePasseHashe) {
		return "SELECT fonction FROM login WHERE mail = '" + login + "' AND motDePasse = '"+ motDePasseHashe +"';";
	}
	
	public static final String SELECT_ID_EMPLOYE(String login) {
		return "SELECT id_employé FROM employe WHERE login = '" + login + "';";
	}
	
	public static final String SELECT_DONNEE_PERSO_ET_PRIVE_UTILISATEUR(String login, String motDePasseHashe) {
		return "SELECT login, civilite,nomDeJeuneFille,situationConjugale,nombreEnfants,antecedantMedicale FROM employe WHERE login = '"+ login + "' AND motDePasse = '"+ motDePasseHashe + "' ;";
	}
	
	public static final String SELECT_MDP_UTILISATEUR(String[] idEmploye) {
		return "SELECT motDePasse FROM login WHERE mail =(SELECT login FROM employe WHERE id_employé = '" + idEmploye[0] + "');";
	}
	
	
	public static final String UPDATE_FONCTION_UTILISATEUR_TABLE_EMPLOYE(String idEmploye, String nouvelleFonction) {
		return "UPDATE employe SET fonction='"+ nouvelleFonction + "' WHERE id_employé = '"+ idEmploye +"';";
				
	}
	
	public static final String UPDATE_FONCTION_UTILISATEUR_TABLE_LOGIN(String idEmploye, String nouvelleFonction) {
		return "UPDATE login SET fonction = '" + nouvelleFonction + "' WHERE mail = (SELECT login FROM employe WHERE id_employé = '"+ idEmploye + "');";
				
	}
	
	public static final String UPDATE_MDP_UTILISATEUR_TABLE_LOGIN(String[] idEmploye, String motDePasseHashe) {
		return "UPDATE login SET motDePasse = '" + motDePasseHashe + "' WHERE mail = (SELECT login FROM employe WHERE id_employé = '"+ idEmploye[0] + "');";
				
	}
	
	public static final String UPDATE_MDP_UTILISATEUR_TABLE_EMPLOYE(String[] idEmploye, String motDePasseHashe) {
		return "UPDATE employe SET motDePasse = '" + motDePasseHashe + "' WHERE id_employé ='" + idEmploye[0] +"';";
				
	}
	
	public static final String UPDATE_DEPARTEMENT_UTILISATEUR_TABLE_EMPLOYE(String idEmploye, String nouveauDepartement) {
		return "UPDATE employe SET departement='"+ nouveauDepartement + "' WHERE id_employé = '"+ idEmploye +"';";
				
	}
}
