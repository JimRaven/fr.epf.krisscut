<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Page</title>

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

	<div class="container-fluid" id="dashboard">

		<div class="half">

			<div class="month">
				<p class="title">Welcome ${username}</p>
				<p class="subtitle">MOOD OF THE MONTH</p>
			</div>

			<div class="details">

				<a href="motm">
					<div class="panel-footer">
						<span class="pull-left">Give your mood for this month</span> <span
							class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a> <a href="dashboard">
					<div class="panel-footer">
						<span class="pull-left">See Krisscut's results for this
							month</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>

				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-user fa-fw"></i> Your recent moods of the month
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead>
											<tr>
												<th>Mood</th>
												<th>Comment</th>
												<th class="text-right">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${motmList}" var="element">
												<tr>
													<td><img class="mood"
														src="img/<c:out value="${element.level}"/>.png"
														height="25" width="25" /></td>
													<td><c:out value="${element.comment}" /></td>
													<td class="text-right" width=60>
														<form action="edit_user_motm" method="post">
															<input type="number" value="${element.id}" class="hidden"
																name="id"> <input type="text" value="call"
																class="hidden" name="action">

															<button type="submit" class="btn btn-sm btn-warning">
																<i class="fa fa-pencil"></i> Edit
															</button>
														</form>
													</td>
													<td class="text-right" width=80>
														<form action="" method="post">
															<input type="number" value="${element.id}" class="hidden"
																name="id"> <input type="text" value="call"
																class="hidden" name="action">

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
			</div>
		</div>


		<div class="half-2">

			<div class="global">
				<div class="global-mood">
					<div class="img-container">
						<img class="mood"
							src="<%=request.getSession().getAttribute("avgImg")%>" alt="" />
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
							src="<%=request.getSession().getAttribute("motm1Img")%>" alt="" />
					</div>
					<div class="comment">${motm1}</div>
				</div>
				<div class="comment-container">
					<div class="note">
						<img class="mood"
							src="<%=request.getSession().getAttribute("motm2Img")%>" alt="" />
					</div>
					<div class="comment">${motm2}</div>
				</div>
				<div class="comment-container">
					<div class="note">
						<img class="mood"
							src="<%=request.getSession().getAttribute("motm3Img")%>" alt="" />
					</div>
					<div class="comment">${motm3}</div>
				</div>
				<div class="comment-container">
					<div class="note">
						<img class="mood"
							src="<%=request.getSession().getAttribute("motm4Img")%>" alt="" />
					</div>
					<div class="comment">${motm4}</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>