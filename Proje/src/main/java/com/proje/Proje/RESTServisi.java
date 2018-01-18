package com.proje.Proje;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class RESTServisi {
    private static final List<Haber> HABERLER = new ArrayList<>();
    
    @RequestMapping("/haber/olustur")
   	public static Haber haberYAZ(String haberbasligi, String habericerigi) 
   	{
   		Haber haber = new Haber(haberbasligi, habericerigi);
   		HABERLER.add(haber);
   		return haber;
   	}

    
	@RequestMapping("/haber/listele")
	public static List<Haber> haberListele()
	{
		return HABERLER;
	}
	
	@RequestMapping("/haber/temizle")
	public static String haberTemizle()
	{
		HABERLER.clear();
		return "OK";
	}
	
	
	@RequestMapping("/haber/sil")
	public static String haberSil(int index)
	{
		HABERLER.remove(index);
		return "OK";
	}
   
	

   
	
}
