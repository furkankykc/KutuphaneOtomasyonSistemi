package Entity;
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int address_id;
	
	public User(){
		super();
		this.id = 0;
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		this.address_id = 0;
		
	}
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	
	public User(int id, String firstName, String lastName, int address_id, String userName, String password) {
		super();
		this.id = 0;
		this.firstName = null;
		this.lastName = null;
		this.userName = userName;
		this.password = password;
		this.address_id = 0;
		
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getId() {
		return id;
	}
	public void setid(int id) {
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
}
	

