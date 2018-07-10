package fr.projet.evenement.service.implementation;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.ErreurFonctionnelleException;
import fr.projet.evenement.exception.ErreurTechniqueException;
import fr.projet.evenement.exception.UtilisateurIdentiqueException;
import fr.projet.evenement.service.ICreationUtilisateurService;

@Service
public class CreationUtilisateurService implements ICreationUtilisateurService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	@Autowired
	private IUtilisateurDAO util;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Utilisateur creationCompte(String nom, String prenom, String pseudonyme, String email, String motDePasse,
			Date dateDeNaissance) throws ErreurFonctionnelleException, ErreurTechniqueException {
		CreationUtilisateurService.LOG.debug("creationCompte {} Xxxx");
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email");
		}
		Utilisateur entite = new Utilisateur();
		entite.setNom(nom);
		entite.setPrenom(prenom);
		entite.setPseudonyme(pseudonyme);
		entite.setEmail(email);
		entite.setMotDePasse(motDePasse);
		entite.setDateDeNaissance(dateDeNaissance);
		Utilisateur resultat = null;
		if (this.util.findEmail(email) == null) { // il existe deja
			resultat = this.util.save(entite);
		} else {
			throw new UtilisateurIdentiqueException("meme utilisateur" + email);

		}
		CreationUtilisateurService.LOG.debug("authentifier Resultat = {} ", resultat);
		return resultat;

	}

}
