package fr.projet.evenement;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Exemple de recuperation du context via les annotations. <br/>
 *
 * C'est comme cela qu'il faut faire.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjetEvenementApplication.class)
@Transactional
@Rollback(true)
public abstract class AbstractAnnotationTest {
	// Pour porter les annotations
}
