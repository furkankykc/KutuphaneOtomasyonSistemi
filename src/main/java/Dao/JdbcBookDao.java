package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Book;

public class JdbcBookDao {
	private DataSource dataSource;
	Book Book = null;
	ArrayList<Book> BookList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(String BookId) {
		String sql  = "DELETE FROM Book " +
				"WHERE idBook=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, BookId);
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
				"WHERE idBook=? and bookName=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Book.getIdBook());
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
				"(idBook,bookName) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Book.getIdBook());
			ps.setString(2, Book.getBookName());
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

		String sql = "SELECT * FROM Book WHERE idBook = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Bookid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Book = new Book(
					rs.getInt("idBook"),
					rs.getString("bookName"),
					rs.getInt("bookPage")
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
		BookList = new ArrayList<Book>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.BookList.add(new Book(
					rs.getInt("idBook"),
					rs.getString("bookName"),
					rs.getInt("bookPage")
				));
			
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
