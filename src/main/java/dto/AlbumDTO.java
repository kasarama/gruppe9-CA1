/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Album;

/**
 *
 * @author magda
 */
public class AlbumDTO {
    private int id;
    private int year;
    private int price;
    private String publisher;
    private String country;
    private int edition;
    private String title;

    public AlbumDTO(Album album) {
        this.id=album.getId();
        this.year = album.getYearOfrelise();
        this.price=album.getPrice();
        this.publisher=album.getPublisher();
        this.country=album.getCountry();
        this.edition=album.getEdition();
        this.title=album.getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
