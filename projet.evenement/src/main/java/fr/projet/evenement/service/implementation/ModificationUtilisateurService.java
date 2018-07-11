package fr.projet.evenement.service.implementation;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.UtilisateurIdentiqueException;
import fr.projet.evenement.service.IUtilisateurService;

public class ModificationUtilisateurService implements IUtilisateurService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	@Autowired
	private IUtilisateurDAO util;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Utilisateur modificationUtilisateur(String nom, String prenom, String pseudonyme, String email,
			String motDePasse, Date dateDeNaissance) throws Exception {

		ModificationUtilisateurService.LOG.debug("creationCompte {} Xxxx");
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email");
		}
		if (motDePasse == null || motDePasse.trim().length() == 0) {
			throw new IllegalArgumentException("motDePasse");
		}
		Utilisateur entite = new Utilisateur();
		entite.getNom();
		entite.getPrenom();
		entite.getPseudonyme();
		entite.getEmail();
		entite.getMotDePasse();
		entite.getDateDeNaissance();
		Utilisateur resultat = null;
		if (this.util.findEmail(email) == null) { // il existe deja
			resultat = this.util.save(entite);
		} else {
			throw new UtilisateurIdentiqueException("meme utilisateur" + email);
		}
		entite.setNom(nom);
		entite.setPrenom(prenom);
		entite.setPseudonyme(pseudonyme);
		entite.setEmail(email);
		entite.setMotDePasse(motDePasse);
		entite.setDateDeNaissance(dateDeNaissance);

		ModificationUtilisateurService.LOG.debug("Modification Resultat = {} ", resultat);
		return resultat;


		//// return null;
		////
		////
		////
		//// public Utilisateur save (Utilisateur id) {
		//// return this.util.save(id);
		//// }
		////
		////
		//// public Utilisateur findOne (int id) throws Exception {
		//// Utilisateur util = this.util.findOne(id);
		//// if (util == null) {
		//// throw new UtilisateurNonReconnuException("Utilisateur Inconnu");
		//// }
		//// return util;
		//// }
		//// }
		// }
		//
		//
		// @Override
		// public Utilisateur findOneByEmail(String email) throws Exception {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		//
		// @Override
		// public Utilisateur save(Utilisateur pUtilisateur) throws Exception {
		// // TODO Auto-generated method stub
		// return null;
	}

	@Override
	public Utilisateur findOneByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findLoginMotDePasse(String email, String motDePasse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur save(Utilisateur pUtilisateur) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
