<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dtree.css">

<title>Insert title here</title>
</head>
<body>
	<div>
		<img  width="65%" height="200px" src="${pageContext.request.contextPath }/img/${oneproduct.pimage }"/>
	</div>
	<div>
	序号：${oneproduct.pid }<br/>
	商品名称：${oneproduct.pname }<br/>
	</div>
</body>
</html>