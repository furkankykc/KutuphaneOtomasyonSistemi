package Dao;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;
	import Entity.kitap;

	public class JdbcKitapDao
	{
		private DataSource dataSource;
		kitap kitap = null;
		ArrayList<kitap> kitapList= null;
	
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
		public void delete(String kitapId) {
			String sql  = "DELETE FROM kitap " +
					"WHERE id=?";
			Connection conn = null;
			try{
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, kitapId);
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
		public void delete(kitap kitap) {
			String sql  = "DELETE FROM kitap " +
					"WHERE ad=? and yazar=?";
			Connection conn = null;
			try{
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, kitap.getAd());
				ps.setString(2,	kitap.getYazar());
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
		public void insert(kitap kitap){

			String sql = "INSERT INTO kitap " +
					"(ad,yazar) VALUES (?, ?)";
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, kitap.getAd());
				ps.setString(2, kitap.getYazar());
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

		public kitap getKitap(int kitapid){

			String sql = "SELECT * FROM kitap WHERE id = ?";
			
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, kitapid);
				
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					this.kitap = new kitap(
						rs.getInt("id"),
						rs.getString("ad"),
						rs.getString("yazar")
					);
				}
				rs.close();
				ps.close();
				return kitap;
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
		
		public ArrayList<kitap> getKitap(){
			String sql = "SELECT * FROM kitap ";
			kitapList = new ArrayList<kitap>();
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from kitap");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) 
					this.kitapList.add(new kitap(
						rs.getInt("id"),
						rs.getString("ad"),
						rs.getString("yazar")
					));
				
				rs.close();
				ps.close();
				return kitapList;
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
