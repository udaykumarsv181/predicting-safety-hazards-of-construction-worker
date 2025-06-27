<%@page import="Logic.info"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Device Details</title>

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
        <%
            String utype = "";
            if (session.getAttribute("utype") != null) {
                utype = session.getAttribute("utype").toString();

            }


        %>
        <%
            String msg = "", user = "";
            if (session.getAttribute("msg") != null) {
                msg = session.getAttribute("msg").toString();
            } else {
                msg = "";
            }

            if (request.getAttribute("user") != null) {
                user = request.getAttribute("user").toString();
            } else {
                user = "";
            }
        %>
        <script language="javascript">
            function validate(){
                var fname=document.getElementById("fname").value;
                var mname=document.getElementById("mname").value;
                var lname=document.getElementById("lname").value;
                var usn=document.getElementById("usn").value;
                var email=document.getElementById("email").value;
                var pass=document.getElementById("pass").value;
                var cpass=document.getElementById("cpass").value;
       
        
                if(fname.length==0)
                {
                    alert("Enter First name");
                    return false;
                }
            
                if(lname.length==0)
                {
                    alert("Enter Last name");
                    return false;
                }
                if(usn.length==0)
                {
                    alert("Enter USN");
                    return false;
                }
                if(email.length==0)
                {
                    alert("Enter Last Email ID");
                    return false;
                }
                if(pass.length==0)
                {
                    alert("Enter password");
                    return false;
                } if(pass.length<6)
                {
                    alert("password must be greater than or equal to 6 ");
                    return false;
                }
             
                if(cpass.length==0)
                {
                    alert("Confirm password");
                    return false;
                }   
        
                if(pass!=cpass)
                {
                     
                    alert("Passwords are not matching!!");
                    document.getElementById("cpass").value="";
                    document.getElementById("cpass").focus;
                    return false;     
                }
    
            }
        </script>

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
                            <li class="active"><a href="add_device_details.jsp">Add Device Details</a></li>
                            <li><a href="Device_Detail.jsp">Device Details</a></li>
                              <li><a href="add_employee.jsp">Add Employees</a></li>    
                               <li><a href="Employees_Detail.jsp">Employees Details</a></li>
                                <li><a href="view_complaint.jsp">View Complaint</a></li>
                                   <li><a href="admin_view_request.jsp">View Insurance Status</a></li>
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
                            <h2>Add Device Details</h2>
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

                                <center><h4><%=msg%></h4><% session.removeAttribute("msg");%></center>
                                <table align="center" width="1015">
                                    <tr>
                                        <td width="364" valign="top">

                                        </td>
                                        <td width="639" valign="top">
                                            <table align="center" width="600">


                                                <tr>
                                                    <td class="paragraping1" align="justify">
                                                        <%
                                                            int i = 0;
                                                        %>

                                                        <form action="./upload_device_details"  method="post" enctype="multipart/form-data">
                                                            <table >

                                                                
                                                               
                                                                <tr>
                                                                    <td>
                                                                        Equipment Name:
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="ename" id="ename" style="width: 200px" required/>
                                                                    </td>
                                                                </tr>
                                                                 <tr>
                                                                    <td>
                                                                        Equipment Description:
                                                                    </td>
                                                                    <td>
                                                                        <textarea name="description" id="description" required style="width: 200px"></textarea> 
                                                                       
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        RFID Tag:
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="tag" id="tag" style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        Manufacturer:
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="manufacturer" id="manufacturer" style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        Vendor:
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="vendor" id="vendor" required style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Date of Manufacturing:</td>
                                                                    <td>
                                                                <input type="date" name="date_of_manufacturing" id="date_of_manufacturing" style="width: 200px"/>
                                                                    </td>  
                                                                </tr> 
                                                                <tr>
                                                                    <td>
                                                                        Date of Introduction:
                                                                    </td>
                                                                    <td>
                                                                        <input type="date" name="date_of_introduction" id="date_of_introduction" style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        Date of Expiry:
                                                                    </td>
                                                                    <td>
                                                                        <input type="date" name="date_of_expiry" id="date_of_expiry" style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                               

                                                               <tr>
                                                                    <td>
                                                                        File:
                                                                    </td>
                                                                    <td>
                                                                        <input type="file" name="file" id="file" style="width: 200px"/>
                                                                    </td>
                                                                </tr>
                                                              
                                                                

                                                                
                                                              
                                                               
                                                               
                                                              


                                                                <td>
                                                                    <input type="submit" name="submit" value="Add Equipment"/>
                                                                </td>
                                                                </tr>
                                                            </table>            
                                                        </form>




                                                    </td>
                                                </tr>

                                            </table>

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