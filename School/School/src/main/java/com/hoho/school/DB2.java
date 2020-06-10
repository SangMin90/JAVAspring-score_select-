package com.hoho.school;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.sqlite.SQLiteConfig;

public class DB2 {
	
	private Connection connection;
	private String dbFileName;
	private String dbTableName;
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public DB2(String databaseFileName, String dbTableName) {
		this.dbFileName = databaseFileName;
		this.dbTableName = dbTableName;
	}
	
	
	public boolean open() {
		try {
			SQLiteConfig config = new SQLiteConfig();
			this.connection = DriverManager.getConnection("jdbc:sqlite:/"+this.dbFileName, config.toProperties());
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean close() {
		if (this.connection == null) {
			return true;
		}
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Student selectData(int student_no) throws SQLException{
			
			String query = "SELECT * FROM " + this.dbTableName + " WHERE student_no=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, student_no);
			ResultSet resultSet = preparedStatement.executeQuery();
			Student result = new Student();
			
			if (resultSet.next()) {
				result.student_no = resultSet.getInt("student_no");
				result.name = resultSet.getString("name");
				result.kor = resultSet.getInt("kor");
				result.eng = resultSet.getInt("eng");
				result.math = resultSet.getInt("math");
				
			}
			resultSet.close();
			preparedStatement.close();
			return result;
	}
	
		
		
	public ArrayList<Student> selectData() throws SQLException{
			String query = "SELECT * FROM " + this.dbTableName + " WHERE ?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<Student> dataSet = new ArrayList<Student>();
			while(resultSet.next()) {
				dataSet.add(new Student(resultSet.getInt("student_no"), resultSet.getString("name"),
						resultSet.getInt("kor"), resultSet.getInt("eng"), resultSet.getInt("math")));
			}
			
			resultSet.close();
			preparedStatement.close();
			return dataSet;
		}
	
	public void updateData(Student student) throws SQLException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String dateString = format1.format(time);
		String query = "UPDATE " + this.dbTableName + " SET name = '" + student.name + "', kor=" + student.kor + ", eng=" + student.eng + ", math=" + student.math + ", modified= '" + dateString + "'  WHERE student_no=" + student.student_no + "";
		Statement statement = this.connection.createStatement();
		statement.executeUpdate(query);
		statement.close();
	}
	
	
	public void insertData(Student student) throws SQLException {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date time = new Date();
	    String dateString = format.format(time);
	//    String query = "INSERT INTO " + this.dbTableName + "(student_no, name, kor, eng, math, created) VALUES(?, ?, ?, ?, ?, ?);";
	    String query = "INSERT INTO " + this.dbTableName + "( name, kor, eng, math, created) VALUES(?, ?, ?, ?, ?);";  
	    PreparedStatement preparedStatement = this.connection.prepareStatement(query); 
	//    preparedStatement.setInt(1, student.student_no);
	    preparedStatement.setString(1, student.name);   // 첫번째 물음표에 이 값을 넣어줘
	    preparedStatement.setInt(2, student.kor);   // 첫번째 물음표에 이 값을 넣어줘
	    preparedStatement.setInt(3, student.eng);   // 첫번째 물음표에 이 값을 넣어줘
	    preparedStatement.setInt(4, student.math);   // 첫번째 물음표에 이 값을 넣어줘
	    preparedStatement.setString(5, dateString);   // 첫번째 물음표에 이 값을 넣어줘
	    preparedStatement.executeUpdate();   // 출력? resultset이란?
	    preparedStatement.close();
	 }
	//	public void err() 



}
