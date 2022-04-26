package cybercar;

public class Voiture {
	private String id_voiture;
	private String Marque;
	private String Modèle;
	private String Couleur;
	private String Année_de_production;
	private String Transmission;
	private String Type_de_carburant;
	private String Pays_de_provenance;
	private String Prix;
	private String Entrepôt;
	
	
	
	public Voiture() {
	}
	
	public Voiture(String Marque,String Modèle, String Couleur,String Année_de_production,String Transmission, String Type_de_carburant, String Pays_de_provenance, String Prix, String Entrepôt){
		this.Marque = Marque;
		this.Modèle = Modèle;
		this.Couleur = Couleur;
		this.Année_de_production = Année_de_production;
		this.Transmission = Transmission;
		this.Type_de_carburant = Type_de_carburant;
		this.Pays_de_provenance = Pays_de_provenance;
		this.Prix = Prix;
		this.Entrepôt = Entrepôt;
	}
	
	public String getid_voiture() {
		return id_voiture;
	}
	public void setid_voiture(String id_voiture) {
		this.id_voiture = id_voiture;
	}
	public String getMarque() {
		return Marque;
	}
	public void setMarque(String Marque) {
		this.Marque = Marque;
	}
	public String getModèle() {
		return Modèle;
	}
	public void setModèle(String Modèle) {
		this.Modèle = Modèle;
	}
	public String getCouleur() {
		return Couleur;
	}
	public void setCouleur(String Couleur) {
		this.Couleur = Couleur;
	}
	public String getAnnée_de_production() {
		return Année_de_production;
	}
	public void setAnnée_de_production(String Année_de_production) {
		this.Année_de_production = Année_de_production;
	}
	public String getTransmission() {
		return Transmission;
	}
	public void setTransmission(String Transmission) {
		this.Transmission = Transmission;
	}
	public String getType_de_carburant() {
		return Type_de_carburant;
	}
	public void setType_de_carburant(String Type_de_carburant) {
		this.Type_de_carburant = Type_de_carburant;
	}
	public String getPays_de_provenance() {
		return Pays_de_provenance;
	}
	public void setPays_de_provenance(String Pays_de_provenance) {
		this.Pays_de_provenance = Pays_de_provenance;
	}
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String Prix) {
		this.Prix = Prix;
	}
	public String getEntrepôt() {
		return Entrepôt;
	}
	public void setEntrepôt(String Entrepôt) {
		this.Entrepôt = Entrepôt;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
			sb.append("Student[");
			sb.append("Id voiture:"+this.id_voiture);
			sb.append(",Marque:"+this.Marque);
			sb.append(",Modèle:"+this.Modèle);
			sb.append(",Couleur:"+this.Couleur);
			sb.append(",Année_de_production:"+this.Année_de_production);
			sb.append(",Transmission:"+this.Transmission);
			sb.append(",Type_de_carburant:"+this.Type_de_carburant);
			sb.append(",Pays_de_provenance:"+this.Pays_de_provenance);
			sb.append(",Prix:"+this.Prix);
			sb.append(",Entrepôt:"+this.Entrepôt);
			sb.append("]");
		return sb.toString();
	}

}
