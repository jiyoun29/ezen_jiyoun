package Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Dto.Product;
import Dto.Roomlive;
import Dto.room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class roomDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	//db설계 꼼꼼히
	
	public static roomDao roomDao = new roomDao();
	
	public roomDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
		"root", "1234"); 

		} catch (Exception e) {} }
		
		//dao 연동 완
		
		
	//1.방 저장 메소드
	public boolean roomadd(room room) {

		try { //예외처리필수
		//sql 추가				//테이블명(필드)values(값1)
		String sql = "insert into room(roname,roip) values(?,?)";
					//테이블에 레코드 추가 문법 = insert into 테이블명(필드명1,필드명2) values(값1, 값2);
		ps = con.prepareStatement(sql);
		ps.setString(1, room.getRoname());
		ps.setString(2, room.getRoip());
		ps.executeUpdate();
		return true;
		} catch (Exception e) {System.out.println("오류="+e);}
		return false;
	}
	
		
	//2.방번호 호출 메소드 [ 방번호 = 포트번호로 사용할 예정 ]
	public int getroomnum() {
		try { //예외처리필수
			
			//가장 최근에 등록된 방 번호 가져오기(max(필드명) : 해당 필드의 가장 큰 값)<-db함수
			String sql = "select max ronum from room";
						//검색
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); //쿼리를 가져와서 최근에 등록된 방번호를 반환
			}
			
			
		} catch (Exception e) {System.out.println("오류="+e);}
		
		return 0; //없으면 0
		
	}
	


	///////
	//3. 모든 방 호출 메소드
	public ObservableList<room> roomList(){
		ObservableList<room> roomlist = FXCollections.observableArrayList();
		try {

			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				room room = new room(rs.getInt(1),rs.getString(2),rs.getString(3),0 );
				
				
				roomlist.add(room);
			}
			return roomlist;
			
		} catch (Exception e) {System.out.println("오류="+e);}
		return null;
	}
	
	
	
	/////////////////////
	
	
	//4. 채팅방 접속 명단 추가
	public boolean addroomlive(Roomlive roomlive) {
		
		String sql = "insert into roomlive(ronum,mid) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomlive.getRonum());
			ps.setString(2, roomlive.getMid());
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("오류="+e);}

		return false;
	}
	
	
	
	//5. 채팅방에 접속한 모든 명단 호출
	public ArrayList<Roomlive> getRoomlivelist (int ronum){
		
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where ronum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Roomlive roomlive = new Roomlive(rs.getInt(1),
						rs.getInt(2), rs.getString(3));
				roomlivelist.add(roomlive);
			}
			return roomlivelist;
			
			
		} catch (Exception e) {System.out.println("오류="+e);}
		return null;

	}
	
	///////////////////////
	
	
	
	//6. 채팅방 접속 명단 삭제
	public boolean roomlivedelete(String mid) {
		
		//삭제가 편하다... 노션 참고 sql은 외우기
		String sql = "delete from roomlive where mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate(); //업데이트 상태로 만듦
			return true;
			
		} catch (Exception e) {System.out.println("오류="+e);}
	
		return false;

	}
	
	
	//7. 채팅방 삭제[조건 : 인원이 0일때]
	public boolean roomdelete(int ronum) {
	
		//만약에 해당 방 번호로 roomlive에서 검색했을 때 검색결과가 존재(레코드 존재)하면 방 삭제x
			//검색 결과가 없으면(레코드 존재하지 않음) 방 삭제o
		
		String sql = "select * from roomlive where ronum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
			
			if(rs.next()) { //결과가 존재하면 방 삭제 안함
				return false;
			} else { //결과가 없으면 방 삭제 처리
				String sql2 = "delete from room where ronum =? ";
				//룸을 삭제
				ps = con.prepareStatement(sql);
				ps.setInt(1, ronum);
				ps.executeUpdate();
				return true; //접속 명단이 없는 방 삭제 성공
			}
			
		} catch (Exception e) {System.out.println("오류="+e);}
					
		
	
		return false;
	}
	
	
	///////////////////////////////
}
