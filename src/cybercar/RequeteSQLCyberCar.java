package cybercar;

public class RequeteSQLCyberCar {
	
	private RequeteSQLCyberCar(){
		
	}

	public static String selectLaFonctionDeLutilisateur(String login, String motDePasseHashe) {
		return "SELECT fonction FROM login WHERE email = '" + login + "' AND motDePasse = '"+ motDePasseHashe +"';";
	}
	
	public static String selectDonnePersoEtPriveUtilisateur(String login, String motDePasseHashe) {
		return "SELECT login, civilite,nomDeJeuneFille,situationConjugale,nombreEnfants,entecedantMedicale FROM employe WHERE login = '"+ login + "' AND motDePasse = '"+ motDePasseHashe + "' ;";
	}
}
