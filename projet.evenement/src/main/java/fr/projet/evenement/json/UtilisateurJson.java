package fr.projet.evenement.json;

import java.sql.Date;

public class UtilisateurJson {
	private String nom;
	private String prenom;
	private String pseudonyme;
	private String email;
	private String pwd;
	private Date dateDeNaissance;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudonyme() {
		return this.pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreationCompteJson [nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", pseudonyme=");
		builder.append(this.pseudonyme);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", pwd=");
		builder.append(this.pwd);
		builder.append(", dateDeNaissance=");
		builder.append(this.dateDeNaissance);
		builder.append("]");
		return builder.toString();
	}

}
