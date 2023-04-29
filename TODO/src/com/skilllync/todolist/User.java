package com.skilllync.todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class User {
	private static String user_name;
	 private static String password;
	
	static Connection con = Main.con;
	static PreparedStatement pstmt;
	static ResultSet res;
	static Scanner sc =new Scanner(System.in);
	public User(String user_name,
	String password) {
		super();
		this.user_name=user_name;
		this.password=password;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	static boolean userLogin() {
		try {
    		System.out.println(con);
    		System.out.println("Enter the user name : ");
    		user_name =sc.next();
    		System.out.println("Enter the password");
    		password=sc.next();
    		String sql="select * from user where user_name=? and password=?";
    		pstmt =con.prepareStatement(sql);
    		pstmt.setString(1,user_name);
    		pstmt.setString(2,password);
    		res =pstmt.executeQuery();
    		if (res.next()== true) {
    			System.out.println("Login Successfull \n"
    					+"***************Welcome to your To-Do-List Application  "+res.getString(1).toUpperCase()+"*******************");
    			
				
			}else {
    			System.out.println("User Login failed. Refresh the page to register again ");
			}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
		return false;
		
		
	}
    static boolean userRegister() {
    	try {
    		System.out.println(con);
    		System.out.println("Enter the user name : ");
    		user_name =sc.next();
    		System.out.println("Enter the password");
    		password=sc.next();
    		String sql="insert into user values(?,?)";
    		pstmt =con.prepareStatement(sql);
    		pstmt.setString(1,user_name);
    		pstmt.setString(2,password);
    		int x =pstmt.executeUpdate();
    		if (x>0) {
    			System.out.println("User Added. Refresh the page to login ");
    			
				
			}else {
    			System.out.println("User Action failed. Refresh the page to register again ");
			}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
		
		return false;
	}
}
