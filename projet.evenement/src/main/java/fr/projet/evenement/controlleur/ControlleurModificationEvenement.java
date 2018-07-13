package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.service.IEvenementService;

@RestController
@RequestMapping("/modification/evenement")
public class ControlleurModificationEvenement {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IEvenementService evenementsService;

	@RequestMapping(produces = "application/json; charset=UTF-8", method = { RequestMethod.PUT })
	public Evenement modifEven(@RequestBody() Evenement evenement) {
		ControlleurModificationEvenement.LOG.debug("Dans mon controlleur modification evenement", evenement);
		this.evenementsService.modification(evenement);
		// Evenement eEnBase = null;
		// Evenement eEnBaseModif = null;
		//
		// try {
		// ControlleurModificationEvenement.LOG.debug("Dans le try de findOne");
		// eEnBase = this.service.findOne(modifEvenJson.getIdEvenement());
		//
		// eEnBaseModif = this.service.modification(eEnBase);
		//
		//
		//
		// ControlleurModificationEvenement.LOG.debug("Fin de modification");
		// } catch (Exception e) {
		// ControlleurModificationEvenement.LOG.debug("Exception");
		// return new ResponseEntity<Object>("Eve introuvable",
		// HttpStatus.NOT_MODIFIED);
		//
		// }
		// // ControlleurModificationEvenement.LOG.debug("Dans modification de
		// l'event");
		// // eEnBase.setId(modifEvenJson.getIdEvenement());
		//
		// try {
		// ControlleurModificationEvenement.LOG.debug("Dans la methode Save");
		// eEnBase = this.service.save(eEnBase);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// // gestion des erreurs
		// return new ResponseEntity<Object>(eEnBase, HttpStatus.OK);
		return evenement;
	}
}
