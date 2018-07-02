package fr.projet.evenement.dao;

import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.projet.evenement.AbstractAnnotationTest;
import fr.projet.evenement.entity.Utilisateur;


public class UtilisateurDAOTest extends AbstractAnnotationTest {
	@Autowired
	private IUtilisateurDAO dao;

	private Utilisateur createUtilisateur() throws Exception {
		Utilisateur unUtilisateur = new Utilisateur();
		// 02/07/1994
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		unUtilisateur.setDateDeNaissance(sdf.parse("02/07/1994"));
		unUtilisateur.setEmail("florian-lec@hotmail.fr");
		unUtilisateur.setMotDePasse("toto");
		unUtilisateur.setNom("Lecocq");
		unUtilisateur.setPrenom("Florian");
		unUtilisateur.setPseudonyme("flo");
		unUtilisateur.setReputation(5);
		return unUtilisateur;
	}

	@Test
	public void testFindOneOk() throws Exception {
		Utilisateur uenbd = this.dao.save(this.createUtilisateur());
		Assert.assertNotNull("Le user ne doit pas etre null", uenbd);
		Assert.assertNotNull("L'id ne doit pas etre null", uenbd.getId());
		final int id = uenbd.getId();
		Utilisateur util = this.dao.findOne(uenbd.getId());
		Assert.assertNotNull("Le user ne doit pas etre null", util);
		Assert.assertEquals("L'id doit etre " + id, id, util.getId());
	}

	@Test
	public void testSauvegarderInsertOk() throws Exception {
		Utilisateur util = this.dao.save(this.createUtilisateur());
		Assert.assertNotNull("Le user ne doit pas etre null", util);
		Assert.assertNotNull("L'id ne doit pas etre null", util.getId());
	}

	@Test
	public void testSaveUpdateOk() throws Exception {
		Utilisateur uenbd = this.dao.save(this.createUtilisateur());
		Assert.assertNotNull("Le user ne doit pas etre null", uenbd);
		Assert.assertNotNull("L'id ne doit pas etre null", uenbd.getId());
		final int id = uenbd.getId();
		Utilisateur util = this.dao.findOne(uenbd.getId());
		util.setNom("tata");
		util = this.dao.save(util);
		Assert.assertNotNull("Le user ne doit pas etre null", util);
		Assert.assertEquals("L'id doit etre " + id, id, util.getId());
		Assert.assertEquals("Le nom doit etre tata", "tata", util.getNom());
	}

	@Test
	public void testDeleteOk() throws Exception {
		Utilisateur uenbd = this.dao.save(this.createUtilisateur());
		Assert.assertNotNull("Le user ne doit pas etre null", uenbd);
		Assert.assertNotNull("L'id ne doit pas etre null", uenbd.getId());
		this.dao.delete(uenbd.getId());
		Utilisateur util = this.dao.findOne(uenbd.getId());
		Assert.assertNull("Le user doit etre null", util);
	}

	@Test
	public void ComparateurUtil() throws Exception {
		Utilisateur comparateurUtil = this.dao.findOne(8);
		Utilisateur comparateurUtilDeux = this.dao.findOne(9);
		Assert.assertNotEquals("verifique qu'il n'y a pas deux utilisateur identique", comparateurUtil.getNom(),
				comparateurUtilDeux.getNom());
	}
}
