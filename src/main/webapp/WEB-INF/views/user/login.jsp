<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝宝淘论坛登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   <c:if test="${!empty error}">
   <font color="red"><c:out value="${error}"/></font>
   </c:if>
   <form action="<c:url value="/loginCheck.action"/>" method="post">
   用户名：<input type="text" name="userName"><br/>
   密码：<input type="password" name="password"> <br>
   <input type="submit" value="登录">
   <input type="reset" value="重置"> 
   </form>
  </body>
</html>
