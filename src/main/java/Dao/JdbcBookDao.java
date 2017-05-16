package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Book;
import Entity.Publisher;

public class JdbcBookDao {
	private DataSource dataSource;
	Book Book = null;
	ArrayList<Book> BookList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(String id) {
		String sql  = "DELETE FROM Book " +
				"WHERE id=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void delete(Book Book) {
		String sql  = "DELETE FROM Book " +
				"WHERE id=? and bookName=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Book.getId());
			ps.setString(2,	Book.getBookName());
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void insert(Book Book){

		String sql = "INSERT INTO Book " +
				"(bookName,bookPage,author_id,category_id,publisher_id,printingDate) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
	//| id | bookName       | bookPage | author_id | category_id | publisher_id | 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Book.getBookName());
			ps.setInt(2, Book.getBookPage());
			ps.setInt(3, Book.getAuthor().getId());
			ps.setInt(4, Book.getCategory().getId());
			ps.setInt(5, Book.getPublisher().getId());
			ps.setDate(6, Book.getPrintingDate());

			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public void update(Book Book){
		String sql = "UPDATE Book SET bookName = ?, bookPage = ?, author_id = ?, category_id = ?, publisher_id = ? , printingDate = ? WHERE id = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Book.getBookName());
			ps.setInt(2, Book.getBookPage());
			ps.setInt(3, Book.getAuthor_id());
			ps.setInt(4, Book.getCategory_id());
			ps.setInt(5, Book.getPublisher_id());
			ps.setDate(6, Book.getPrintingDate());
			ps.setInt(7, Book.getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public Book getBook(int Bookid){

		String sql = "SELECT * FROM Book WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Bookid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Book = new Book(
						rs.getInt("id"),
						rs.getString("bookName"),
						rs.getInt("bookPage"),
						rs.getInt("author_id"),
						rs.getInt("category_id"),
						rs.getInt("publisher_id"),
						rs.getDate("printingDate")
				);
			}
			rs.close();
			ps.close();
			return Book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public ArrayList<Book> getBook(){

		String sql = "SELECT * FROM Book";
		BookList = new ArrayList<Book>();
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				this.BookList.add( new Book(
						rs.getInt("id"),
						rs.getString("bookName"),
						rs.getInt("bookPage"),
						rs.getInt("author_id"),
						rs.getInt("category_id"),
						rs.getInt("publisher_id"),
						rs.getDate("printingDate")
						
				));
			}
			rs.close();
			ps.close();
			return BookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
