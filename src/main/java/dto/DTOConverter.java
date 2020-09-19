/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Cars;
import entities.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magda
 */
public class DTOConverter {

    public DTOConverter() {
    }
    
    public static  List<StudentDTO> studentListToDTO(List<Student> entities){
       List<StudentDTO> dtos = new ArrayList();
        for (Student student : entities) {
            StudentDTO sDTO = new StudentDTO(student);
            dtos.add(sDTO);
        }
        return dtos;
    }
    public static  List<CarsDTO> CarsListToDTO(List<Cars> entities){
    List<CarsDTO> dtoc = new ArrayList();
        for (Cars car : entities) {
            CarsDTO cDTO = new CarsDTO(car);
            dtoc.add(cDTO);
        }
        return dtoc;
    }
}
