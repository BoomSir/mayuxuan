<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.qianfeng.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#pageUl{
		display:inline;
	}
	#pageUl li{
		font-size:30px;
		margin-right: 10px;
	}
	#pageUl a{
		text-decoration: none;
		color: black;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XXX商城</title>
			<link rel="stylesheet" href="css/demo1.css" />
			<script>
				var i=1;
				var timer;
				window.onload=function(){
					setInterval(gdt,3000);
					timer=setTimeout(showph,4000);
				}
				
				function showph(){
					var imgid=document.getElementById("imgid");
					imgid.style.display="block";
					clearTimeout(timer);
					timer=setTimeout(hidderph,4000);
				}
				function hidderph(){
					var imgid=document.getElementById("imgid");
					imgid.style.display="none";
					clearTimeout(timer);
				}
				
				
				function gdt(){
					var img=document.getElementById("img");
					img.src="img/b"+i+".jpg";
					i++
					if(i==3){
						i=1;
					}
				}
			</script>
	</head>
	<body>
		<div id="fatherdiv">
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：logo
            -->
            <div>
            	<img src="img/ad.bmp" width="100%" id="imgid" style="display: none;"/>
            </div>
			<div id="div1_logo">
				<div id="logophoto">
					<img src="img/mylogo.png"/>
				</div>
				<div id="login">
				<c:if test="${empty user }">
					<a href="buyerLogin.jsp">用户登入</a>
					<a href="buyerRegister.jsp">用户注册</a>
				</c:if>
				<c:if test="${!empty user }">
					欢迎你,${user.username }
				</c:if>
					<a href="userLogin.jsp">商家登入</a>
					<a href="shopcar/shopcar.jsp">购物车</a>
				</div>
				<div class="clear"></div>
			</div>
			
			<!--
             	作者：ma
             	时间：2017-11-20
             	描述：导航
             -->
			<div id="navigation">
				<ul>
					<a href="#navigation"><li>首页</li></a>
			 		<a href="#bimaibaokuan"><li>爆款电脑</li></a>
					<a href="#shenghuojiadian"><li>家电</li></a>
					<a href="#shoujihuichang"><li>手机会场</li></a>
					<a href="#changjiachengnuo"><li>厂家承诺</li></a>
					<a href="#linked"><li>超链接</li></a>
					<a href="#banquan"><li>法律申明</li></a>
				</ul>
			</div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：必买爆款
           -->
			<div><img src="img/tittle1.png"  width="100%" id="bimaibaokuan"/></div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
               	描述：电脑
           -->
			<div><img src="img/b1.jpg"  width="100%" id="img"/></div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：生活家电
           -->
			<div><img src="img/tittle2.png" width="100%" id="shenghuojiadian"/></div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：家电
            -->
			<div id="jiadian1"><img src="img/banner1.jpg" /></div>
			<div id="jiadian2">
				<div id="p1"><img src="img/small01.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p2"><img src="img/small02.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p3"><img src="img/small03.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p4"><img src="img/small04.jpg"/><p>显示器</br>¥999</p></div>
				<div class="clear"></div>
				<div id="p5"><img src="img/small05.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p6"><img src="img/small06.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p7"><img src="img/small07.jpg"/><p>显示器</br>¥999</p></div>
				<div id="p8"><img src="img/small08.jpg"/><p>显示器</br>¥999</p></div>
			</div>
			
			<!--商品title1-->
			<div>
				<img src="img/tittle3.png" width="100%" />
			</div>
			<!--商品列表-->
			<!-- <div id="pro_left">
					<img src="img/banner_left.jpg" width="100%" />
				</div> -->
			<div style="width:100%" id="shoujihuichang">
				<c:forEach items="${pageBean.pageData}" var="pro">
					<div style='padding-top:10px;text-align:center;border:1px solid black;width:220px;height:240px;float:left'>
						<a href="${pageContext.request.contextPath}/productServlet?pid=${pro.pid }"><img width='130px' height='130px' src='${pageContext.request.contextPath }/img/${pro.pimage }' /></a>
						<p>${pro.pname }<br/>店铺价格：${pro.shop_price }</p>
					</div>
				</c:forEach>
					<div style="text-align: center;">
						<ul id="pageUl">
						<c:if test="${pageBean.currentPage!=1 }">
							<li><a href="${pageContext.request.contextPath }/showAllProductServlet?currentPage=${pageBean.currentPage-1}">上一页</a></li>
						</c:if>
						<c:if test="${pageBean.currentPage==1 }">
							<li>上一页</li>
						</c:if>
							<li><a href="${pageContext.request.contextPath}/showAllProductServlet?currentPage=2">1</a></li>
							<li><a href="${pageContext.request.contextPath}/showAllProductServlet?currentPage=3">2</a></li>
							<li><a href="${pageContext.request.contextPath}/showAllProductServlet?currentPage=4">3</a></li>
							<li><a href="${pageContext.request.contextPath}/showAllProductServlet?currentPage=5">4</a></li>
							<%-- <c:forEach begin="1" end="${pageBean.totalPage }" var="page">
								<c:if test="${page!=pageBean.currentPage }">
									<li><a href="${pageContext.request.contextPath }/showAllProductServlet?currentPage=${page }">${page }</a></li>
								</c:if>
								<c:if test="${page==pageBean.currentPage }">
									<li><font size="30px">${page }</font></li>
								</c:if>
							</c:forEach> --%>
						<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
							<li><a href="${pageContext.request.contextPath }/showAllProductServlet?currentPage=${pageBean.currentPage+1}">下一页</a></li>
						</c:if>
						<c:if test="${pageBean.currentPage==pageBean.totalPage }">
							<li>下一页</li>
						</c:if>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
		
			
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：厂家承诺
            -->
			<div id="changjiachengnuo"><img src="img/bottom.png" width="100%"/></div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：超链接
            -->
			<div id="linked" >
				<a href="#">关于我们</a>
				<a href="#">联系我们</a>
				<a href="#">招贤纳士</a>
				<a href="#">法律声明</a>
				<a href="#">友情链接</a>
				<a href="#">支付方式</a>
				<a href="#">配送方式</a>
				<a href="#">广告声明</a>
			</div>
			
			<!--
            	作者：ma
            	时间：2017-11-20
            	描述：版权信息
            -->
            <div id="banquan" >Copyright &copy;2010-2017 &nbsp;千锋商城&nbsp;&nbsp;版权所有</div>
		</div>
	</body>
</html>