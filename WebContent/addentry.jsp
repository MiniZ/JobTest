<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="html/header.html"%>
<link href="styles/jumbotron-narrow.css" rel="stylesheet">
<title>Submit Your Entry</title>
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
	<div class="container not_nav">
		<div class="jumbotron not_nav">
			<form action="addEntry" method="post" role="form" >
				
				<div >
					<div class="form-group">
					<label for="inputName3" class="col-sm-2 control-label">Movie:</label>
					<div class="col-sm-10">
						<%@include file="html/movies.html"%>
					</div>
				</div>
				
				</div>
				<div>
					<div class="form-group">
					<label for="inputName3"class="col-sm-2 control-label">Type:</label>
					<div class="col-sm-10">
						<%@include file="html/types.html"%>
					</div>
				</div>
				</div>
				<button style="margin-top:2%;"class="btn btn-lg btn-warning submit_button" type="submit">SUBMIT ENTRY</button>
			</form>
		</div>
	</div>
	<!-- /container -->
	<%@include file="html/include_scripts.html"%>
	<script type="text/javascript">
		$("#platform_hidden").val($("#platformsList").find(":selected").text());
		$(document).ready(
				function() {
					$("#platformsList").change(
							function() {
								$("#platform_hidden").val(
										$("#platformsList").find(":selected")
												.text());
							});
				});
	</script>
</body>
</html>