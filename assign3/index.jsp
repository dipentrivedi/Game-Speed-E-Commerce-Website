
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Game-Speed</title>
	<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>
<div id="container">
    
<header>
		<div class="top" align="right">
		<button type="button" ><a href="login.jsp">Login</a></button>
		<button type="button" ><a href="signup.jsp">Sign Up</a></button>
		</div>
    	<br>
		<h1><a href="index.jsp">Game<span>Speed</span></a></h1>
        <h2>world's largest online Game store</h2>
</header>
    <nav>
    	<ul>
        	<li class="start selected"><a href="index.jsp">Home</a></li>
            <li class=""><a href="XBox.jsp">XBox</a></li>
            <li class=""><a href="PlayStation.jsp">Play Station</a></li>
			<li class=""><a href="Nintendo.jsp">Nintendo</a></li>
			<li class="end"><a href="Accessories.jsp">Accessories</a></li>
			
		</ul>
    </nav>
<marquee behavior="scroll" direction="left" style="">
<img class="header-image" src="images/img_index1.jpg" width = "100%" height = "100%" alt="Index Page Image" />
<img class="header-image" src="images/img_index2.jpg" width = "100%" height = "100%" alt="Index Page Image" />
<img class="header-image" src="images/img_Nintendo.jpg" width = "100%" height = "100%" alt="Index Page Image" />
</marquee>
    <div id="body">		

	<section id="content">

	    <article>
			
			<h2>Welcome to Game<span>Speed</span></h2>
			
            <p>This is a sample tempate using CSS3 &amp; HTML5 to demonstrate the structure of an enterprise web page.</p>	
            
            <p>This is the section to give an introduction to your web page.</p>
			
		</article>
	
		<article class="expanded">

            <h2>Secondary Section</h2>
						
            <p>This is the secondary where in you can put more information. This is not really mandatory</p>

			<h3>Learn More on HTML and CSS</h3>

			<p>Click on the links on your left under the section 'Helpful links' to learn more on HTML and CSS</p>
			<p>You can also click on the buttons below for references on HTML and CSS</p>
			
			<br><br>

			<a href="http://www.w3schools.com/html/default.asp" class="button">HTML</a>
			<a href="http://www.w3schools.com/css/default.asp" class="button">CSS</a>
			<br><br>
			<br>
			
		</article>
    </section>
        
    <aside class="sidebar">
	
            <ul>	
               <li>
                    <h4>Products</h4>
                    <ul>
                        <li><a href="XBox.jsp">XBox</a></li>
                        <li><a href="PlayStation.jsp">Play Station</a></li>
						<li class=""><a href="Nintendo.jsp">Nintendo</a></li>
						<li><a href="#">Accessories</a></li>
                    
                    </ul>
                </li>
                
                <li>
                    <h4>About us</h4>
                    <ul>
                        <li class="text">
                        	<p style="margin: 0;">This is a sample website created to demonstrate a standard enterprise web page.</p>
                        </li>
                    </ul>
                </li>
                
                <li>
                	<h4>Search site</h4>
                    <ul>
                    	<li class="text">
                            <form method="get" class="searchform" action="#" >
                                <p>
                                    <input type="text" size="25" value="" name="s" class="s" />
                                    
                                </p>
                            </form>	
						</li>
					</ul>
                </li>
                
                <li>
                    <h4>Helpful Links</h4>
                    <ul>
                        <li><a href="http://www.w3schools.com/html/default.asp" title="premium templates">Learn HTML here</a></li>
                        <li><a href="http://www.w3schools.com/css/default.asp" title="web hosting">Learn CSS here</a></li>
                        
                    </ul>
                </li>
                
            </ul>
		
    </aside>
    
	<div class="clear"></div>
	</div>
    
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