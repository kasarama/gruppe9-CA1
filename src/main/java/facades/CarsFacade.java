
package facades;

import dto.CarsDTO;
import dto.DTOConverter;
import entities.Cars;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class CarsFacade {
    
    private static CarsFacade instance;
    private static EntityManagerFactory emf;
    
    public CarsFacade(){
    }

    public static CarsFacade getCarsFacade(EntityManagerFactory _emf){
           if (instance == null) {
            emf = _emf;
            instance = new CarsFacade();
        }
        return instance;
}    
    public CarsDTO addNewCar(Cars car){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
                        em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return new CarsDTO (car);
        } finally {
            em.close();
        }
    }
    
        public List<CarsDTO> getAllCars() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Cars> query = em.createQuery("SELECT m FROM Cars m", Cars.class);
            return DTOConverter.CarsListToDTO (query.getResultList());
        } finally {
            em.close();
        }
    }
    
}
