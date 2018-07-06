package fr.projet.evenement.controlleur;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.json.EvenementUtilisateurJson;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.service.IEvenementService;

@RestController
@RequestMapping("/evenements")
public class ControlleurEvenement {

	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IEvenementService service;

	// http://localhost:8080/evenements/utilisateur en PUT uniquement
	// avec un json dans le body : {"idUtilisateur":1, "evenementValider": true,"evenementParticiper": true, "evenementCreateur":true}
	@RequestMapping(path = "/utilisateur", produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8", method = {
			RequestMethod.PUT })
	public ResponseEntity<Object> even001(@RequestBody EvenementUtilisateurJson eveUtilJson) {
		ControlleurEvenement.LOG.debug("Dans mon WS ControlleurEvenement {}", eveUtilJson);
		ResponseEntity<Object> reponse = null;
		Collection<Evenement> evenements = null;
		try {
			evenements = this.service.findEvenementByUserId(eveUtilJson.getIdUtilisateur(),
					eveUtilJson.isEvenementValider(),
					eveUtilJson.isEvenementParticiper(), eveUtilJson.isEvenementCreateur());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurEvenement.LOG.debug("Dans mon WS ControlleurEvenement qui a plente!", e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(evenements, HttpStatus.OK);
			ControlleurEvenement.LOG.debug("Dans mon WS ControlleurEvenement tout est ok");
		}
		return reponse;
	}

}
