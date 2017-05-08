package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.User;;

public class JdbcUserDao {
	private DataSource dataSource;
	User User = null;
	ArrayList<User> UserList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(int IDUser) {
		String sql  = "DELETE FROM User " +
				"WHERE idUser=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, IDUser);
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
	public void delete(User User) {
		String sql  = "DELETE FROM User " +
				"WHERE idUser=? and =userName?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, User.getID());
			ps.setString(2,	User.getUserName());
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
	public void insert(User User){

		String sql = "INSERT INTO User " +
				"(userName,password) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, User.getUserName());
			ps.setString(2, User.getPassword());
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

	public User getUser(int idUSer){

		String sql = "SELECT * FROM User WHERE idUser = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idUSer);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.User = new User(
					rs.getInt("idUser"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("userName"),
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return User;
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
	public User getUser(String userName){

		String sql = "SELECT * FROM User WHERE userName = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.User = new User(
					rs.getInt("idUser"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("userName"),
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return User;
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
	
	public ArrayList<User> getUser(){
		UserList = new ArrayList<User>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from User");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.UserList.add(new User(
						rs.getInt("idUser"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("userName"),
						rs.getString("password")
				));
			
			rs.close();
			ps.close();
			return UserList;
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
