/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Album;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author magda
 */
public class ConverterTest {
    
    public ConverterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testAlbumListToDTO() {
    }

    @Test
    public void testStuddentListToDTO() {
        List<Album> result= Converter.populateAlbums();
        assertEquals(result.size(), 40);
        
    }

    
}
