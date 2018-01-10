<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#dengru{
	margin:0 auto;border: 1px solid #000;width: 400px;height: 120px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userLogin</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#username").blur(
			function(){
				$.get(
					"${pageContext.request.contextPath }/userLoginServlet",
					{"username":this.value},
					function(data) {
						if(data!=null){
							var val=data.username;
							$("#span1").html("商家可以登入");
						}else{
							$("#span1").html("商家未注册或输入名错误");
						}
					},
					"json"
				);	
			}		
		);
	});
</script>
</head>
<body>
<table>
<div>
	<tr>
		<img src="img/login1.png"  width="100%">
	</tr>
</div>
<div id="dengru">
		<form  action="${pageContext.request.contextPath }/userLoginServlet1" method="post" >
			商家名：<input type="text"  id="username" name="username"/><span id="span1"></span><br/>
			密        码 &nbsp:&nbsp<input type="password" name="password" /><br/>
			<input type="submit" name="登录" value="登入" /> 
		</form>
		<div>没有账户？<input type="button" name="注册" value="注册" onclick="location.href='${pageContext.request.contextPath}/userRegister.jsp'"/>&nbsp&nbsp<button type="button" onclick="history.go(-1)">返回</button></div>
</div>
</table>
</body>
</html>