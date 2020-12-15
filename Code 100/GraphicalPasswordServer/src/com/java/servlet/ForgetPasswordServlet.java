package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.SMSApi.SMSApi;
import com.java.bean.UserBean;
import com.java.db.UserDBHelper;
import com.java.util.Constant;


@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForgetPasswordServlet() {
        super();
    }



    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			HttpSession session=request.getSession();
		UserBean bean=new UserBean();
		bean.setEmailId(request.getParameter("email"));
		bean.setMobileno(request.getParameter("mobileno"));
		String autoPassword=Constant.generateRandomPassword();
		System.out.println("autoPassword:"+autoPassword);
		bean.setPassword(autoPassword);
		
		
		UserDBHelper helper=new UserDBHelper();
		bean=helper.forgetPassword(bean);
		
		if(bean!=null && bean.getUserid()>0)
		{
			//here send SMS to user mobile number with new password
			try{
				SMSApi.sendSMSMesage(bean.getMobileno(),"Your Password is reset. Now login to our site by using new password:"+bean.getPassword());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("user mobile no:"+bean.getMobileno());
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("msg","fail");
			response.sendRedirect("ForgetPassword.jsp");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
