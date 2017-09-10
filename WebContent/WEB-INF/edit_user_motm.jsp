<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top container-fluid"
			role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="admin">Mood of the month</a>
		</div>
		<!-- /.navbar-header --> </nav>

		<div id="page-wrapper" class="container">
			<div class="row">
				<div class="col-lg-12 title-motm">
					<h1 class="page-header">How was your month?</h1>
					<p class="chapo">${desc}</p>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body" id="motm">
							<div class="row">
								<div class="col-xs-12">
									<form action="" method="post" class="">
										<div class="form-group">
											<label>Mood</label>
											<div class="notation">
												<label for="n1"> <input id="n1" name="note"
													type="radio" value="1" ${isLevel1} /> <img src="img/1.png"
													alt="Sad" width="100" height="100" />
												</label> <label for="n2"> <input id="n2" name="note"
													type="radio" value="2" ${isLevel2} /> <img src="img/2.png"
													alt="Not Happy" width="100" height="100" />
												</label> <label for="n3"> <input id="n3" name="note"
													type="radio" value="3" ${isLevel3} /> <img src="img/3.png"
													alt="Average" width="100" height="100" />
												</label> <label for="n4"> <input id="n4" name="note"
													type="radio" value="4" ${isLevel4} /> <img src="img/4.png"
													alt="Happy" width="100" height="100" />
												</label> <label for="n5"> <input id="n5" name="note"
													type="radio" value="5" ${isLevel5} /> <img src="img/5.png"
													alt="Super Happy" width="100" height="100" />
												</label>
											</div>
										</div>
										<div class="form-group">
											<label for="content">Comment (optional)</label>
											<textarea id="content" class="content" name="comment"><c:out value = "${motm.comment}"/></textarea>
											<br />
											<p>
												Make this comment public(*)&nbsp; <input name="public"
													type="checkbox" ${isVisible} />
											</p>
										</div>

										<label for="error"><c:out value="${error}" /></label> <input
											type="text" value="save" class="hidden" name="action">
										<input type="text" value="<c:out value = "${motm.id}"/>"
											class="hidden" name="id">

										<div class="text-right">
											<button type="submit" class="btn btn-lg btn-primary">Save</button>
										</div>
									</form>
								</div>
							</div>
							<!-- /.row -->
							<div class="row">
								<i>* Public comments will be displayed on the company
									dashboard for everyone to see. Nice if you want to say hello :)</i>
							</div>
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

	<!-- jQuery -->
	<script src="../js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- CKEditor -->
	<script src="https://cdn.ckeditor.com/4.6.2/basic/ckeditor.js"></script>
	<script>
		CKEDITOR.replace('content');
	</script>

</body>
</html>