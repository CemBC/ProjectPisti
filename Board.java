public class Board{
	private String [] board;
	
	public Board() {
		String [] arr = new String[52];
		this.board = arr;
	}
	
	public void showBoard(){
		for(int i = board.length ; i > -1 ; i--){
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
	
	public String getFromBoardTo(String[] a){
		for(int i = board.length ; i > -1 ; i--){
			if(board[i] != null) {
				for(int j = 0 ; j < a.length ; j++){
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