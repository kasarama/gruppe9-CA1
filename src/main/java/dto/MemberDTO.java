/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.GroupMember;
/**
 *
 * @author magda
 */
public class MemberDTO {
    private String id;
    private String name;
    private String color;

    public MemberDTO() {
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

    public MemberDTO(GroupMember entity) {
        this.id = entity.getCphId();
        this.name = entity.getFirstName();
        this.color = entity.getColor();
    }
    
    
    
    
}
