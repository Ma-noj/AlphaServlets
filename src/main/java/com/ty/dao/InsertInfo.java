package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.User;

public class InsertInfo {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;

	public boolean insertUserinfo(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			sql = "INSERT INTO userinfodb.user VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setLong(4, user.getPhoneNumber());
			pstmt.setString(5, user.getPassword());

			if (pstmt.executeUpdate() == 1) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public User validateUserByEmail(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			sql = "SELECT * FROM userinfodb.user WHERE email=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				long phoneNumber = res.getLong(4);
				User user = new User();
				user.setId(id);
				user.setEmail(email);
				user.setName(name);
				user.setPhoneNumber(phoneNumber);
				user.setPassword(password);
				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<User> findAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			sql = "SELECT * FROM userinfodb.user";
			pstmt = con.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			List<User> users = new ArrayList<>();
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt(1));
				user.setName(res.getString(2));
				user.setEmail(res.getString(3));
				user.setPhoneNumber(res.getLong(4));
				user.setPassword(res.getString(5));
				users.add(user);
			}
			return users;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateById(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			sql = "UPDATE userinfodb.user SET name =?,email=?,phoneNumber =?,password=? WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getPhoneNumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getId());

			if (pstmt.executeUpdate() == 1) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean DeleteById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			sql = "DELETE FROM userinfodb.user WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate()==1) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
