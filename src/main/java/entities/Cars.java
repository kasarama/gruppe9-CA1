/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Int id;
    private Int year;
    private String make;
    private String model;
    private Int Price;
    
    public Car(Int id, Int year, String make, String model, Int price){
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Int getId() {
        return id;
    }

    public void setId(Int id) {
        this.id = id;
    }
    
    public Int getYear() {
        return year;
    }

    public void setYear(Int year) {
        this.year = year;
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

    public void setMake(String make) {
        this.make = make;
    }
    
     public Int getPrice() {
        return price;
    }

    public void setPrice(Int price) {
        this.price = price;
    }
}
