<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>
<script type="text/javascript">
$(function() {
	$("#myform").validate({
		rules:{
			username:{
				required:true
			},
			password:{
				required:true
			},
			repassword:{
				equalTo:"#password"
			},
			realname:{
				required:true
			},
			email:{
				email:true
			},
			phone:{
				required:true,
			}
			
		},
	messages:{
		username:{
			required:"你必须输入用户名"
		},
		password:{
			required:"你必须输入密码"
		},
		repassword:{
			required:"你必须正确输入确认的密码"
		},
		realname:{
			required:"你必须输入真实姓名"
		},
		email:{
			required:"你必须输入正确输入邮箱格式"
		},
		phone:{
			required:"你必须输入正确输入电话",
		}
	}
	});
});
</script>
</head>
<body>
<div>
	<tr>
		<img src="img/regist.png"  width="100%">
	</tr>
</div>
<div id="zhuce">
		<form  id="myform" action="${pageContext.request.contextPath }/insertUserServlet" method="post" >
		 <table width="900xp" border="1xp" cellspacing="0xp" cellpadding="0xp" align="center">
			<!--
                	作者：ma
                	时间：2017-11-20
                	描述：用户名
                -->
			    <tr>
				    <td>
					    <a>用户名</a>
				    </td>
				    <td width="50%">
					    <input type="text"  id="username" name="username"/><span id="span1"></span>
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：密码
                -->
			    <tr>
				    <td>
					    <a>密码</a>
				    </td>
				    <td width="50%">
					    <input  type="password" id="password" name="password"/>
				    </td>
			    </tr>
			
			<!--
                	作者：ma
                	时间：2017-11-20
                	描述：确认密码
                -->
			    <tr>
				    <td>
					    <a>确认密码</a>
				    </td>
				    <td width="50%">
					    <input type="password" id="repassword" name="repassword"/>
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：真实姓名
                -->
			    <tr>
				    <td>
					    <a>真实姓名</a>
				    </td>
				    <td width="50%">
					    <input type="text" id="realname" name="realname" />
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：邮箱
                -->
			    <tr>
				    <td>
					    <a>邮箱</a>
				    </td>
				    <td width="50%">
					    <input type="email" id="email" name="email"/>
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：电话
                -->
			    <tr>
				    <td>
					    <a>电话</a>
				    </td>
				    <td width="50%">
					    <input type="text" id="phone" name="phone"/>
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：生日
                -->
			    <tr>
				    <td>
					    <a>生日</a>
				    </td>
				    <td width="50%">
					    <input type="date" name="date" />
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：性别
                -->
			    <tr>
				    <td>
					    <a>性别</a>
				    </td>
				    <td width="50%">
					    <input name="sex" type="radio" />男
					    <input name="sex" type="radio" />女
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：职业
                -->
			    <!-- <tr>
				    <td>
					    <a>职业</a>
				    </td>
				    <td width="50%">
					    <select name="zhiye">
					    	<option value="---请选择---"></option>
					    	<option value="医生"></option>
					    	<option value="教师"></option>
					    	<option value="警察"></option>
					    	<option value="程序员"></option>
					    </select>
				    </td>
			    </tr> -->
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：爱好
                -->
			    <tr>
				    <td>
					    <a>爱好</a>
				    </td>
				    <td width="50%">
					    <input type="checkbox" name="运动" />运动
					    <input type="checkbox" name="读书" />读书
					    <input type="checkbox" name="看电影" />看电影
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：简介
                -->
			    <tr>
				    <td>
					    <a>简介</a>
				    </td>
				    <td width="50%">
					    <textarea>woshidawang</textarea>
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：头像
                -->
			    <tr>
				    <td>
					    <a>头像</a>
				    </td>
				    <td width="50%">
					    <input type="file"  />
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：你的头像
                -->
			    <tr>
				    <td>
					    <a>你的头像</a>
				    </td>
				    <td>
					    <input src="img/1.jpg" name="wo" />
				    </td>
			    </tr>
			    
			    <!--
                	作者：ma
                	时间：2017-11-20
                	描述：按钮
                -->
			    <tr align="center">
				    <td colspan="2">
				    	<table>
				    		<tr>
				    			<td>
				    				<input type="submit" value="注册" name="注册"/>
				    			</td>
				    			<td width="50%">
				    				<input type="reset" value="重置" />
				    			</td>
				    		    <td width="50%">
				    				<button type="button" onclick="history.go(-1)">返回</button>
				    		    </td>
				    		</tr>
				    	</table>
				    </td>
			    </tr>
		    </table>	
		</form>
</div>
</body>
</html>