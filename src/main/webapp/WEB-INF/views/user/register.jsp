<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册页面</title>
		<script type="text/javascript" src="/js/jquery-1.6.1.min.js"></script>
		
	
	
	</head>
	
	<body>
	<c:if test="${!empty error}">
   <font color="red"><c:out value="${error}"/></font>
   </c:if>
	    <form method="post"  action="/user/register.action">
		    <ul>
			    <li>username: <input type="text" name="userName" onblur="check(this)"/><img id="register"/></li>
			    <li>password: <input type="password" name="password"/></li>
			    <li>confirm: <input type="password" name="confirm"/></li>
			    <li>age: <input type="text" name="age"/></li>
				<li>phone:<input type="text" name="phone"></li>
				<li>email:<input type="text" name="email"></li>
			</ul>
			<input type="text" name="vlidateCode" /><span><img id="code" src="/user/getIcon.action" height="40px" width="100px"/></span>
			<input type="submit" name="submit" value="注册"/>
			<input type="reset" name="reset" value="重置" />
		</form>
		<script type="text/javascript">
		$("#code").click(function(){
			alert("nihao");
			var rand = Math.random();   
			this.src="/user/getIcon.action?r="+rand;
		});
		</script>
	</body>
</html>
