package fr.projet.evenement.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.evenement.dao.IUtilisateurDAO;
import fr.projet.evenement.entity.Utilisateur;
import fr.projet.evenement.service.IUtilisateurService;

@Service
public class ModificationUtilisateurService implements IUtilisateurService {
	private static final Logger LOG = LogManager.getLogger(); // singleton
	@Autowired
	private IUtilisateurDAO utilisateurDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Utilisateur modificationUtilisateur(Utilisateur utilisateur) {
		return this.utilisateurDao.save(utilisateur);

	}

	@Override
	public Utilisateur findOneByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findLoginMotDePasse(String email, String motDePasse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur save(Utilisateur pUtilisateur) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
