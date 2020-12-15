package com.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.InnerOuterBean;
import com.java.bean.UserBean;
import com.java.util.Constant;


@WebServlet("/GraphicalPasswordServlet")
public class GraphicalPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GraphicalPasswordServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			HttpSession session=request.getSession();
			UserBean bean=(UserBean)session.getAttribute("userbean");
		
			String password="";
			System.out.println("In servlet puser password color:"+bean.getPassword_color());
		
			String str=request.getParameter("pwdcolor");
			System.out.println("str:"+str);
		
		
			HashMap<String, ArrayList<InnerOuterBean>> map=Constant.populateMap();
		
			System.out.println("map size:"+map.size());
		
			String [] pwdArry=str.split(";");
			
			ArrayList<InnerOuterBean> characterArr=map.get(bean.getPassword_color());
			
			System.out.println("charachter Array size:"+characterArr.size());
			for(InnerOuterBean charBean:characterArr)
				System.out.println("inner char:"+charBean.getInnerChar()+" outer char:"+charBean.getOuterChar());
				
			
			
			System.out.println("after split by ; array size:"+pwdArry.length);
			for(String indexStr:pwdArry)
			{
				String[] indexOrbit=indexStr.split(",");
				System.out.println("index:"+indexOrbit[0]+" orbit:"+indexOrbit[1]);
				if(indexOrbit[1].equals("i")){
					password=password+characterArr.get(Integer.parseInt(indexOrbit[0])).getInnerChar();
					System.out.println("in if password:"+password);
				}
				else if(indexOrbit[1].equals("o"))
				{
					password=password+characterArr.get(Integer.parseInt(indexOrbit[0])).getOuterChar();
				}
			}
			
			System.out.println("Password is:"+password);
			
			if(password.equals(bean.getPassword()))
			{
				session.setAttribute("userbean",bean);
				session.setAttribute("role","USER");
				response.sendRedirect("welcome.jsp");
			}else
			{
				session.setAttribute("userbean",bean);
				response.sendRedirect("GraphicalPassword.jsp");
			
			}
		
		
		
		
		
		
		
		
	
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
