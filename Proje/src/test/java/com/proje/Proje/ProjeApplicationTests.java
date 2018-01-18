package com.proje.Proje;

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

}
