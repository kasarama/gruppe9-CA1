
package rest;

import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import entities.Student;

/**
 *
 * @author magda
 */
public class GroupmembersResourceTest {
    
    
    



    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Student m1 = new Student("frist1", "last", "blue", "cph-aa458");
    private static Student m2 = new Student("firstname", "surname", "black", "cph-bb458");

    
    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        
        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterAll
    public static void closeTestServer(){
        //System.in.read();
         //Don't forget this, if you called its counterpart in @BeforeAll
         EMF_Creator.endREST_TestWithDB();
         httpServer.shutdownNow();
    }
    
        

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Student").executeUpdate();
            em.persist(m1);
            em.persist(m2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testDemo() {
        given()
        .contentType("text/html")
        .get("/groupmembers/").then()
        .assertThat()
        .statusCode(HttpStatus.OK_200.getStatusCode())
        .equals("<h1>Member Demo<h1>");  
    }

    @Test
    public void testGetAllMembers() {
        
        given()
            .contentType("application/json")
        .get("/groupmembers/all")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK_200.getStatusCode())
        .body("size()", is(2))
        .and()
        .body("name",hasItems("frist1","firstname"));
        
    }

    @Test
    public void testInsertDataIfEmpty() {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Student").executeUpdate();           
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
         given()
            .contentType("application/json")
        .get("/groupmembers/insertdata")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK_200.getStatusCode())
        .body("size()", is(4))
        .and()
        .body("name",hasItems("Magdalena","Selina"));       
        
        
    }

}