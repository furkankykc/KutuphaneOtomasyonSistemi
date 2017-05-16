package Entity;

public class Colour {

	private int id;
	private String colourName;

	public String getColourName() {
		return colourName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setColourName(String colourName) {
		this.colourName = colourName;
	}

	public Colour(String colourName){
		this.colourName=colourName;
	}public Colour(){
		this.id =0;
		this.colourName=null;
	}
	@Override
	public String toString() {
		return "Colour [colourName=" + colourName + "]";
	}
	
	
}