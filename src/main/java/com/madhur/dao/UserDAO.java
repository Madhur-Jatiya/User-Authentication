package com.madhur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madhur.dto.UserDTO;
import com.madhur.util.DBUtil;

public class UserDAO {
	private final String INSERT_USER = "insert into userinfo(username,password,fname,lname,mobile,email) values(?,?,?,?,?,?)";
	private final String UPDATE_USER_BY_ID = "update userinfo set username = ?, password = ?, fname = ?, lname = ?, mobile = ?, email =? where user_id = ?";
	private final String FIND_USER_BY_ID = "select * from userinfo where user_id = ?";	
	private final String FIND_ALL_USER = "select * from userinfo";
	private final String FIND_USER_BY_USERNAME_PASSWORD = "select * from userinfo where username = ? and password = ?";
	private final String DELETE_USER_BY_ID = "delete userinfo from userinfo where user_id = ?";
	
	DBUtil dbUtil = new DBUtil();
	
	public int insert(UserDTO userDTO) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(INSERT_USER);
		
			pstmt.setString(1, userDTO.getUsername());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setString(3, userDTO.getFirstName());
			pstmt.setString(4, userDTO.getLastName());
			pstmt.setString(5, userDTO.getMobileNumber());
			pstmt.setString(6, userDTO.getEmailId());
			
			count = pstmt.executeUpdate();
			dbUtil.close(connection,pstmt);
			return count;
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(UserDTO userDTO) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(UPDATE_USER_BY_ID);
		
			pstmt.setString(1, userDTO.getUsername());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setString(3, userDTO.getFirstName());
			pstmt.setString(4, userDTO.getLastName());
			pstmt.setString(5, userDTO.getMobileNumber());
			pstmt.setString(6, userDTO.getEmailId());
			pstmt.setInt(7, userDTO.getId());
			
			count = pstmt.executeUpdate();
			dbUtil.close(connection,pstmt);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public UserDTO getById(int id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(FIND_USER_BY_ID);
			pstmt.setInt(1, id);
			
			ResultSet resultSet = pstmt.executeQuery();
			UserDTO userDTO = null;
			
			if(resultSet.next()) {
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getInt("user_id"));
				userDTO.setUsername(resultSet.getString("username"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setFirstName(resultSet.getString("fname"));
				userDTO.setLastName(resultSet.getString("lname"));
				userDTO.setMobileNumber(resultSet.getString("mobile"));
				userDTO.setEmailId(resultSet.getString("email"));
			}
			return userDTO;
		}
			
			catch (Exception e) {
			dbUtil.close(connection, pstmt);
			throw e;
		}
	}
	
	public UserDTO getByLogin(String username, String password) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = dbUtil.getConnection();

			pstmt = connection.prepareStatement(FIND_USER_BY_USERNAME_PASSWORD);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();
			UserDTO userDTO = null;
			if (resultSet.next()) {
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getInt("user_id"));
				userDTO.setUsername(resultSet.getString("username"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setFirstName(resultSet.getString("fname"));
				userDTO.setLastName(resultSet.getString("lname"));
				userDTO.setMobileNumber(resultSet.getString("mobile"));
				userDTO.setEmailId(resultSet.getString("email"));
				
				System.out.println("Login success");

			}
			return userDTO;

		} catch (Exception e) {
			dbUtil.close(connection, pstmt);
			System.err.println(e.getMessage());
			throw e;
		}

	}

	public List<UserDTO> getAll() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = dbUtil.getConnection();

			pstmt = connection.prepareStatement(FIND_ALL_USER);

			ResultSet resultSet = pstmt.executeQuery();
			List<UserDTO> userDTOList = new ArrayList<>();
			while (resultSet.next()) {
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getInt("user_id"));
				userDTO.setUsername(resultSet.getString("username"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setFirstName(resultSet.getString("fname"));
				userDTO.setLastName(resultSet.getString("lname"));
				userDTO.setMobileNumber(resultSet.getString("mobile"));
				userDTO.setEmailId(resultSet.getString("email"));
				userDTOList.add(userDTO);
			}
			return userDTOList;

		} catch (Exception e) {
			dbUtil.close(connection, pstmt);
			System.err.println(e.getMessage());
			throw e;
		}

	}

	public int deleteById(int id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = dbUtil.getConnection();

			pstmt = connection.prepareStatement(DELETE_USER_BY_ID);

			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			dbUtil.close(connection, pstmt);

			System.out.println("count: " + count);
			return count;
		} catch (Exception e) {
			dbUtil.close(connection, pstmt);
			System.err.println(e.getMessage());
			throw e;
		}
	}
}
