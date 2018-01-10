<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
			function check(){
				var username=document.getElementById("username");
				var password=document.getElementById("password");
				var repassword=document.getElementById("repassword");
				var email=document.getElementById("email");
				var reg=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/gi;
				var result = reg.test(email.value);
				if(username.value==""){
					alert("用户名不能为空");
					return false;
				}
				if(password.value==""){
					alert("密码不能为空");
					return false;
				}
				if(repassword.value==""){
					alert("确认密码不能为空");
					return false;
				}
				if(repassword.value!=password.value){
					alert("前后密码不一致");
					return false;
				}
				if(email.value==""){
					alert("邮箱不能为空");
					return false;
				}
				if(!result){
					alert("邮箱不能为空");
					return false;
				}
				return true;
			}
		</script>
</head>
<body>
<div>
	<tr>
		<img src="img/regist.png"  width="100%">
	</tr>
</div>
		<form onsubmit="return check()" action="">
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
					    <input type="text" id="username"/>
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
					    <input  type="password" id="password"/>
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
					    <input type="password" id="repassword"/>
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
					    <input type="email" id="email"/>
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
					    <input type="date" />
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
				    				<input type="submit" value="注册" />
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
	</body>
</html>