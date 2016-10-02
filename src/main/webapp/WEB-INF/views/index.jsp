<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户主页</title>
</head>
<body>
    ${username},你好！<br/>
    
   <a href="/exportExcel.action">导出学生信息</a><br>
   <a href="/user/getECardUI.action">生成电子图片</a><br>
   <a href="/JvmUI.action">java虚拟机信息</a><br>
   <a href="/spider.action">抓取内容</a><br>
   <a href="/user/registerUI.action">注册</a>
</body>
</html>