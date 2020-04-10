<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/bootstrap-grid.css" th:href="@{/css/bootstrap-grid.css}" rel="stylesheet"></link>
<link href="css/navbar.css" th:href="@{/css/navbar.css}" rel="stylesheet"></link>
<link href="css/navbar.css" th:href="@{/css/bubbleHoverEffect.css}" rel="stylesheet"></link>
<link href="css/navbar.css" th:href="@{/css/tableCustome.css}" rel="stylesheet"></link>
<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">

<script src="js/jquery-3.2.1.min.js" th:src="@{/js/bubbleHoverEffect.js}"></script>
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
<script>
$('button').click(function() {
	  $(this).toggleClass('clicked');
	  $('button p').text(function(i, text) {
	    return text === "Sent!" ? "Send" : "Sent!";
	  });
	});
</script>
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

	<br/><br/>
<div class="content">
  <h1>Bubble hover effect</h1>
  <div class="button_container">
      <div class="button_su">
        <span class="su_button_circle">
        </span>
        <a href="teamsPlayData" class="button_su_inner">
          <span class="button_text_container">
            Team<br>
            Narimasu
          </span>
        </a>
      </div>

      <div class="button_su">
        <span class="su_button_circle">
        </span>
        <a href="#" class="button_su_inner">
          <span class="button_text_container">
            Team<br>
            DCP
          </span>
        </a>
      </div>
  </div>
  <p class="credit">By Sammy Helali</p>
</div>
</body>
</html>