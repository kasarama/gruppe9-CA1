
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int byear;
    private String make;
    private String model;
    private int price;
    private String img;

    public Cars() {
    }
    
    public Cars(int id, int byear, String make, String model, int price, String img){
        this.id = id;
        this.byear = byear;
        this.make = make;
        this.model = model;
        this.price = price;
        this.img = img;
    }

    public int getCarId() {
        return id;
    }

    public void setCarId(int id) {
        this.id = id;
    }
    
    public int getbYear() {
        return byear;
    }

    public void setbYear(int byear) {
        this.byear = byear;
    }
    
     public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    
     public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
     public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}