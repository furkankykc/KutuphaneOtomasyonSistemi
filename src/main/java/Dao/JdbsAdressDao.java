package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Adress;

public class JdbsAdressDao {
	private DataSource dataSource;
	Adress Adress = null;
	ArrayList<Adress> AdressList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(int IdAdress) {
		String sql  = "DELETE FROM Adress " +
				"WHERE idAdress=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, IdAdress);
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
	public void delete(Adress Adress) {
		String sql  = "DELETE FROM Adress " +
				"WHERE idAdress=? and buildNo=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Adress.getIdAdress());
			ps.setString(2,	Adress.getBuildNo());
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
	public void insert(Adress Adress){

		String sql = "INSERT INTO Adress " +
				"(idAdress,buildNo) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Adress.getIdAdress());
			ps.setString(2, Adress.getBuildNo());
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

	public Adress getAdress(int idAdress){

		String sql = "SELECT * FROM Adress WHERE idAdress = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAdress);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Adress = new Adress(
					rs.getInt("idAdress"),
					rs.getString("street"),
					rs.getString("road"),
					rs.getString("buildNo")
					
				);
			}
			rs.close();
			ps.close();
			return Adress;
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
	public ArrayList<Adress> getAdress(){
		String sql = "SELECT * FROM Adress ";
		AdressList = new ArrayList<Adress>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Adress");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.AdressList.add(new Adress(
						rs.getInt("idAdress"),
						rs.getString("street"),
						rs.getString("road"),
						rs.getString("buildNo")
				));
			
			rs.close();
			ps.close();
			return AdressList;
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
