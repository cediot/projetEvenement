package fr.projet.evenement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the utilisateur database table.
 *
 */
@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_de_naissance")
	private Date dateDeNaissance;

	private String email;

	@Column(name = "mot_de_passe")
	private String motDePasse;

	private String nom;

	private String prenom;

	private String pseudonyme;

	private int reputation;

	@Column(name = "utilisateurSupr")
	private int utilisateurSupr;

	// bi-directional many-to-one association to Evenement
	@OneToMany(mappedBy = "utilisateur")
	@JsonIgnore
	private List<Evenement> evenements1;

	// bi-directional many-to-many association to Evenement
	@ManyToMany
	@JoinTable(name = "evenement_valider_par_utilisateur", joinColumns = {
			@JoinColumn(name = "utilisateur_id") }, inverseJoinColumns = { @JoinColumn(name = "evenement_id") })
	@JsonIgnore
	private List<Evenement> evenements2;

	// bi-directional many-to-many association to Evenement
	@ManyToMany
	@JoinTable(name = "utilisateur_participe_evenement", joinColumns = {
			@JoinColumn(name = "utilisateur_id") }, inverseJoinColumns = { @JoinColumn(name = "evenement_id") })
	@JsonIgnore
	private List<Evenement> evenements3;

	public Utilisateur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

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

	public int getReputation() {
		return this.reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public int getUtilisateurSupr() {
		return this.utilisateurSupr;
	}

	public void setUtilisateurSupr(int utilisateurSupr) {
		this.utilisateurSupr = utilisateurSupr;
	}

	public List<Evenement> getEvenements1() {
		return this.evenements1;
	}

	public void setEvenements1(List<Evenement> evenements1) {
		this.evenements1 = evenements1;
	}

	public Evenement addEvenements1(Evenement evenements1) {
		this.getEvenements1().add(evenements1);
		evenements1.setUtilisateur(this);

		return evenements1;
	}

	public Evenement removeEvenements1(Evenement evenements1) {
		this.getEvenements1().remove(evenements1);
		evenements1.setUtilisateur(null);

		return evenements1;
	}

	public List<Evenement> getEvenements2() {
		return this.evenements2;
	}

	public void setEvenements2(List<Evenement> evenements2) {
		this.evenements2 = evenements2;
	}

	public List<Evenement> getEvenements3() {
		return this.evenements3;
	}

	public void setEvenements3(List<Evenement> evenements3) {
		this.evenements3 = evenements3;
	}

}