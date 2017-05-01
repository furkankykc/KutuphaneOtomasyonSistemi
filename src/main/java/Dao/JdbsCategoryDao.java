package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Entity.Category;;

public class JdbsCategoryDao {
	private DataSource dataSource;
	Category Category = null;
	ArrayList<Category> CategoryList= null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void delete(int IdCategory) {
		String sql  = "DELETE FROM Category " +
				"WHERE idCategory=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, IdCategory);
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
	public void delete(Category Category) {
		String sql  = "DELETE FROM Category " +
				"WHERE idCategory=? and catName=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Category.getIdCategory());
			ps.setString(2,	Category.getCatName());
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
	public void insert(Category Category){

		String sql = "INSERT INTO Category " +
				"(idCategory,catName) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Category.getIdCategory());
			ps.setString(2, Category.getCatName());
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

	public Category getCategory(int idCategory){

		String sql = "SELECT * FROM Category WHERE idCategory = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idCategory);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.Category = new Category(
					rs.getInt("idCategory"),
					rs.getString("catName")
				
				);
			}
			rs.close();
			ps.close();
			return Category;
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
	public ArrayList<Category> getCategory(){
		String sql = "SELECT * FROM Category ";
		CategoryList = new ArrayList<Category>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.CategoryList.add(new Category(
						rs.getInt("idCategory"),
						rs.getString("catName")
				));
			
			rs.close();
			ps.close();
			return CategoryList;
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
