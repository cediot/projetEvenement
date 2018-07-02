package fr.projet.evenement.dao;

import org.springframework.beans.factory.annotation.Autowired;

import fr.projet.evenement.AbstractAnnotationTest;
import fr.projet.evenement.entity.Categorie;


public class CategorieDAOTest extends AbstractAnnotationTest {
	@Autowired
	private ICategorieDAO dao;

	private Categorie createCategorie() {
		Categorie uneCat = new Categorie();
		return uneCat;
	}

}
