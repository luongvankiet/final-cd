package com.finalproject;

import java.sql.*;

public class DbConnector {
	public Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
//			String connectionUrl = "jdbc:postgresql://localhost:5432/project_karaoke_management";
//			String connectionUser = "postgres";
//			String connectionPassword = "123";
			
			String connectionUrl = "jdbc:postgresql://ec2-107-21-120-104.compute-1.amazonaws.com/d6h8e90fsf79nt?user=grcopcmljywiqg&password=3137c8ba281afd074dd84de0c5f24e480e807c67656f6ef02dcf0c319385c751&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			conn = DriverManager.getConnection(connectionUrl);
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(Connection conn) {
		try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
	}
	
	public void closeStatement(Statement sm) {
		try { if(sm != null) sm.close(); } catch (SQLException e) { e.printStackTrace();}
	}
	
	public void closePreparedStatement(PreparedStatement ps) {
		try { if(ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace();}
	}
	
	public void closeResultSet(ResultSet rs) {
		try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
	}
}
