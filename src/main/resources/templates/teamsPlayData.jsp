<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/bootstrap-grid.css" th:href="@{/css/bootstrap-grid.css}" rel="stylesheet"></link>
<link href="css/navbar.css" th:href="@{/css/navbar.css}" rel="stylesheet"></link>
<link href="css/navbar.css" th:href="@{/css/tableCustome.css}" rel="stylesheet"></link>
<script src="js/jquery-3.2.1.min.js" th:src="@{/js/jquery-3.2.1.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/popper.min.js" th:src="@{/js/popper.min.js}"></script>

<title>TOP画面</title>
<style>
#map-canvas {
	width: 600px;
	height: 600px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">MCP</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="shopSearchResultList"> private</a></li>
				<li><a href="shopSearch">DCP 麻雀部</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="active"><a href="shopSearchResultList"> private</a></li>
				<li><a href="halfRoundGameDetailPoint">test</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<button type="button" class="btn btn-primary btn-lg">Primary</button>
	<button type="button" class="btn btn-success btn-lg">Success</button>
	<br/><br/>
	<div class="container-fluid">
<!-- 		<table class="table-hover table-responsive table-scroll table"> -->
		<div class="table-responsive">
			<!-- classの説明 -->
			<!-- table-hover : カーソルをmouse-overさせたときのアニメーションを追加する  -->


		</div>
	</div>
</body>
</html>