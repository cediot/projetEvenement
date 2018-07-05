package fr.projet.evenement.service;

import java.sql.Date;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.exception.ErreurFonctionnelleException;
import fr.projet.evenement.exception.ErreurTechniqueException;

public interface ICreationEvenementService {
	/**
	 * Creer un evenement.
	 *
	 * @param utilisteurId
	 *            l'id de l utilisateur createur
	 * @param nomEvenement
	 *            le nom de l'evenement
	 * @param adresse
	 *            l'adresse de l evenemement
	 * @param tarif
	 *            le tarif de l evenement
	 * @param dateDebutEvenement
	 *            la date de debut de l evenememnt
	 * @param dateFinEvenement
	 *            la date de la fin de l evenement
	 * @return l'evenement crée, leve une exception sinon
	 * @throws ErreurFonctionnelleException
	 *             si un probleme metier survient
	 * @throws ErreurTechniqueException
	 *             si un probleme technique survient
	 */
	public abstract Evenement CreerEvenement(int utilisateurId, String nomEvenement, String adresse, double tarif,
			Date dateDebutEvenement, Date dateFinEvenement) throws Exception;

}
