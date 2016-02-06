<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Game-Speed</title>
	<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>
<div id="container">
    
<header>
    	<h1><a href="index.jsp">Game<span>Speed</span></a></h1>
        <h2>world's largest online Game store</h2>
    </header>
	
<h2 align="center">Login</h2> 

<form name="login" action="loginServlet.jsp" method="post">
<input type="hidden" name="pagename" value="login"/>
<table  cellspacing="5" border="1" width="30%" cellpadding="5" align="center" >


<tr>
	<td>User Id</td>
	<td><input type="text" name="userid" required autofocus placeholder="Your User Id" title="Please enter in more than three letters"/></td>
</tr>

<tr>
	<td>Password</td>
	<td><input type="password" name="password" required autofocus placeholder="Your Password" title="Please enter in more than five letters"/></td>
</tr>

<tr>
	<td></td>
	<td><button type="submit">Submit</button></td>
</tr>

</table>
</form>

<footer>
	
        <div class="footer-content">
            <ul>
            	<li><h4>Dummy Link Section 1</h4></li>
                <li><a href="#">Dummy Link 1</a></li>
                <li><a href="#">Dummy Link 2</a></li>
                <li><a href="#">Dummy Link  3</a></li>
			</ul>
           
        <div class="clear"></div>
        </div>
		
        <div class="footer-bottom">
            <p>CSP 595 - Enterprise Web Application - Tutorial 2</p>
        </div>
		
    </footer>
</div>

</body>

</html>