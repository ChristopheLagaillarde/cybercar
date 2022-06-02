package cybercar;

import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.pdf.PdfWriter;  

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;

public class GenereFacturePdf {

	static String[] informationVoiture(String idVoiture) {

		String[] informationVoiture = {"Voiture non existante", "Modèle", "Couleur", "Années_de_production", "Transmission", "Type_de_carburant", "Prix"};
		String nomBDD = "sql11497241";
		String username = "sql11497241";
		String motDePasseBDD = "9B2cyk9VAv";

		ConnectionFactory connectionBDTrouverInformationVoiture = null;
		ResultSet resultatSelectVoiture = null;

		connectionBDTrouverInformationVoiture = new ConnectionFactory(nomBDD, username, motDePasseBDD);
		try {
			resultatSelectVoiture = connectionBDTrouverInformationVoiture.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_INFORMATION_VOITURE(idVoiture));

			while(resultatSelectVoiture.next()) {
				informationVoiture[0] =  resultatSelectVoiture.getString("Marque");
				informationVoiture[1] =  resultatSelectVoiture.getString("Modèle");
				informationVoiture[2] =  resultatSelectVoiture.getString("Couleur");
				informationVoiture[3] =  resultatSelectVoiture.getString("Année_de_production");
				informationVoiture[4] =  resultatSelectVoiture.getString("Transmission");
				informationVoiture[5] =  resultatSelectVoiture.getString("Type_de_carburant");
				informationVoiture[6] =  resultatSelectVoiture.getString("Prix");
			}

		}
		catch (SQLException echecRequeteSelectVoiture) {
			JOptionPane.showMessageDialog(null, "Echec de la requete pour selectionner la voiture");
			echecRequeteSelectVoiture.printStackTrace();
		}
		return informationVoiture;
	}

	String[] nomPrenomEmploye(String idEmploye) {

		String [] listeNomPrenomEmploye = {"Employe inexistant", "Employe inexistant"};
		String nomBDD = "sql11497241";
		String username = "sql11497241";
		String motDePasseBDD = "9B2cyk9VAv";

		ConnectionFactory connectionBDRecupererNomPrenomEmploye = null;
		ResultSet resultatSelectEmploye = null;

		connectionBDRecupererNomPrenomEmploye = new ConnectionFactory(nomBDD, username, motDePasseBDD);
		try {
			resultatSelectEmploye = connectionBDRecupererNomPrenomEmploye.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_NOM_PRENOM_EMPLOYE(idEmploye));
			while(resultatSelectEmploye.next()) {
				listeNomPrenomEmploye[0] =  resultatSelectEmploye.getString("nom");
				listeNomPrenomEmploye[1] =  resultatSelectEmploye.getString("prenom");
			}

		}
		catch (SQLException echecRequeteSelectVoiture) {
			JOptionPane.showMessageDialog(null, "Echec de la requete pour selectionner l'employé");
			echecRequeteSelectVoiture.printStackTrace();
		}
		return listeNomPrenomEmploye;
	}

	static String[] nomPrenomClient(String idClient) {

		String [] listeNomPrenomClient = {"Client inexistant", "Client inexistant"};
		String nomBDD = "sql11497241";
		String username = "sql11497241";
		String motDePasseBDD = "9B2cyk9VAv";

		ConnectionFactory connectionBDRecupererNomPrenomClient = null;
		ResultSet resultatSelectClient = null;

		connectionBDRecupererNomPrenomClient = new ConnectionFactory(nomBDD, username, motDePasseBDD);
		try {
			resultatSelectClient = connectionBDRecupererNomPrenomClient.requeteAFaire.executeQuery(RequeteSQLCyberCar.SELECT_NOM_PRENOM_CLIENT(idClient));
			while(resultatSelectClient.next()) {
				listeNomPrenomClient[0] =  resultatSelectClient.getString("nom");
				listeNomPrenomClient[1] =  resultatSelectClient.getString("prenom");
			}

		}
		catch (SQLException echecRequeteSelectVoiture) {
			JOptionPane.showMessageDialog(null, "Echec de la requete pour selectionner le client");
			echecRequeteSelectVoiture.printStackTrace();
		}
		return listeNomPrenomClient;
	}

	private BaseFont policeGras;
	private BaseFont policeParDefault;
	private int numeroPage = 0;

	public static void main(String[] args) {
		String idClient = args[0];
		String idEmploye = args[1];
		String idVoiture = args[2];

		GenereFacturePdf genereFacture = new GenereFacturePdf();

		String adresseFichierPdf = "Facture.pdf";
		genereFacture.creePdf(adresseFichierPdf, idClient, idEmploye, idVoiture, informationVoiture(idVoiture));

	}

	private void creePdf (String adresseFichierPdf, String idClient, String idEmploye, String idVoiture, String[] detailVoiture){

		Document documentPdf = new Document();
		PdfWriter ecrireDansDocumentPdf = null;
		initialisePolices();
		try {
			if (detailVoiture[0].equals("Voiture non existante") || nomPrenomClient(idClient)[0].equals("Client inexistant")) {
				JOptionPane.showMessageDialog(null, "Voiture ou client inexistant");
				return;
			}
			ecrireDansDocumentPdf = PdfWriter.getInstance(documentPdf , new FileOutputStream(adresseFichierPdf));
			documentPdf.addAuthor("Lagaillarde Christophe");
			documentPdf.addCreationDate();
			documentPdf.addProducer();
			documentPdf.addCreator("Cybercar");
			documentPdf.addTitle("Facture");
			documentPdf.setPageSize(PageSize.LETTER);

			documentPdf.open();
			PdfContentByte contenueFichierEnByte = ecrireDansDocumentPdf.getDirectContent();

			boolean commencementPage = true;
			int y = 0;

			// Génère chaque page si on ajoute for
			if(commencementPage){
				commencementPage = false;
				genereDispositionsFormes(documentPdf, contenueFichierEnByte); 
				genereEntete(documentPdf, contenueFichierEnByte, idClient, idEmploye);
				y = 615; 
			}
			genereDetail(documentPdf, contenueFichierEnByte, 1, y, idVoiture, detailVoiture); // 1 à remplacer par i
			y = y - 15;
			if(y < 50){
				afficheNombreDePage(contenueFichierEnByte);
				documentPdf.newPage();
				commencementPage = true;
			}

			afficheNombreDePage(contenueFichierEnByte);

		}
		catch (DocumentException erreurDocument)
		{
			erreurDocument.printStackTrace();
		}
		catch (Exception erreurGenereDocument)
		{
			erreurGenereDocument.printStackTrace();
		}
		finally
		{
			if (documentPdf != null)
			{
				documentPdf.close();
			}
			if (ecrireDansDocumentPdf != null)
			{
				ecrireDansDocumentPdf.close();
			}
		}
	}

	private void genereDispositionsFormes(Document documentPdf, PdfContentByte contenueFichierEnByte)  {

		try {

			contenueFichierEnByte.setLineWidth(1f);

			// Formes entête de la facture
			contenueFichierEnByte.rectangle(420,700,150,60);
			contenueFichierEnByte.moveTo(420,720);
			contenueFichierEnByte.lineTo(570,720);
			contenueFichierEnByte.moveTo(420,740);
			contenueFichierEnByte.lineTo(570,740);
			contenueFichierEnByte.moveTo(480,700);
			contenueFichierEnByte.lineTo(480,760);
			contenueFichierEnByte.stroke();

			// Formes entête du texte de la facture
			creeEntete(contenueFichierEnByte,422,743,"Nom acheteur");
			creeEntete(contenueFichierEnByte,422,723,"Nom vendeur");
			creeEntete(contenueFichierEnByte,422,703,"Date");

			// Formes encadrement détail facture
			contenueFichierEnByte.rectangle(20,50,550,600);
			contenueFichierEnByte.moveTo(20,630);
			contenueFichierEnByte.lineTo(570,630);
			contenueFichierEnByte.moveTo(50,50);
			//contenueFichierEnByte.lineTo(50,650);
			contenueFichierEnByte.moveTo(50,50);
			contenueFichierEnByte.lineTo(50,650);
			contenueFichierEnByte.moveTo(430,50);
			contenueFichierEnByte.moveTo(500,50);
			contenueFichierEnByte.lineTo(500,650);
			contenueFichierEnByte.stroke();

			// Formes encadrement titre facture 
			creeEntete(contenueFichierEnByte,22,633,"ID");
			creeEntete(contenueFichierEnByte,52,633,"Description");
			creeEntete(contenueFichierEnByte,502,633,"Prix");

			//ajout du logo
			Image logoCybercar = Image.getInstance("cybercarLogo.jpg");
			logoCybercar.setAbsolutePosition(25,700);
			logoCybercar.scalePercent(25);
			documentPdf.add(logoCybercar);

		}

		catch (DocumentException erreurDocument){
			erreurDocument.printStackTrace();
		}
		catch (Exception erreurGenereDocument){
			erreurGenereDocument.printStackTrace();
		}

	}

	private void genereEntete(Document documentPdf, PdfContentByte contenueFichierEnByte, String idClient, String idEmploye)  {

		try {

			DateTimeFormatter heureEtDateDeLAchat = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDateTime maintenant = LocalDateTime.now();  

			creeEntete(contenueFichierEnByte,200,750,"Nom: Cybercar");
			creeEntete(contenueFichierEnByte,200,735,"Adresse: MCCIBS,");
			creeEntete(contenueFichierEnByte,200,720,"Cybercity, Ebène - 9999");
			creeEntete(contenueFichierEnByte,200,705,"Maurice");
			creeEntete(contenueFichierEnByte,200,690,"Tél: 54840792");

			creeEntete(contenueFichierEnByte,482,743, nomPrenomClient(idClient)[0] + ' ' + nomPrenomClient(idClient)[1]);
			creeEntete(contenueFichierEnByte,482,723,nomPrenomEmploye(idEmploye)[0] + ' ' + nomPrenomEmploye(idEmploye)[1]);
			creeEntete(contenueFichierEnByte,482,703, heureEtDateDeLAchat.format(maintenant).toString());

		}

		catch (Exception erreurGenereDocument){
			erreurGenereDocument.printStackTrace();
		}

	}

	private void genereDetail(Document documentPdf, PdfContentByte contenueFichierEnByte, int index, int y, String idVoiture, Object[] detailVoiture)  {

		try {

			creeContenue(contenueFichierEnByte,30,y, idVoiture,PdfContentByte.ALIGN_RIGHT);
			creeContenue(contenueFichierEnByte,52,y,detailVoiture[0] +" "+ detailVoiture[1] +" "+ detailVoiture[2] +" "+ detailVoiture[3]
					+" "+ detailVoiture[4] +" "+ detailVoiture[5],PdfContentByte.ALIGN_LEFT);

			creeContenue(contenueFichierEnByte,568,y, detailVoiture[6].toString(), PdfContentByte.ALIGN_RIGHT);

		}

		catch (Exception erreurGenereDocument){
			erreurGenereDocument.printStackTrace();
		}

	}

	private void creeEntete(PdfContentByte contenueFichierEnByte, float x, float y, String text){


		contenueFichierEnByte.beginText();
		contenueFichierEnByte.setFontAndSize(policeGras, 8);
		contenueFichierEnByte.setTextMatrix(x,y);
		contenueFichierEnByte.showText(text.trim());
		contenueFichierEnByte.endText(); 

	}

	private void afficheNombreDePage(PdfContentByte contenueFichierEnByte){


		contenueFichierEnByte.beginText();
		contenueFichierEnByte.setFontAndSize(policeGras, 8);
		contenueFichierEnByte.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (numeroPage+1), 570 , 25, 0);
		contenueFichierEnByte.endText(); 

		numeroPage++;

	}

	private void creeContenue(PdfContentByte contenueFichierEnByte, float x, float y, String text, int align){


		contenueFichierEnByte.beginText();
		contenueFichierEnByte.setFontAndSize(policeParDefault, 8);
		contenueFichierEnByte.showTextAligned(align, text.trim(), x , y, 0);
		contenueFichierEnByte.endText(); 

	}

	private void initialisePolices(){


		try {
			policeGras = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			policeParDefault = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

		} catch (DocumentException erreurDocument) {
			erreurDocument.printStackTrace();
		} catch (IOException erreurFichier) {
			erreurFichier.printStackTrace();
		}


	}

}