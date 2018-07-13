package fr.projet.evenement.service.implementation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projet.evenement.dao.IEvenementDAO;
import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Evenement;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.exception.UtilisateurNonReconnuException;
import fr.projet.evenement.service.IEvenementService;

@Service
public class EvenementService implements IEvenementService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	@Autowired
	private IUtilisateurDAO util;
	@Autowired
	private IEvenementDAO evenementDao;

	@Override
	public Collection<Evenement> findEvenementByUserId(int idUtilisateur, boolean evenementValider,
			boolean evenementCreateur, boolean evenementParticiper) throws Exception {

		Utilisateur u = this.util.findOne(idUtilisateur);
		if (u == null) {
			throw new UtilisateurNonReconnuException();
		} else {
			Set<Evenement> resu = new HashSet<>();
			if (evenementCreateur) {
				resu.addAll(u.getEvenementsDontJeSuisLeCreateur());
			}
			if (evenementParticiper) {
				resu.addAll(u.getEvenementsOuJeParticipe());
			}
			if (evenementValider) {
				resu.addAll(u.getEvenementsValides());
			}

			return resu;
		}
	}

	@Override
	public Evenement findOne(int idEvenement) throws Exception {
		Evenement event = this.evenementDao.findOne(idEvenement);
		if (event == null) {
			throw new Exception("evenement inconnu");
		}
		return event;
	}

	@Override
	public Evenement save(Evenement pEvenement) {
		return this.evenementDao.save(pEvenement);
	}

	@Override
	public Evenement modification(Evenement evenement) {
		return this.evenementDao.save(evenement);
	}

}
