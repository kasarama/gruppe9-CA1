package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CarsDTO;
import entities.Cars;
import facades.CarsFacade;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author zarpy
 */
@Path("Cars")
public class CarsResource {

    @Context
    private UriInfo context;
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CarsFacade FACADE = CarsFacade.getCarsFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Creates a new instance of CarsResource
     */
    public CarsResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String cardemo() {
        //   return "{\"msg\":\"<p1>Car stock Demo<p1>\"}";
        return "<h1>Car Stock Demo<h1>";
    }
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMembers() {
        List<Cars> all = FACADE.getAllCars();
        //List<CarsDTO> dtos = converter.listMemberEntityToDTO(all);
        List<CarsDTO> dtos = new ArrayList();
        for (Cars car : all) {
            CarsDTO cDTO = new CarsDTO(car);
            dtos.add(cDTO);       
        }
        return new Gson().toJson(all);
    }
    
    @Path("insertdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String insertData() {
        List<Cars> all = new ArrayList();
          if(FACADE.getAllCars().isEmpty()){
              
              Cars c1=FACADE.addNewCar(new Cars(1, 1993, "Ford", "Fiesta", 800, "img1"));
              Cars c2=FACADE.addNewCar(new Cars(2, 1973, "Crysler", "Cristal", 1000, "img2"));
              Cars c3=FACADE.addNewCar(new Cars(3, 2011, "Toyota", "Tuscana", 600, "img3"));
              Cars c4=FACADE.addNewCar(new Cars(4, 1993, "Lamborghini", "Latvia", 900, "img4"));
              all.add(c1);
              all.add(c2);
              all.add(c3);
              all.add(c4);
          }

        return new Gson().toJson(all);
    }
}
    