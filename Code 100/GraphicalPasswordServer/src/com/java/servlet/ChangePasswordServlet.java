package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.UserBean;
import com.java.db.UserDBHelper;


@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			UserBean bean=new UserBean();
			bean.setUserid(Integer.parseInt(request.getParameter("userId")));
			bean.setPassword(request.getParameter("password"));
			bean.setPassword_color(request.getParameter("color"));
			
			UserDBHelper helper=new UserDBHelper();
			int result=helper.updateUserPassword(bean);
			if(result>0)
				response.sendRedirect("login.jsp");
			else
				response.sendRedirect("welcome.jsp");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	
	
	}

}
