package fr.projet.evenement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Utilisateur;

@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<Utilisateur, Integer> {

	/**
	 * Selectionne un utilisateur en fonction de son email et son mot de passe.
	 *
	 * @param pEmail
	 *            une adresse mail
	 * @param pMotDePasse
	 *            un mot de passe
	 * @return un utilisateur
	 */
	@Query("FROM Utilisateur uti where uti.email = :pEmail and uti.motDePasse = :pMotDePasse")
	public Utilisateur findLoginMotDePasse(@Param("pEmail") String pEmail, @Param("pMotDePasse") String pMotDePasse);

	@Query("FROM Utilisateur uti where uti.email = :pEmail")
	public Utilisateur findEmail(@Param("pEmail") String pEmail);


}
