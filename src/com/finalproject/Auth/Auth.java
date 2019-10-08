package com.finalproject.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import com.finalproject.DbConnector;
import com.finalproject.Role.*;
import com.finalproject.User.*;

public class Auth {
	private DbConnector dConn = new DbConnector();
	private RoleDAO rDao = new RoleDAO();
	
	public User login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		List<Role> rList;
		try {

			String pwd = PasswordEncryptor.encrypt(password);
			String sql = "SELECT * FROM users WHERE users.username = ? AND users.password = ?";
			conn = dConn.connectDB();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				String created_at = df.format(rs.getTimestamp("created_at"));
				String updated_at = df.format(rs.getTimestamp("updated_at"));
				rList = rDao.getRoleByUserId(rs.getInt("id"));
				if(username.equals(rs.getString("username")) && pwd.equals(rs.getString("password"))) {
					u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("token"), 
							rList, created_at, updated_at);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dConn.closeConnection(conn);
			dConn.closePreparedStatement(ps);
			dConn.closeResultSet(rs);
		}
		return u;
	}
}
