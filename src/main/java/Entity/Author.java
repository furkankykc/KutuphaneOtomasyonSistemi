package Entity;

public class Author {
	private int id;
	private String firstName;
	private String lastName;
	private int address_id;
	
	public Author(){
		this.id = 0;
		this.firstName=null;
		this.lastName=null;
		this.address_id=0;
	}
	public Author(int id,String firstName,String lastname,int address_id){
		this.id = id;
		this.firstName=firstName;
		this.lastName=lastname;
		this.address_id=address_id;
	}
	public Author(String firstName,String lastname,int address_id){
		this.id = 0;
		this.firstName=firstName;
		this.lastName=lastname;
		this.address_id=address_id;
	}	
	public Author(String firstName,String lastname){
		this.id = id;
		this.firstName=firstName;
		this.lastName=lastname;
		this.address_id=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getaddress_id() {
		return address_id;
	}
	public void setaddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	
	
}
