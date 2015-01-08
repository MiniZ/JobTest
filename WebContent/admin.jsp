<%@page import="data.User"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="managers.UserManager"%>
	<%@page import="data.Entry"%>
	<%@page import="data.Stat"%>
	<%@page import="java.util.List"%>
	<%@page import="java.text.ParseException"%>
	<%@page import="java.sql.Timestamp"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.text.SimpleDateFormat"%>
	<%@page import="managers.EntryManager"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="html/header.html"%>
<title>Admin</title>
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
			<%
			out.print("<form action=\"SignOut\" class=\"navbar-form\" role=\"form\">");
			out.print("<button type=\"submit\" id=\"disconnect\" class=\"btn btn-info\">Sign Out</button>");
			out.print("</form>");
			%>
			<!--/.navbar-collapse -->
		</div>
	</div>
	
	<%
	String username = request.getParameter("id");
	EntryManager manager = (EntryManager) getServletContext()
			.getAttribute(EntryManager.ATTRIBUTE_NAME);
	%>
	<div class="jumbotron">
	<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-6">
				<h1></h1>
				<%
				List<Stat>res = null;
				
				String startDate = request.getParameter("fromDate");
				String endDate = request.getParameter("toDate");
				
				if ((startDate == null ||  endDate == null)
						|| ("".equals(startDate) || "".equals(endDate))) {
					res = manager.getEntries(10);
					System.out.print(res.size());
				} else  {
					//date formatter
					SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
					//start date
			        Date pStartDate = formatDate.parse(startDate);
			        java.sql.Date sqlStartDate = new java.sql.Date(pStartDate.getTime());
			        //end date
			        Date pEndDate = formatDate.parse(endDate);
			        java.sql.Date sqlEndDate = new java.sql.Date(pEndDate.getTime());
			        
				}
			
				if (res.size() == 0) {
					out.print("<h1 class=\"text-center\">");
					out.print("<span class=\"label label-warning\">");
					out.print("არ მოიძებნა არცერთი ჩანაწერი");
					out.print("</span>");
					out.print("</h1>");
				}
				
				for(int i = 0; i < res.size(); i++) {
					out.print("<ol class=\"breadcrumb\">");
					out.print("<li class=\"active\">");
					out.print("ფილმის სახელი: " + res.get(i).getMovieName());
					out.print("</li>");
					out.print("<li class=\"active\">");
					out.print("ჯავშანი: " + res.get(i).getJavshnebi());
					out.print("</li>");
					out.print("<li class=\"active\">");
					out.print("სეანსები: " + res.get(i).getSeansebi());
					out.print("</li>");
					out.print("<li class=\"active\">");
					out.print("სხვადასხვა: " + res.get(i).getSxva());
					out.print("</li>");
					out.print("</ol>");
				}
				%>
				</div>
				<div class="col-md-5">
				<h5></h5>
				<form action="admin.jsp" method="get"
						class="form-horizontal form-search" id="gh_search" role="form"
						accept-charset="UTF-8">
				<button type="button" class="btn btn-warning">თარიღიდან</button>
				<h5></h5>
				<input type="date" class="form-control input-sm"
							placeholder="Month/Day/Year" id="fromDate"
							name="fromDate">
							<h5></h5>
				<button type="button" class="btn btn-warning">თარიღამდე</button>
				<h5></h5>
				<input type="date" class="form-control input-sm"
							placeholder="Month/Day/Year" id="toDate"
							name="toDate">
							<h5></h5>
				
				<button class="btn btn-lg btn-danger btn-block" type="submit">ძებნა</button>
				</form>
				</div>
				</div>
				</div>
				</div>
	<%@include file="html/include_scripts.html"%>
</body>
</html>