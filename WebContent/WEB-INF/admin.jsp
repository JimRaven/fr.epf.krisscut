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
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle navlink"
				data-toggle="dropdown" href="#"> <i class="fa fa-gear fa-fw"></i>
					Manage MOTMs <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="add_member"><i class="fa fa-user fa-fw"></i>
							Add member</a></li>
					<li><a href="edit_motm"><i class="fa fa-calendar fa-fw"></i>
							Change MOTM Template</a></li>
				</ul></li>
		</ul>
		</nav>

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Administration Panel</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-user fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${memberNumber}</div>
									<div class="huge-label">Registered members</div>
								</div>
							</div>
						</div>
						<a href="add_member">
							<div class="panel-footer">
								<span class="pull-left">Add member</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-smile-o fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">3</div>
									<div class="huge-label">Moods Closed</div>
								</div>
							</div>
						</div>
						<a href="edit_motm">
							<div class="panel-footer">
								<span class="pull-left">Edit MOTM content</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-blue">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tachometer fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">Your page</div>
									<div class="huge-label">View & Export</div>
								</div>
							</div>
						</div>
						<a href="employee">
							<div class="panel-footer">
								<span class="pull-left">Show personal window</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-user fa-fw"></i> Manage Members
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-hover table-striped">
											<thead>
												<tr>
													<th>Name</th>
													<th>Email</th>
													<th>Birthdate</th>
													<th class="text-right">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${employeeList}" var="element">
													<tr>
														<td><c:out value="${element.name}" /></td>
														<td><c:out value="${element.email}" /></td>
														<td><fmt:formatDate type="date" dateStyle="medium"
																value="${element.birth}" /></td>
														<td class="text-right" width=60>
															<form action="edit_member" method="post">
																<input type="number" value="${element.id}"
																	class="hidden" name="id"> <input type="text"
																	value="call" class="hidden" name="action">

																<button type="submit" class="btn btn-sm btn-warning">
																	<i class="fa fa-pencil"></i> Edit
																</button>
															</form>
														</td>
														<td class="text-right" width=80>
															<form action="" method="post">
																<input type="number" value="${element.id}"
																	class="hidden" name="id"> <input type="text"
																	value="call" class="hidden" name="action">

																<button type="submit" class="btn btn-sm btn-danger">
																	<i class="fa fa-trash"></i> Remove
																</button>
															</form>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="text-center">
											<ul class="pagination">
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
											</ul>
										</div>
									</div>
									<!-- /.table-responsive -->
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-tachometer fa-fw"></i> Stats
						</div>
						<div class="panel-body" id="stats">

							<div class="note">
								${average}<small>/5</small>
								<p>Avg Mood</p>
							</div>

							<div class="details">
								<div class="mood">
									<div class="img-container">
										<img src="img/1.png" alt="super" />
									</div>
									<div class="progress-bar-container">
										<span class="desc">Vote count: ${level1Counter}</span>
										<div class="progress">
											<div class="progress-bar progress-bar-danger"
												role="progressbar" aria-valuenow="10" aria-valuemin="0"
												aria-valuemax="100" style="width:${level1Total}">
												<span class="">${level1Total}</span>
											</div>
										</div>
									</div>
								</div>
								<div class="mood">
									<div class="img-container">
										<img src="img/2.png" alt="super" />
									</div>
									<div class="progress-bar-container">
										<span class="desc">Vote count: ${level2Counter}</span>
										<div class="progress">
											<div class="progress-bar progress-bar-warning"
												role="progressbar" aria-valuenow="5" aria-valuemin="0"
												aria-valuemax="100" style="width:${level2Total}">
												<span class="">${level2Total}</span>
											</div>
										</div>
									</div>
								</div>
								<div class="mood">
									<div class="img-container">
										<img src="img/3.png" alt="super" />
									</div>
									<div class="progress-bar-container">
										<span class="desc">Vote count: ${level3Counter}</span>
										<div class="progress">
											<div class="progress-bar progress-bar-neutral"
												role="progressbar" aria-valuenow="15" aria-valuemin="0"
												aria-valuemax="100" style="width:${level3Total}">
												<span class="">${level3Total}</span>
											</div>
										</div>
									</div>
								</div>
								<div class="mood">
									<div class="img-container">
										<img src="img/4.png" alt="super" />
									</div>
									<div class="progress-bar-container">
										<span class="desc">Vote count: ${level4Counter}</span>
										<div class="progress">
											<div class="progress-bar progress-bar-midsuccess"
												role="progressbar" aria-valuenow="45" aria-valuemin="0"
												aria-valuemax="100" style="width:${level4Total}">
												<span class="">${level4Total}</span>
											</div>
										</div>
									</div>
								</div>
								<div class="mood">
									<div class="img-container">
										<img src="img/5.png" alt="super" />
									</div>
									<div class="progress-bar-container">
										<span class="desc">Vote count: ${level5Counter}</span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												role="progressbar" aria-valuenow="25" aria-valuemin="0"
												aria-valuemax="100" style="width:${level5Total}">
												<span class="">${level5Total}</span>
											</div>
										</div>
									</div>
								</div>
							</div>

							<a href="stats" class="btn btn-default btn-block">View more
								reports</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->

					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-cog fa-fw"></i> Settings
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table settings">
								<tbody>
									<tr>
										<td>Mailing Date</td>
										<td>Last friday of each month</td>
									</tr>
									<tr>
										<td>Time</td>
										<td>10:00</td>
									</tr>
								</tbody>
							</table>
							<table class="table editsettings hidden">
								<tbody>
									<tr>
										<td>Mailing Date</td>
										<td><select name="date" class="form-control"
											id="senddate">
												<option value="1">Last friday of each month</option>
												<option value="2">Last office-day of each month</option>
												<option value="3">First monday of each month</option>
												<option value="4">First office-day of each month</option>
										</select></td>
									</tr>
									<tr>
										<td>Time</td>
										<td><input type="text" class="form-control"></td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit"
											class="btn btn-sm btn-primary"></td>
									</tr>
								</tbody>
							</table>

							<!-- /.list-group -->
							<a class="btn btn-default btn-block edit">Change Settings</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
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