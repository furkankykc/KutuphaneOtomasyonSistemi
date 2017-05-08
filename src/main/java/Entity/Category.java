package Entity;

public class Category {
	
	int id;
	String name;
	
	public Category(int id ,String name){
		this.id=id;
		this.name=name;
	}
	
	public Category(){
		this.id = 0;
		this.name = null;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
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
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
