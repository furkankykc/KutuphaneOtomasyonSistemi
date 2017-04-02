package Entity;
public class User {

	private Long id;
	private String name;
	private String surName;
	private String password;
	private String userName;
	private String studentId;
	
	public User(){
		super();
		this.id= null;
		this.name = null;
		this.surName = null;
		this.password = null;
		this.userName = null;
		this.studentId = null;
		
	}
	
	public User(Long id, String name, String surName, String password, String userName,String studentId) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.password = password;
		this.userName = userName;
		this.studentId = studentId;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	
		this.password =password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surName=" + surName + ", password=" + password + ", userName="
				+ userName + ", studentId=" + studentId + "]";
	}

}
	

