package com.login.database;

import java.sql.*;

import com.login.models.User;



public class UserDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUName ="root";
	private String dbPassowrd = "";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	
	//method to load jdbc driver
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//method to make connection
	public Connection getConnection() {
		Connection con = null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUName,dbPassowrd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public boolean validate(User user) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		//fetch username and password fron database
		String sql = "select * from loginuser where username = ? and password = ?";
		PreparedStatement ps;
        try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery(sql);
		status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
