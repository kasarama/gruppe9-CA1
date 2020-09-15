/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Converter;
import dto.MemberDTO;
import facades.MemberFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;
import entities.GroupMember;
import java.util.ArrayList;
        

/**
 * REST Web Service
 *
 * @author magda
 */
@Path("groupmembers")
public class GroupmembersResource {

    @Context
    private UriInfo context;

    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final MemberFacade FACADE = MemberFacade.getMemberFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Converter converter= new Converter();

    
    /**
     * Creates a new instance of GroupmembersResource
     */
    public GroupmembersResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GroupmembersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String demo() {
        //   return "{\"msg\":\"<p1>Magdalena's Demo<p1>\"}";
        return "<h1>Member Demo<h1>";
    }


    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMembers() {
        List<GroupMember> all = FACADE.getAllMembers();
        List<MemberDTO> dtos = converter.listMemberEntityToDTO(all);
        
        
        return new Gson().toJson(all);
    }
    
    
    
    @Path("insertdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String insertData() {
        List<GroupMember> all = new ArrayList();
          if(FACADE.getAllMembers().isEmpty()){
              
              GroupMember m1=FACADE.addNewMember(new GroupMember("Søren", "Andersen", "white", "cph-sa343"));
              GroupMember m2=FACADE.addNewMember(new GroupMember("Magdalena", "Wawrzak", "white", "cph-mw216"));
              GroupMember m3=FACADE.addNewMember(new GroupMember("Selina", "Søndengaard", "white", "cph-ss258"));
              GroupMember m4=FACADE.addNewMember(new GroupMember("Noell", "Gierringe ", "white", "cph-ng67"));
              all.add(m1);
              all.add(m2);
              all.add(m3);
              all.add(m4);
          }

        return new Gson().toJson(all);
    }
    
    
    
}