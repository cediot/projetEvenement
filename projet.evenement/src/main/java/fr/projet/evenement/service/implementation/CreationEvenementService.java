package fr.projet.evenement.service.implementation;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.dao.IEvenementDAO;
import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.service.ICreationEvenementService;

@Service
public class CreationEvenementService implements ICreationEvenementService {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IEvenementDAO dao;
	@Autowired
	private IUtilisateurDAO daoUtilisateur;

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Evenement creerEvenement(int utilisateurId, String nomEvenement, String adresse, double tarif,
			Timestamp dateDebutEvenement, Timestamp dateFinEvenement) throws Exception {

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
		Evenement e = new Evenement();
		e.setAdresse(adresse);
		e.setDateDebut(dateDebutEvenement);
		e.setDateFin(dateFinEvenement);
		e.setTarif(tarif);
		e.setNom(nomEvenement);
		e.setUtilisateur(this.daoUtilisateur.findOne(utilisateurId));

		Evenement resultat = this.dao.save(e);

		CreationEvenementService.LOG.debug("CreerEvenement resultat{} Xxxx", resultat);
		return resultat;
	}
}
