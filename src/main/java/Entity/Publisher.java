package Entity;

public class Publisher {
	int idPublisher;
	String pubName;
	public Publisher(int idPublisher ,String pubName){
		this.idPublisher = idPublisher;
		this.pubName = pubName;
	
		
	}
	public Publisher(String firstName,String lastName, String pubName){
		this.idPublisher = 0;
		this.pubName = pubName;
	}
	public Publisher(){
		this.idPublisher=0;
		this.pubName=null;
	}
	public int getIdPublisher() {
		return idPublisher;
	}
	public void setIdPublisher(int idPublisher) {
		this.idPublisher = idPublisher;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	@Override
	public String toString() {
		return "Publisher [idPublisher=" + idPublisher + ", pubName=" + pubName + "]";
	}

	
}
