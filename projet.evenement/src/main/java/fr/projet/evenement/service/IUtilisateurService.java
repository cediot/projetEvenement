package fr.projet.evenement.service;

import java.sql.Date;

import fr.projet.evenement.entity.Utilisateur;

public interface IUtilisateurService {


	public abstract Utilisateur findOneByEmail(String email) throws Exception;

	public abstract Utilisateur findLoginMotDePasse(String email, String motDePasse) throws Exception;

	public abstract Utilisateur save(Utilisateur pUtilisateur) throws Exception;

	public abstract Utilisateur modificationUtilisateur(String nom, String prenom, String pseudonyme, String email,
			String motDePasse, Date dateDeNaissance) throws Exception;

}
