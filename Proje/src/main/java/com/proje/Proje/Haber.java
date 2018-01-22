package com.proje.Proje;

/**	
 * Haber işlemlerinden sorumlu sınıf.
 * @author Batuhan Kutluay
 */

public class Haber {
	
	private static int COUNT = 0;
	private int id;
	private String haberBaslik;
	private String haberIcerik;
	
	/**
	 * 
	 * @param haberBaslik RESTServisi sınıfından oluşturulan haber başlığı burada alınır.
	 * @param haberIcerik RESTServisi sınıfından oluşturulan haber içeriği burada alınır.
	 */
	
	public Haber(String haberBaslik,String haberIcerik)
	{
		this.id = ++COUNT;
		this.haberBaslik=haberBaslik;
		this.haberIcerik=haberIcerik;
	}
	
	/**
	 * Mevcut Haber Başlığını return eder.
	 * @return Haberin Başlığı
	 */
	
	public String getHaberBaslik() {
		return haberBaslik;
	}
	
	/**
	 * Mevcut Haber İçeriğini return eder.
	 * @return Haberin İçeriği
	 */
	
	public String getHaberIcerik() {
		return haberIcerik;
	}
	
	/**
	 * Mevcut id'yi return eder.
	 * @return Haberin id'si
	 */
	
	public int getId() {
		return id;
	}
	
}
