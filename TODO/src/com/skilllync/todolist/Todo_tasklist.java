package com.skilllync.todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Todo_tasklist {
	static PreparedStatement pstmt;
	static Connection con = Main.con;
	static String user_name;
	static ResultSet res;

	static Scanner sc = new Scanner(System.in);

	static void taskList(String user) {
		user_name = user;
		System.out.println("Select an option : \n" + "1. Add task \n" + "2. View tasks \n" + "3. Update task \n"
				+ "4. Remove task ");
		int choice = sc.hashCode();
		switch (choice) {
		case 1: {
			newTask();
		}
		case 2: {
			viewTasks();
		}
		case 3: {
			updateTask();
		}
		case 4: {
			removeTask();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexcepted value" + choice);
		}
	}

	private static void updateTask() {
		// TODO Auto-generated method stub

	}

	private static void removeTask() {
		// TODO Auto-generated method stub

	}

	private static void viewTasks() {
		// TODO Auto-generated method stub
		try {
		String sql = "insert into todo list (task_name, description, user_name) values (?,?,?)";
		pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, user_name);
			res = pstmt.execute();
			while()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void newTask() {
		// TODO Auto-generated method stub

		try {

			System.out.println(con);
			System.out.println("Enter the description: ");
			String task_name = sc.next();
			System.out.println();
			String desc = sc.next();
			String sql = "insert into todo list (task_name, description, user_name) values (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, task_name);
			pstmt.setString(2, desc);
			pstmt.setString(3, user_name);
			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Task added successfully ,\n");
				taskList(user_name);
			} else {
				System.out.println("Task action failed.");
				taskList(user_name);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
