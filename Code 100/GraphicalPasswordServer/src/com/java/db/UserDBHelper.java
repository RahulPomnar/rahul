package com.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.java.bean.UserBean;


public class UserDBHelper {
	
	
	public UserBean insertUser(UserBean bean) {
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		System.out.println("In insertUser method");
		String query = "insert into user_table(name, dob, email_id, mobile,password,password_color) values('"
				+ bean.getName()
				+ "','"
				+ bean.getDob()
				+ "','"
				+ bean.getEmailId()
				+ "','"
				+ bean.getMobileno()
				+ "','"
				+ bean.getPassword()
				+ "','"
				+ bean.getPassword_color()
				+ "')";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// find the max number from db....say id
			String squery = "SELECT *FROM graphical_password_db.user_table u where user_id=(SELECT MAX(user_id) FROM graphical_password_db.user_table u);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.beforeFirst();
			while (resultSet.next()) {
				bean.setUserid(resultSet.getInt("user_id"));
				bean.setName(resultSet.getString("name"));
				bean.setDob(resultSet.getString("dob"));
				bean.setEmailId(resultSet.getString("email_id"));
				bean.setMobileno(resultSet.getString("mobile"));
				bean.setPassword(resultSet.getString("password"));
				bean.setPassword_color(resultSet.getString("password_color"));
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int checkEmilId(String  username) 
	{
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		int id = 0;
		try {
			PreparedStatement stmt=connection.prepareStatement("select user_id from user_table where email_id=?");
			stmt.setString(1,username);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{   
				id =rs.getInt("user_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public UserBean fetchUserByEmailId(String email) 
	{
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		UserBean bean=new UserBean();
		try {
			PreparedStatement stmt=connection.prepareStatement("select * from user_table where email_id=?");
			stmt.setString(1,email);
			ResultSet resultSet=stmt.executeQuery();
			if(resultSet.next())
			{   
				resultSet.beforeFirst();
				while (resultSet.next()) {
					bean.setUserid(resultSet.getInt("user_id"));
					bean.setName(resultSet.getString("name"));
					bean.setDob(resultSet.getString("dob"));
					bean.setEmailId(resultSet.getString("email_id"));
					bean.setMobileno(resultSet.getString("mobile"));
					bean.setPassword(resultSet.getString("password"));
					bean.setPassword_color(resultSet.getString("password_color"));
					return bean;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet fetchAllUsers() {
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		String query = "select * from user_table";
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public ArrayList<UserBean> fetchAllStudentInfo() {
		ResultSet resultSet = fetchAllUsers();
		ArrayList<UserBean> userBeanList = new ArrayList<UserBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					userBeanList.add(fetchUserFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return userBeanList;
	}

	private UserBean fetchUserFromResultSet(ResultSet resultSet) {
		UserBean bean = new UserBean();
		try {
			bean.setUserid(resultSet.getInt("user_id"));
			bean.setName(resultSet.getString("name"));
			bean.setDob(resultSet.getString("dob"));
			bean.setEmailId(resultSet.getString("email_id"));
			bean.setMobileno(resultSet.getString("mobile"));
			bean.setPassword(resultSet.getString("password"));
			bean.setPassword_color(resultSet.getString("password_color"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
	
	
	public int deleteStudent(String StudentId) {
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		String query = "DELETE from user_table where user_id='"
				+ StudentId + "'";
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserPassword(UserBean bean) {
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		String query = "update user_table set password= '"
				+ bean.getPassword()   +"', password_color='"+bean.getPassword_color()+"' where user_id= '"+bean.getUserid()+"'";
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public UserBean forgetPassword(UserBean bean) {
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		System.out.println("email id:"+bean.getEmailId()+" mobile:"+bean.getMobileno()+" new password:"+bean.getPassword());
		String query = "update user_table set password= '"
				+ bean.getPassword()   +"' where email_id= '"+bean.getEmailId()+"' AND mobile='"+bean.getMobileno()+"'";
		try {
			Statement statement = connection.createStatement();
			int result=statement.executeUpdate(query);
			System.out.println("update result:"+result);
			if(result>0)
			{
				bean=fetchUserByEmailId(bean.getEmailId());
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UserBean fetchUserById(String Id) {
		System.out.println("fetch student by id:"+Id);
		DBConnection dBConnection = new DBConnection();
		Connection connection = dBConnection.connect();
		String query = "select * from user_table where user_id='"+Id+"';";
		ResultSet resultSet = null;
		UserBean bean=new UserBean();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet!=null)
			{
				resultSet.beforeFirst();
				while(resultSet.next())
				{
					bean.setUserid(resultSet.getInt("user_id"));
					bean.setName(resultSet.getString("name"));
					bean.setDob(resultSet.getString("dob"));
					bean.setEmailId(resultSet.getString("email_id"));
					bean.setMobileno(resultSet.getString("mobile"));
					bean.setPassword(resultSet.getString("password"));
					bean.setPassword_color(resultSet.getString("password_color"));	}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
}
