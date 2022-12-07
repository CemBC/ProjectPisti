public class GamePisti{
	public static void main(String [] args){
		Deck deck = new Deck();
		Hand hand = new Hand();
		Board board = new Board();
		String [] arr = new String[52];
		board.showBoard();
		int count = 0;
		do{
			board.getToBoard(deck.getCard());
			count += 1;
		}while (count != 4);
		board.showBoard();
		board.getFromBoardTo(arr);
		board.showBoard();
		System.out.println("------------");
		showCache(arr);
		
		
		
		
	}
	
	public static void showCache(String[] arr) {
		System.out.print("[");
		for(int i = 0 ; i< arr.length ; i++){
			if(arr[i] != null){
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}