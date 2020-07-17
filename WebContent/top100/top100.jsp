<%@ page contentType="text/html; charset=UTF-8"%>
<%
		request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<Object width="400" height="400" data="entries/HdZdxocqzq4.description">
	
</Object>

<Object width="400" height="400" data="entries/HdZdxocqzq4.info.json" id="entry" onload="getData()" >
	
</Object>
<script>
function getData() {
    var textFile = document.getElementById('entry').contentDocument;
  
    var textObject = textFile.getElementsByTagName('pre')[0];
   
    var text = textObject.innerHTML;

    alert(text); 
}

</script>
</body>
</html>
