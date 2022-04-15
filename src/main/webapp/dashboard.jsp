<%@page import="java.util.List"%>
<%@page import="com.madhur.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

	<%
	boolean isShow = false;
	UserDTO activeUserDTO = (UserDTO) request.getAttribute("activeUserDTO");

	if (activeUserDTO != null) {
	%>
	<h1>
		Welcome
		<%=activeUserDTO.getFirstName() + " " + activeUserDTO.getLastName()%></h1>

	<%
}
%>

	<table>
		<form action="./users" method="post">
			<input type="hidden" name="task" value="getById" />
			<tr>
				<td>Search By User Id:</td>
				<td><input type="number" name="userId" /></td>
				<td><input type="submit" name="submit" value="Search" /></td>
			</tr>
		</form>
	</table>
	<h1>OR</h1>
	<table>
		<form action="./users" method="post">
			<input type="hidden" name="task" value="getAll" />
			<tr>
				<td>Search All Users : <input type="submit" name="submit"
					value="Search All" /></td>
			</tr>
		</form>
	</table>
	<br>
	<%
	UserDTO userDTO = (UserDTO) request.getAttribute("userDTO");
	if (userDTO != null) {
	%>

	<table border="2px solid black">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile Number</th>
			<th>Action</th>
		</tr>
		<tr>
			<td><%=userDTO.getId()%></td>
			<td><%=userDTO.getUsername()%></td>
			<td><%=userDTO.getFirstName()%></td>
			<td><%=userDTO.getLastName()%></td>
			<td><%=userDTO.getMobileNumber()%></td>
			<td><%=userDTO.getEmailId()%></td>

			<td>
				<form action="./users" method="post">
					<input type="hidden" name="task" value="deleteById" /> <input
						type="hidden" name="userId" value="<%=userDTO.getId()%>" /> <input
						type="submit" name="submit" value="Delete" />
				</form>

				<form action="./users" method="post">
					<input type="hidden" name="task" value="viewEditForm" /> <input
						type="hidden" name="userId" value="<%=userDTO.getId()%>" /> <input
						type="submit" name="submit" value="Edit" />
				</form>
			</td>
		</tr>
	</table>

	<%
	}
	%>






	<%
	List<UserDTO> userDTOList = (List) request.getAttribute("userDTOList");
	if (userDTOList != null) {
	%>

	<table border="2px solid black">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Number</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<%
		for (UserDTO userDTO1 : userDTOList) {
		%>
		<tr>
			<td><%=userDTO1.getId()%></td>
			<td><%=userDTO1.getUsername()%></td>
			<td><%=userDTO1.getFirstName()%></td>
			<td><%=userDTO1.getLastName()%></td>
			<td><%=userDTO1.getMobileNumber()%></td>
			<td><%=userDTO1.getEmailId()%></td>
			<td>

				<form action="./users" method="post">
					<input type="hidden" name="task" value="deleteById" /> <input
						type="hidden" name="userId" value="<%=userDTO1.getId()%>" /> <input
						type="submit" name="submit" value="Delete" />
				</form>
				<form action="./users" method="post">
					<input type="hidden" name="task" value="viewEditForm" /> <input
						type="hidden" name="userId" value="<%=userDTO1.getId()%>" /> <input
						type="submit" name="submit" value="Edit" />
				</form>


			</td>
		</tr>
		<%
		}
		%>
	</table>

	<%
	}
	%>


	<%
	UserDTO editUserDTO = (UserDTO) request.getAttribute("editUserDTO");

	if (editUserDTO != null) {
	%>
	<form action="./users" method="POST">
		<input type="hidden" name="task" value="updateById"> <input
			type="hidden" name="id" value="<%=editUserDTO.getId()%>">
		<table>
			<tr>
				<th>Username</th>
				<td><input type="username" name="username"
					value="<%=editUserDTO.getUsername()%>"></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=editUserDTO.getPassword()%>" disabled="disabled"></td>
			</tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					value="<%=editUserDTO.getFirstName()%>"></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					value="<%=editUserDTO.getLastName()%>"></td>
			</tr>
			<tr>
				<th>Mobile Number</th>
				<td><input type="text" name="mobile"
					value="<%=editUserDTO.getMobileNumber()%>"></td>

			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email"
					value="<%=editUserDTO.getEmailId()%>"></td>

			</tr>
			<tr>
				<td><input type="submit" value="Modify"></td>
			</tr>


		</table>
	</form>

	<%
	}
	%>
</body>
</html>