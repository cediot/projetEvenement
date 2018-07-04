package fr.projet.evenement.service;

import java.util.Collection;

import fr.projet.evenement.entity.Evenement;

public interface IEvenementService {
	// TODO Javadoc
	public abstract Collection<Evenement> findEvenementByUserId(int idUtilisateur, boolean evenementValider,
			boolean evenementCreateur, boolean evenementParticiper) throws Exception;

}
