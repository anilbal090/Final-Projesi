package com.proje.Proje;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class RESTServisi {
    private static final List<Haber> HABERLER = new ArrayList<>();
	@RequestMapping("/haber/olustur")
	public Haber haberOlustur(String haberBaslik,String haberIcerik)
	{
		Haber haber = new Haber(haberBaslik, haberIcerik);
		HABERLER.add(haber);
		return haber;
	}

	

	@RequestMapping("/haber/listele")
	public List<Haber> haberListele()
	{
		return HABERLER;
	}
	
	
	@RequestMapping("/haber/temizle")
	public String haberTemizle()
	{
		HABERLER.clear();
		return "OK";
	}
	
	@RequestMapping("/haber/sil")
	public String haberSil(int index)
	{
		HABERLER.remove(index);
		return "OK";
	}
}
