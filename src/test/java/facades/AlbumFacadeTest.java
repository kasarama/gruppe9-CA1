/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.AlbumDTO;
import entities.Album;
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
 * @author magda
 */


public class AlbumFacadeTest {
    
     
    private static EntityManagerFactory emf;
    private static AlbumFacade facade;   
    private static Album m1;
    private static Album m2;
    
    
    
    
    
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = AlbumFacade.getAlbumFacade(emf);
    }
      

    @BeforeEach
    public void setUp(){
        m1=new Album(1988, 12, "publisher1", "country1", 0, 0, 0, "placing1", "status");
        m2=new Album(1988, 12, "publisher2", "Holland", 0, 10, 20, "down", "gone");
         EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("Delete from Album").executeUpdate();
           
            em.persist(m1);
            em.persist(m2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    






    @Test
    public void testAddNewAlbum() {
        AlbumDTO result = facade.addNewAlbum(new Album(2020, 2, "Your mama", "Malta", 17, 10, 05, "down", "quo"));
        assertTrue(result.getPublisher().equals("Your mama"));
    }

    @Test
    public void testGetAllAlbums() {
        
       List<AlbumDTO> all = facade.getAllAlbums();
        assertEquals(all.size(),2);
    }

    
    
}
