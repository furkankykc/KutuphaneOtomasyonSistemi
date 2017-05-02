package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Address;

public class JdbcAddressDao {
	private DataSource dataSource;
	Address Address = null;
	ArrayList<Address> AddressList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(String id) {
		String sql  = "DELETE FROM Address " +
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
	public void delete(Address Address) {
		String sql  = "DELETE FROM Address " +
				"WHERE id=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Address.getId());;
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
	public void insert(Address Address){

		String sql = "INSERT INTO Address " +
				"(name,street,road,buildNo) VALUES (?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Address.getName());
			ps.setString(2, Address.getStreet());
			ps.setString(3, Address.getRoad());
			ps.setString(4, Address.getBuildNo());
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

	public Address getAddress(int id){

		String sql = "SELECT * FROM Address WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Address = new Address(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("street"),
						rs.getString("road"),
						rs.getString("buildNo")
				);
			}
			rs.close();
			ps.close();
			return Address;
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
	public ArrayList<Address> getAddress(){
		String sql = "SELECT * FROM Address ";
		AddressList = new ArrayList<Address>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Address");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.AddressList.add(new Address(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("street"),
						rs.getString("road"),
						rs.getString("buildNo")
				));
			
			rs.close();
			ps.close();
			return AddressList;
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
