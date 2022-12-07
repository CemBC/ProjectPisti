import java.util.Scanner;
public class Hand{
	private String[] hand;
	
	public Hand() {
		String [] arr = new String[4];
		this.hand = arr;
	}
	
	public getFromHand(){
		Scanner inp = new Scanner(System.in);
		System.out.println("Which card do you want to play? Express it as 1,2,3 or 4 = ");
		int index = inp.nextInt()-1;
		return hand[index];
	}
		