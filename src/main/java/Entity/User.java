package Entity;
public class User {

	private int idUser;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	public User(){
		super();
		this.idUser = 0;
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		
	}
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	
	public User(int idUser, String firstName, String lastName, String userName, String password) {
		super();
		this.idUser = 0;
		this.firstName = null;
		this.lastName = null;
		this.userName = userName;
		this.password = password;
		
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
}
	

