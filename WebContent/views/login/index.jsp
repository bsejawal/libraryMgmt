<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="main">
<form method="post" action="login?action=authenticate">
<fieldset><legend><b>Login System</b></legend> <label
	for="username">Username: </label><input id="username" name="username" /><br />
<label for="password">Password: </label><input type="password" id="password"
	name="password" /><br />
<input type="submit" value="Login" /></fieldset>
</form>
</div>