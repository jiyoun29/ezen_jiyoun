package Day18;

import java.util.Vector;

public class day18_2 {
	//730
	public static void main(String[] args) {
		
		/*
		 			ArrayList			vector
		 ����ȭ			x					o
		 ������	�̱۽�����(main)	��Ƽ������(Thread, Runnable)
		 
		
		 Vector Ŭ����
		 1. Vector ����Ʈ ��ü ����
		 */
	Vector<Board> list = new Vector<>();
		//2. ����Ʈ ��ü �� �߰�
	list.add(new Board("����1", "����1", "�۾���1"));
		//�ι�°���
		Board board = new Board("����2", "����2", "�۾���2");
		list.add(board);
		
	System.out.println("Ȯ��"+list);

	//3. �˻�
	
	System.out.println("�˻�"+list.contains(board));
	System.out.println("�˻� ��ġ:"+list.indexOf(board));
	
	
	//4. ����
	list.remove(2); System.out.println("����Ȯ��:"+list);

	
	
///////////////////////////////		
	}
}
