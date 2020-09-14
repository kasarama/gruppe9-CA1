/*
; * To change this license header, choose License Headers in Project Properties.
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
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName; 
    private String color;
    private String cphId;

    public String getCphId() {
        return cphId;
    }

    public void setCphId(String cphId) {
        this.cphId = cphId;
    }
    
      public GroupMember() {
    }

    public GroupMember(String firstName, String lastName, String color, String cphId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
        this.cphId = cphId;
    }

   
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

    public int getId() {
        return id;
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

  

    
    
}
