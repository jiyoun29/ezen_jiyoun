package Day12;

import java.util.Scanner;
//Students와 연계. 모범답안

public class 실행 {
	
	public static void main(String[] args) {
		
		Students[] studentlist = new Students[100];
		//배열 생성. 학생 리스트를 만들고 최대 100명까지 넣을 수 있는 크기를 생성한다.
		
		Scanner scanner = new Scanner(System.in);
		//읽을 수 있는 스캐너 삽입
		
		while(true) { //반복문 시작
			try {//예외처리 try 시작
				System.out.println("--------------------------------------");
				System.out.println(" \t성\t적\t표");
				System.out.println("--------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				//목차를 우선 기입한다.
				
				///////////////////************여기부터 중요
				
				// 개인 석차 기준으로 배열내 인덱스 정렬하기 
				for(int i = 0; i <studentlist.length;i++) {
					//i가 0일때 스튜던트 리스트와 i++, 1개씩 비교해서 올라간다.

					for(int j = 0; j < studentlist.length;j++) {
						//그 비교를 진행중일때, j가 0일때 스튜던트 리스트와 다시 한 번 더 비교한다.
					
						if(studentlist[i] != null && studentlist[j] != null){
							//만일 스튜던트리스트 i와 스튜던트리스트 j가 비어있지 않다면.
						
							if(studentlist[i].getTotal() > studentlist[j].getTotal()) {
								//
								
								Students[] temp = new Students[1];
								
								temp[0] = studentlist[i];
								
								studentlist[i] = studentlist[j];
								
								studentlist[j] = temp[0];
								
							} //if 2 end
						} //if 1 end
					} //for2 end
				}//for1 end
				
				///////////////////************	
				
				// 출력 
				
				
				int h=0; // 인덱스 
				for(Students temp : studentlist) {
					if(temp != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
								temp.getNo(),temp.getName(),temp.getKor(),temp.getEng(),temp.getMath(),temp.getTotal(),temp.getAve(),(h+1));
					}
					h++;
				}
				
				System.out.println("--------------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();
				if(ch == 1) {
					// 학생정보 입력받기 
					System.out.print("번호입력 : ");	int no = scanner.nextInt();
					System.out.print("이름 입력 :");	String name = scanner.next();
					System.out.print("국어점수 : ");	int korean = scanner.nextInt();
					System.out.print("영어점수 : ");	int english = scanner.nextInt();
					System.out.print("수학점수 : ");	int math = scanner.nextInt();
					// 번호 중복체크 
					boolean check = true;
					for( Students temp : studentlist ) {
						if( temp != null && temp.getNo() == no ) {
							check = false; break;
						}
					}
					// 중복이 없으면 학생등록하기 
					if( check ) {
						int total = korean+english+math;
						double avg = total/3.0;
						
						Students students = new Students(no ,name, korean, english, math, total, avg);
						int j = 0;
						for(Students temp : studentlist) {
							if(temp == null) {
								studentlist[j] = students;
								break;
							}
							j++;
						}
					}
					
				}
				else if(ch == 2) {
					System.out.println("삭제할 학생 번호 입력 : ");
					int num = scanner.nextInt();
					int j = 0 ;
					// 학생번호를 찾아서 삭제후 삭제된 인덱스 뒤로 한칸씩 당기기
					for( Students temp : studentlist  ) {
						if( temp != null && temp.getNo() == num ) {
							for(int i = j;i <studentlist.length;i++) {
								if( i == studentlist.length-1) {
									studentlist[ studentlist.length-1 ] = null;
								}
								else {
									studentlist[i] = studentlist[i+1];
								}
							}
						}
						j++;
					}
				}
			} //예외처리 try end
			catch(Exception e) {
				System.out.println("메세지)) 오류");
				scanner = new Scanner(System.in);
			}
			
			
		}
		
	}
	

}
