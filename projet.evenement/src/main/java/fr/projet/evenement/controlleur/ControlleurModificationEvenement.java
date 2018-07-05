package fr.projet.evenement.controlleur;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.json.EvenementUtilisateurJson;
import fr.projet.evenement.json.ExceptionJson;
import fr.projet.evenement.service.IEvenementService;

@RestController
@RequestMapping("/modification/evenement")

public class ControlleurModificationEvenement {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IEvenementService service;

	public ResponseEntity<Object> even002(@RequestBody EvenementUtilisateurJson eveUtilJson) {
		ControlleurModificationEvenement.LOG.debug("Dans mon WS ControlleurEvenement {}", eveUtilJson);
		ResponseEntity<Object> reponse = null;
		Collection<Evenement> evenements = null;
		try {
			evenements = this.service.findEvenementByUserId(eveUtilJson.getIdUtilisateur(),
					eveUtilJson.isEvenementValider(), eveUtilJson.isEvenementParticiper(),
					eveUtilJson.isEvenementCreateur());
		} catch (Exception e) {
			reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
			ControlleurModificationEvenement.LOG.debug("Dans mon WS ControlleurEvenement qui a plente!", e);
		}
		if (reponse == null) {
			reponse = new ResponseEntity<>(evenements, HttpStatus.OK);
			ControlleurModificationEvenement.LOG.debug("Dans mon WS ControlleurEvenement tout est ok");
		}
		return reponse;
	}

}
