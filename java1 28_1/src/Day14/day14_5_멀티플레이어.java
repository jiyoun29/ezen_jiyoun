package Day14;

import java.util.Scanner;

public class day14_5_��Ƽ�÷��̾� {
	
	//���� 1. �Ҹ����/���� 2. ���� ���/����
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //�Է°�ü
		
		//�����մ��� �����ִ��� üũ�� �ؾ���
		boolean soundsw = true;
		//		����
		
		boolean moviesw = true;
		//���� Ȯ��
		
		
		while (true) {
			System.out.println("1.�Ҹ���� 2.�������");
			int ch = scanner.nextInt();
			//����
			
			//���� : �Ҹ� or ������ ����� �ٽ� �� �� ������ ������ �����
				if(ch == 1) { //ù�۵��� true

					Sound sound = new Sound(); //��ü ����
					//���������� �߰�ȣ ������ �������� ���� ���Ÿ� ���⼭ �Է�

					// �Ҹ��� �����Ŀ� ���� stop
					if(soundsw) { // ==true
						sound.Soundstop(true);
						sound.start();
						
						//sound.stop = false; //�Ҹ� ����
						//stop �ʵ忡 ���� ����� ->�ٷ� ���� �ǹǷ� 1�� �������� �����ϵ���
						
						soundsw = false; //�Ҹ� ���� //���� �� ���� ���
					}
					else { // ==false
						sound.Soundstop(false);
						//sound.stop = true; //�Ҹ����
						soundsw = true; //���� ����� ���
					}
					
				}
				else if (ch == 2) {
					
					movie movie = new movie();
						if(moviesw) {
							movie.moivestop(true); //���� ����
							movie.start(); //������ ����
							moviesw = false; //���º���
						}
						else { movie.moivestop(false); //���� ����
						moviesw = true; //���� ����
						
						}
					
					
					
					
				}
			
			
		}
		
		
		
		
	}

}
