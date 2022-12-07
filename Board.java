public class Board{
	private String [] board;
	
	public Board() {
		String [] arr = new String[52];
		this.board = arr;
	}
	
	public void showBoard(){
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null){
				System.out.print(board[i] + " ");
			}
		}
	}
	
	public void getToBoard(String a){
		for(int i = 0 ; i< board.length ; i++){
			if(board[i] == null){
				board[i] = a;
				break;
			}
		}
	}
	
	public void getFromBoardTo(String[] a){
		int counter = 0;
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null) {
				for(int j = counter++ ; j < a.length ; j++){
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