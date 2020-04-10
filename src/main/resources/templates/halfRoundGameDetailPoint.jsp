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
<!--
	<button type="button" class="btn btn-primary btn-lg">Primary</button>
	<button type="button" class="btn btn-success btn-lg">Success</button>
 -->
 	<br/><br/>
	<div class="container">
		<div class="row mb-2">
			<div class="col-md-6">
<!-- 				<div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative"> -->
				<div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
<!-- 						<strong class="d-inline-block mb-2 text-primary">世界</strong> -->
						<table class="table-hover table-responsive table-scroll">
							<tr colspan="4">
								<th colspan="4">
									<h3 class="mb-0">猪野</h3>
								</th>
							</tr>
							<tr colspan="4">
								<td colspan="1"><label for="text1">得点</label></td>
								<td colspan="2">
									<input type="text" id="text1" class="form-control">
								</td>
								<td colspan="2">点</td>
							</tr>
							<tr>
								<td colspan="1"><label for="text1">飛び</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option></option>
										<option>○</option>
									</select>
								</td>
								<td colspan="1"><label for="text1">風</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option>東</option>
										<option>南</option>
										<option>西</option>
										<option>北</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
<!-- 						<strong class="d-inline-block mb-2 text-primary">世界</strong> -->
						<table class="table table-hover table-responsive table-scroll">
							<tr colspan="4">
								<th colspan="4">
									<h3 class="mb-0">猪野</h3>
								</th>
							</tr>
							<tr colspan="4">
								<td colspan="1"><label for="text1">得点</label></td>
								<td colspan="2">
									<input type="text" id="text1" class="form-control">
								</td>
								<td colspan="2">点</td>
							</tr>
							<tr>
								<td colspan="1"><label for="text1">飛び</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option></option>
										<option>○</option>
									</select>
								</td>
								<td colspan="1"><label for="text1">風</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option>東</option>
										<option>南</option>
										<option>西</option>
										<option>北</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row mb-2">
			<div class="col-md-6">
				<div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
<!-- 						<strong class="d-inline-block mb-2 text-primary">世界</strong> -->
						<table class="table table-hover table-responsive table-scroll">
							<tr colspan="4">
								<th colspan="4">
									<h3 class="mb-0">猪野</h3>
								</th>
							</tr>
							<tr colspan="4">
								<td colspan="1"><label for="text1">得点</label></td>
								<td colspan="2">
									<input type="text" id="text1" class="form-control">
								</td>
								<td colspan="2">点</td>
							</tr>
							<tr>
								<td colspan="1"><label for="text1">飛び</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option></option>
										<option>○</option>
									</select>
								</td>
								<td colspan="1"><label for="text1">風</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option>東</option>
										<option>南</option>
										<option>西</option>
										<option>北</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
<!-- 						<strong class="d-inline-block mb-2 text-primary">世界</strong> -->
						<table class="table table-hover table-responsive table-scroll">
							<tr colspan="4">
								<th colspan="4">
									<h3 class="mb-0">猪野</h3>
								</th>
							</tr>
							<tr colspan="4">
								<td colspan="1"><label for="text1">得点</label></td>
								<td colspan="2">
									<input type="text" id="text1" class="form-control">
								</td>
								<td colspan="2">点</td>
							</tr>
							<tr>
								<td colspan="1"><label for="text1">飛び</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option></option>
										<option>○</option>
									</select>
								</td>
								<td colspan="1"><label for="text1">風</label></td>
								<td>
									<select id="select1a" class="form-control">
										<option>東</option>
										<option>南</option>
										<option>西</option>
										<option>北</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>