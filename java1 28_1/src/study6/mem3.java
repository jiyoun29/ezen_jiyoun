package study6;

import java.util.Scanner;

public class mem3 {
	public static void main(String[] args) {

		// ȸ���� �湮�� ���α׷�
		// 1. �ʱ�޴� [ 1. ȸ������ 2.�α��� ]
			// 1. ȸ������ [ ���̵�, ���, �̸�]
			// 2. �α��� [ ���̵�, ��� �����ϸ� �α��� ó��]
		// 2. �α��� �� �޴� [ 1. �湮�� ���� 2.�α׾ƿ�]
			// 1. �湮�� ���� [ ����, ����, �ۼ���(�α��� ���̵�)]
			// 2. �α׾ƿ� [�ʱ�޴��� ���ư���]

//		int[][] �迭2 = new int[2][3]; 
//		//2���� �迭. ���� ��, �ڰ� ��. 4����Ʈ * 2 * 3 => 24����Ʈ �迭
//		�迭2[0][0] = 80; �迭2[0][1] = 90; �迭2[0][2] = 100;
//		�迭2[1][0] = 40; �迭2[1][1] = 50; �迭2[1][2] = 60;

////////////////////////////////////////
	

	Scanner scanner = new Scanner(System.in);
		
	String[][] memlist = new String [10][3]; //ȸ��
	String[][] boardlist = new String [10][3]; //�Խù�
		

	//1.�ʱ�
	while(true) { System.out.println("=====ȸ���� �湮��=====");
	System.out.println("1. ȸ������ 2. �α���"); int ch = scanner.nextInt();
		
	
	
	//2. ȸ������
		
	if(ch==1) { //1.ȸ�������� �����Ͽ��� ���
			System.out.println("=====ȸ������ ������=====");
			System.out.print("���̵� : "); String id = scanner.next();
			System.out.print("��й�ȣ : "); String pw = scanner.next();
			System.out.print("�̸� : "); String name = scanner.next();
			//�Է¹������� �������Ʈ�� �����Ѵ�.
		
			//���̵� �ߺ�üũ
		boolean idcheck = true; //üũ ���ΰ� �����Ҷ�
		    for(int i = 0; i<memlist.length ; i++) {
			if(memlist[i][0] != null && memlist[i][0].equals(id)) {
				System.out.println("������ ���̵� �����մϴ�."); idcheck = false;
				break; }  //���߰� ��������
				} // for end
		
		   //üũ ���ΰ� ���� ������(���� ���̵� ����)
		if (idcheck) { for(int i = 0 ; i<memlist.length ; i++) { 
		if(memlist[i][0] == null) { //����ִ� �迭�� ã�� �ִ´�.
		memlist[i][0] = id; memlist[i][1] = pw; memlist[i][2] = name;
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�."); break; }	// ���߰� ����������.
		} // for end
	} //if end	
		
}// ch1 end
	
	
	
	//3. �α���
	else if (ch == 2) {
		System.out.println("=====�α��� ������=====");
		System.out.print("���̵� : "); String id = scanner.next();
		System.out.print("��й�ȣ : "); String pw = scanner.next();	
		
		//��������v ����ġ�ϴ� �� �ִ���.
		boolean logincheck = false; //�α��� ������ �ʱⰪ����
		
		for(int i = 0; i<memlist.length; i++) { 
			if (memlist[i][0].equals(id) && memlist[i][1].equals(pw) ) { //���� ��
				System.out.println("�α��� ����"); logincheck = true;

				
				
			//�α��� ����
		while(true) { System.out.println("=====�湮�� ������=====");	
					  System.out.println("��ȣ\t�ۼ���\t����\t����");
			
		for( int j = 0 ; j<boardlist.length ; j++  ) {
		if( boardlist[j][0] != null ) { System.out.printf("%d\t%s\t%s\t%s \n" , 
				j , boardlist[j][2] , boardlist[j][0] , boardlist[j][1] ); }
		}//for end
		//����� �湮�� ���� �� ����
		
		System.out.print("1.�湮�� ����� 2.�α׾ƿ�"); int ch2 = scanner.nextInt();
		
		if( ch2 == 1 ) { System.out.println("=====�۾��� ������=====");	
		System.out.print(" ���� : "); 	String title = scanner.next();
		System.out.print(" ���� : ");	String content = scanner.next();
		
		
		
		for( int j = 0 ; j<boardlist.length ; j++ ) {
			
			if( boardlist[j][0] == null  ) { 
				boardlist[j][0] = title;
				boardlist[j][1] = content;
				boardlist[j][2] = id;
				System.out.println("�湮���� �ۼ��Ǿ����ϴ�.");break; }
					} //����
	}
		
		
		else if( ch2 == 2 ) { System.out.println(" �α׾ƿ� �Ǿ����ϴ�."); break; }
	else { System.err.println(" �˼� ���� ��ȣ�Դϴ�."); }
				
	} // while end 
			
			} // if end = login end  
		} // for end 
		if( logincheck == false )
			System.out.println(" ȸ�������� ���ų� �ٸ��ϴ�.");
		
	} // 
	else { System.err.println(" �˼� ���� ��ȣ�Դϴ�."); }
		
		
	} //while end	
	
////////////////////////////////////////
	}//main end
}