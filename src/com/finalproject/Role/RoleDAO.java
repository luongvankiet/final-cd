package com.finalproject.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.finalproject.DbConnector;

public class RoleDAO {
	private DbConnector dConn = new DbConnector();
	public List<Role> getRoleByUserId(int user_id){
		Connection conn = null;
		Statement sm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Role> rList = new ArrayList<Role>();
		try {
			String sql = "SELECT * FROM roles" 
					+ " LEFT JOIN user_role"
					+ " ON roles.role_id = user_role.role_id"
					+ " WHERE user_role.user_id = ?";
			conn = dConn.connectDB();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				String created_at = df.format(rs.getTimestamp("created_at"));
				String updated_at = df.format(rs.getTimestamp("updated_at"));
				Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"), created_at, updated_at);
				rList.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dConn.closeConnection(conn);
			dConn.closeStatement(sm);
			dConn.closeResultSet(rs);
		}
		return rList;
	}
}
