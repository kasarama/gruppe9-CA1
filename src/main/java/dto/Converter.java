/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.*;
import dto.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author magda
 */
public class Converter {

    public static List<AlbumDTO> albumListToDTO(List<Album> entities) {
        List<AlbumDTO> dtos = new ArrayList();

        for (Album ent : entities) {
            AlbumDTO a = new AlbumDTO(ent);
            dtos.add(a);

        }
        return dtos;
    }

    public static List<StudentDTO> studdentListToDTO(List<Student> entities) {
        List<StudentDTO> dtos = new ArrayList();

        for (Student ent : entities) {
            StudentDTO a = new StudentDTO(ent);
            dtos.add(a);

        }
        return dtos;
    }

    /*
    private int yearOfrelise;
    private double price;
    private String publisher;
    private String country;
    private int edition;
    private int copyQuantity;
    private int row;
    private String placing;
    private String status;
     */
    public static List<Album> populateAlbums() {
        List<Album> bigOne = new ArrayList();
        String[] titles = {"Cherry", "Dread and horror", "Dark matters", "Climate changed",
            "Beautiful beasts", "Dedication to the cause", "The drawing board", "All ears",
            "First chance", "Rain check", "Zero experience", "No guarantees", "Hand in hand", "Class act",
            "Last candidate", "Chip off the old block", "Battleground", "The last laugh",
            "Crime of the century", "Cat napped", "Honestly", "Dedication", "Kiacnen",
            "Cat killed curiosity", "Spilled beans", "X marks the spot", "Collar of bones",
            "Glass houses", "Bullet bites", "Grains of sand", "No history", "Agnu", "Kemde", "Missles",
            "Mengem", "Zagmugin", "Zumderel", "Gaesliniad", "Viassrurusun", "Asnumoled",};

        String[] publishers = {"The Shimmering Wilds", "The Royal Lion Garden",
            "The Angry Bush", "The White Tropics", "The Narrow Jungles", "The Soft Garden"};

        String[] statuses = {"on stock", "sold out", "unknown", "pending"};

        String[] countries = {"Poland", "Germany", "russia", "Spain", "United Kingdom", "USA", "Danmark"};
        String[] placing = {"back", "front", "down"};

        for (int i = 0; i < titles.length; i++) {
            int indexPubl = (int) (Math.random() * (publishers.length-1 - 0 + 1) + 0);
            int price = (int) (Math.random() * (2500 - 100 + 1) + 100);
            int row = (int) (Math.random() * (20 - 1 + 1) + 1);
            int year = (int) (Math.random() * (2020 - 1963 + 1) + 1963);           
            int edition = (int) (Math.random() * (10 - 1 + 1) + 1);
            int copy = (int) (Math.random() * (150 - 1 + 1) + 1);
            
            
         
            
            Album album = new Album(year,price,publishers[indexPubl],countries[i%7],edition,copy,row,placing[i%3],statuses[i%4]);
            bigOne.add(album);
        }
        return bigOne;

    }
   
}
