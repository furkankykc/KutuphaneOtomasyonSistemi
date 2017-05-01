package Entity;

public class Adress {
	public int idAdress;
	public String street;
	public String road;
	public String buildNo;
	
	public Adress(){
		
		this.idAdress = 0;
		this.street = null;
		this.road = null;
		this.buildNo = null;
		
	}
	
	public Adress(int idAdress, String street, String road, String buildNo) {
	
		this.idAdress = 0;
		this.street = null;
		this.road = null;
		this.buildNo = null;
	}

	public int getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(int idAdress) {
		this.idAdress = idAdress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	@Override
	public String toString() {
		return "Adress [idAdress=" + idAdress + ", street=" + street + ", road=" + road + ", buildNo=" + buildNo + "]";
	}
	

}
