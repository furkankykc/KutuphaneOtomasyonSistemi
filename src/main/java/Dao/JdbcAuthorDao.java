package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Author;
import Entity.Author;

public class JdbcAuthorDao {
	private DataSource dataSource;
	Author Author = null;
	ArrayList<Author> AuthorList = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(String id) {
		String sql  = "DELETE FROM Author " +
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
	public void delete(Author Author) {
		String sql  = "DELETE FROM Author " +
				"WHERE id=? and firstName=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Author.getId());
			ps.setString(2,	Author.getFirstName());
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
	public void insert(Author Author){

		String sql = "INSERT INTO Author " +
				"(firstName,lastName,address_id) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Author.getFirstName());
			ps.setString(2, Author.getLastName());
			ps.setInt(3, Author.getAddress_id());
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
	public void update(Author Author){
		String sql = "UPDATE Author SET firstName = ?, lastName = ?, address_id = ? WHERE id = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Author.getFirstName());
			ps.setString(2, Author.getLastName());
			ps.setInt(3,Author.getAddress_id());
			ps.setInt(4, Author.getId());
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
	
	
	public Author getAuthor(int Authorid){

		String sql = "SELECT * FROM Author WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Authorid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Author = new Author(
					rs.getInt("id"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getInt("address_id")
				);
			}
			rs.close();
			ps.close();
			return Author;
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
	public ArrayList<Author> getAuthor(){
		AuthorList = new ArrayList<Author>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Author");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.AuthorList.add(new Author(
						rs.getInt("id"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getInt("address_id")
				));
			
			rs.close();
			ps.close();
			return AuthorList;
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
