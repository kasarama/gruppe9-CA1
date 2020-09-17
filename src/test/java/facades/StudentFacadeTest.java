
package facades;

import dto.StudentDTO;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.Student;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author magda
 */
public class StudentFacadeTest {
    
    
    private static EntityManagerFactory emf;
    private static StudentFacade facade;   
    private static Student m1;
    private static Student m2;
    
    
    public StudentFacadeTest() {
    }
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = StudentFacade.getStudentFacade(emf);
    }
      

    @BeforeEach
    public void setUp(){
        m1=new Student("name1","last1","white","cph-xx000");
        m2=new Student("first1","name2","white","cph-yy99");
         EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("Delete from Student").executeUpdate();
           
            em.persist(m1);
            em.persist(m2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

  
    @Test
    public void testAddNewStudent() {
        StudentDTO result = facade.addNewStudent(new Student("test1","test1","test1","test1"));
        assertTrue(result.getColor().equals("test1"));
    }

    @Test
    public void testGetAllStudents() {
        
       List<StudentDTO> all = facade.getAllStudents();
        assertEquals(all.size(),2);
    }
    
    
    
}
