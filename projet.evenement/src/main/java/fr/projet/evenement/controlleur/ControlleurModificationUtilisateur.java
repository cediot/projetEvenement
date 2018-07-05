// package fr.projet.evenement.controlleur;
//
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
//
// import fr.projet.evenement.entity.Utilisateur;
// import fr.projet.evenement.json.CompteJson;
// import fr.projet.evenement.json.ExceptionJson;
// import fr.projet.evenement.service.IUtilisateurService;
//
// @RestController
// @RequestMapping("/modification/utilisateur")
//
// public class ControlleurModificationUtilisateur {
// private static final Logger LOG = LogManager.getLogger();
//
// @Autowired
// private IUtilisateurService service;
// @RequestMapping(produces = "application/json; charset=UTF-8", consumes =
// "application/json; charset=UTF-8", method = {
// RequestMethod.PUT })
// public ResponseEntity<Object> crea001(@RequestBody CompteJson
// creaComJson)
// {
// ControlleurModificationUtilisateur.LOG.debug("Dans mon WS
// ControlleurCreationCompte{}", creaComJson);
// ResponseEntity<Object> reponse = null;
// Utilisateur user = null;
// try {
// user = this.service.modificationCompte(creaComJson.getNom(),
// creaComJson.getPrenom(),
// creaComJson.getPseudonyme(), creaComJson.getEmail(), creaComJson.getPwd(),
// creaComJson.getDateDeNaissance());
// } catch (Exception e) {
// reponse = new ResponseEntity<>(new ExceptionJson(e), HttpStatus.NOT_FOUND);
// ControlleurModificationUtilisateur.LOG.debug("Dans mon WS
// ControlleurCreationCompte qui a plente!", e);
// }
// if (reponse == null) {
// reponse = new ResponseEntity<>(user, HttpStatus.OK);
// ControlleurModificationUtilisateur.LOG.debug("Dans mon WS
// ControlleurCreationCompte tout est ok");
// }
// return reponse;
// }
// }
