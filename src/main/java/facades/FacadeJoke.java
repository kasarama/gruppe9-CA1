package facades;

import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeJoke {

    private static FacadeJoke instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeJoke() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeJoke getFacadeJoke(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeJoke();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getJokeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long jokeCount = (long)em.createQuery("SELECT COUNT(j) FROM Joke j").getSingleResult();
            return jokeCount;
        }finally{  
            em.close();
        }
        
    }
     public void populateDB(){
            EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Joke("I bought a world map for my wife, and gave her a dart. I said, \"Where ever this lands, that's where I am taking you after this pandemic is over.\"\n" +
            "Turns out we are spending two weeks behind the fridge.", "Pandemic", "Reddit"));
            em.persist(new Joke("What’s the difference between a police officer and a bullet?\n" +
            "When a bullet kills someone else, you know it’s been fired", "Police", "/u easywaycentre"));
            em.persist(new Joke("Don't be mad at lazy people.\n" +
            "They didn't do anything.", "Productivity", "/u To_me_my_board"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
