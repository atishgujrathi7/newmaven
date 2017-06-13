<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>LMS</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:700,300,400">        
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/elegant-font/code/style.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
    
        <!-- Loader -->
    	<div class="loader">
    		<div class="loader-img"></div>
    	</div>
		
		<!-- Top menu -->
		<nav class="navbar navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">ALMS</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						
						<li><a class="scroll-link" href="#about">Farmer Request List</a></li>
						<li><a class="scroll-link" href="#about">Labors Available</a></li>
						<li><a class="scroll-link" href="#contact">Contact</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
        <!-- Page title -->
        <div class="page-title top-content">
            <div class="page-title-text wow fadeInUp">
            <br/><br/>
            <br/><br/>
            <br/>
            	<h1>Agro-Labor Management System</h1>
            	
            	
            </div>
        </div>

		
        <!-- About us -->
        <div class="about-container section-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 about section-description wow fadeIn">
	                    <h2>Farmer Request List</h2>
	                    <div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    
	                    <% 
	                    
	                    String url=System.getenv("url");
	        			String port=System.getenv("port");
	        			String schema=System.getenv("schema");
	        			String username=System.getenv("username");
	        			String password=System.getenv("password");
	        			Connection connection = DriverManager.getConnection("jdbc:mysql://"+url+":"+port+"/"+schema,username,password);

            Statement statement = connection.createStatement();

            //String id = request.getParameter("id");  

            ResultSet resultset = 
                statement.executeQuery("select * from sampledb.request") ;
		        %>
	  <form action="deal.html" autocomplete="on">
	     <TABLE BORDER="2">
            <TR>
               <TH>ID</TH>
               <TH>Farmer</TH>
               <TH>Request for Labor</TH>
               <TH>Approve</TH>
            </TR>
    
    <%	while(resultset.next()){ %>
           <TR>
               <TD> <%= resultset.getString(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <input type="submit" id=<%= resultset.getString(1) %> name=<%= resultset.getString(1) %> value="<%= resultset.getString(1) %>"/> </TD>
          </TR>
       
       <% 
           } 
       %>	                
			</TABLE>
       <BR>		                
	               
	        </form>
	                    
	               </div>
	            </div>
	        </div>
        </div>
        
        
        
        <!-- About us -->
        <div class="about-container section-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 about section-description wow fadeIn">
	                    <h2>Labors Available</h2>
	                    <div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	     
	     	<% 
            /* Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/lms", "root", "root");

            Statement statement = connection.createStatement();

            //String id = request.getParameter("id");  

 */             ResultSet resultset1 = 
                statement.executeQuery("select * from lms.labor") ; 
		
            
        %>

	
        <TABLE BORDER="2">
            <TR>
               <TH>ID</TH>
               <TH>Name</TH>
               <TH>Gender</TH>
               <TH>Dob</TH>
               <TH>Location</TH>
               <TH>Wages</TH>
           </TR>
    

    <%	while(resultset1.next()){ %>
           <TR>
               <TD> <%= resultset1.getString(1) %> </TD>
               <TD> <%= resultset1.getString(2) %> </TD>
               <TD> <%= resultset1.getString(4) %> </TD>
               <TD> <%= resultset1.getString(5) %> </TD>
               <TD> <%= resultset1.getString(6) %> </TD>
               <TD> <%= resultset1.getString(7) %> </TD>
              
           </TR>
       
       <% 
           } 
       %>	                
			</TABLE>
       <BR>		                
							                    
							                    
	     
	                    	
	                    </p>
	                </div>
	            </div>
	        </div>
        </div>
        
        
       
        
		<!-- Contact us (block 2) -->
        <div class="block-2-container section-container contact-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 block-2 section-description wow fadeIn">
	                	<h2>Contact us</h2>
	                	<div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    	For every question or information, here is how you can get in touch with us. Send us an email or come visit us!
	                    </p>
	                </div>
	            </div>
	            <div class="row">
	            	
	            	<div class="col-sm-4 block-2-box block-2-right contact-address wow fadeInUp">
	            		<h3>Visit us</h3>
	                    <p><span aria-hidden="true" class="icon_pin"></span>Hinjewadi phase II, Pune</p>
	                    <p><span aria-hidden="true" class="icon_phone"></span>Phone:<br/> 7350143484 </p>
	                    <p><span aria-hidden="true" class="icon_mail"></span>Email:<br/>group9@alms.net</p>
	            	</div>
	            </div>
	            <div class="contact-icon-container">
            		<span aria-hidden="true" class="icon_mail"></span>
            	</div>
	        </div>
        </div>


        <!-- Footer -->
        <footer>
	        <div class="container">
	        	<div class="row">
		        	<div class="col-sm-12">
		        		<div class="scroll-to-top">
		        			<a href="#"><i class="fa fa-chevron-up"></i></a>
		        		</div>
		        	</div>
		        </div>
	            <div class="row">
                    <div class="col-sm-7 footer-copyright">
                    	&copy; Agro-Labor Management System By Group 9.
                    </div>
                    
	            </div>
	        </div>
        </footer>
        

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/jquery.magnific-popup.min.js"></script>
        <script src="assets/js/waypoints.min.js"></script>
        <script src="assets/js/jquery.countTo.js"></script>
        <script src="assets/js/masonry.pkgd.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>
