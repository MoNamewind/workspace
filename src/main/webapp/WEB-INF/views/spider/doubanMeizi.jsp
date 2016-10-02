<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>java 探秘搜索引擎核心技术</title>
		<link href="/css/spder.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="/js/spider/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/spider/jquery.lazyload.min.js"></script>
		<script type="text/javascript" src="/js/spider/blocksit.min.js"></script>	
	<script type="text/javascript">
	  var pageNum=1;//页数
	  $(function(){
		  //loadImages();
		  $("img.lazy").lazyload({
			  load :function(){
				 $("#contanier").BlocksIt({
					 numofCol:3,
					 offsetX:8,
					 offsetY:8
				 }); 
				  
			  }
		  });
		  
	  });
	  //后台请求数据
	  function loadImages() {
		//alert("nihao");
		var category=$("#category").val() //获取选择的类型
		$.ajax({
			url:"/getImage.action",
			async:false,
			data:{pageNum:pageNum,category:category},
			dataType:"json",
			success:function(result){
				for(var i=0;i<result.length;i++){
                    var img="";
					img +='<div class="grid"><div class="imgholder">'
					img+='<img class="lazy" src="/images/pixel.gif" data-original="'
					img+=result[i].url;
					img+='" width="175"/></div><strong>';
					img+=result[i].title;
					img+='</strong><div class="meta"><a href="'
					img+= result[i].ourl;
					img+='" target="_blank">高清无码原图</a></div></div>';
					$("#contanier").append(img);
				}
				pageNum++;
				$("#contanier").BlocksIt({
					numofCol:4,
					offsetX:8,
					offsetY:8
				});
				$("img.lazy").lazyload();
			}
			//fail：function(r){
				//alert("请求失败了");
			//}	
		});
	}
	  
	
	
	
	</script>
	</head>
	
	<body>
		<div class="search">
		   <h1>java 探秘搜索引擎核心技术</h1>
		   <div class="s_box">
		     <select name="category" id="category" class="s_txt">  
		       <option value="all">所有</option>
		       <option value="xiong">大胸妹</option>
		       <option value="tun">美臀</option>
		       <option value="silk">黑丝袜</option>
		       <option value="leg" selected="selected">美腿</option>
		       <option value="beatiful">高颜值</option>
		       <option value="other">大杂烩</option>
		     </select>
		     <input type="button" id="changeTypeBtn" value="确定" class="s_btn">
		   </div>
		</div>
		
		<div id="wrapper">
		   <div id="contanier">
		   
		   </div>
		
		</div>
		
		
		<script type="text/javascript">
		$("#changeTypeBtn").click(function(){
			
			loadImages();
		});
		$(window).scroll(function(){
		   if($(document).height()-$(this).scrollTop()-$(this).height()<50)
		    loadImages();
		})
		$("#category").change(function(){
		  $("#contanier").html('');
		})
		
		</script>
		
		
	</body>
</html>
