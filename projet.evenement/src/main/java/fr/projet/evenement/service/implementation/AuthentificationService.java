package fr.projet.evenement.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.ErreurTechniqueException;
import fr.projet.evenement.exception.ErreurFonctionnelleException;
import fr.projet.evenement.exception.UtilisateurNonReconnuException;
import fr.projet.evenement.service.IAuthentificationService;

@Service
public class AuthentificationService implements IAuthentificationService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	private IUtilisateurDAO util;

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Utilisateur authentifier(String pEmail, String pMotDePasse)
			throws ErreurFonctionnelleException, ErreurTechniqueException {


		AuthentificationService.LOG.debug("authentifier {} Xxxx", pEmail);
		if (pEmail == null || pEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email");
		}
		if (pMotDePasse == null || pMotDePasse.trim().length() == 0) {
			throw new IllegalArgumentException("password");
		}
		Utilisateur resultat = this.util.findLoginMotDePasse(pEmail, pMotDePasse);
		if (resultat == null) {
			throw new UtilisateurNonReconnuException();
		}
		AuthentificationService.LOG.debug("authentifier Resultat = {} ", resultat);
		return resultat;
	}
}