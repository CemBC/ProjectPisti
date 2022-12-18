public class Board{
	private String [] board;
	
	public Board() {  //Constructor
		String [] arr = new String[52];
		this.board = arr;
	}
	
	
	public String[] get(){ //getting String[] board
		return board;
	}
	
	
	
	
	
	
	public void getToBoard(String a){ //Adding card to board when board has null index 
		for(int i = 0 ; i< board.length ; i++){
			if(board[i] == null){
				board[i] = a;
				break;
			}
		}
	}
	
	
	
	
	
}