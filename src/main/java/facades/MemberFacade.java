/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import entities.GroupMember;

/**
 *
 * @author magda
 */
public class MemberFacade {
    
    
    private static MemberFacade instance;
    private static EntityManagerFactory emf;

    public MemberFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MemberFacade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MemberFacade();
        }
        return instance;
    }

    
    public GroupMember addNewMember(GroupMember member) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(member);
            em.getTransaction().commit();
            return member;
        } finally {
            em.close();
        }
    }
    
    

    public List<GroupMember> getAllMembers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<GroupMember> query = em.createQuery("SELECT m FROM GroupMember m", GroupMember.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    
    
}
