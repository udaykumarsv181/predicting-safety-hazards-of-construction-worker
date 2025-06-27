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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
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
#customers tr:nth-child(even) {background-color: #f2f2f2;}
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
    String msg = (session.getAttribute("msg") != null) ? session.getAttribute("msg").toString() : "";
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
</div>

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
                    <li><a href="admin_home.jsp">Home</a></li>
                    <li><a href="add_device_details.jsp">Add Device Details</a></li>
                    <li class="active"><a href="Device_Detail.jsp">Device Details</a></li>
                    <li><a href="Equipment_Status.jsp">Equipment Status</a></li>
                    <li><a href="Logout.jsp">Logout</a></li>
                </ul>
            </div>  
        </div>
    </div>
</div>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Employee Details</h2>
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

                        <%
                            String eid = request.getParameter("eid");
                            String ename = request.getParameter("ename");

                            if (eid == null || ename == null || eid.isEmpty() || ename.isEmpty()) {
                        %>
                            <h2 style="color: red;">Error: Employee ID or Name is missing.</h2>
                        <%
                            } else {
                        %>
                        <center>  
                            <table cellspacing="1" cellpadding="1" border="1" id="customers">
                                <tr>
                                    <th>ID</th>
                                    <th>Supervisor</th>
                                    <th>Employee ID</th>
                                    <th>Employee Name</th>
                                    <th>Mobile</th>
                                    <th>Department</th>
                                    <th>Message</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Status</th>                                       
                                </tr>

                        <%
                            try {
                                Connection con = DBConnection.getConnection();
                                if (con != null) {
                                    Statement statement = con.createStatement();
                                    ResultSet rs = statement.executeQuery("SELECT * FROM issues_details WHERE eid='" + eid + "'");

                                    while (rs.next()) {
                                        String id = rs.getString("id");
                                        String supervisor = rs.getString("supervisor");
                                        String mobile = rs.getString("mob");
                                        String dept = rs.getString("dept");
                                        String msgs = rs.getString("msg");
                                        String idate = rs.getString("idate");
                                        String itime = rs.getString("itime");
                                        String status = rs.getString("status");
                        %>
                                        <tr>
                                            <td><%=id%></td>
                                            <td><%=supervisor%></td>
                                            <td><%=eid%></td>
                                            <td><%=ename%></td>
                                            <td><%=mobile%></td>
                                            <td><%=dept%></td>
                                            <td><%=msgs%></td>
                                            <td><%=idate%></td>
                                            <td><%=itime%></td>
                                            <td><%=status%></td>
                                        </tr>
                        <%
                                    }
                                } else {
                                    out.println("<h2 style='color:red;'>Database connection failed.</h2>");
                                }
                            } catch (Exception e) {
                                out.println("<h2 style='color:red;'>Error fetching data: " + e.getMessage() + "</h2>");
                            }
                        %>
                            </table>
                        </center>
                        <%
                            }
                        %>

                    </div>                       
                </div>                    
            </div>
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

<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>
