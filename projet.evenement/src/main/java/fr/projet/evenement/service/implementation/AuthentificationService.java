package fr.projet.evenement.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.ErreurFonctionnelleException;
import fr.projet.evenement.exception.UtilisateurNonReconnuException;
import fr.projet.evenement.service.IAuthentificationService;

@Service
public class AuthentificationService implements IAuthentificationService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	@Autowired
	private IUtilisateurDAO utilisateurDao;

	@Override
	public Utilisateur authentifier(String pEmail, String pMotDePasse) throws ErreurFonctionnelleException {

		AuthentificationService.LOG.debug("authentifier {} Xxxx", pEmail);
		if (pEmail == null || pEmail.trim().isEmpty()) {
			throw new IllegalArgumentException("Email");
		}
		if (pMotDePasse == null || pMotDePasse.trim().length() == 0) {
			throw new IllegalArgumentException("MotDePasse");
		}
		Utilisateur resultat = this.utilisateurDao.findLoginMotDePasse(pEmail, pMotDePasse);
		if (resultat == null) {
			throw new UtilisateurNonReconnuException();
		}
		AuthentificationService.LOG.debug("authentifier Resultat = {} ", resultat);
		return resultat;
	}

	@Override
	public Utilisateur modification(Utilisateur pUtilisateur) throws Exception {

		return this.utilisateurDao(pUtilisateur);
	}

	private Utilisateur utilisateurDao(Utilisateur pUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}
}