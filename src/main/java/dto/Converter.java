/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.GroupMember;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magda
 */
public class Converter {

    public Converter() {
    }
    public  List<MemberDTO> listMemberEntityToDTO(List<GroupMember> entities){
        List<MemberDTO> dtos = new ArrayList();
        entities.stream().map(ent -> new MemberDTO(ent)).forEachOrdered(dto -> {
            dtos.add(dto);
        });
return dtos;
        
    }
    
}
