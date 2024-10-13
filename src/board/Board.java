package board;

public class Board {

	private static int bno;
	private String writer;
	private String contents;
	private static Board instance;
	
	
	public static Board getInstance() {
		//null 아닐 때만 객체 반환하는 유효성 검증
		
		if(instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	public Board() {}
	
	public Board(String w, String c) {
		setBno();
		setWriter(w);
		setContents(c);
	}
	

	public String toString(int bno, String writer, String contents) {
		return "(" + bno + ") 작성자 : " + writer + "내용 : " + contents;
	}
	
	public void setBno() {
		bno++;
	}

	public void getBno() {
		System.out.println(bno);
	}
	
	public void setWriter(String w) {
		writer = w;
	}
	
	public void getWriter() {
		System.out.println(writer);
	}
	
	public void setContents(String c) {
		contents = c;
	}
	
	public void getContents() {
		System.out.println(contents);
	}
	
}
