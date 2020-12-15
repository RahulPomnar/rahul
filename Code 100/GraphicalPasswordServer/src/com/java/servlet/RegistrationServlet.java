package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.UserBean;
import com.java.db.UserDBHelper;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
			UserBean bean=new UserBean();
			bean.setName(request.getParameter("firstname"));
			bean.setDob(request.getParameter("address"));
			bean.setEmailId(request.getParameter("email"));
			bean.setMobileno(request.getParameter("mobileno"));
			bean.setPassword(request.getParameter("password"));
			bean.setPassword_color(request.getParameter("color"));
			
			UserDBHelper helper=new UserDBHelper();
			int userId=helper.checkEmilId(request.getParameter("email"));
			if(userId>0){
				request.setAttribute("msg","registerUsername");
			    ServletContext ctx = this.getServletContext();
		        RequestDispatcher rd = ctx.getRequestDispatcher("/Registration.jsp");
		        rd.forward(request, response);
			}
			else{
			bean=helper.insertUser(bean);
			if(bean!=null && bean.getUserid()>0)
			{
				request.setAttribute("flag","success");
			    ServletContext ctx = this.getServletContext();
		        RequestDispatcher rd = ctx.getRequestDispatcher("/login.jsp");
		        rd.forward(request, response);				
			}
			else 
			{
				response.sendRedirect("error.jsp");
			}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	}
}
