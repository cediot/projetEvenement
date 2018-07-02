package fr.projet.evenement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Categorie;
import fr.projet.evenement.entity.Evenement;

@Repository
public interface IEvenementDAO extends PagingAndSortingRepository<Evenement, Integer> {
	// evenement(s) pour une cate
	// Query("from Evenement e, IN(e.categories) cats where cats.id = :cat.id")
	@Query("from Evenement e where :cat member e.categories")
	public List<Evenement> findEvenementContainingCategories(@Param("cat") Categorie cat);

	// evenements qui ont plusieurs categories

	// @Query("from Evenement e, IN(e.categories) cats where cats.id = :cat1.id or
	// cats.id = :cat2.id or cats.id = :cat3.id")
	// public List<Evenement> findEvenementByCategories(@Param("cat1") Categorie
	// cat1, @Param("cat2") Categorie cat2,
	// @Param("cat3") Categorie cat3);
}
