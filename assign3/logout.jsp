<html>
<head>

<title>Logout Successful</title>  

</head>
<body>


<h2> Logout Successful </h2>
<%
session.invalidate();
%>
<a href="index.jsp"><input type="button" name="indexButton" value="Home"</a>

</body>
</html>
 