<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="logout"><a href="<c:url value="login?action=logout" />">Logout</a></div>
<h1>this is test User</h1>
<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Action</th>
		<th>Phone</th>
		<th>User Type</th>
		<th>Action</th>
	</tr>
		<tr>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
			<td>${user.userType}</td>
			<td><a class="pop" href="?action=form&id=${user.id}">Update your profile</a></td>
		</tr>
</table>
<a class="testPopup" href="#testDiv">ClickMe</a>