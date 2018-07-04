package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Utilisateur;

@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<Utilisateur, Integer> {

	// /**
	// * Selectionne tous les comptes qui appartiennent a un utilisateur.
	// *
	// * @param aUserId
	// * un utilisateur id
	// * @return tous les comptes de l'utilisateur
	// */
	// @Query("FROM Utilisateur uti where uti.id = :aUserId order by cpt.libelle")
	// public Utilisateur FindUserAndPwd(@Param("nomDeCompte") String nomDeCompte,
	// @Param("motDePasse") String motDePasse);
}
