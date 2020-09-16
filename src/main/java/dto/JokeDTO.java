package dto;

import entities.Joke;

/**
 *
 * @author soend
 */


public class JokeDTO {
    private Long id;
    private String joke;
    private String topic;
    
     
    public JokeDTO(Joke j) {
        this.id = j.getId();
        this.joke = j.getJoke();
        this.topic = j.getTopic();
       
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
