package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.json.CreerEvenementJson;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.service.ICreationEvenementService;

@RestController
@RequestMapping("/creerunevenement")
public class ControlleurCreationEnvenement {
	private static final Logger LOG = LogManager.getLogger();

	private ICreationEvenementService service;

	// http://localhost:8080/creerunevenement en PUT uniquement
	// avec un json dans le body : {"utilisateurId" : "2", "nomEvenement": "wazemme
	// accordeon", "adresse": "5 rue des halles", "tarif":"20,00", "Date
	// debut":"04/06/2018", "date de
	// fin":"05/06/2018"}
	@RequestMapping(produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8", method = {
			RequestMethod.PUT })
	public ResponseEntity<Object> creeEven(@RequestBody CreerEvenementJson creeEvenJson) {
		ControlleurCreationEnvenement.LOG.debug("Dans mon WS ControlleurCreationEvenement {}", creeEvenJson);
		ResponseEntity<Object> reponse = null;
		Evenement even = null;
		try {
			even = this.service.CreerEvenement(creeEvenJson.getUtilisateurId(), creeEvenJson.getNomEvenement(),
					creeEvenJson.getAdresse(), creeEvenJson.getTarif(), creeEvenJson.getDateDebutEvenement(),
					creeEvenJson.getDeteFinEvenement());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurCreationEnvenement.LOG.debug("Dans mon WS ControlleurCreationEvenement qui plante!", e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(even, HttpStatus.OK);
			ControlleurCreationEnvenement.LOG.debug("Dans mon WS ControlleurCreationEvenement tout est ok");
		}
		return reponse;

	}
}
