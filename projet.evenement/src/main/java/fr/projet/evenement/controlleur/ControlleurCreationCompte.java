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
import fr.projet.evenement.json.CreationCompteJson;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.service.ICreationCompteService;

@RestController
@RequestMapping("/creationCompte")
public class ControlleurCreationCompte {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private ICreationCompteService service;

	// http://localhost:8080/creationCompte en PUT uniquement
	// avec un json dans le body :
	// {"nom":"legrand","prenom":"gerald","pseudonyme":"gege","email":"toto@oll.com","pwd":"tata","dateDeNaissance":\"1997-07-15\"}
	// String nom, String prenom,

	@RequestMapping(produces = "application/json; charset=UTF-8", consumes =
			"application/json; charset=UTF-8", method = {
					RequestMethod.PUT })
	public ResponseEntity<Object> crea001(@RequestBody CreationCompteJson
			creaComJson)
	{
		ControlleurCreationCompte.LOG.debug("Dans mon WS ControlleurCreationCompte{}", creaComJson);
		ResponseEntity<Object> reponse = null;
		Utilisateur user = null;
		try {
			user = this.service.creationCompte(creaComJson.getNom(),
					creaComJson.getPrenom(),
					creaComJson.getPseudonyme(), creaComJson.getEmail(), creaComJson.getPwd(),
					creaComJson.getDateDeNaissance());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurCreationCompte.LOG.debug("Dans mon WS ControlleurCreationCompte qui a plente!", e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(user, HttpStatus.OK);
			ControlleurCreationCompte.LOG.debug("Dans mon WS ControlleurCreationCompte tout est ok");
		}
		return reponse;
	}

}
