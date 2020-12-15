<!DOCTYPE html>
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
    <div class="container">
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Login
          <strong>Form</strong>
        </h2>
        <hr class="divider">
        <form name="form" action="LoginServlet" method="post" onsubmit="return validate(form);">
          <div class="row">
            <div class="form-group col-lg-4">
              <label class="text-heading">Email Id</label>
              <input type="email" name="email" id="email" class="form-control">
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Submit</button>
              <a href="ForgetPassword.jsp">Forget Password</a>
            </div>
          </div>
        </form>
        <% if(request.getAttribute("flag")=="success")
                		   {
                           %>
                         <script type="text/javascript">
                            alert("Registration Successfully.");
                            </script>
	<%}if(request.getAttribute("msg")=="emailmsg"){%>
	<script type="text/javascript">
                            alert("Invalid Email Id");
                            </script>
                            <%} %>
      </div>
    </div>
    <!-- /.container -->

      <%@ include file="footer.jsp"%>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	  <script src="js/LoginValidation.js"></script> 
    <!-- Zoom when clicked function for Google Map -->
  </body>
</html>
