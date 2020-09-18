/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.Converter;
import dto.StudentDTO;
import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author magda
 */
public class StudentFacade {

    private static StudentFacade instance;
    private static EntityManagerFactory emf;

    public StudentFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static StudentFacade getStudentFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentFacade();
        }
        return instance;
    }

    public StudentDTO addNewStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return new StudentDTO(student);
        } finally {
            em.close();
        }
    }

    public List<StudentDTO> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
            List<Student> students = query.getResultList();
            
            return Converter.studdentListToDTO(students);

        } finally {
            em.close();
        }
    }

}
