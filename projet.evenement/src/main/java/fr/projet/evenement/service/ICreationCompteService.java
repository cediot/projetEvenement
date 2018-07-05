package fr.projet.evenement.service;

import java.sql.Date;

import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.ErreurFonctionnelleException;
import fr.projet.evenement.exception.ErreurTechniqueException;

public interface ICreationCompteService {
	/**
	 * Authentifie un utilisateur.
	 *
	 * @param pLogin
	 *            le login
	 * @param pPassword
	 *            le password
	 * @return l'utilisateur authentifie, leve une exception sinon
	 * @throws ErreurFonctionnelleException
	 *             si un probleme metier survient
	 * @throws ErreurTechniqueException
	 *             si un probleme technique survient
	 */
	public abstract Utilisateur creationCompte(String nom, String prenom, String pseudonyme, String email, String pwd,
			Date dateDeNaissance) throws Exception;

}
