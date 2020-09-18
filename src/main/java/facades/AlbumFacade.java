/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.AlbumDTO;
import dto.Converter;
import dto.StudentDTO;
import entities.Album;
import entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author magda
 */
public class AlbumFacade {

    private static AlbumFacade instance;
    private static EntityManagerFactory emf;

    public AlbumFacade() {
    }

    public static AlbumFacade getAlbumFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AlbumFacade();
        }
        return instance;
    }

    public AlbumDTO addNewAlbum(Album album) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(album);
            em.getTransaction().commit();
            return new AlbumDTO(album);
        } finally {
            em.close();
        }
    }

    public List<AlbumDTO> addAlbumList() {
        EntityManager em = emf.createEntityManager();
        List<Album> manyALbums = Converter.populateAlbums();
        List<Album> commited = new ArrayList();

        try {

            em.getTransaction().begin();
            for (Album album : Converter.populateAlbums()) {

                em.persist(album);
                commited.add(album);

            }
            em.getTransaction().commit();
            return Converter.albumListToDTO(commited);
        } finally {
            em.close();
        }
    }

    public List<AlbumDTO> getAllAlbums() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Album> query = em.createQuery("SELECT a FROM Album a", Album.class);
            List<Album> albums = query.getResultList();

            return Converter.albumListToDTO(albums);

        } finally {
            em.close();
        }
    }

}
