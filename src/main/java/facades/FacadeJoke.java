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
    public static FacadeJoke getFacadeExample(EntityManagerFactory _emf) {
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
            long renameMeCount = (long)em.createQuery("SELECT COUNT(j) FROM Joke j").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

}
