public class GamePisti{
	public static void main(String [] args){
		Deck deck = new Deck();
		Hand hand = new Hand();
		hand.showHand();
		hand.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
		hand.showHand();
		hand.getFromHand(4);
		hand.showHand();
		
		
		
		
		
	}
}