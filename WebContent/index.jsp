<%@page import="data.User"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="html/header.html"%>
<title>Sign In</title>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
	<div class="jumbotron">
	<div class="container">
		<form action="SignIn" method="post" class="form-signin" id="gh_sign"
			role="form">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
			<%
				String incorrectID = (String) request
						.getAttribute("incorrectUsername");
				String incorrectPass = (String) request
						.getAttribute("incorrectPassword");
				if (incorrectID != null || incorrectPass != null)
					out.print("<h2 class=\"form-signin-heading text-center\"><span class=\"label label-warning\">Please try again</span></h2>");
				else
					out.print("<h2 class=\"form-signin-heading text-center\"><span class=\"label label-success\">Please Sign In</span></h2>");
			%>
			<h1></h1>
			<input type="text" class="form-control" placeholder="Username" required
				autofocus id="username" name="username"> 
				<h1></h1>
			<input
				type="password" class="form-control" placeholder="Password" required
				id="password" name="password">
				<h1></h1>
			<button class="btn btn-lg btn-success btn-block" type="submit">Sign
				in</button>
				</div>
				<div class="col-md-3"></div>
				</div>
		</form>
	</div>
	</div>
	<%@include file="html/include_scripts.html"%>
</body>
</html>