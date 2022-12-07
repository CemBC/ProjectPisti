public class Board{
	private String [] board;
	
	public Board() {
		String [] arr = new String[52];
		this.board = arr;
	}
	
	public void showBoard(){ //Shows Board
		System.out.print("[");
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null){
				System.out.print(board[i] + " ");
			}
		}
		System.out.print("]");
	}
	
	public void getToBoard(String a){ //Adding card to board when board has null index 
		for(int i = 0 ; i< board.length ; i++){
			if(board[i] == null){
				board[i] = a;
				break;
			}
		}
	}
	
	public void getFromBoardTo(String[] a){ 
		int counter = -1;
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null) {
				counter++;
				for(int j = counter ; j < a.length ; j++){
					if(a[i] == null) {
						a[j] = board[i];
						board[i] = null;
						break;
					}
				}
			}
		}
	}
	
	
}