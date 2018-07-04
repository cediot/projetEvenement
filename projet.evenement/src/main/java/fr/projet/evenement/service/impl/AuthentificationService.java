// package fr.projet.evenement.service.impl;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// import fr.projet.evenement.dao.IUtilisateurDAO;
// import fr.projet.evenement.entity.Utilisateur;
// import fr.projet.evenement.service.IAuthentificationService;
//
// @Service
// public class AuthentificationService implements IAuthentificationService {
// @Autowired
// private IUtilisateurDAO util;
//
// @Override
// @Transactional(readOnly = true, rollbackFor = Exception.class)
// public Utilisateur authentifier(String pLogin, String pPassword)
// throws FonctionnelleException, ErreurTechniqueException {
// AuthentificationService.LOG.debug("authentifier {} Xxxx", pLogin);
// if (pLogin == null || pLogin.trim().length() == 0) {
// throw new IllegalArgumentException("login");
// }
// if (pPassword == null || pPassword.trim().length() == 0) {
// throw new IllegalArgumentException("password");
// }
// Utilisateur resultat = this.getUtilisateurDAO().selectLogin(pLogin);
// if (resultat == null) {
// throw new UtilisateurInconnuException();
// }
// if (!pPassword.equals(resultat.getPassword())) {
// throw new MauvaisMotdepasseException();
// }
// AuthentificationService.LOG.debug("authentifier Resultat = {} ", resultat);
// return resultat;
// }
// }