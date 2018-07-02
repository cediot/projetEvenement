package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Utilisateur;

@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<Utilisateur, Integer> {

	// La requete DOIT etre en JPQL (ce n'est pas du SQL)
	// En JPQL : untable = uneclasse, unecolonne = unattribut
	// @Query("")
	// public List<Utilisateur> searchUtilisateur(String pNom, String pPrenom);
}
