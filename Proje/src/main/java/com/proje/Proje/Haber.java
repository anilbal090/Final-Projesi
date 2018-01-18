package com.proje.Proje;

public class Haber {
	private static int COUNT = 0;

	private int id;
	
	private String haberBaslik;

	private String haberIcerik;
	public Haber(String haberBaslik,String haberIcerik)
	{
		this.id = ++COUNT;
		this.haberBaslik=haberBaslik;
		this.haberIcerik=haberIcerik;
	}
	
	public String getHaberBaslik() {
		return haberBaslik;
	}

	public String getHaberIcerik() {
		return haberIcerik;
	}
	public int getId() {
		return id;
	}

}
