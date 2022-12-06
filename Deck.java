import java.util.Random;
public class Deck{
	private String[] deck;
	
	public Deck() {
		String [] arr = {"SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
		"CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK",
		"HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
		"DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK"};
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
		for(String a : deck) {
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