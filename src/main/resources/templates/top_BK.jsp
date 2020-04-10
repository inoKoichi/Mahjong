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
		  <table class="table table-striped table-bordered table-hover">
				<tr class="success">
					<th >半荘数</th>
					<th colspan="3">猪野</th>
					<th colspan="3">望</th>
					<th colspan="3">伊藤</th>
					<th colspan="3">工藤</th>
					<th colspan="3">間宮</th>
					<th colspan="3">岳</th>
					<th colspan="3">オットー</th>
					<th colspan="3">ああああ</th>
				</tr>
				<tr class="sub-header-maney">
					<th >金額</th>
					<td colspan="3">1000円</th>
					<td colspan="3">2000円</td>
					<td colspan="3">-4000円</td>
					<td colspan="3">200円</td>
					<td colspan="3">300000円</td>
					<td colspan="3">30000円</td>
					<td colspan="3">30000円</td>
					<td colspan="3">30000円</td>
				</tr>
				<tr class="sub-header-point">
					<th >得点</th>
					<td colspan="3">200</th>
					<td colspan="3">10</td>
					<td colspan="3">30</td>
					<td colspan="3">-40</td>
					<td colspan="3">10</td>
					<td colspan="3">10</td>
					<td colspan="3">10</td>
					<td colspan="3">10</td>
				</tr>
				<tr class="sub-header">
					<td>No</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
					<td>順位</td>
					<td>点数</td>
					<td>得点</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>40000 点</td>
					<td>35</td>
					<td>2</td>
					<td>30000</td>
					<td>15</td>
					<td>3</td>
					<td>-40000</td>
					<td>-50</td>
					<td>3</td>
					<td>-40000</td>
					<td>-50</td>
					<td>4</td>
					<td>-40000</td>
					<td>-100</td>
					<td>3</td>
					<td>-40000</td>
					<td>-50</td>
					<td>3</td>
					<td>-40000</td>
					<td>-50</td>
					<td>3</td>
					<td>-40000</td>
					<td>-50</td>
				</tr>

			</table>
		</div>
</body>
</html>