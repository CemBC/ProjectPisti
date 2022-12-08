import java.util.Scanner;
public class Hand{
	private String[] hand;
	
	public Hand() {
		String [] arr = new String[4];
		this.hand = arr;
	}
	
	public String getFromHand(int index){  //getting card index from user and equalize that temporary value, then equalize that index to null so user cant chose that card anymore
		Scanner inp = new Scanner(System.in);
		String temp;
		temp = hand[index-1];
		hand[index-1] = null;
		return temp;
	}
	
	public String[] get(){
		return hand;
	}
		
	
	
	
	public void getToHand(String a, String b, String c, String d) { //Adding hand 4 card, I used simple code because user gets card when user's hand is empty
		hand[0] = a;
		hand[1] = b;
		hand[2] = c;
		hand[3] = d;
	}
}
	


			
		