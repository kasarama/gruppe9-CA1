package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE FROM Joke"),
@NamedQuery(name = "Joke.getAll", query = "SELECT j FROM Joke j"),
@NamedQuery(name = "Joke.getByID", query = "SELECT j FROM Joke j WHERE j.id = :id")
})
public class Joke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String joke;
    private String topic;
    @Temporal(TemporalType.DATE)
    private java.util.Date created;
    private String source;

    public Joke(String joke, String topic, String source) {
        this.joke = joke;
        this.topic = topic;
        this.created = new Date();
        this.source = source;
    }

    public Date getCreated() {
        return created;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
    
    public Joke() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    

   
}
