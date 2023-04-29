package com.skilllync.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Main {
	static Connection con;
	static PreparedStatement pstmt;
public static void main(String[] args) {
	try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/todolist","root","ROOT");
        System.out.println("*************Connected  to the Database *************");

        System.out.println("Please Select an Option\n"
        		+"1. Register as new User\n"
        		+"2. Login");
        Scanner sc =new Scanner(System.in);
        int choice =sc.nextInt();
        if (choice == 1) {
			User.userRegister();
		}else if (choice == 2) {
			User.userLogin();
		}else {
			System.out.println("Wrong Option  selected Refresh the Page");
		}
        
        
    } catch (Exception e) {
       e.printStackTrace();
    }
}
}
