package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Publisher;

public class JdbcPublisherDao {
	private DataSource dataSource;
	Publisher Publisher = null;
	ArrayList<Publisher> PublisherList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(String id) {
		String sql  = "DELETE FROM Publisher " +
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
					
					e.printStackTrace();
				}
	}
	public void delete(Publisher Publisher) {
		String sql  = "DELETE FROM Publisher " +
				"WHERE id=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Publisher.getId());
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	}
	public void insert(Publisher Publisher){

		String sql = "INSERT INTO Publisher " +
				"(pubName,address_id) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Publisher.getName());
			ps.setInt(2, Publisher.getAddress_id());
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
	public void update(Publisher Publisher){
		String sql = "UPDATE Publisher SET pubName = ?, address_id = ? WHERE id = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Publisher.getName());
			ps.setInt(2, Publisher.getAddress_id());
			ps.setInt(3, Publisher.getId());
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
	
	
	public Publisher getPublisher(int id){

		String sql = "SELECT * FROM Publisher WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Publisher = new Publisher(
						rs.getInt("id"),
						rs.getString("pubName"),
						rs.getInt("address_id")
				);
			}
			rs.close();
			ps.close();
			return Publisher;
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
	
	@SuppressWarnings("unused")
	public ArrayList<Publisher> getPublisher(){
		String sql = "SELECT * FROM Publisher ";
		PublisherList = new ArrayList<Publisher>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Publisher");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.PublisherList.add(new Publisher(
						rs.getInt("id"),
						rs.getString("pubName"),
						rs.getInt("address_id")
				));
			
			rs.close();
			ps.close();
			return PublisherList;
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
