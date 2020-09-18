/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.AlbumDTO;
import facades.AlbumFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author magda
 */
@Path("album")
public class AlbumResource {

    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final AlbumFacade FACADE = AlbumFacade.getAlbumFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of AlbumResource
     */
    public AlbumResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String demo() {
        //   return "{\"msg\":\"<p1>Magdalena's Demo<p1>\"}";
        return "<h1>Album Demo<h1>";
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAlbums() {
        List<AlbumDTO> all = FACADE.getAllAlbums();

        return new Gson().toJson(all);
    }

    @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        
        List<AlbumDTO> all = new ArrayList();
        if (FACADE.getAllAlbums().isEmpty()){
          all=FACADE.addAlbumList();
    }
        return new Gson().toJson(all);
    }
}
