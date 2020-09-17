
package dto;
    
import entities.Cars;
/**
 *
 * @author zarpy
 */
public class CarsDTO {
    
    private int id;
    private int byear;
    private String make;
    private String model;
    private int price;
    private String img;
    
    public CarsDTO(){
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

    public void setYear(int byear) {
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
    
    public CarsDTO(Cars entity){
        this.id = entity.getCarId();
        this.byear = entity.getbYear();
        this.make = entity.getMake();
        this.model = entity.getModel();
        this.price = entity.getPrice(); 
        this.img = entity.getImg();
    }    
}
