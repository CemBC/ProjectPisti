public class Hand{
	private String[] hand;
	
	public Hand() {  //Constructor
		String [] arr = new String[4];
		this.hand = arr;
	}
	
	public String getFromHand(int index){  //getting card index from user and equalize that temporary value, then equalize that index to null so user cant chose that card anymore
		String temp;
		temp = hand[index-1];
		hand[index-1] = null;
		return temp;
	}
	
	public String[] get(){ //getting String[] hand
		return hand;
	}
		
	
	
	
	public void getToHand(String a, String b, String c, String d) { //Adding hand 4 card, I used simple code because ı already wrote the code that has called "getCard()" into the deck class
		hand[0] = a;
		hand[1] = b;
		hand[2] = c;
		hand[3] = d;
	}
}
	


			
		