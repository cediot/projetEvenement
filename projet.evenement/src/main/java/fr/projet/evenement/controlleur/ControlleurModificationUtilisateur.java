package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.service.IUtilisateurService;

@RestController
@RequestMapping("/modification/utilisateur")
public class ControlleurModificationUtilisateur {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurService utilisateurService;


	@RequestMapping(produces = "application/json; charset=UTF-8", method = { RequestMethod.PUT }) // put envoie

	public Utilisateur modUti001(@RequestBody() Utilisateur utilisateur)
	{

		ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur{}", utilisateur);
		this.utilisateurService.modificationUtilisateur(utilisateur);
		//		ResponseEntity<Object> reponse = null;
		//		Utilisateur user = null;
		//		try {
		//			user = this.service.findOneByEmail(Utilisateur.getEmail());
		//			user.setDateDeNaissance(Utilisateur.getDateDeNaissance());
		//			user.setEmail(Utilisateur.getEmail());
		//			user.setNom(Utilisateur.getNom());
		//			user.setPrenom(Utilisateur.getPrenom());
		//			user.setDateDeNaissance(Utilisateur.getDateDeNaissance());
		//			user = this.service.save(user);
		//		} catch (Exception e) {
		//			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
		//			ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur qui a plente!",
		//					e);
		//		}
		//		if (reponse == null) {
		//			reponse = new ResponseEntity<>(user, HttpStatus.OK);
		//			ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur tout est ok");
		//		}
		return utilisateur;
	}
}
