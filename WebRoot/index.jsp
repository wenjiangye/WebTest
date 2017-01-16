<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
	<title> This is my JSP page!  </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
   var socket =null;
  
   $(function(){
	function parseObj(strData){//转换对象
	    return (new Function( "return " + strData ))();
	};
	//创建socket对象
	//alert("ws://"+ window.location.host+"${pageContext.request.contextPath}/game");
	socket = new WebSocket("ws://"+ window.location.host+"${pageContext.request.contextPath}/websock/websocket");
	
	
	//连接创建后调用
	socket.onopen = function() {
		$("#showMsg").append("连接成功...<br/>");
	};
	//接收到服务器消息后调用
	socket.onmessage = function(message) {
		$("#showMsg").append("<span style='display:block'>"+ message.data+"</span>");
	
	};
	//关闭连接的时候调用
	socket.onclose = function(){
		alert("close");
	};
	//出错时调用
	socket.onerror = function() {
		alert("error");
	};
	$("#sendButton").click(function() {
		socket.send($("#msg").val());
	});
	window.onbeforeunload = function(event) { 
      socket.close();
    }
});
    </script>
  </head>
  
  <body>
    <div id="showMsg" style="border: 1px solid; width: 500px; height: 400px; overflow: auto;"></div>
	<div>
		<input type="text" id="msg" /> 
		<input type="button" id="sendButton" value="发送" />
	</div>
  </body>
</html>
