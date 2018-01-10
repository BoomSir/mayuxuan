<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function back() {
		window.open('${pageContext.request.contextPath}/index.jsp','_top');
	}
</script>
</head>
<body>
	<div>
		<a style="text-decoration: line-through;">超市价格：${oneproduct.market_price }元</a><br/>
		<br/>
		
	</div>
	<div>
		商店价格：${oneproduct.shop_price }元<br/>
		<br/>
		
	</div>
	<div>
		日期：${oneproduct.pdate }<br/>
		<br/>
		
	</div>
	<div>
	商品描述：${oneproduct.pdesc }<br/>
	
	</div>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/findOneServlet?pid=${oneproduct.pid}'">添加购物车</button>
	<button type="button" name="back" onclick="back()">返回</button>
</body>
</html>