<%@page import="data.User"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="managers.UserManager"%>
	<%@page import="data.Entry"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="html/header.html"%>
<title>User</title>
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
			<div class="row">
			<%
			out.print("<form action=\"SignOut\" class=\"navbar-form\" role=\"form\">");
			out.print("<button type=\"submit\" id=\"disconnect\" class=\"btn btn-info\">გამოსვლა</button>");
			out.print("</form>");
			%>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
	
	<%
	String username = request.getParameter("id");
	UserManager manager = (UserManager) getServletContext()
			.getAttribute(UserManager.ATTRIBUTE_NAME);
	%>
	<div class="jumbotron">
	<div class="container">
			<div class="row">
				<form action="addEntry" method="post" role="form" >
				
				<div >
					<div class="form-group">
					<label for="inputName3" class="col-sm-2 control-label">ფილმი:</label>
					<div class="col-sm-10">
						<%@include file="html/movies.html"%>
					</div>
				</div>
				
				</div>
				<div>
					<div class="form-group">
					<label for="inputName3"class="col-sm-2 control-label">ზარის ტიპი:</label>
					<div class="col-sm-10">
						<%@include file="html/types.html"%>
					</div>
				</div>
				</div>
				<button style="margin-top:2%;"class="btn btn-lg btn-warning submit_button" type="submit">დამატება</button>
			</form>
			<h1></h1>
				<%
				List<Entry>  res = manager.getEntries(username, 5);
				for(int i = 0; i < res.size(); i++) {
					out.print("<ol class=\"breadcrumb\">");
					out.print("<li class=\"active\">");
					out.print(res.get(i).getMovieName());
					out.print("</li>");
					out.print("<li class=\"active\">");
					out.print(res.get(i).getEntryType());
					out.print("</li>");
					out.print("</ol>");
				}
				
				out.print("<form action=\"AddMovie\" class=\"navbar-form\" role=\"form\">");
				out.print("<button type=\"submit\" id=\"disconnect\" class=\"btn btn-success\">ფილმის დამატება</button>");
				out.print("</form>");
				%>
				</div>
				<div class="col-md-3"></div>
				</div>
	</div>
	<%@include file="html/include_scripts.html"%>
</body>
</html>