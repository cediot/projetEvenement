package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creationCompte")
public class ControlleurCreationCompte {
	private static final Logger LOG = LogManager.getLogger();

	// @Autowired
	// private IAuthentificationService service;
	//
	// // http://localhost:8080/creationCompte en PUT uniquement
	// // avec un json dans le body : {"email":"toto@oll.com", "pwd":"tata"}
	// @RequestMapping(produces = "application/json; charset=UTF-8", consumes =
	// "application/json; charset=UTF-8", method = {
	// RequestMethod.PUT })
	// public ResponseEntity<Object> crea001(@RequestBody AuthentifierJson autJson)
	// {
	// ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurCreationCompte {}",
	// autJson);
	// ResponseEntity<Object> reponse = null;
	// Utilisateur user = null;
	// try {
	// user = this.service.authentifier(autJson.getEmail(), autJson.getPwd());
	// } catch (Exception e) {
	// reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
	// ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurCreationCompte qui
	// a plente!", e);
	// }
	// if (reponse == null) {
	// reponse = new ResponseEntity<>(user, HttpStatus.OK);
	// ControlleurAuthentifier.LOG.debug("Dans mon WS ControlleurCreationCompte tout
	// est ok");
	// }
	// return reponse;
	// }

}
