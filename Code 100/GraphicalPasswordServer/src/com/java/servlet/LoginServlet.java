package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.UserBean;
import com.java.db.UserDBHelper;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			try{
				HttpSession session=request.getSession(true);
				UserBean bean=new UserBean();
				String email=request.getParameter("email");
				
				UserDBHelper helper=new UserDBHelper();
				bean=helper.fetchUserByEmailId(email);
				if(bean!=null && bean.getUserid()>0)
				{
					//session.setAttribute("role","USER");
					session.setAttribute("userbean",bean);
					//request.setAttribute("name",bean.getName());
					//request.setAttribute("pwdcolor",bean.getPassword_color());
				    ServletContext ctx = this.getServletContext();
			        RequestDispatcher rd = ctx.getRequestDispatcher("/GraphicalPassword.jsp");
			        rd.forward(request, response);
				}else
				{
					request.setAttribute("msg","emailmsg");
				    ServletContext ctx = this.getServletContext();
			        RequestDispatcher rd = ctx.getRequestDispatcher("/login.jsp");
			        rd.forward(request, response);
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	
	
	
	
	
	}

}
