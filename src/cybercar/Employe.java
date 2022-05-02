package cybercar;

public class Employe {


	private String id;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String login;
	private String motDePasse;
	private String departement;
	private String civilite;
	private String nomJeuneFille;
	private String telephone;
	
	
	private String 	mail;
	private String 	sConjugale ;
	
	private String  nbEnfant;
	private String 	aMedical;
	private String 	fonction;
	private String  dateEmbauche;
	private String  salaire;
	
	private String  nbConges ;
	private String  nbCongesRestants ;
	private String  dateFin ;
	
	public Employe() {
	}
	
	public Employe(String nom, String prenom, String adresse, String login, String motDePasse, String departement, String civilite, String nomJeuneFille,
			 String    telephone, String mail,String sConjugale, String nbEnfant, String aMedical,
			String fonction, String dateEmbauche, String  salaire, String nbConges, String nbCongesRestants, String dateFin)
	{
		
		
		
		this.nom = nom;						//1
		this.prenom = prenom;				//2
		this.adresse = adresse;				//3
		this.login = login;					//4
		this.motDePasse=motDePasse;			//5
		this.departement = departement;		//6
		this.civilite= civilite;			//7
		
		this.nomJeuneFille = nomJeuneFille;	//8
		
		this. telephone = telephone;		//9
		this.mail = mail;					//10
		this.sConjugale = sConjugale;		//11
		
		this.nbEnfant = nbEnfant;			//12
		this.aMedical =aMedical ;			//13
		this.fonction=fonction ;			//14
		
		this.dateEmbauche = dateEmbauche ;	//15
		this.salaire =salaire ;				//16
		this.nbConges = nbConges;			//17
		
		this.nbCongesRestants = nbCongesRestants;//18
		this.dateFin = dateFin;						//19
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nomJeuneFille
	 */
	public String getNomJeuneFille() {
		return nomJeuneFille;
	}

	/**
	 * @param nomJeuneFille the nomJeuneFille to set
	 */
	public void setNomJeuneFille(String nomJeuneFille) {
		this.nomJeuneFille = nomJeuneFille;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the sConjugale
	 */
	public String getsConjugale() {
		return sConjugale;
	}

	/**
	 * @param sConjugale the sConjugale to set
	 */
	public void setsConjugale(String sConjugale) {
		this.sConjugale = sConjugale;
	}

	/**
	 * @return the nbEnfant
	 */
	public String getNbEnfant() {
		return nbEnfant;
	}

	/**
	 * @param nbEnfant the nbEnfant to set
	 */
	public void setNbEnfant(String nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	/**
	 * @return the aMedical
	 */
	public String getaMedical() {
		return aMedical;
	}

	/**
	 * @param aMedical the aMedical to set
	 */
	public void setaMedical(String aMedical) {
		this.aMedical = aMedical;
	}

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @return the dateEmbauche
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the salaire
	 */
	public String getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the nbConges
	 */
	public String getNbConges() {
		return nbConges;
	}

	/**
	 * @param nbConges the nbConges to set
	 */
	public void setNbConges(String nbConges) {
		this.nbConges = nbConges;
	}

	/**
	 * @return the nbCongesRestants
	 */
	public String getNbCongesRestants() {
		return nbCongesRestants;
	}

	/**
	 * @param nbCongesRestants the nbCongesRestants to set
	 */
	public void setNbCongesRestants(String nbCongesRestants) {
		this.nbCongesRestants = nbCongesRestants;
	}

	/**
	 * @return the dateFin
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the civilite
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * @param civilite the civilite to set
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
//	@Override
//	public String toString(){
//		StringBuilder sb = new StringBuilder();
//			sb.append("Student[");
//			sb.append("Increment Id:"+this.incid);
//			sb.append(",Id:"+this.id);
//			sb.append(",Name:"+this.name);
//			sb.append(",Address:"+this.address);
//			sb.append(",Gender:"+this.gender);
//			sb.append(",Age:"+this.age);
//			sb.append("]");
//		return sb.toString();
//	}
}
