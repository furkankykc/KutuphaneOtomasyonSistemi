package Entity;

import java.sql.Date;

public class Book {
	private int id;
	private String bookName;
	private int bookPage;
	private int author_id;
	private int category_id;
	private int publisher_id;
	private Date printingDate;
	
	public Book(){
		this.id = 0;
		this.bookName=null;
		this.bookPage=0;
		this.author_id=0;
		this.category_id=0;
		this.publisher_id=0;
		this.printingDate=null;
	}
	public Book(String bookName,int bookPage,int author_id,int category_id,int publisher_id){
		this.id = 0;
		this.bookName=bookName;
		this.bookPage=bookPage;
		this.author_id=author_id;
		this.category_id=category_id;
		this.publisher_id=publisher_id;
		this.printingDate=null;
	}
	public Book(int id,String bookName,int bookPage,int author_id,int category_id,int publisher_id,Date printingDate){
		this.id = id;
		this.bookName=bookName;
		this.bookPage=bookPage;
		this.author_id=author_id;
		this.category_id=category_id;
		this.publisher_id=publisher_id;
		this.printingDate=printingDate;
	}
	public Book(String bookName,int bookPage,int author_id,int category_id,int publisher_id,Date printingDate){
		this.id = 0;
		this.bookName=bookName;
		this.bookPage=bookPage;
		this.author_id=author_id;
		this.category_id=category_id;
		this.publisher_id=publisher_id;
		this.printingDate=printingDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public Date getPrintingDate() {
		return printingDate;
	}
	public void setPrintingDate(Date printingDate) {
		this.printingDate = printingDate;
	}
	
	
	
	
}
