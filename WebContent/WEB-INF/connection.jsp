<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mood of the month</title>

<!-- Bootstrap CSS -->
<link href="style/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="style/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div id="wrapper">

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Connection</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<form action="" method="post" class="">
										<p>
											<c:out value="${error}" />
										</p>
										<div class="form-group">
											<label for="name">Login</label> <input type="text"
												class="input-lg form-control" name="login" id="login"
												placeholder="Login" required="true">
										</div>
										<div class="form-group">
											<label for="name">Password</label> <input type="text"
												class="input-lg form-control" name="password" id="password"
												placeholder="Password" required="true">
										</div>
										<div class="text-right">
											<button type="submit" class="btn btn-lg btn-primary">Login</button>
										</div>
									</form>
								</div>


							</div>
						</div>
						<!-- /.row -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<footer class="footer">
	<div class="container">
		<div class="row text-center">Resourcepool &bullet; 2017</div>
	</div>
	</footer>

</body>
</html>