package fr.projet.evenement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Utilisateur;

@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<Utilisateur, Integer> {

	/**
	 * Selectionne tous les comptes qui appartiennent a un utilisateur.
	 *
	 * @param aUserId
	 *            un utilisateur id
	 * @return tous les comptes de l'utilisateur
	 */
	@Query("FROM Utilisateur uti where uti.email = :pEmail and uti.motDePasse = :pMotDePasse")
	public Utilisateur findLoginMotDePasse(@Param("pEmail") String pEmail, @Param("pMotDePasse") String pMotDePasse);

	@Query("FROM Utilisateur uti where uti.email = :pEmail")
	public Utilisateur findEmail(@Param("pEmail") String pEmail);


}
