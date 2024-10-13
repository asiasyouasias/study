package board;

public class BoardApp {

	public static void main(String[] args) {
		Board board = new Board("kim", "hhh");
		
		Board board2 = Board.getInstance();
		board2.setBno();
		board2.setWriter("Lee");
		board2.setContents("mmm");
	
		board2.getBno();
		board2.getWriter();
		board2.getContents();
	
		System.out.println(board.toString());
		
	}

}
