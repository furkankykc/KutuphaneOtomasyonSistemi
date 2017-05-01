package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Author;

public class JdbcAuthorDao {
	private DataSource dataSource;
	Author Author = null;
	ArrayList<Author> AuthorList = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(int IdAuthor) {
		String sql  = "DELETE FROM Author " +
				"WHERE idAuthor=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, IdAuthor);
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
				"WHERE idAuthor=? and firstName=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Author.getIdAuthor());
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
				"(idAuthor,firstName) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Author.getIdAuthor());
			ps.setString(2, Author.getFirstName());
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
	public void update(Author Author){}
	public Author getAuthor(int Authorid){

		String sql = "SELECT * FROM Author WHERE idAuthor = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Authorid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Author = new Author(
					rs.getInt("idAuthor"),
					rs.getString("firstName"),
					rs.getString("lastName")
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
					rs.getInt("idAuthor"),
					rs.getString("firstName"),
					rs.getString("lastName")
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
