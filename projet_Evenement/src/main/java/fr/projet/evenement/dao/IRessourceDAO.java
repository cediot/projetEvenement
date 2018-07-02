package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Ressource;

@Repository
public interface IRessourceDAO extends PagingAndSortingRepository<Ressource, Integer> {
}
