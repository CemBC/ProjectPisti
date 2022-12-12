import java.util.Random;
import java.util.Scanner;
public class Deck{
	private String[] deck;
	
	public Deck() {
		String [] arr = {"♠A","♠2","♠3","♠4","♠5","♠6","♠7","♠8","♠9","♠10","♠J","♠Q","♠K",
		"♣A","♣2","♣3","♣4","♣5","♣6","♣7","♣8","♣9","♣10","♣J","♣Q","♣K",
		"♥A","♥2","♥3","♥4","♥5","♥6","♥7","♥8","♥9","♥10","♥J","♥Q","♥K",
		"♦A","♦2","♦3","♦4","♦5","♦6","♦7","♦8","♦9","♦10","♦J","♦Q","♦K"};
		this.deck = arr;
	}
	
	public String[] get(){
		return deck;
	}
	
	
	
	public String getCard(){  //Getting card from top of the deck and convert that index to null so you cant get that card anymore
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
	
	public void showDeck(){ //Shows deck
		System.out.println("THE DECK");
		System.out.print("[");
		for(String a : deck) {
			System.out.print(a + " ");
		}
		System.out.print("]");
		System.out.println("\n");
	}
	
	
	public void Shuffle(){ //Shuffle method with switching value way
		Random rd = new Random(System.currentTimeMillis());
		for(int i = 0 ; i < deck.length ; i++) {
			
			int tempindex = rd.nextInt(deck.length);
			
			String tempstring = deck[tempindex];
			deck[tempindex] = deck[i];
			deck[i] = tempstring;
		}
	}
	
	public void cutDeck(){
		Random rd = new Random(System.currentTimeMillis());
		int rc = rd.nextInt(49)+2;  		// rc = random card
		String [] td = new String[rc];     // td = top of deck
		String [] bd = new String[52-rc];	// bd = bottom of deck
		
		System.arraycopy(deck,0,td,0,td.length); //copy cutted deck's top side to top of deck array
		System.arraycopy(deck,rc,bd,0,bd.length); //copy cutted deck's bottom side to bottom of deck array
		
		System.arraycopy(bd,0,deck,0,bd.length);  //copy bd to top of the main deck
		System.arraycopy(td,0,deck,bd.length,td.length); //copy td to bottom of the main deck
		
		
	}
	
	

		
		
		
		
		
		
				
}