package fr.projet.evenement.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Categorie;
import fr.projet.evenement.entity.Evenement;

@Repository
public interface IEvenementDAO extends PagingAndSortingRepository<Evenement, Integer> {
	// evenement(s) pour une categorie
	@Query("from Evenement e where :cat member e.categories")
	public List<Evenement> findEvenementContainingCategories(@Param("cat") Categorie cat);

	// // evenement(s) qui ont 2 categories
	@Query("from Evenement e where :cat1 member e.categories and :cat2 member e.categories")
	public List<Evenement> findEvenementByCategories(@Param("cat1") Categorie cat1, @Param("cat2") Categorie cat2);

	// evenement(s) qui ont 3 categories
	@Query("from Evenement e where :cat1 member e.categories and :cat2 member e.categories and :cat3 member e.categories")
	public List<Evenement> findEvenementByCategories(@Param("cat1") Categorie cat1, @Param("cat2") Categorie cat2,
			@Param("cat3") Categorie cat3);

	// evenement(s) par date
	@Query("from Evenement e where e.dateDebut >= :dateDebut order by e.dateDebut DESC")
	public abstract List<Evenement> findByDateDebut(@Param("dateDebut") Timestamp dateDebut);

	// evenement(s) entre deux date
	// select Evenement from evenemnt where "la date de debut d un evenement est
	// comprise entre deux dates choisies
	@Query("from Evenement e where e.dateDebut between :dateDebut and :dateFin order by e.dateDebut DESC")
	public abstract List<Evenement> findByDateBetween(@Param("dateDebut") Timestamp dateDebut,
			@Param("dateFin") Timestamp dateFin);

}
