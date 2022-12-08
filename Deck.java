import java.util.Random;
import java.util.Scanner;
public class Deck{
	private String[] deck;
	
	public Deck() {
		String [] arr = {"SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
		"CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK",
		"HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
		"DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK"};
		this.deck = arr;
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
		int rc = rd.nextInt(52);  		// rc = random card
		String [] td = new String[rc +1];     // td = top of deck
		String [] bd = new String[52-(rc+1)];	// bd = bottom of deck
		
		System.arraycopy(deck,0,td,0,td.length); //copy cutted deck's top side to top of deck array
		System.arraycopy(deck,rc+1,bd,0,bd.length); //copy cutted deck's bottom side to bottom of deck array
		
		System.arraycopy(bd,0,deck,0,bd.length);  //copy bd to top of the main deck
		System.arraycopy(td,0,deck,rc+1,td.length); //copy td to bottom of the main deck
		
		
	}
	
	
	public boolean checkDeck(){
		boolean flag = false;
		for(int i = 0; i < deck.length ; i++){
			if(deck[i] != null){
				flag = true;
				break;
			}
		}
		return flag;
	}
		
		
		
		
		
				
}