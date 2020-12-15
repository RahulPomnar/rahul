	<nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <%
		try {

			String user = (String) session.getAttribute("role");
			if (user != null && user.equals("USER")) {
			%>
			<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="#">Menu 1</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="changePassword.jsp">Change Password</a>
            </li>
			<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="logout.jsp">Logout</a>
            </li>
            <%
		}else {	%>
		<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="Registration.jsp">Registration</a>
            </li>
			<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="login.jsp">Login</a>
            </li>
			<%
			}
			} catch (Exception e) {
						System.out.println(e);
			}
			%>
          </ul>
        </div>
      </div>
    </nav>