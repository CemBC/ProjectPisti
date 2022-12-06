public class GamePisti{
	public static void main(String [] args){
		Deck deck = new Deck();
		deck.Shuffle();
		deck.ShowDeck();
		System.out.println("---------");
		System.out.println(deck.getCard());
		System.out.println(deck.getCard());
		deck.ShowDeck();
		
	}
}