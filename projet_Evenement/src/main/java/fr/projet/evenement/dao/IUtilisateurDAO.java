package fr.projet.evenement.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.projet.evenement.entity.Utilisateur;

@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<Utilisateur, Integer> {
}
