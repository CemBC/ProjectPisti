import java.util.Random;
public class Deck{
	private String[] deck;
	
	public Deck() {
		String [] arr = {"♠A","♠2","♠3","♠4","♠5","♠6","♠7","♠8","♠9","♠10","♠J","♠Q","♠K",
		"♣A","♣2","♣3","♣4","♣5","♣6","♣7","♣8","♣9","♣10","♣J","♣Q","♣K",
		"♥A","♥2","♥3","♥4","♥5","♥6","♥7","♥8","♥9","♥10","♥J","♥Q","♥K",
		"♦A","♦2","♦3","♦4","♦5","♦6","♦7","♦8","♦9","♦10","♦J","♦Q","♦K"};
		this.deck = arr;
		}
	public String getCard(){
		String temporary = "";
		for(int i = 0 ; i < deck.length ; i++) {
			if(deck[i] != null) {
				temporary = deck[i];
				deck[i] = null;
				break;
			}
		}
		return temporary;
	}
	public void ShowDeck(){
		for(String a : deck){
			System.out.println(a);
		}
	}
	
	public void Shuffle(){
		Random rd = new Random(System.currentTimeMillis());
		for(int i = 0 ; i < deck.length ; i++) {
			int tempindex = rd.nextInt(deck.length);
			String tempstring = deck[tempindex];
			deck[tempindex] = deck[i];
			deck[i] = tempstring;
		}
	}
		
		
				
}