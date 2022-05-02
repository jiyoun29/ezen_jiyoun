package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	protected Connection con; //패키지가 달라도 상속 받으면 접근 가능
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	
	public Dao() {
		try { //super클래스와 동일
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb?serverTimezone=UTC",
					"root", "1234");
			System.out.println("연동성공");
			
		} catch (Exception e) {System.out.println(e);}
		
	}
	
	
}
