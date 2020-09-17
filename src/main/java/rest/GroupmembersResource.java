/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.StudentDTO;
import entities.Student;
import facades.StudentFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

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

    private static final StudentFacade FACADE = StudentFacade.getStudentFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Creates a new instance of GroupmembersResource
     */
    public GroupmembersResource() {
    }

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
        List<StudentDTO> all = FACADE.getAllStudents();
        //List<StudentDTO> dtos = converter.listMemberEntityToDTO(all);
               
        
        return new Gson().toJson(all);
    }
    
    @Path("insertdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String insertData() {
        List<StudentDTO> all = new ArrayList();
          if(FACADE.getAllStudents().isEmpty()){
              
              StudentDTO m1=FACADE.addNewStudent(new Student("Søren", "Andersen", "blue", "cph-sa343"));
              StudentDTO m2=FACADE.addNewStudent(new Student("Magdalena", "Wawrzak", "blue", "cph-mw216"));
              StudentDTO m3=FACADE.addNewStudent(new Student("Selina", "Søndengaard", "blue", "cph-ss258"));
              StudentDTO m4=FACADE.addNewStudent(new Student("Noell", "Gierringe ", "blue", "cph-ng67"));
              all.add(m1);
              all.add(m2);
              all.add(m3);
              all.add(m4);
          }

        return new Gson().toJson(all);
    }
    
}
