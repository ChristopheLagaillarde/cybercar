package cybercar;

import java.util.Date;

public class Employe {


	private int    id;
	
	private String nom;
	private String prenom;
	private String nom_Jeune_Fille;
	private String adresse;
	private String login;
	
	private String motDePasse;
	private String departement;
	private int    telephone;
	private String mail;
	private String sConjugale ;
	
	private int    nbEnfant;
	private String aMedical;
	private String fonction;
	private Date   dateEmbauche;
	private Float  salaire;
	
	private int    nbConges ;
	private int    nbCongesRestants ;
	private Date   dateFin ;
	
	public Employe() {
	}
	
	public Employe(String nom, String prenom, String nomJeuneFille,String adresse, String login, String motDePasse, 
			String departement, int    telephone, String mail,String sConjugale, int nbEnfant, String aMedical,
			String fonction, Date dateEmbauche,Float  salaire, int nbConges, int nbCongesRestants, Date dateFin)
	{
		
		
		
		this.nom = nom;
		this.prenom = prenom;
		this.nom_Jeune_Fille = nomJeuneFille;
		
		this.adresse = adresse;
		this.login = login;
		this.departement = departement;
		
		this. telephone = telephone;
		this.mail = mail;
		this.sConjugale = sConjugale;
		
		this.nbEnfant = nbEnfant;
		this.aMedical =aMedical ;
		this.fonction=fonction ;
		
		this.dateEmbauche = dateEmbauche ;
		this.salaire =salaire ;
		this.nbConges = nbConges;
		
		this.nbCongesRestants = nbCongesRestants;
		this.dateFin = dateFin;
		
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
		return nom_Jeune_Fille;
	}

	/**
	 * @param nomJeuneFille the nomJeuneFille to set
	 */
	public void setNomJeuneFille(String nomJeuneFille) {
		this.nom_Jeune_Fille = nomJeuneFille;
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
	public int getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
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
	public int getNbEnfant() {
		return nbEnfant;
	}

	/**
	 * @param nbEnfant the nbEnfant to set
	 */
	public void setNbEnfant(int nbEnfant) {
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
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the salaire
	 */
	public Float getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(Float salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the nbConges
	 */
	public int getNbConges() {
		return nbConges;
	}

	/**
	 * @param nbConges the nbConges to set
	 */
	public void setNbConges(int nbConges) {
		this.nbConges = nbConges;
	}

	/**
	 * @return the nbCongesRestants
	 */
	public int getNbCongesRestants() {
		return nbCongesRestants;
	}

	/**
	 * @param nbCongesRestants the nbCongesRestants to set
	 */
	public void setNbCongesRestants(int nbCongesRestants) {
		this.nbCongesRestants = nbCongesRestants;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nom_Jeune_Fille
	 */
	public String getNom_Jeune_Fille() {
		return nom_Jeune_Fille;
	}

	/**
	 * @param nom_Jeune_Fille the nom_Jeune_Fille to set
	 */
	public void setNom_Jeune_Fille(String nom_Jeune_Fille) {
		this.nom_Jeune_Fille = nom_Jeune_Fille;
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
