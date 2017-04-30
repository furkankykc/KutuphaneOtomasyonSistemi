package Entity;

public class Category {
	
	int idCategory;
	String catName;
	
	public Category(int idCategory ,String catName){
		this.idCategory=idCategory;
		this.catName=catName;
	}
	
	public Category(){
		this.idCategory = 0;
		this.catName = null;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", catName=" + catName + "]";
	}

}
