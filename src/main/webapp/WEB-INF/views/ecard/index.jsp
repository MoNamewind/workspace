<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>java开发电子名片</title>
		<script type="text/javascript" src="/js/jquery-1.6.1.min.js"></script>
		<style type="text/css">
		 div body{
		   margin:0;
		   padding:0;
		 }
		  #info{
		     width:500px;
		     float:left;
		  }
		  #imgcontainer{
		    float:left;
		  }
		</style>
	</head>
	
	<body>
	    <div id="info">
	    <h1>电子名片系统</h1>
		姓名：<input type="text" name="name" value="刘书进"/> 公司：<input type="text"name="company" value="58同城"/> <br/>
		部门：<input type="text" name="dept" value="商业技术部"/> 职务：<input type="text" name="title" value="rd"/><br/><br/>
		地址：<input type="text" name="address" value="花梨坎"/> 手机：<input type="text" name="mobile" value="18601297084"/><br/>
		 电话：<input type="text" name="telphone" value="5953778"/><br/>
		 传真：<input type="text" name="fax" value="336699"/> 邮箱：<input type="text" name="email" value="liushujin01@58ganji.com"/> <br/>
		 网址：<input type="text" name="web" value="www.baidu.com"/> 备注：<input type="text" name="remark" value="欢迎保存"/> <br/>
		<input type="button" value="提交" onclick="send()"/>
	    </div>
		<div id="imgcontainer">
		
		</div>
		<script type="text/javascript">
		
		   function send(){
			   alert("nihao");
			   var name1 = $("input[name='name']").val();
			   var company1 = $("input[name='company']").val();
			   var dept1 = $("input[name='dept']").val();
			   var title1= $("input[name='title']").val();
			   var address1 = $("input[name='address']").val();
			   var mobile1 = $("input[name='mobile']").val();
			   var telphone1 = $("input[name='telphone']").val();
			   var fax1 = $("input[name='fax']").val();
			   var eamil1 = $("input[name='email']").val();
			   var web1 = $("input[name='web']").val();
			   var remark1 = $("input[name='remark']").val();
			   $.ajax({
                   url:"/user/getECard.action",
				   data:{name:name1,company:company1,dept:dept1,
				   title:title1,address:address1,mobile:mobile1,
				   telphone:telphone1,fax:fax1,eamil:eamil1,web:web1,remark:remark1
				   },
				   type:"POST",
				   
				  success:function(response,status,xhr){
					  //var blob=new Blob(); 
					 // blob=response;
					  var img = document.createElement("img");
					  img.src="/aa.jpg"
					 // img.onload = function(e) {
	                  //      window.URL.revokeObjectURL(img.src); 
	                 // };
	                   // img.src = window.URL.createObjectURL(blob);
	                   $("#imgcontainer").html(img);    
				
				  }
				 });
			   
			   


			    
		  }
		
		</script>
	</body>
</html>
