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
<!-- <script type="text/javascript">
function setColor(selectObject) {
    var value = selectObject.value; 
    alert("value:"+value);
    var colorButton=document.getElementById(colorButton);
    selectObject.style.; ="#FF0000";
}
</script> -->
  <body>

   <%@ include file="header.jsp"%>
    <!-- Navigation -->
     <%@ include file="Navigation.jsp"%> 
     <%
     	UserBean bean=(UserBean)session.getAttribute("userbean");
     	
     %>

    <div class="container">
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Change Password
          <strong>Form</strong>
        </h2>
        <hr class="divider">
		<form name="form" action="ChangePasswordServlet" method="post" onsubmit="return validate(form);">
          <div class="row">
            <div class="form-group col-lg-4">
            <input type="hidden" name="userId" id="userId" value="<%=bean.getUserid()%>">
              <label class="text-heading">New Password</label>
              <input type="password" name="password" id="password" class="form-control" 
               title="Password Contains atleast one digit(1-8),lower case letter a-f and any sepcial character(@,#).">
              <p> Password Contains at least one digit(1-8),lower case letter a-f and any special character(@,#) </p>
            </div>
            <div class="form-group col-lg-4" align="left">
              <label class="text-heading">Password Color</label>
              <select name="color" id="color" style="width: 1500xp;" class="form-control" onchange="setColor(this);">
              <option value="0"> Select Color</option>
              <option value="#ff0000" style="background-color: #ff0000">Red</option>
              <option value="#ffff00" style="background-color: #ffff00">Yellow</option>
              <option value="#00ff00" style="background-color: #00ff00">Green</option>
              <option value="#0000ff" style="background-color: #0000ff">Blue</option>
              <option value="#bf00ff" style="background-color: #bf00ff;">Violet</option>
              <option value="#ff00bf" style="background-color: #ff00bf">Pink</option>
              <option value="#8c7373" style="background-color: #8c7373"> Gray</option>
              <option value="#000000" style="background-color: #000000"> Black</option>
              </select>
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Change</button>
            </div>
          </div>
        </form>
		<%if(request.getAttribute("msg")=="registerUsername"){	%>
     <script type="text/javascript">
        alert("Username already Exists.");
        </script>
	<%}%>
      </div>
    </div>
    <!-- /.container -->
      <%@ include file="footer.jsp"%>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 	<script src="js/ChangePasswordValidation.js"></script>
    <!-- Zoom when clicked function for Google Map -->
  </body>
</html>
