<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
<% String cp = request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food - Register</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<script type="text/javascript">

function sendMember(){
	 var f = document.memberForm;
	 
	 //이름 유효성 검사
	 var str = f.mem_name.value;
	 str=str.trim();
	 if(!str) {
        alert("이름을 입력해주세요.");
        f.mem_name.focus();
        return;
    }
	 if(!/^[가-힣]{2,}$/.test(str)) { 
		alert("올바른 이름을 입력해주세요. (2글자 이상, 한글만 입력)");
		f.mem_name.focus();
		return;
	}
	f.mem_name.value = str;
	
	//이메일 유효성 검사
	str = f.mem_email.value;
	str=str.trim();
	if(!str) {
       alert("이메일을 입력해주세요.");
       f.mem_email.focus();
       return;
   }
	if(!/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/.test(str)) { 
		alert("올바른 이메일을 입력해주세요.");
		f.mem_email.focus();
		return;
	}
	f.mem_email.value = str;
	
	//비밀번호 유효성 검사 
	str = f.mem_pwd.value;
	str=str.trim();
   if(!str) {
       alert("비밀번호를 입력해주세요.");
       f.mem_pwd.focus();
       return;
   }
	if(!/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/.test(str)) { 
		alert("회원가입 비밀번호는 영문, 숫자, 특수문자의 조합으로 6~16자리로 입력해주세요.");
		f.mem_pwd.focus();
		return;
	}
	f.mem_pwd.value = str;

	if(str != f.mem_pwd_confirm.value) {
       alert("비밀번호가 일치하지 않습니다.");
       f.mem_pwd_confirm.focus();
       return;
	}
	
	f.action = "<%=cp%>/member/loginForm";
	f.submit();
}

function idcheck(){
	
	var url = "<%=cp%>/member/idcheck";
	var mem_email=$.trim($("#mem_email").val());
	var params="mem_email="+mem_email;
	
	$.ajax({
		url:url
		,type:"post"
		,data: params
		,dataType:"json"
		,success:function(data){
			var out=data.result;
			
			if(out=="true"){
				var s="<span style=color:blue;'>"+mem_email+"</span>&nbsp;사용 가능한 이메일입니다.";
				$("#idcheck").html(s);
				
			}else{
				var s="<span style='color:red;'>"+mem_email+"</span>&nbsp;중복된 이메일입니다.";
				$("#idcheck").html(s);
				$("#mem_email").val("");
				$("#mem_email").focus();
			}
		},error:function(err){
			alert(err.responseText);
		}
	});
}

</script>
<style type="text/css">
</style>
</head>

<body>
<br>
 
<div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">회원가입</div>
        </div>  
       	<div class="panel-body" >
       		<form name="memberForm" method="post" action="<%=cp%>/member/register" >
       			<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="mem_name" id="mem_name" placeholder="이름" >
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="mem_email" id="mem_email" placeholder="e-mail">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
						<input type="password" class="form-control" name="mem_pwd" id="mem_pwd" placeholder="비밀번호 (6자-16자, 영문/숫자/특수문자 조합)" onfocus="idcheck();">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
						<input type="password" class="form-control" name="mem_pwd_confirm" id="mem_pwd_confirm" placeholder="비밀번호 확인" >
					</div>
				</div>

                <div class="form-group" align="center">
					<button type="button" style="width: 80px" class="btn btn-info" onclick="sendMember();">가입</button>
					<button type="reset" style="width: 80px" class="btn btn-default">취소</button>
				</div>
                                
				<div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">                    
                <div id="idcheck">중복 체크하자.</div>                                  
                </div>
			</form>
		</div>
	</div>
</div> 
</body>
</html>