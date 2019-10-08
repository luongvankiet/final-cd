package com.finalproject.User;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.finalproject.DbConnector;
import com.finalproject.Role.Role;
import com.finalproject.Role.RoleDAO;

public class UserDAO {
	private DbConnector dConn = new DbConnector();
	private RoleDAO rDao = new RoleDAO();
	public List<User> getAllUser(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> uList = new ArrayList<User>();
		List<Role> rList;
		try {
			String sql = "SELECT * FROM users";
			conn = dConn.connectDB();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				String created_at = df.format(rs.getTimestamp("created_at"));
				String updated_at = df.format(rs.getTimestamp("updated_at"));
				rList = rDao.getRoleByUserId(rs.getInt("id"));
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), 
						rs.getString("token"), rList, created_at, updated_at);
				uList.add(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dConn.closeConnection(conn);
			dConn.closePreparedStatement(ps);
			dConn.closeResultSet(rs);
		}
		return uList;
	}
	
	public User getUserByToken(String token){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<Role> rList = null;
		try {
			String sql = "SELECT * FROM users WHERE user.token = '?'";
			conn = dConn.connectDB();
			ps = conn.prepareStatement(sql);
			ps.setString(1, token);
			rs = ps.executeQuery();
			while(rs.next()) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				String created_at = df.format(rs.getTimestamp("created_at"));
				String updated_at = df.format(rs.getTimestamp("updated_at"));
				rList = rDao.getRoleByUserId(rs.getInt("id"));
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("token"), 
						rList, created_at, updated_at);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dConn.closeConnection(conn);
			dConn.closePreparedStatement(ps);
			dConn.closeResultSet(rs);
		}
		return user;
	}
}
