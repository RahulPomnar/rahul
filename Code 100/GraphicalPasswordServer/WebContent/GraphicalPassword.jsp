<!DOCTYPE html>
<%@page import="com.java.bean.UserBean"%>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Graphical Password</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">
  </head>
  <body>
   <%@ include file="header.jsp"%>
    <!-- Navigation -->
     <%@ include file="Navigation.jsp"%> 
     <%try{
    	 UserBean bean=(UserBean)session.getAttribute("userbean");
    	 System.out.println("email:"+bean.getEmailId());
    	 System.out.println("Password color:"+bean.getPassword_color());
    	 session.setAttribute("userbean",bean);
    	 %>
    <div class="container">
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Graphical Password Check 
          <strong>Form</strong>
        </h2>
        <hr class="divider">
        <form name="form" action="GraphicalPasswordServlet" method="post">
          <div align="center">
          <input type="hidden" id="pwdcolor" name="pwdcolor">
            <div class="form-group col-lg-4" >
              <label class="text-heading">Email Id</label>
              <input type="email" name="email" id="email" class="form-control" value="<%=bean.getEmailId()%>" readonly="readonly">
            </div>
            <div class="form-group col-lg-4">
            <canvas id="myCanvas" width="500" height="500"></canvas>
            </div>
             <div class="form-group col-lg-12">
             	<table style="padding: 10xp 20xp;padding-right: 30xp" border="0">
             	<tr style="padding: 10xp 20xp">
             	<td style="padding: 300dp 500dp">
              <img alt="" id="clockwise" src="img/clock.png" height="90xp" width="90xp" onclick="rotateClockwise();">
              </td>
              <td></td><td></td><td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
              <img alt="" id="anticlockwise" src="img/anticlock.png" height="90xp" width="90xp" onclick="rotateAntiClockwise();">
            	<td>
            </tr>
		  	<tr> 
		  	 <td></td><td></td><td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td><td></td><td></td></tr>
              <tr>
              <td>
               <div class="form-group col-lg-12">
              <button type="button" id="innerButton" name="innerButton" class="btn btn-secondary" onclick="getInnerCharacter();">Inner</button>
               </div>
              </td>
              <td></td><td></td><td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td> <td>
               <div class="form-group col-lg-12">
              <button type="button"  id="outerButton" name="outerButton" class="btn btn-secondary" onclick="getOuterCharacter();">Outer</button>
            </div>
              </td>
              </tr>
            </table>
             <div class="form-group col-lg-4" >
              <label class="text-heading">Password</label>
              <input type="text" name="password" id="password" class="form-control" readonly="readonly">
            </div>
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" id="submit" name="submit" class="btn btn-secondary" onclick="submit();">Submit</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <%}catch(Exception e){e.printStackTrace();} %>
    <!-- /.container -->

      <%@ include file="footer.jsp"%>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	 <script src="js/circle.js"></script>
    <!-- Zoom when clicked function for Google Map -->
  </body>
</html>
