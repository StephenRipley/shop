<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
</head>

<body>
	<h1>Log in</h1>
	<div>
		<form action="LoginSubmit" method="post">
			${errorMessage}
			<div>
				<label>User Id: </label>
				<input type="text" name="user_id"/>				
			</div>
			<button type="submit">Submit </button>
		</form>
	</div>	
</body>
</html>
