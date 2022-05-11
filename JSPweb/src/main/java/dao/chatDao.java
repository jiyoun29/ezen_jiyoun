package dao;

import java.util.ArrayList;

import dto.chat;

public class chatDao extends Dao {
	
	public chatDao() {
		super();
	}
	
	public static chatDao chatDao = new chatDao();
	public static chatDao getChatDao() {return chatDao;}
	
	//1. 게시물-채팅 쓰기 메소드
	public boolean chatwrite(chat chat) {
		
		String sql = "insert into chat(cname, ccontent)values(?,?)";
		
		try { ps = con.prepareStatement(sql);
		ps.setString(1, chat.getCname());
		ps.setString(2, chat.getCcontent());
//		ps.setInt(3, chat.getCnum());
			ps.executeUpdate();
		return true;
		} catch (Exception e) {System.out.println("쓰기오류"+e);}	
	return false;}
	
	
	//2. 게시물 출력 메소드 (인수 나중에 집어넣기)
	public ArrayList<chat> getchatlist(){
		ArrayList<chat> chatList = new ArrayList<chat>();
		
		String sql = "select * from chat";
		
		try { ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			chat chat = new chat(rs.getString(1), rs.getString(2), 
					rs.getInt(3));
			chatList.add(chat);
		}
			return chatList;
		} catch (Exception e) {System.out.println("출력오류"+e);}	
	return null;
	}
	
	
	
	
}
