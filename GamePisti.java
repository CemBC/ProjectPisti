public class GamePisti{
	public static void main(String [] args){
		Deck deck = new Deck();
		Hand hand = new Hand();
		Board board = new Board();
		board.showBoard();
		count = 0;
		do{
			board.getToBoard(deck.getCard);
			count += 1;
		}(while count != 3);
		board.showBoard();
		board.getFromBoardto(hand);
		
		
		
	}
}