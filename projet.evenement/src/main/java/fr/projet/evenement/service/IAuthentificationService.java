package fr.projet.evenement.service;

import fr.projet.evenement.entity.Utilisateur;

public interface IAuthentificationService {
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
	public abstract Utilisateur authentifier(String pLogin, String pPassword)
			throws Exception;

}