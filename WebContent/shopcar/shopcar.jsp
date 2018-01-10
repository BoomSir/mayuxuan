<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	$(function(){
		var str=$(".checkbox");
		var str1="";
		for(var i=0;i<str.length;i++){
			if(str[i].checked==true){
				str1+=str[i].value+",";
			}
		}
		$("#str").val(str1);
	});
	function delBoxClick(pid){
		var conf = confirm("确定要删除吗？");
		if(conf){
			location.href="${pageContext.request.contextPath}/delectCarProductServlet?pid="+pid;
		}
	}
	window.onload = function(){
			var allBox=document.getElementById("allBox");
			allBox.onchange=function(){
				if(allBox.checked==true){
					var boxes=document.getElementsByName("delBox")
					for(var i=0;i<boxes.length;i++){
						boxes[i].checked=true;
						}
					}else{
						var boxes=document.getElementsByName("delBox")
						for(var i=0;i<boxes.length;i++){
							boxes[i].checked=false;
					}
			}
		}
			var allBox2=document.getElementById("allBox2");
			allBox2.onchange=function(){
				if(allBox2.checked==true){
					var boxes2=document.getElementsByName("count")
					for(var i=0;i<boxes2.length;i++){
						boxes2[i].checked=true;
						}
					}else{
						var boxes2=document.getElementsByName("count")
						for(var i=0;i<boxes2.length;i++){
							boxes2[i].checked=false;
					}
			}
		}
	}
		function delBoxClick() {
			var b=true;
			var allBox=document.getElmentByName("allBox");
			var boxes=document.getElmentByName("deBox");
			for(var i=0;i<boxes.length;i++){
				if(boxes[i].checked==false){
					b=false;
					break;
				}else{
					continue;
				}
				b=true;
			}
			if(b==false){
				allBox.checked=false;
			}else{
				allBox.checked=true;
			}
		}
		function countBoxClick() {
			var c=true;
			var allBox2=document.getElmentByName("allBox2");
			var boxes2=document.getElmentByName("count");
			for(var i=0;i<boxes2.length;i++){
				if(boxes2[i].checked==false){
					c=false;
					break;
				}
			}
			if(c==false){
				allBox2.checked=false;
			}else{
				allBox2.checked=true;
			}
		}
	

	
	
</script>
</head>
<body>
<div>
	<img width="100%" src="${pageContext.request.contextPath }/img/shopcar.png"/>
</div>
<div>
<form action="${pageContext.request.contextPath }/countCarProductServlet" method="get" >
	<table width="100%" cellpadding="0px" cellspacing="0px" border="1px">
		
		<caption>商品列表</caption>
		<!-- 序号	图片	名称	门店价格	是否热门	编辑	删除 -->
		<tr>
			<td align="center">序号</td>
			<td align="center">图片</td>
			<td align="center">名称</td>
			<td align="center">门店价格</td>
			<td align="center">删除</td>
			<td align="center">结算</td>
		</tr>
		
		<c:forEach items="${listCarOneProduct }" var="pro" varStatus="vs">
			<tr>
				<td align="center">${vs.count }</td>
				<td align="center">
					<img src="${pageContext.request.contextPath }/img/${pro.pimage }" width="40px" height="45px"/>
				</td>
				<td align="center">${pro.pname }</td>
				<td align="center">${pro.shop_price }</td>
				<td align="center">
				<input type="checkbox" name="delBox" id="delBox" onclick="delBoxClick('${pro.pid }')" value="${pro.pid }"/>
				</td>
				<td align="center">
				<input type="checkbox" class="checkbox" name="count" id="count" onclick="countBoxClick('${pro.pid }')" value="${pro.pid }"/>
				</td>
				
			</tr>
		
		</c:forEach>
		<tr align="right">
				<td colspan="6">
				<input type="checkbox" name="allBox" id="allBox"/>删除的全选/全不选<br/>
				<input type="checkbox" name="allBox2" id="allBox2" />结算的全选/全不选<br/>
				<input type="button" value="删除"/>
				<input type="submit" value="结算" />
				<input type="hidden" name="str1" id="str" value=""/>
				
				</td>
			</tr>
	</table>
	</form>
</div>
</body>
</html>