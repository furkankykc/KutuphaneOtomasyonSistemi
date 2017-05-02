package Entity;

public class Publisher {
	int id;
	String name;
	int address_id;
	public Publisher(int id ,String name,int addres_id){
		this.id = id;
		this.name = name;
		this.address_id=addres_id;
	
		
	}
	public Publisher(String name,int addres_id){
		this.id = 0;
		this.name = name;
		this.address_id = address_id;
	}
	public Publisher(){
		this.id=0;
		this.name=null;
		this.address_id =0;
	}
	public int getId() {
		return id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
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
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}

	
}
