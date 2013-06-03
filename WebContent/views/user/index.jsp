<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
			<td><a class="pop" href="?action=form">Update your profile</a></td>
		</tr>
</table>
<a class="testPopup" href="#testDiv">ClickMe</a>
<div style="display:none;">
	<div id="testDiv">
	Test pop updf a sdfas
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$(".testPopup").fancybox({
			'transitionIn' : 'fade',
			'transitionOut' : 'fade',
			'speedIn' : 600,
			'speedOut' : 200,
			'overlayShow' : true,
			'autoScale' : true
		});
	});
</script>