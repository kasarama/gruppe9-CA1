
package facades;

import dto.CarsDTO;
import entities.Cars;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author zarpy
 */
public class CarsFacadeTest {
    private static EntityManagerFactory emf;
    private static CarsFacade facade;   
    private static Cars c1;
    private static Cars c2;
    
    
    public CarsFacadeTest() {
    }
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = CarsFacade.getCarsFacade(emf);
    }
      

    @BeforeEach
    public void setUp(){
        c1=new Cars(1,1,"Make1","Model1", 1, "img1");
        c2=new Cars(2,2,"Make2","Model2", 2, "img2");
         EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("Delete from Cars").executeUpdate();
           
            em.persist(c1);
            em.persist(c2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

  
    @Test
    public void testAddNewCar() {
        CarsDTO result = facade.addNewCar(new Cars(1,1,"test1","test1",1,"test1"));
        assertTrue(result.getModel().equals("test1"));
    }

    @Test
    public void testGetAllCars() {
        
       List<CarsDTO> all = facade.getAllCars();
        assertEquals(all.size(),2);
    }
}
