package fr.projet.evenement.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.projet.evenement.AbstractAnnotationTest;
import fr.projet.evenement.entity.Categorie;
import fr.projet.evenement.entity.Evenement;

public class EvenementDAOTest extends AbstractAnnotationTest {
	@Autowired
	private IEvenementDAO dao;
	@Autowired
	private ICategorieDAO daoCategorie;

	private Evenement createEvenement() throws Exception {
		Evenement unEvenenement = new Evenement();
		// 02/07/1994
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		unEvenenement.setAdresse("5 allee des mimosas");
		// unEvenenement.setCategories(categories);
		unEvenenement.setDuree("1 jour");// TODO reflechir au format des delais des evenements
		unEvenenement.setNom("Michel");
		// unEvenenement.setRessources(ressources);
		unEvenenement.setTarif("10");// TODO typer le tarif en decimal
		// unEvenenement.setUtilisateur(utilisateur);
		// unEvenenement.setUtilisateurs1(utilisateurs1);
		// unEvenenement.setUtilisateurs2(utilisateurs2);
		unEvenenement.setValidation((byte) 1);
		return unEvenenement;
	}

	@Test
	public void testFindOneOk() throws Exception {
		final int id = 1;
		Evenement evt = this.dao.findOne(id);
		Assert.assertNotNull("L'evenement ne doit pas etre null", evt);
		Assert.assertEquals("L'id doit etre " + id, id, evt.getId());
	}

	@Test
	public void testfindEvenementByCategoryOk() throws Exception {
		final int catId = 2;
		Categorie cat1 = this.daoCategorie.findOne(catId);
		Assert.assertNotNull("La categorie ne doit pas etre null", cat1);
		Assert.assertEquals("L'id doit etre " + catId, catId, cat1.getId());

		List<Evenement> evt = this.dao.findEvenementContainingCategories(cat1);
		Assert.assertNotNull("Ma liste ne doit pas etre null", evt);

		for (Evenement evenement : evt) {
			Assert.assertNotNull("L'evenement ne doit pas etre null", evenement);
			List<Categorie> catEvn = evenement.getCategories();
			Assert.assertNotNull("Les categories de l'evenement ne doivent pas etre null", catEvn);
			boolean trouve = false;
			for (Categorie categorie : catEvn) {
				if (categorie.equals(cat1)) {
					trouve = true;
					break;
				}
			}
			Assert.assertTrue("Une des categories doit être celle demandee", trouve);
		}
	}
}
