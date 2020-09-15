package facades;

import dto.JokeDTO;
import entities.Joke;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


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
     
     public List<JokeDTO> getAllJokes() {
                
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery query = em.createQuery("SELECT j FROM Joke j", Joke.class);
              List<Joke> jokes = query.getResultList();
            List<JokeDTO> jokeDTOs = new ArrayList<>();
            for (Joke joke : jokes) {
                jokeDTOs.add(new JokeDTO(joke));
            }
            return jokeDTOs;
        } 
        finally {
            em.close();
        }
    }
     
     public JokeDTO getJokeByID(long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Joke joke = em.find(Joke.class, id);
            return new JokeDTO(joke);
        } finally {
            em.close();
        }
    }
}


