package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Evenement;

@Repository
public interface IEvenementDAO extends PagingAndSortingRepository<Evenement, Integer> {
}
