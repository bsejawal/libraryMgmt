<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="logout"><a
	href="<c:url value="login?action=logout" />">Logout</a></div>
<h2>User List</h2>
<div class="link"><a href="javascript:void(0)" onclick=getForm('new');
>Add
New User</a></div>
<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Action</th>
		<th>Phone</th>
		<th>User Type</th>
		<th>Action</th>
	</tr>
	<tr class="testststst">
		<td>${user.name}</td>
		<td>${user.email}</td>
		<td>${user.phone}</td>
		<td>${user.userType}</td>
		<td><a class="pop" href="javascript:void(0)"
			onclick=getForm(this);>Update your profile</a></td>
	</tr>
</table>
<div style="display: none" id="form"><jsp:include page="form.jsp"
	flush="true" /></div>
<script type="text/javascript">
	$(document).ready(function() {
		//callDialogBox("#form");
		});
	function callDialogBox(id) {
		$(id).dialog({
			'overlay' : true,
			'modal' : true,
			open: function() {
	        	$('div.ui-widget-overlay').addClass('custom-overlay');
			}
		});
		$(id).siblings('div.ui-dialog-titlebar').remove();
	}

	function getForm(el) {
		clearForm("#form");
		if (el == "new")
			var st="sts";
		else {
			var v = [];
			$(el).parent().parent().find("td").each(function() {
				v.push($(this).html());
			});
			setFormValues(v)
		}
		callDialogBox("#form");
	}
	function setFormValues(v) {
		$("#name").val(v[0]);
		$("#email").val(v[1]);
		$("#phone").val(v[2]);
		$("#userType").val(v[3]);
	}
	function clearForm(form) {
		$(form).find("input[type=text]").val("");
		$("select option:first").attr('selected', 'selected');

	}
	function closeDialog(){
		$('#form').dialog('close');
	}
</script>