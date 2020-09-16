package facades;

import dto.JokeDTO;
import utils.EMF_Creator;
import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeJokeTest {

    private static EntityManagerFactory emf;
    private static FacadeJoke facade;
    private Joke j1;
    private Joke j2;
    
    public FacadeJokeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = FacadeJoke.getFacadeJoke(emf);
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        j1 = new Joke("Don't be mad at lazy people.\n" + "They didn't do anything.", "Productivity", "/u To_me_my_board");
        j2 = new Joke("What’s the difference between a police officer and a bullet?\n" +"When a bullet kills someone else, you know it’s been fired", "Police", "/u easywaycentre");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate(); //Deletes all rows in DB
            em.persist(j1); //Persists two jokes
            em.persist(j2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testFacadeJokeGetCount() {
        assertEquals(2, facade.getJokeCount(), "Expects two jokes in the database");
    }
    
    @Test
    public void testFacadeGetAllJokes(){
        List<JokeDTO> jokes = facade.getAllJokes();
        assertEquals(2,facade.getJokeCount(),"Expects two jokes in the database");
        assertThat(jokes, everyItem(hasProperty("joke")));
    }
      @Test
    public void testFacadeGetJokeByID() {
        JokeDTO joke = facade.getJokeByID(j2.getId()); //Gets the joke of j2's ID
        assertEquals("Police",joke.getTopic()); //Checks if the topic matches
    }
}