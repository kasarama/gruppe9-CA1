/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.GroupMember;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author magda
 */
public class MemberFacadeTest {
    
    
    private static EntityManagerFactory emf;
    private static MemberFacade facade;   
    private static GroupMember m1;
    private static GroupMember m2;
    
    
    public MemberFacadeTest() {
    }
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MemberFacade.getMemberFacade(emf);
    }
      

    @BeforeEach
    public void setUp(){
        m1=new GroupMember("name1","last1","white","cph-xx000");
        m2=new GroupMember("first1","name2","white","cph-yy99");
         EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("Delete from GroupMember").executeUpdate();
           
            em.persist(m1);
            em.persist(m2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

  
    @Test
    public void testAddNewMember() {
        GroupMember result = facade.addNewMember(new GroupMember("test1","test1","test1","test1"));
        assertTrue(result.getColor().equals("test1"));
    }

    @Test
    public void testGetAllMembers() {
        
       List<GroupMember> all = facade.getAllMembers();
        assertEquals(all.size(),2);
    }
    
}
