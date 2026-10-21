package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.util.DBConnection;

public class StudentDAO {
  //Add Student
	public void addStudent(int id,String name,String email,String course,int age) {
		try {
			Connection con = DBConnection.getConnection();			
			String query="insert into students(id,name,email,course,age) values (?, ?, ?, ?, ?)"; //add a new students, ? placeholder for student values			
			PreparedStatement ps = con.prepareStatement(query);
			
			//supples an integer value
			ps.setInt(1, id);//supplies a test value
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, course);
			ps.setInt(5, age);
			
			ps.executeUpdate();//runs a insert query// 			
				System.out.println("Student added successfully");
				
			ps.close();
			con.close();
						
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//-----------------------------------------------------------------------
	
	//View Students
	public void viewStudents() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from students";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("id: "+rs.getInt("id"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("email: "+rs.getString("email"));
				System.out.println("course: "+rs.getString("course"));
				System.out.println("age: "+rs.getInt("age"));
				
				System.out.println("-------------------------------------");
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	//----------------------------------------------------------------------------------
		//Search Student
	public void searchStudents(int id) {
		try {
			Connection con = DBConnection.getConnection();
			String check="select * from students where id = ?";
			PreparedStatement ps = con.prepareStatement(check);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("id: "+rs.getInt("id"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("email: "+rs.getString("email"));
				System.out.println("course: "+rs.getString("course"));
				System.out.println("age: "+rs.getInt("age"));
			}else {
				System.out.println("Student not found");
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	//--------------------------------------------------------------------------
	//Update Students
	public void updateStudent(int id,String name,String email,String course, int age) {
		try {
			Connection con=DBConnection.getConnection();	
			String udate = "update students set name = ?,email= ?,course = ?, age = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(udate);
			
		    ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, course);
			ps.setInt(4, age);
			ps.setInt(5, id);
						
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Student update successfully!");
			}else {
				System.out.println("Student not found");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//----------------------------------------------------------------------
	//Delete Student
	public void deleteStudent(int id) {
		try {
			Connection con=DBConnection.getConnection();
			String delete = "delete from students where id = ?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Student delete successfully");
			}else {
				System.out.println("Student not found");
			}
			
			ps.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

