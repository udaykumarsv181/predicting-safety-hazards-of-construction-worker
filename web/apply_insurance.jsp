<%@page import="DataBase.DBConnection"%>
<%@page import="Logic.info"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Equipment Details</title>
<%
            String utype = "";
            if (session.getAttribute("utype") != null) {
                utype = session.getAttribute("utype").toString();

            }


        %>
        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
     <%
            String msg="";
            if(session.getAttribute("msg")!=null)
            {
            msg=session.getAttribute("msg").toString();
            }
            
            
            %>
        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                             <h1><a href="admin_home.jsp"><span><%=info.pname%></span></a></h1>
                       <h2><font color="red"><%=utype%></font></h2>
                        </div>
                    </div>


                </div>
            </div>
        </div> <!-- End site branding area -->
 <%
          String eid=request.getParameter("eid").toString();
          String name=request.getParameter("name").toString();
          String email=request.getParameter("email").toString();
          String mobile=request.getParameter("mobile").toString();
         
          String dept=request.getParameter("dept").toString();
         
         
             
             
              
         
          
      %>
        <div class="mainmenu-area">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li ><a href="admin_home.jsp">Home</a></li>
                            <li><a href="add_device_details.jsp">Add Device Details</a></li>
                            <li><a href="Device_Detail.jsp">Device Details</a></li>
                              <li><a href="add_employee.jsp">Add Employees</a></li>    
                               <li class="active"><a href="Employees_Detail.jsp">Employees Details</a></li>
                                <li><a href="view_complaint.jsp">View Complaint</a></li>
                                <li><a href="Logout.jsp">Logout</a></li>
                        </ul>
                    </div>  
                </div>
            </div>
        </div> <!-- End mainmenu area -->

        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Apply for Insurance</h2>
                            <%=msg%>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">


                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">


                                <center>  
                                    

                                    <table id="customers">
                    <tr>
                      <td>Apply for Insurance</td>
                    </tr>

                            <form action="upload.jsp" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="eid" value="<%=eid%>"/>
                                <input type="hidden" name="name" value="<%=name%>"/>
                                <input type="hidden" name="email" value="<%=email%>"/>
                                <input type="hidden" name="mobile" value="<%=mobile%>"/>
                          
                                <input type="hidden" name="dept" value="<%=dept%>"/>
                            
                             <tr> <td>Employee ID</td>    <td><%=eid%></td></tr>
                             <tr> <td>Name</td>  <td><%=name%></td></tr>
                             <tr> <td>Email</td> <td><%=email%></td></tr>
                             <tr> <td>Mobile</td>  <td><%=mobile%></td></tr>
                        
                            <tr>  <td>Department</td>  <td><%=dept%></td></tr>
                           <tr>   <td>Proof of Video / Image</td><td><input type="file" name="file" /></td></tr>
                                
                               <tr>  
                                   <td></td>
                                <td>
                                    <input type="submit" name="submit" value="Upload"/>
                                </td></tr>
                            
                            </form>
                      
                       
                        
                     
                       
                       
                    </table>
                                </center>
                                    <br/><br/><br/><br/>
                            </div>                       
                        </div>                    
                    </div>
                </div>
            </div>
        </div>


        <div class="footer-top-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">




                </div>
            </div>
        </div>
        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="copyright">
                          <p>&copy; <%=info.year%>. <%=info.pname%></p>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="footer-card-icon">
                            <i class="fa fa-cc-discover"></i>
                            <i class="fa fa-cc-mastercard"></i>
                            <i class="fa fa-cc-paypal"></i>
                            <i class="fa fa-cc-visa"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Latest jQuery form server -->
        <script src="https://code.jquery.com/jquery.min.js"></script>

        <!-- Bootstrap JS form CDN -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <!-- jQuery sticky menu -->
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.sticky.js"></script>

        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.min.js"></script>

        <!-- Main Script -->
        <script src="js/main.js"></script>
    </body>
</html>