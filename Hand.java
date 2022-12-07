import java.util.Scanner;
public class Hand{
	private String[] hand;
	
	public Hand() {
		String [] arr = new String[4];
		this.hand = arr;
	}
	
	public String getFromHand(int index){
		Scanner inp = new Scanner(System.in);
		String temp;
		temp = hand[index-1];
		hand[index-1] = null;
		return temp;
	}
		
	
	public void showHand(){
		for(String a: hand) {
			System.out.print(a + " ");
		}
	}
	
	public void getToHand(String a, String b, String c, String d) {
		hand[0] = a;
		hand[1] = b;
		hand[2] = c;
		hand[3] = d;
	}
	
}

			
		