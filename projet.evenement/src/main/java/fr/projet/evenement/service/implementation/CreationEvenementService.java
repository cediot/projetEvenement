package fr.projet.evenement.service.implementation;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.exception.EvenemenetNonReconnuException;
import fr.projet.evenement.service.ICreationEvenementService;

@Service
public class CreationEvenementService implements ICreationEvenementService {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private ICreationEvenementService even;

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Evenement CreerEvenement(int utilisateurId, String nomEvenement, String adresse, double tarif,
			Date dateDebutEvenement, Date dateFinEvenement) throws Exception {

		CreationEvenementService.LOG.debug("CreerEvenement {} Xxxx", nomEvenement);
		if (utilisateurId == 0) {
			throw new IllegalArgumentException("id incorrect");
		}
		if (nomEvenement == null || nomEvenement.trim().isEmpty()) {
			throw new IllegalArgumentException("nom evenenement incorrect");
		}
		if (adresse == null || adresse.trim().isEmpty()) {
			throw new IllegalArgumentException("adresse incorrect");
		}
		if (tarif < 0) {
			throw new IllegalArgumentException("tarif incorrect");
		}
		Date now = new Date(System.currentTimeMillis());
		if (dateDebutEvenement.before(now)) {
			throw new IllegalArgumentException("date de debut incorrect");
		}
		if (dateFinEvenement.before(dateDebutEvenement)) {
			throw new IllegalArgumentException("date de fin incorrect");
		}
		Evenement resultat = this.even.CreerEvenement(utilisateurId, nomEvenement, adresse, tarif, dateDebutEvenement,
				dateFinEvenement);
		if (resultat == null) {
			throw new EvenemenetNonReconnuException();
		}
		CreationEvenementService.LOG.debug("CreerEvenement resultat{} Xxxx", resultat);
		return resultat;
	}
}
