<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deletePro(pid){
	var conf = confirm("确定要删除吗？");
	if(conf){
		location.href="${pageContext.request.contextPath}/adminDeleteProductServlet?pid="+pid;
	}
}
function addProduct(){
	location.href="${pageContext.request.contextPath}/adminShowAddProductServlet";
}
window.onload = function(){
	var cid = "${condition.cid}";
	var sc = document.getElementById("sc");
	var options = sc.getElementsByTagName("option");
	for(var i=0;i<options.length;i++){
		if(cid==options[i].value){
			options[i].selected=true;
		}
	}
	
	var ih = "${condition.is_hot}";
	var si = document.getElementById("si");
	var options_si = si.getElementsByTagName("option");
	for(var i=0;i<options_si.length;i++){
		if(ih==options_si[i].value){
			options_si[i].selected=true;
		}
	}

</script>
</head>
<body>
	<table width="100%" cellpadding="0px" cellspacing="0px" border="1px">
		
		<caption>商品列表</caption>
		<tr>
		  <form action="${pageContext.request.contextPath }/adminSearchProductListServlet" method="post">
			<td align="left" colspan="7" width="100%">
				商品名称<input type="text" name="pname"/> &nbsp; &nbsp; &nbsp;
				是否热门<select name="is_hot">
							<option value="">--请选择--</option>
							<option value="1">是</option>
							<option value="0">否</option>
					  </select>&nbsp; &nbsp; &nbsp;
			   	 所属分类
			    	<select name="cid">
			    			<option value="">--请选择--</option>
							<c:forEach items="${categoryList }" var="cat">
								<option value="${cat.cid }">${cat.cname }</option>
							</c:forEach>
					  </select>&nbsp; &nbsp; &nbsp; 
					  <input type="submit" value="搜索"/>
			</td>
		</form>
		
		</tr>
		<tr align="right">
			<td colspan="7" width="100%">
				<button onclick="addProduct()">添加商品</button>
			</td>
		</tr>
		<!-- 序号	图片	名称	门店价格	是否热门	编辑	删除 -->
		<tr>
			<td align="center">序号</td>
			<td align="center">图片</td>
			<td align="center">名称</td>
			<td align="center">门店价格</td>
			<td align="center">是否热门</td>
			<td align="center">编辑</td>
			<td align="center">删除</td>
		</tr>
		<c:forEach items="${productList }" var="pro" varStatus="vs">
			<tr>
				<td align="center">${vs.count }</td>
				<td align="center">
					<img src="${pageContext.request.contextPath }/img/${pro.pimage }" width="40px" height="45px"/>
				</td>
				<td align="center">${pro.pname }</td>
				<td align="center">${pro.shop_price }</td>
				<td align="center">${pro.is_hot==1?"是":"否" }</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/adminShowEditProductServlet?pid=${pro.pid}">编辑</a>
				</td>
				<td align="center">
					<a href="javascript:void(0)" onclick="deletePro('${pro.pid}')">删除</a>
				</td>
				
			</tr>
		
		
		</c:forEach>
		
	</table>
</body>
</html>