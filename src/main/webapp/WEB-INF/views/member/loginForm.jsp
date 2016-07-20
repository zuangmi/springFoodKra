<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<% String cp = request.getContextPath(); %>
<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food - Login</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<script type="text/javascript">

function checkLogin(){
	
	var id=$("#mem_email").val();
	var pwd=$("#mem_pwd").val();
	
	if(id==""){
		alert("이메일을 입력해주세요.");
		id.focus();
		return;
	}
	/*
	if(!/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/.test(id)){
		alert("올바른 이메일을 입력해주세요.");
		id.focus();
		return;
	}
	*/
	if(pwd=="") {
		alert("비밀번호를 입력해주세요.");
		pwd.focus();
		return;
	}
	
	$("#loginform").attr("action","<%=cp%>/member/login").submit();
	return;
}

</script>
<body> 
	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
		<div class="panel panel-info" >
			<div class="panel-heading">
				<div class="panel-title">로그인</div>
					<div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="<%=cp%>/member/forgotPwForm">비밀번호 찾기</a></div>
                </div>     

                <div style="padding-top:30px" class="panel-body" >
                	<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                        <form id="loginform" method="post" action="<%=cp%>/member/login" class="form-horizontal">
                        	<div style="margin-bottom: 25px" class="input-group">
                        		<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input id="login-username" type="text" class="form-control" id="mem_email" name="mem_email" placeholder="e-mail">                                        
							</div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                 <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                 <input id="login-password" type="password" class="form-control" id="mem_pwd" name="mem_pwd" placeholder="비밀번호" maxlength="16">
                            </div>
                            
                             <span style="color: red;">${msg}</span>      
                             <div class="input-group">
                             	<div class="checkbox">
                             		<label><input id="login-remember" type="checkbox"  id="uRemem" name="uRemem" value="1"> 아이디 저장</label>
                                </div>
                             </div>

                             <div style="margin-top:10px" class="form-group">
                             	<div class="col-sm-12 controls" align="center">
                             	<button class="btn btn-info" onclick="checkLogin()">확인</button>
                                <a href="<%=cp%>/member/registerForm" class="btn btn-default">회원가입</a>
                                </div>
                             </div>                        
                          </form>     
				</div>                     
		</div>  
	</div>
</body>
</html>