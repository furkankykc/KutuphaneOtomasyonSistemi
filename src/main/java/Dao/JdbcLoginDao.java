package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import Entity.LoginBean;
public class JdbcLoginDao {


		private DataSource dataSource;
		LoginBean user = null;
		ArrayList<LoginBean> userList = null;
		
	
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
		
		public void insert(LoginBean login){

			String sql = "INSERT INTO user " +
					"(username,password) VALUES (?, ?)";
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, login.getUserName());
				ps.setString(2, login.getPassword());
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

		public LoginBean getUser(String username){

			String sql = "SELECT * FROM user WHERE username = ? ";
			
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					this.user = new LoginBean(
						rs.getString("username"),
						rs.getString("password")
					);
				}
				rs.close();
				ps.close();
				return user;
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
		
		public ArrayList<LoginBean> getUser(){
			String sql = "SELECT * FROM user ";
			userList = new ArrayList<LoginBean>();
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) 
					this.userList.add(new LoginBean(
						rs.getString("username"),
						rs.getString("password")
					));
				
				rs.close();
				ps.close();
				return userList;
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


