<div class="dialog">
<div class="closeDialog">c</div>
<div class="head-style" id="dialog-title">Add User</div>
<form action="">
<table>
	<tr>
		<td><label for="name">Name</label></td>
		<td><input type="text" name="name" id="name" /></td>
	</tr>
	<tr>
		<td><label for="eamil">Email</label></td>
		<td><input type="text" name="email" id="email" /></td>
	</tr>
	<tr>
		<td><label for="phone">Phone</label></td>
		<td><input type="text" name="phone" id="phone" /></td>
	</tr>
	<tr>
		<td><label for="userType">User Type</label></td>
		<td><select name="userType" id="userType">
			<option>--select--</option>
			<option value="USER_NORMAL">Normal User</option>
			<option value="USER_ADMIN">Admin User</option>
		</select></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" name="submit" value="Submit" /><input type="reset" onclick="closeDialog()" value="Cancel" /></td>
	</tr>
</table>
</div>

<!--<script type="text/javascript">
	$(document).ready(function() {
		$(".dialog").dialog( {
			height : 400,
			width : 500,
			overlay : {
				opacity : 0.1,
				background : "#ff0000"
			},
			'modal' : true,
			'close' : function() {
				windows.location = 'user';
			}
		}).open();
	});
</script>
--><!--

<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
			<td>${user.userType}</td>-->