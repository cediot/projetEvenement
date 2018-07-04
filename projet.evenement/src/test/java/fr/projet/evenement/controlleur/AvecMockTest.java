package fr.projet.evenement.controlleur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.projet.evenement.AbstractAnnotationTest;
import fr.projet.evenement.json.AuthentifierJson;

/**
 * Test sur le web service d'authentification. <br/>
 */
@WebAppConfiguration
public class AvecMockTest extends AbstractAnnotationTest {
	private static final Logger LOG = LogManager.getLogger();

	private static final String AUTHENTIFIER_URL = "/authentifier";

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc; // faux objet

	/**
	 * Fabrication de notre mock MVC
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	/**
	 * Usage des mock.
	 *
	 * @throws Exception
	 */
	@Test
	public void testAuthentifierOk() throws Exception {
		AvecMockTest.LOG.trace("Test - testAuthentifierOk");
		AuthentifierJson loginBean = new AuthentifierJson();
		loginBean.setEmail("cediot@ici.fr");
		loginBean.setPwd("toto");
		// Objet -> Json en Jackson
		ObjectMapper mapper = new ObjectMapper();
		String loginBeanAsJSon = mapper.writeValueAsString(loginBean);
		AvecMockTest.LOG.debug(loginBeanAsJSon);

		// On appelle le web service en POST, en envoyant du JSON
		// Attention : il n'y a plus d'URL complet (http://....)
		// Juste l'URL du web service <=> @RequestMapping
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.put(AvecMockTest.AUTHENTIFIER_URL)
				.contentType(MediaType.APPLICATION_JSON).content(loginBeanAsJSon));
		// On test que le resultat est bien 200
		result.andExpect(MockMvcResultMatchers.status().isOk());
		// Avec un flux JSON qui contient une propriete id qui vaut 1
		result.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(Integer.valueOf(1)));
	}

}
