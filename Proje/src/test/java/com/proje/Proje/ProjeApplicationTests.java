package com.proje.Proje;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@JsonTest

public class ProjeApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
    private JacksonTester<Haber> json;
	Haber details = new Haber("Baslik", "Icerik");
  
  @Test
    public void testHaber() throws Exception {
        Haber haber = new Haber("Baslik", "Icerik");
        assertThat(this.json.write(haber)).hasJsonPathStringValue("@.haberBaslik");
        assertThat(this.json.write(haber)).extractingJsonPathStringValue("@.haberIcerik")
                .isEqualTo("Icerik");
    }
  
  @Test
	public void testHaberYaz() throws Exception {
	  	Haber haber = RESTServisi.haberYAZ("deneme", "icerik");
	  	assertEquals(haber.getHaberBaslik(), "deneme");
	  	assertEquals(haber.getHaberIcerik(), "icerik");
	}
  
  @Test
 	public void testHaberListele() throws Exception{

	  	RESTServisi.haberYAZ("Baslik", "icerik");
	    assertTrue(RESTServisi.haberListele().stream().anyMatch(item -> "Baslik".equals(item.getHaberBaslik())));	
	    assertTrue(RESTServisi.haberListele().stream().anyMatch(item -> "icerik".equals(item.getHaberIcerik())));	  	

 	}
  
  @Test
	public void testHaberTemizle() throws Exception{

		assertTrue(RESTServisi.haberTemizle(), true);
	}
  
  @Test
 	public void testHaberSil() throws Exception{
	    List<Haber> HABERLERTEST = new ArrayList<>();
	  	Haber haber = RESTServisi.haberYAZ("deneme", "icerik");
	    HABERLERTEST.add(haber);
	  	assertEquals(RESTServisi.haberSil(0),"OK");

 	}
  
  @Test
 	public void testClass() {
 		boolean hataOlustu = false;
 		try {
 			RESTServisi servis = new RESTServisi();
 		} catch(Exception e) {
 			hataOlustu = true;
 		}
 		
 		assertFalse(hataOlustu);
 	}
  
	

}
