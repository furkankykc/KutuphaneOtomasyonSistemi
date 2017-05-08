package Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.JdbcAddressDao;

public class Author {
	private int id;
	private String firstName;
	private String lastName;
	private int address_id;
	private Address address;
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
	public int getID() {
		return id;
	}
	public void setID(int id) {
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
	public int getAddress_id(){
		return address_id;
	}public void setAddress_id(int address_id){
		this.address_id=address_id;
	}
	public void setAddress(int address_id) {
		this.address_id = address_id;
	}
	public Address getAddress(){
		ApplicationContext context =
   			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
    		return AddressDao.getAddress(address_id);
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address_id=" + address_id
				+ ", address=" + address + "]";
	}
	
	
	
}

