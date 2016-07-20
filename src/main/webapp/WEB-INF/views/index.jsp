<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<% String cp = request.getContextPath(); %>
<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>  
<html>
<head>
<title>Food - Main</title>
<script type="text/javascript">
$(document).ready(function() {
	$('#Carousel').carousel({
		interval : 5000
	})
});
</script>
<style type="text/css">
.carousel {
	margin-bottom: 0;
	padding: 0 40px 30px 40px;
}

.carousel-control {
	left: -12px;
	height: 40px;
	width: 40px;
	background: none repeat scroll 0 0 #222222;
	border: 4px solid #FFFFFF;
	border-radius: 23px 23px 23px 23px;
	margin-top: 90px;
}

.carousel-control.right {
	right: -12px;
}

.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}

.carousel-indicators li {
	background: #cecece;
}

.carousel-indicators .active {
	background: #428bca;
}
</style>
</head>
<body>
	<div class="main">
		<div class="jumbotron text-center">
			<h2>Main</h2>
			<p><a class="btn btn-info" href="<%=cp%>/food/listPage" role="button">상세검색</a></p>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div id="Carousel" class="carousel slide">

						<ol class="carousel-indicators">
							<li data-target="#Carousel" data-slide-to="0" class="active"></li>
							<li data-target="#Carousel" data-slide-to="1"></li>
						</ol>

						<!-- Carousel items -->
						<div class="carousel-inner">
							<div class="item active">
								<div class="row">
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/cheesecupnoodle.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/gimchisabalnoodle.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/jjajangnoodle.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/sixdognoodle.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
								</div>
								<!--.row-->
							</div>
							<!--.item-->
							
							<div class="item">
								<div class="row">
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/shinnoodle.jpg" alt="Image" style="width: 250; height: 250;max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/samyangnoodle.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/food8.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
									<div class="col-md-3">
										<a href="#" class="thumbnail"><img src="http://14.63.213.212:55/images/food7.jpg" alt="Image" style="width: 250; height: 250; max-width: 100%;"></a>
									</div>
								</div>
								<!--.row-->
							</div>
							<!--.item-->

						</div>
						<!--.carousel-inner-->
						<a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a> 
						<a data-slide="next" href="#Carousel" class="right carousel-control">›</a>
					</div>
					<!--.Carousel-->
				</div>
			</div>
		</div>
		<!--.container-->
	</div>
</body>
</html>
