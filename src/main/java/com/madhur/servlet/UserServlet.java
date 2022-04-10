package com.madhur.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madhur.dto.UserDTO;
import com.madhur.services.UserServices;

public class UserServlet extends HttpServlet {

	protected void goGet(HttpServletRequest request, HttpServletResponse response) {
		String task = request.getParameter("task");

//		if (task.equalsIgnoreCase("getById")) {
//			System.out.println("Redirect to Get By Id....");
//			getById(request, response);
//
//		} else if (task.equalsIgnoreCase("getAll")) {
//			System.out.println("Redirect to Get All....");
//			getAll(request, response);
//
//		} else if (task.equalsIgnoreCase("deleteById")) {
//			System.out.println("Redirect to Delete....");
//			deleteById(request, response);
//
//		} else if (task.equalsIgnoreCase("viewEditForm")) {
//			System.out.println("Redirect to viewEditForm....");
//			viewEditForm(request, response);
//
//		} else {
//			System.out.println("No task found....");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");

		if (task.equalsIgnoreCase("getById")) {
			System.out.println("Redirect to Get By Id....");
			getById(request, response);

		} else if (task.equalsIgnoreCase("getAll")) {
			System.out.println("Redirect to Get All....");
			getAll(request, response);

		} else if (task.equalsIgnoreCase("deleteById")) {
			System.out.println("Redirect to Delete....");
			deleteById(request, response);

		} else if (task.equalsIgnoreCase("viewEditForm")) {
			System.out.println("Redirect to viewEditForm....");
			viewEditForm(request, response);

		} else if (task.equalsIgnoreCase("login")) {
			System.out.println("Redirect to Login....");
			login(request, response);

		} else if (task.equalsIgnoreCase("signup")) {
			System.out.println("Redirect to Signup....");
			singup(request, response);

		} else if (task.equalsIgnoreCase("updateById")) {
			System.out.println("Redirect to Update....");
			updateById(request, response);

		} else {
			System.out.println("No task found....");
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("logInUsername");
			String password = request.getParameter("logInPswd");
			PrintWriter printWriter = response.getWriter();
			UserDTO userDTO;

			userDTO = new UserServices().getByLogin(username, password);

			if (userDTO == null) {
				System.out.println("User not found");
				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('No Data found');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("login.jsp").include(request, response);

			} else {
				System.out.println("User found login success");
				request.setAttribute("activeUserDTO", userDTO);
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void singup(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter printWriter = response.getWriter();
			UserDTO userDTO = new UserDTO();
			String Pswd = request.getParameter("signUpPswd1");
			String confrimPswd = request.getParameter("signUpPswd2");
			
			if (Pswd.equals(confrimPswd)) {
				userDTO.setUsername(request.getParameter("signUpUsername"));
				userDTO.setPassword(request.getParameter("signUpPswd1"));
				userDTO.setFirstName(request.getParameter("firstName"));
				userDTO.setLastName(request.getParameter("lastName"));
				userDTO.setMobileNumber(request.getParameter("mobileNumber"));
				userDTO.setEmailId(request.getParameter("emailId"));
				int count = new UserServices().insert(userDTO);

				if (count > 0) {
					System.out.println("Singup success");
					response.sendRedirect("login.jsp");

				} else {
					System.out.println("failed to create account");
					response.sendRedirect("signup.jsp");
				}
			}

			else {
				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('Confrim Password is not amtch with Password');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("signup.jsp").include(request, response);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getById(HttpServletRequest request, HttpServletResponse response) {
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));

			UserDTO userDTO = new UserServices().getById(userId);

			if (userDTO == null) {
				PrintWriter printWriter = response.getWriter();

				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('No Data found');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			}

			else {

				request.setAttribute("userDTO", userDTO);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<UserDTO> userDTOList = new UserServices().getAll();
			if (userDTOList.isEmpty()) {
				PrintWriter printWriter = response.getWriter();

				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('No Data found');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			} else {

				request.setAttribute("userDTOList", userDTOList);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteById(HttpServletRequest request, HttpServletResponse response) {
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			PrintWriter printWriter = response.getWriter();

			int count = new UserServices().deleteById(userId);
			if (count <= 0) {

				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('No Data found');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			} else {
				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('Data deleted successfully');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void viewEditForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			PrintWriter printWriter = response.getWriter();

			UserDTO userDTO = new UserServices().getById(userId);
			if (userDTO == null) {

				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('No Data found');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			} else {

				request.setAttribute("editUserDTO", userDTO);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateById(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter printWriter = response.getWriter();
			UserDTO userDTO = new UserDTO();

			userDTO.setUsername(request.getParameter("username"));
			userDTO.setPassword(request.getParameter("password"));
			userDTO.setId(Integer.parseInt(request.getParameter("id")));
			userDTO.setFirstName(request.getParameter("firstName"));
			userDTO.setLastName(request.getParameter("lastName"));
			userDTO.setEmailId(request.getParameter("email"));
			userDTO.setMobileNumber(request.getParameter("mobile"));

			int count = new UserServices().update(userDTO);

			if (count > 0) {
				System.out.println("Update success");
				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('Update successfully');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			} else {
				System.out.println("failed to Update account");
				printWriter.write("<html><body onload='myFunction()'>");
				printWriter.write("<script>function myFunction() {alert('failed to Update account');}</script>");
				printWriter.write("</body></html>");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
