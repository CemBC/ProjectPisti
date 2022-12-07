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
		System.out.println("------------");
		for(String a : arr){
			System.out.println(a+" ");
		}
		
		
		
	}
}