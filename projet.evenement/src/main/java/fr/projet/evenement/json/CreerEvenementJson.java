package fr.projet.evenement.json;

import java.sql.Timestamp;

/**
 * Le json devra etre : <br/>
 * {"email":"toto@oll.com", "pwd":"tata"}
 *
 */

public class CreerEvenementJson {

	private int idEvenement;
	private int utilisateurId;
	private String nomEvenement;
	private String adresse;
	private double tarif;
	private Timestamp dateDebutEvenement;
	private Timestamp dateFinEvenement;

	public int getIdEvenement() {
		return this.idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

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

	public Timestamp getDateDebutEvenement() {
		return this.dateDebutEvenement;
	}

	public void setDateDebutEvenement(Timestamp dateDebutEvenement) {
		this.dateDebutEvenement = dateDebutEvenement;
	}

	public Timestamp getDateFinEvenement() {
		return this.dateFinEvenement;
	}

	public void setDateFinEvenement(Timestamp dateFinEvenement) {
		this.dateFinEvenement = dateFinEvenement;
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
		builder.append(", dateFinEvenement=");
		builder.append(this.dateFinEvenement);
		builder.append("]");
		return builder.toString();
	}

}
