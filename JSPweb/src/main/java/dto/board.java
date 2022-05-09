package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;

public class board {
	private int bno; /*게시물 번호*/
	private String btitle; /*게시물 제목*/
	private String bcontent; /*게시물 내용*/
	private int mno; /*작성자 = member테이블 mno 관계*/
	private int bview; // default 0, /*게시물 조회수*/
	private String bdate; // datetime default now(), /*게시물 작성일*/	
	private String bfile; /*게시물 첨부 파일*/ //LONGTEXT
   // foreign key(mno) references memdb(mno) /*게시물 테이블의 작성자mno와 회원테이블의 회원번호mno와 fk-pk 연계*/
	private String mid; //화면표시용


	
	//객체정보(필드정보) 출력 메소드

	@Override
	public String toString() {
		return "board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + ", bview="
				+ bview + ", bdate=" + bdate + ", bfile=" + bfile + ", mid=" + mid + "]";
	}


	
	public board() {
		// TODO Auto-generated constructor stub
	}



	public board(int bno, String btitle, String bcontent, int mno, int bview, String bdate, String bfile, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bview = bview;
		
		if(bdate != null) {
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate를 여기서 사용하려면 포맷 사용		
		String today = dateformat.format(LocalDate.now()); //오늘날짜를 문자열 변환

		//db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리 후 앞에 있는 날짜만 가져오기
		String boardday = bdate.split(" ")[0]; //날짜와 시간을 공백 기준으로 쪼개기
		String boardtime = bdate.split(" ")[1]; //시간만	
		
		//현재 날짜와 게시물 등록날짜가 동일하면 시간
		if(today.equals(boardday)) { this.bdate = boardtime;
		}  else { this.bdate = boardday; } //동일하지 않으면 날짜
		} else { this.bdate = bdate;}
		this.bfile = bfile;
		this.mid = MemberDao.getMemberDao().getmid(mno);
	}




	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getBtitle() {
		return btitle;
	}



	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}



	public String getBcontent() {
		return bcontent;
	}



	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}



	public int getMno() {
		return mno;
	}



	public void setMno(int mno) {
		this.mno = mno;
	}



	public int getBview() {
		return bview;
	}



	public void setBview(int bview) {
		this.bview = bview;
	}



	public String getBdate() {
		return bdate;
	}



	public void setBdate(String bdate) {
		this.bdate = bdate;
	}



	public String getBfile() {
		return bfile;
	}



	public void setBfile(String bfile) {
		this.bfile = bfile;
	}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}





	
	
	
}
