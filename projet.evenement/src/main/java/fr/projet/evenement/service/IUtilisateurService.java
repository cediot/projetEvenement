package fr.projet.evenement.service;

import java.sql.Date;

import fr.projet.evenement.entity.Utilisateur;

public interface IUtilisateurService {
	public abstract Utilisateur modificationUtilisateur(String nom, String prenom, String pseudonyme, String email,
			String pwd, Date dateDeNaissance) throws Exception;

}
