package test;

import java.util.ArrayList;

public class student { //입력 받는 곳
	
	private int index;
	private String 이름;
	private int 국어,영어,수학;
	private int 총점 = 국어+영어+수학;
	private double 평균 = 총점 * 0.3;
	private int 석차; //총점에 따른 석차
	//입력 받아서 저장
	
	private ArrayList<Reply> replylist = new ArrayList();
	//어레이리스트
	
	// 생성자
	public student() {}


	//학생 등록시 사용되는 생성자
	public student(int index, String 이름, int 국어, int 영어, int 수학) {
		super();
		this.index = index;
		this.이름 = 이름;
		this.국어 = 국어;
		this.영어 = 영어;
		this.수학 = 수학;
	}


	//풀생성자
	

	public student(int index, String 이름, int 국어, int 영어, int 수학, int 총점,
			double 평균, int 석차, ArrayList<Reply> replylist) {
		super();
		this.index = index;
		this.이름 = 이름;
		this.국어 = 국어;
		this.영어 = 영어;
		this.수학 = 수학;
		this.총점 = 총점;
		this.평균 = 평균;
		this.석차 = 석차;
		this.replylist = replylist;
	}

	
	
	

	//3.메소드
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String get이름() {
		return 이름;
	}


	public void set이름(String 이름) {
		this.이름 = 이름;
	}


	public int get국어() {
		return 국어;
	}


	public void set국어(int 국어) {
		this.국어 = 국어;
	}


	public int get영어() {
		return 영어;
	}


	public void set영어(int 영어) {
		this.영어 = 영어;
	}


	public int get수학() {
		return 수학;
	}


	public void set수학(int 수학) {
		this.수학 = 수학;
	}


	public int get총점() {
		return 총점;
	}


	public void set총점(int 총점) {
		this.총점 = 총점;
	}


	public double get평균() {
		return 평균;
	}


	public void set평균(double 평균) {
		this.평균 = 평균;
	}


	public int get석차() {
		return 석차;
	}


	public void set석차(int 석차) {
		this.석차 = 석차;
	}


	public ArrayList<Reply> getReplylist() {
		return replylist;
	}


	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}


	
	
	
	
	
	
	

}
