package fr.projet.evenement.json;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.projet.evenement.AbstractAnnotationTest;

public class EvenementJsonTest extends AbstractAnnotationTest {
	private static final Logger LOG = LogManager.getLogger();

	@Test
	public void testEventJson() throws Exception {
		String s = "{\"utilisateurId\" : 2, \"nomEvenement\": \"wazemme accordeon\", \"adresse\": \"5 rue des halles\", \"tarif\":20.50, \"dateDebutEvenement\":\"2018-08-06T10:00:00.000\", \"dateFinEvenement\":\"2018-08-12T10:00:00.000\"}";
		ObjectMapper mapper = new ObjectMapper();
		CreerEvenementJson e = mapper.readValue(s, CreerEvenementJson.class);
		EvenementJsonTest.LOG.debug("resultat {}", e);
	}

	@Test
	public void testEventJson2() throws Exception {
		CreerEvenementJson cj = new CreerEvenementJson();
		cj.setAdresse("5 rue des halles");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		cj.setDateDebutEvenement(new Timestamp(sdf.parse("2018-20-09 10:00").getTime()));
		cj.setDateFinEvenement(new Timestamp(sdf.parse("2018-30-09 10:00").getTime()));
		cj.setNomEvenement("wazemme accordeon");
		cj.setTarif(20.5D);
		cj.setUtilisateurId(2);
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(cj);
		EvenementJsonTest.LOG.debug("resultat {}", s);
	}

}
