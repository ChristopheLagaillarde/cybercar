package cybercar;

public class QueryStatement {
	public final static String ADD_CAR_QUERY = "INSERT INTO voiture (Marque,Modèle,Couleur,Année_de_production,Transmission,Type_de_carburant,Pays_de_provenance,Prix,Entrepôt) VALUES(?,?,?,?,?,?,?,?,?)";
	public final static String UPDATE_CAR_QUERY = "UPDATE voiture SET Marque=?,Modèle=?,Couleur=?,Année_de_production=?,Transmission=?,Type_de_carburant=?,Pays_de_provenance=?,Prix=?,Entrepôt=? where id_voiture =?";
	public final static String CHECK_QUERY = "Select * From voiture";
	public final static String DELETE_CAR_QUERY = "Delete from voiture WHERE id_voiture=?";
	
	public final static String
	ADD_EMPLOYE_QUERY =

	"INSERT INTO employe(nom, prenom, adresse, login, motDePasse, departement, civilite, nomDeJeuneFille, telephone, mail, situationConjugale, nombreEnfants, antecedantMedicale, fonction, dateEmbauche, salaire, nombreConge, nombreCongeRestant, dateFinContrat) VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)";

	public final static String
	UPDATE_EMPLOYE_QUERY =

	"UPDATE employe SET nom=?, prenom=?, adresse=?, login=?, motDePasse=?, departement=?, civilite=?, nomDeJeuneFille=?, telephone=?, e-mail=?, situationConjugale=?, nombreEnfants=?, antecedantMedicale=?, fonction=?, dateEmbauche=?, salaire=?, nombreConge=?, nombreCongeRestant=?, dateFinContrat=? where id_employe= ?";

	public final static String DELETE_EMPLOYE_QUERY =

	"DELETE FROM employe WHERE id_employe=?";

	public final static String SELECT_ALL_EMPLOYE_QUERY =

	"SELECT * FROM employe";
}
