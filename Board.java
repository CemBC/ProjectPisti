public class Board{
	private String [] board;
	
	public Board() {
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
	
	public void getFromBoardTo(String[] a){ // reversed for loop gettin all board to cache 
		
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null) {
				for(int j = 0; j < a.length; j++){
					if(a[j] == null){
						a[j] = board[i];
						board[i]= null;
					}
				}		
			}
		}
	}
	
	
	
}