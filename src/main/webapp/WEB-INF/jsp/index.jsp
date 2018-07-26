<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE-edge">
	<meta http-equiv="Prama" content="no-cache">
	<meat http-equiv="Cache-Control" content="no-cache">
	<title>Boot Sample | Home</title>
	 	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	 	<link href="static/css/myLeftNavStyle.css" rel="stylesheet">
	<!-- [If it IE9]>
	<script src="static/js/html6shiv.min.js"></script>
<script src="static/js/respond.min.js"></script>" -->  
</head>
<body>
<div class="container-fluid jumbotron">
  <div class="text-center">
	<h1>Welcome to Spring Boot Demo</h1>
  </div>
</div>
<div class="container-fluid">
  <div class="row content">	
    <div class="col-sm-3 sidenav">
	<h2></h2>	
      <ul class="nav nav-pills nav-stacked">
      	<li id="MODE_HOME"><a href="/" data-id="1">Spring Boot Home</a><li>
		<li id="MODE_SWAGGER_UI"><a href="swagger-ui.html" data-id="2">Swagger UI Demo</a><li>
		<li id="MODE_SPRING_MVC"><a href="all-students" data-id="3">Sprint Boot MVC Demo</a><li>
        <li id="MODE_SPRING_REST"><a href="api/students">Spring Rest</a></li>
		<li id="MODE_SPRING_SECURITY"><a href="spring-security">Spring Security</a></li>
      </ul><br>      
    </div>

    <div class="col-sm-9">       
      <c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div id="homeDiv" class="page-header text-center navLinks">
				<h2>Home Page of Spring Boot</h2>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_SWAGGER_UI'}">
			<div id="swaggerUIDev" class="text-center">
				<h2>Home Page of Swagger UI</h2>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_SPRING_MVC'}">
			<div id="mvcDiv" class="page-header text-center navLinks">
				<h3>Student Details</h3>				
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Name</th>
								<th>Id</th>
								<th>Description</th>
								<th>Course</th>								
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="studentDetails" items="${studentDetails}">
								<tr>
									<td>${studentDetails.studentName}</td>
									<td>${studentDetails.studentId}</td>
									<td>${studentDetails.description}</td>
									<td>${studentDetails.courses}</td>									
									<td><a href="delete-task?studentId=${studentDetails.studentId}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>		
		<c:when test="${mode == 'MODE_SPRING_REST'}">
			<div id="restDiv" class="page-header text-center navLinks">
				<h2>Under development!!!</h2>
				<div class="table-responsive">
					${studentDetailsREST}
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_SPRING_SECURITY'}">
			<div id="securityDiv" class="page-header text-center navLinks">
				<h2>Coming Soon!!!</h2>
		  	</div>
		</c:when>
	  </c:choose>	  	  
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

	<script src="static/js/jquery-3.2.1.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script>
		 $(document).ready(function(){
			console.log('${mode}');
			$('.nav li.active').removeClass('active');
			console.log($("#"+'${mode}').addClass('active'));
			$("#"+'${mode}').addClass('active');			 	
		});
	</script>  
</body>
</html>