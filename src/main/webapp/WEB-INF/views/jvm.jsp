<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript" src="/js/jquery-1.6.1.min.js"></script>
  <script type="text/javascript" src="/js/highcharts.js"></script>
   
   
   <body>
   
    
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">
      
    
    </div>

<script type="text/javascript">
 function getJVM(){
	 var value=101;
	 $.ajax({
        async:false,
		url:"/JvmInfo.action",
		type:"POST",
		success:function(data){
			value=data;
		},
		fail:function(){
			alert("失败");
		}
		 
	 });
	return value;
 }


$(function () {
	
	Highcharts.setOptions({//全局设置
		global: {
			useUTC: false
		}
	});
	
	
    $('#container').highcharts({

    	chart:{  //表的信息
    		events:{   //可以定义多个事件列表
    			load:function(){ //加载时触发的事件
    				var series=this.series[0];
    				setInterval(function(){  //添加定时任务
    					var result=getJVM();
    					//alert(result);
    					var x=(new Date()).getTime();
    					series.addPoint([x,parseFloat(result)],true,true)//添加一个坐标point,并重新绘制
    				},2000);
    						
    			}

    		}
    		
    	},
        
        title: { //显示的标题
            text: 'Java虚拟机内存',
            x: -20 //center
        },
        //提示信息，在每个坐标点上有提示信息
        tooltip:{
        	formatter:function(){
        		var str='<b>'+this.series.name+'</b><br/>';
        		str+=Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',this.x)
        		str+='<br/>'
        		str+=Highcharts.numberFormat(this.y,2);
        		return str;
        		
        	}
        },
        credits:{
        	enabled:true,
        	href:"http://www.58.com",
        	text:"58同城"	
        },
        
        legend:{ //没有图例
        	enabled:false
        },
        exporting:{ //不使用导出功能
        	enabled:false
        },
        //x轴
        xAxis: {
        	type:'datetime',
        	tickPixeInterval:100,
            title: {
            	text:'时间'
            }
        },
        //y轴
        yAxis: {
            title: {//顶标题的样式
                text: '内存大小 (M)'
            },
            labels:{
            	formatter:function(){
            		return this.value+"M";
            	}
            }
        },
        series: [{ //序列，point的集合
            name: 'JVM可用内存',
            data: (function(){ //通过函数来初始化信息
            	var data=[];
            	var time=(new Date()).getTime();//获取当前时间
            	for(var i=-10;i<=0;i++){
            		data.push({
            			x:time+i*1000,
            			y:100  //初始值给死了
            		});
            	}
            	return data;
            	
            })()//创建匿名函数并调用
        }]
    });
    
    
});
    
</script>    
   
</body>
</html>