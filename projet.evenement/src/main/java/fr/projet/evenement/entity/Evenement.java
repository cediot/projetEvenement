package fr.projet.evenement.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the evenement database table.
 *
 */
@Entity
public class Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String adresse;

	@Column(name = "dateDebut")
	private Timestamp dateDebut;
	@Column(name = "dateFin")
	private Timestamp dateFin;

	private String nom;

	private Double tarif;

	private byte validation;

	@Column(name = "evenementSupr")
	private int evenementSupr;

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	// @JsonIgnore
	private Utilisateur utilisateur;

	// bi-directional many-to-many association to Categorie
	@ManyToMany
	@JoinTable(name = "evenement_categorie", joinColumns = {
			@JoinColumn(name = "evenement_id") }, inverseJoinColumns = { @JoinColumn(name = "categorie_id") })
	private List<Categorie> categories;

	// bi-directional many-to-many association to Ressource
	@ManyToMany
	@JoinTable(name = "evenement_ressource", joinColumns = {
			@JoinColumn(name = "evenement_id") }, inverseJoinColumns = { @JoinColumn(name = "ressource_id") })
	private List<Ressource> ressources;

	// bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy = "evenementsValides")
	// @JsonIgnore
	private List<Utilisateur> utilisateurs1;

	// bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy = "evenementsOuJeParticipe")
	// @JsonIgnore
	private List<Utilisateur> utilisateurs2;

	public Evenement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Timestamp getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Timestamp getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getTarif() {
		return this.tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public byte getValidation() {
		return this.validation;
	}

	public void setValidation(byte validation) {
		this.validation = validation;
	}

	public int getEvenementSupr() {
		return this.evenementSupr;
	}

	public void setEvenementSupr(int evenementSupr) {
		this.evenementSupr = evenementSupr;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Categorie> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public List<Utilisateur> getUtilisateurs1() {
		return this.utilisateurs1;
	}

	public void setUtilisateurs1(List<Utilisateur> utilisateurs1) {
		this.utilisateurs1 = utilisateurs1;
	}

	public List<Utilisateur> getUtilisateurs2() {
		return this.utilisateurs2;
	}

	public void setUtilisateurs2(List<Utilisateur> utilisateurs2) {
		this.utilisateurs2 = utilisateurs2;
	}

}