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
<link href="/fr.epf.Krisscut/style/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/fr.epf.Krisscut/style/style.css" rel="stylesheet">

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
			<a class="navbar-brand" href="index">Mood of the month</a>
		</div>
		<!-- /.navbar-header --> </nav>

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Statistics</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body" id="statistics">
							<div class="row">
								<div class="col-xs-12">
									<div>
										<div class="dropdown pull-right selectbtn">
											<a class="dropdown-toggle btn btn-primary btn-lg"
												data-toggle="dropdown" href="#"> <i
												class="fa fa-gear fa-fw"></i> Select month <i
												class="fa fa-caret-down"></i>
											</a>
											<ul class="dropdown-menu dropdown-user">
												<li><a href="#">March 2017</a></li>
												<li><a href="#">February 2017</a></li>
												<li><a href="#">January 2017</a></li>
												<li><a href="#">December 2016</a></li>
											</ul>
										</div>
										<div class="clearfix"></div>
									</div>

									<div class="container-fluid" id="dashboard">
										<div class="half">
											<div class="month">
												<p class="title">MARCH 2017</p>
												<p class="subtitle">MOOD OF THE MONTH</p>
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
										</div>


										<div class="half-2">

											<div class="global">
												<div class="global-mood">
													<div class="img-container">
														<img class="mood"
															src="<%=request.getSession().getAttribute("avgImg")%>"
															alt="" />
													</div>
													<div class="notation">
														<p class="title">GLOBAL MOOD</p>
														<span class="note">${average}</span> <span class="note-on">/5</span>
													</div>
												</div>
											</div>

											<div class="comments">
												<h2 class="title">Comments</h2>
												<div class="comment-container">
													<div class="note">
														<img class="mood"
															src="<%=request.getSession().getAttribute("motm1Img")%>"
															alt="" />
													</div>
													<div class="comment">${motm1}</div>
												</div>
												<div class="comment-container">
													<div class="note">
														<img class="mood"
															src="<%=request.getSession().getAttribute("motm2Img")%>"
															alt="" />
													</div>
													<div class="comment">${motm2}</div>
												</div>
												<div class="comment-container">
													<div class="note">
														<img class="mood"
															src="<%=request.getSession().getAttribute("motm3Img")%>"
															alt="" />
													</div>
													<div class="comment">${motm3}</div>
												</div>
												<div class="comment-container">
													<div class="note">
														<img class="mood"
															src="<%=request.getSession().getAttribute("motm4Img")%>"
															alt="" />
													</div>
													<div class="comment">${motm4}</div>
												</div>
											</div>
										</div>
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