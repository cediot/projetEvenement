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
import fr.projet.evenement.json.AuthentifierJson;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.service.IAuthentificationService;

@RestController
@RequestMapping("/authentifier")
public class ControlleurAuthentifier {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IAuthentificationService service;

	// http://localhost:8080/authentifier en PUT uniquement
	// avec un json dans le body : {"email":"toto@oll.com", "pwd":"tata"}
	@RequestMapping(produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8", method = {
			RequestMethod.PUT })
	public ResponseEntity<Object> auth001(@RequestBody AuthentifierJson autJson) {
		ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurAuthentifier");
		ResponseEntity<Object> reponse = null;
		Utilisateur user = null;
		try {
			user = this.service.authentifier(autJson.getEmail(), autJson.getPwd());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurAuthentifier qui a plente!", e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(user, HttpStatus.ACCEPTED);
			ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurAuthentifier tout est ok");
		}
		return reponse;
	}

}


