package com.madhur.services;

import java.util.List;

import com.madhur.dao.UserDAO;
import com.madhur.dto.UserDTO;

public class UserServices {
	private UserDAO userDAO = new UserDAO();

	public int insert(UserDTO userDTO) throws Exception {
		return userDAO.insert(userDTO);
	}

	public int update(UserDTO userDTO) throws Exception {
		return userDAO.update(userDTO);

	}

	public UserDTO getById(int id) throws Exception {
		return userDAO.getById(id);
	}

	public UserDTO getByLogin(String username, String password) throws Exception {
		return userDAO.getByLogin(username, password);
	}

	public List<UserDTO> getAll() throws Exception {
		return userDAO.getAll();
	}

	public int deleteById(int id) throws Exception {
		return userDAO.deleteById(id);
	}
}
