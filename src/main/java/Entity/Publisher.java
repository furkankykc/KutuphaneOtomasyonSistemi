package Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.JdbcAddressDao;

public class Publisher {
	private int id;
	private String name;
	private int address_id;
	private Address address;
	public Publisher(int id ,String name,int addres_id){
		this.id = id;
		this.name = name;
		this.address_id=addres_id;
	
		
	}
	public Publisher(String name,int address_id){
		this.id = 0;
		this.name = name;
		this.address_id = address_id;
	}
	public Publisher(String name,Address address){
		this.id = 0;
		this.name = name;
		this.address_id = address.getId();
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
	
	public Address getAddress(){
		ApplicationContext context =
	   			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
    		return AddressDao.getAddress(address_id);
	}
	
	public void setAddress(Address add){
			address_id = add.getId();
		
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address_id=" + address_id + ", address=" + address + "]";
	}
	
	
}
