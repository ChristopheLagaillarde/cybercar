package cybercar;

public class RequeteSQLCyberCar {
	
	private RequeteSQLCyberCar(){
		
	}
	
	public static final String SELECT_INFORMATION_VOITURE(String idVoiture) {
		return "SELECT Marque, Modèle, Couleur, Année_de_production, Transmission, Type_de_carburant, Date_de_livraison, Prix FROM `voiture` WHERE id_voiture = '"+ idVoiture + "';";
	}
	
	public static final String SELECT_NOM_PRENOM_EMPLOYE(String idEmploye) {
		return "SELECT nom, prenom FROM `employe` WHERE id_employé = '"+ idEmploye + "';";
	}
	
	public static final String SELECT_NOM_PRENOM_CLIENT(String idClient) {
		return "SELECT nom, prenom FROM `client` WHERE id_client = '"+ idClient + "';";
	}
	
	public static final String SELECT_TOUTES_VOITURES() {
		return "SELECT * FROM `voiture` ;";
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
	
	public static final String DELETE_VOITURE_TABLE_VOITURE(String idVoiture) {
		return "DELETE FROM voiture WHERE `id_voiture` = '" + idVoiture + "';";
	}
}
