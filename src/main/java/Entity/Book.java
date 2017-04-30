package Entity;

public class Book {
	int idBook;
	String bookName;
	int bookPage;
	public Book(int idBookBook,String bookName,int bookPage){
		this.idBook=idBookBook;
		this.bookName=bookName;
		this.bookPage=bookPage;
		
	}
	public Book(String bookName,int bookPage){
		this.idBook=0;
		this.bookName=bookName;
		this.bookPage=bookPage;
	}
	public Book(){
		this.idBook=0;
		this.bookName=null;
		this.bookPage=0;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPage() {
		return bookPage;
	}
	public void setBookPage(int bookPage) {
		this.bookPage = bookPage;
	}
	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", bookName=" + bookName + ", bookPage=" + bookPage + "]";
	}

	
	
}
