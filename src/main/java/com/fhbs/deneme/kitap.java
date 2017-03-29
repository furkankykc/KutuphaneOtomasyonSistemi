package com.fhbs.deneme;

public class kitap {

	int id;
	String ad;
	String yazar;
	public kitap(int id ,String ad,String yazar){
		this.id=id;
		this.ad=ad;
		this.yazar=yazar;
		
	}
	public kitap(){
		this.id=0;
		this.ad=null;
		this.yazar=null;
	}
	
	@Override
	public String toString(){
		return "ad : "+ad+"<br></br> yazar : "+yazar+"<br></br> id :  "+id;
	}
	
	
}
