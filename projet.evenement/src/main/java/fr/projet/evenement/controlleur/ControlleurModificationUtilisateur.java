package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.json.UtilisateurJson;
import fr.projet.evenement.service.IUtilisateurService;

@RestController
@RequestMapping("/modification/utilisateur")

public class ControlleurModificationUtilisateur {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurService service;

	@RequestMapping(produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8", method = {
			RequestMethod.PUT }) // put envoie
	public ResponseEntity<Object> modUti001(@RequestBody UtilisateurJson modComJson) {
		ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur{}", modComJson);
		ResponseEntity<Object> reponse = null;
		Utilisateur user = null;
		try {
			user = this.service.modificationUtilisateur(modComJson.getNom(), modComJson.getPrenom(),
					modComJson.getPseudonyme(), modComJson.getEmail(), modComJson.getPwd(),
					modComJson.getDateDeNaissance());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur qui a plente!",
					e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(user, HttpStatus.OK);
			ControlleurModificationUtilisateur.LOG.debug("Dans mon WS ControlleurModificationUtilisateur tout est ok");
		}
		return reponse;
	}
}
