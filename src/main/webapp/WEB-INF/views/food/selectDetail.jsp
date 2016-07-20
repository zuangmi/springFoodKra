<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%
	String cp = request.getContextPath();
%>
<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
%>
<html>
<head>
<style type="text/css">
    .nav-tabs > li, .nav-pills > li {
    float:none;
    display:inline-block;
}

.nav-tabs {
    text-align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center">
	<div class="container">
		<fieldset>
			<legend>${FoodVO.food_name}</legend>
		</fieldset>
		<img src="${FoodVO.food_image}" alt="Image" style="width: 250; max-width: 100%;">
	</div>
	
	<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#keyInfo" data-toggle="tab">핵심정보</a></li>
	<li><a href="#detailInfo" data-toggle="tab">상세정보</a></li>
	<li><a href="#review" data-toggle="tab">리뷰</a></li>
  </ul>

  <div class="tab-content">
    <div id="keyInfo" class="tab-pane fade in active">
    	<br>
					<div class="container">
						<table>
							<thead>
								<tr>
									<th scope="col">에너지</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_energy}kcal</td>
								</tr>
								<tr>
									<th scope="col">탄수화물</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_calbo}g</td>
								</tr>
								<tr>
									<th scope="col">단백질</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_protein}g</td>
								</tr>
								<tr>
									<th scope="col">지방</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_fat}g</td>
								</tr>
								<tr>
									<th scope="col">나트륨</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_na}mg</td>
								</tr>
								<tr>
									<th scope="col">콜레스테롤</th>
									<td>&nbsp;&nbsp;&nbsp;${FoodVO.food_chol}mg</td>
								</tr>
							</thead>
						</table>
					</div>
				</div> 
    </div>
    <div id="detailInfo" class="tab-pane fade">
    	<h2>상세정보</h2> 
    </div>
    <div id="review" class="tab-pane fade">
      <h2>리뷰</h2>
    </div>
  </div>
</div>
</body>
</html>