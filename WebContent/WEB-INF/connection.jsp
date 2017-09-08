<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/epf.fr.krisscut/style/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mood of the month</title>

	<!-- Bootstrap CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="style/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
</head>
<body>
	<h1>Mood of the month</h1>
	<div>
		<h2>Connection </h2>
		<form action="" method="post">
			<p><c:out value = "${error}"/></p>
			<input type="text" name="login" placeholder="login" required="true">
			<input type="password" name="password" placeholder="password" required="true">
			<input type="submit">
		</form>
	</div>
</body>
</html>