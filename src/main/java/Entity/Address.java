package Entity;

public class Address {
	private int id;
	private String name;
	private String street;
	private String road;
	private String buildNo;
	
	public Address(){
		
		this.id = 0;
		this.street = null;
		this.road = null;
		this.buildNo = null;
		
	}
	
	public Address(int id, String name, String street, String road, String buildNo) {
	
		this.id = id;
		this.name = name;
		this.street = street;
		this.road = road;
		this.buildNo = buildNo;
	}
	
	public Address(String name, String street, String road, String buildNo) {
		
		this.id = 0;
		this.name = name;
		this.street = street;
		this.road = road;
		this.buildNo = buildNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Adress [id=" + id + ", street=" + street + ", road=" + road + ", buildNo=" + buildNo + "]";
	}
	

}
