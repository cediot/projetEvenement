package fr.projet.evenement.json;

import java.sql.Date;

/**
 * Le json devra etre : <br/>
 * {"email":"toto@oll.com", "pwd":"tata"}
 *
 */

public class CreerEvenementJson {
	private int utilisateurId;
	private String nomEvenement;
	private String adresse;
	private double tarif;
	private Date dateDebutEvenement;
	private Date deteFinEvenement;

	public int getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getNomEvenement() {
		return this.nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getTarif() {
		return this.tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public Date getDateDebutEvenement() {
		return this.dateDebutEvenement;
	}

	public void setDateDebutEvenement(Date dateDebutEvenement) {
		this.dateDebutEvenement = dateDebutEvenement;
	}

	public Date getDeteFinEvenement() {
		return this.deteFinEvenement;
	}

	public void setDeteFinEvenement(Date deteFinEvenement) {
		this.deteFinEvenement = deteFinEvenement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreerEvenementJson [utilisateurId=");
		builder.append(this.utilisateurId);
		builder.append(", nomEvenement=");
		builder.append(this.nomEvenement);
		builder.append(", adresse=");
		builder.append(this.adresse);
		builder.append(", tarif=");
		builder.append(this.tarif);
		builder.append(", dateDebutEvenement=");
		builder.append(this.dateDebutEvenement);
		builder.append(", deteFinEvenement=");
		builder.append(this.deteFinEvenement);
		builder.append("]");
		return builder.toString();
	}

}
