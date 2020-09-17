/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import entities.Student;
/**
 *
 * @author magda
 */
public class StudentDTO {
    
    private String id;
    private String name;
    private String color;

    public StudentDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    

    public StudentDTO(Student entity) {
        this.id = entity.getCphId();
        this.name = entity.getFirstName();
        this.color = entity.getColor();
    }
    
        
    
}
