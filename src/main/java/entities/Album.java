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

/**
 *
 * @author magda
 */
@Entity
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private int yearOfrelise;
    private int price;
    private String publisher;
    private String country;
    private int edition;
    private int copyQuantity;
    private int rowNumber;
    private String placing;
    private String status;
    private String title;

    
    public Album() {
    }

    public Album(String title,int yearOfrelise, int price, String publisher, String country, int edition, int copyQuantity, int row, String placing, String status) {
        this.yearOfrelise = yearOfrelise;
        this.price = price;
        this.publisher = publisher;
        this.country = country;
        this.edition = edition;
        this.copyQuantity = copyQuantity;
        this.rowNumber = row;
        this.placing = placing;
        this.status = status;
        this.title=title;
    }

    public int getYearOfrelise() {
        return yearOfrelise;
    }

    public void setYearOfrelise(int yearOfrelise) {
        this.yearOfrelise = yearOfrelise;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getCopyQuantity() {
        return copyQuantity;
    }

    public void setCopyQuantity(int copyQuantity) {
        this.copyQuantity = copyQuantity;
    }

    public int getRow() {
        return rowNumber;
    }

    public void setRow(int row) {
        this.rowNumber = row;
    }

    public String getPlacing() {
        return placing;
    }

    public void setPlacing(String placing) {
        this.placing = placing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

   

   
}
