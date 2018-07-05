package fr.projet.evenement.dao;

import java.sql.Timestamp;
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

	@Autowired
	private Evenement createEvenement() throws Exception {
		Evenement unEvenenement = new Evenement();
		// 02/07/1994
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		unEvenenement.setAdresse("5 allee des mimosas");
		// unEvenenement.setCategories(categories);
		unEvenenement.setDateDebut(new java.sql.Timestamp(sdf.parse("17/01/2018").getTime()));
		unEvenenement.setDateFin(new java.sql.Timestamp(sdf.parse("18/01/2018").getTime()));
		unEvenenement.setNom("Michel");
		// unEvenenement.setRessources(ressources);
		unEvenenement.setTarif(10D);
		// unEvenenement.setUtilisateur(utilisateur);
		// unEvenenement.setUtilisateurs1(utilisateurs1);
		// unEvenenement.setUtilisateurs2(utilisateurs2);
		unEvenenement.setValidation((byte) 1);
		return unEvenenement;
	}

	@Test
	public void testFindByDate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Timestamp dateChoisi = new Timestamp(sdf.parse("17/01/2018 09:00:00").getTime());

		List<Evenement> evt = this.dao.findByDateDebut(dateChoisi);
		Assert.assertNotNull("Ma liste ne doit pas etre null", evt);

		for (Evenement evenement : evt) {
			Assert.assertNotNull("L'evenement ne doit pas etre null", evenement);
			Timestamp dd = evenement.getDateDebut();
			Assert.assertNotNull("les dates ne doivent pas etre nul", dd);
			Assert.assertTrue("la date de l evenement doit etre egale ou apres la date choisi",
					dd.after(dateChoisi) || dd.equals(dateChoisi));
		}
	}

	@Test
	public void testFindByDateBetween() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Timestamp dateChoisiDebut = new Timestamp(sdf.parse("17/01/2018 09:00:00").getTime());
		Timestamp dateChoisiFin = new Timestamp(sdf.parse("20/01/2018 09:00:00").getTime());
		List<Evenement> evt = this.dao.findByDateBetween(dateChoisiDebut, dateChoisiFin);
		Assert.assertNotNull("Ma liste ne doit pas etre null", evt);

		for (Evenement evenement : evt) {
			Assert.assertNotNull("L'evenement ne doit pas etre null", evenement);
			Timestamp dd = evenement.getDateDebut();
			Assert.assertNotNull("les dates ne doivent pas etre nul", dd);
			Assert.assertTrue("la date de l evenement doit etre entre la date de debut et la date de fin",
					dd.after(dateChoisiDebut) && dd.before(dateChoisiFin));
		}
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

	@Test
	public void testfindEvenementByCategoriesOk() throws Exception {
		final int catId = 2;
		Categorie cat1 = this.daoCategorie.findOne(catId);
		Assert.assertNotNull("La categorie ne doit pas etre null", cat1);
		Assert.assertEquals("L'id doit etre " + catId, catId, cat1.getId());

		final int catIdDeux = 3;
		Categorie cat2 = this.daoCategorie.findOne(catIdDeux);
		Assert.assertNotNull("La categorie ne doit pas etre null", cat2);
		Assert.assertEquals("L'id doit etre " + catIdDeux, catIdDeux, cat2.getId());

		final int catIdTrois = 5;
		Categorie cat3 = this.daoCategorie.findOne(catIdTrois);
		Assert.assertNotNull("La categorie ne doit pas etre null", cat3);
		Assert.assertEquals("L'id doit etre " + catIdTrois, catIdTrois, cat3.getId());

		Assert.assertNotEquals(cat1, cat2);
		Assert.assertNotEquals(cat2, cat3);
		Assert.assertNotEquals(cat1, cat3);

		List<Evenement> evt = this.dao.findEvenementByCategories(cat1, cat2, cat3);
		Assert.assertNotNull("Ma liste ne doit pas etre null", evt);

		for (Evenement evenement : evt) {
			Assert.assertNotNull("L'evenement ne doit pas etre null", evenement);
			List<Categorie> catEvn = evenement.getCategories();
			Assert.assertNotNull("Les categories de l'evenement ne doivent pas etre null", catEvn);
			boolean trouve[] = { false, false, false };
			for (Categorie categorie : catEvn) {
				if (categorie.equals(cat1)) {
					trouve[0] = true;
					continue;
				}
				if (categorie.equals(cat2)) {
					trouve[1] = true;
					continue;
				}
				if (categorie.equals(cat3)) {
					trouve[2] = true;
					continue;
				}
			}
			Assert.assertTrue("Une des categories doit être celle demandee", trouve[0] && trouve[1] && trouve[2]);
		}

	}
}
