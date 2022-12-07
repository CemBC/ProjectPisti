import java.util.Scanner;
public class Hand{
	private String[] hand;
	
	public Hand() {
		String [] arr = new String[4];
		this.hand = arr;
	}
	
	public getFromHand(){
		Scanner inp = new Scanner(System.in);
		while(true){
			String temp;
			System.out.println("Which card do you want to play? Express it as 1,2,3 or 4 = ");
			int index = inp.nextInt()-1;
			if(hand[index] == null){
				System.out.println("You dont have a card on that position, try again");
				continue;
			}
			temp = hand[index];
			hand[index] = null;
		}
		return temp;
	}
	
	public getToHand(String a, String b, String c, String d) {
		hand[0] = a;
		hand[1] = b;
		hand[2] = c;
		hand[3] = d;
	}
	
}

			
		