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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food - foodList</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$("#searchBtn").on(
						"click",
						function(event) {
							self.location = "listPage"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();
						});
			});

	function resetSearchData() {
		$("#code1").val("");
		$("#code2").val("");
	}
</script>
</head>
<body>
	<div class='box-body'>
		<select name="searchType">
			<option value="n"
				<c:out value="${cri.searchType == null?'selected':''}"/>>전체</option>
			<option value="fn"
				<c:out value="${cri.searchType eq 'fn'?'selected':''}"/>>식품이름</option>
		</select> <input type="text" name='keyword' id="keywordInput"
			value='${cri.keyword }' />
		<button id='searchBtn'>검색</button>
	</div>

	<div class="FoodSearch" id="FoodSearch">
		<fieldset>
			<label for="code2"> 분류</label> <select name="code1" title="대분류"
				id="code1">
				<option value="">전체</option>
				<option value="1">간장/고추장/장류</option>
				<option value="2">견과류</option>
				<option value="3">과자/시리얼</option>
				<option value="4">라면/컵라면/면식품</option>
				<option value="5">밀가루/설탕/소금/조미료</option>
			</select> <select name="code2" id="code2" title="중분류">
				<option value="">전체</option>
				<option value="1">간장</option>
				<option value="2">고추장</option>
				<option value="3">된장</option>
				<option value="4">쌈장</option>
				<option value="5">초고추장/볶음고추장</option>
				<option value="6">건포도/건과일</option>
				<option value="7">땅콩/아몬드류</option>
				<option value="8">맛밤</option>
				<option value="9">국수/칼국수/콩국수</option>
				<option value="10">고춧가루</option>
			</select> <input type="submit" alt="검색" value="검색" /> <input type="reset"
				alt="초기화" value="초기화" onclick="resetSearchData();" />
		</fieldset>
	</div>
	
	<div class="box-body">
		<table class="table table-list-search">
			<thead>
				<tr>
					<th>비교</th>
					<th class="first-child" scope="col">바코드</th>
					<th scope="col">식품이름</th>
					<th scope="col">에너지<br /> (kcal)
					</th>
					<th scope="col">탄수화물 <br /> (g)
					</th>
					<th scope="col">단백질 <br /> (g)
					</th>
					<th scope="col">지방 <br /> (g)
					</th>
					<th scope="col">나트륨 <br /> (mg)
					</th>
					<th scope="col">콜레스테롤 <br /> (mg)
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="FoodVO">
					<tr>
						<td><input type="checkbox" class="checkthis" /></td>
						<td>${FoodVO.food_barcode}</td>
						<td><a
							href='<%=cp%>/food/selectFood?bcode=${FoodVO.food_barcode}'>${FoodVO.food_name}</a></td>
						<td>${FoodVO.food_energy}</td>
						<td>${FoodVO.food_calbo}</td>
						<td>${FoodVO.food_protein}</td>
						<td>${FoodVO.food_fat}</td>
						<td>${FoodVO.food_na}</td>
						<td>${FoodVO.food_chol}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<div class="text-center">
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a
					href="listPage${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="listPage${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="listPage${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>