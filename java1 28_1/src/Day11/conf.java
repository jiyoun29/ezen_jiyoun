package Day11;

public class conf {
	// 0. �Խù� ����Ʈ  [ ��� �Խù��� ��� ����Ʈ ] 
		public static ArrayList<Board> boadlist = 
				new ArrayList<>();
		//1.��ϸ޼ҵ�
		public static void boardlist() {}
		//2.����޼ҵ� 
		public static void write(String ���� , String ���� , String �ۼ��� , String ��й�ȣ ) {
			Board board = new Board(����, ����, ��й�ȣ, �ۼ���); // 1. ��üȭ[ ������ 4�� --> 1�� ��ü ]
			boadlist.add(board); // 2. ����Ʈ�� ����
			save(); // 3. ���Ͽ� ���� 
		}
		//3.����޼ҵ�
		public static void view() {}
		//4.�����޼ҵ�
		public static void update() {}
		//5.�����޼ҵ� 
		public static void delete() {}
		//6.��۾���޼ҵ� 
		public static void replywrite() {}
		//7.�Խù� ����/���� �޼ҵ� 
		public static void save() { 		// ����Ʈ�� ��� �Խù��� ���Ͽ� ����
			try {
				// 1. ������� Ŭ���� 
				FileOutputStream outputStream = new FileOutputStream("D:/java/�Խù�����.txt");
				// 2. ���Ͽ� �ۼ��� ���� [ ����Ʈ�� ��ü 1���� = ���پ� = �Խù� 1���� = ��ü 1���� ]
				for( Board board : boadlist ) { // , : �ʵ屸�п�     \n : ��ü���п�
					String �ۼ����� = board.getTitle() +","+board.getContent()+","+
							board.getPassword()+","+board.getWriter()+","+
							board.getViewcount()+","+board.getDate()+"\n";
					// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ  [ �ܺ����(��Ʈ��) : ��Ŵ��� : ����Ʈ ]
					outputStream.write( �ۼ�����.getBytes() ); // 4. �������� [ write() ]
				}
			}catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
		}
		//8.�Խù��ҷ�����޼ҵ� [ ���α׷� ���� ] ����---> ����Ʈ
		public static void load() {
			try {
				FileInputStream inputStream = new FileInputStream("D:/java/�Խù�����.txt"); // 1. �����Է�Ŭ���� 
				byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
				inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
				String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
				String[] boards = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
				for( String temp : boards ) { // �迭�� ���ڿ� �ϳ��� ������ 
					String[] field = temp.split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
					Board board = new Board( field[0], field[1],
							field[2], field[3], Integer.parseInt(field[4]),field[5], null);  // 7. ��üȭ 
											// ��ȸ���� �ʵ�� �������̹Ƿ� ���������� ����ȯ [ Integer.parseInt( ���ڿ� ) ]
					boadlist.add(board);// 8. ����Ʈ ��� 
				}
			}catch( Exception e ) { System.err.println(" �˸�]] ���Ϸε� ����( �����ڿ��Թ��� )" + e); }
}