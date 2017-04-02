package Entity;

public class kitap {

	int id;
	String ad;
	String yazar;
	public kitap(int id ,String ad,String yazar){
		this.id=id;
		this.ad=ad;
		this.yazar=yazar;
		
	}
	public kitap(String ad,String yazar){
		this.id=0;
		this.ad=ad;
		this.yazar=yazar;
	}
	public kitap(){
		this.id=0;
		this.ad=null;
		this.yazar=null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	@Override
	public String toString(){
		return "ad : "+ad+"<br></br> yazar : "+yazar+"<br></br> id :  "+id;
	}
	
	
}
