package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Categorie;

@Repository
public interface ICategorieDAO extends PagingAndSortingRepository<Categorie, Integer> {
}
