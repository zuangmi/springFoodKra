<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
<% String cp = request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food - ForgotPw</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<script type="text/javascript">
	
</script>
<body>
<div class="container">    
	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
		<div class="panel panel-info" >
			<div class="panel-heading">
				<div class="panel-title">비밀번호 찾기</div>
                </div>     

                <div style="padding-top:30px" class="panel-body" >
                	<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                        <form action="forgotPw" method="post" class="form-horizontal">
                        	<div style="margin-bottom: 25px" class="input-group">
                        		<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input id="login-username" type="text" class="form-control"  id="mem_email" name="mem_email" placeholder="e-mail">                                        
							</div>
                                
                             <div style="margin-top:10px" class="form-group">
                             	<div class="col-sm-12 controls" align="center">
                                      <a id="btn-ok" href="#" class="btn btn-info">확인  </a>
                                      <a id="btn-reset" href="#" class="btn btn-default">다시입력</a>
                                </div>
                             </div> 
                          </form>     
				</div>                     
		</div>  
	</div>
</div>
</body>
</html>