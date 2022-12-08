import java.util.Scanner;
public class GamePisti{
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		
		Deck deck = new Deck();
		Hand hand = new Hand();
		Board board = new Board();
		
		while(true) {
			boolean flag = true;
			
			
			
			System.out.println("\t THE GAME PİŞTİ ");
			System.out.println("Press \"Q\" to quit the game");
			System.out.println("Or press anything except \"Q\" to start game");
			String Choice = inp.nextLine();
			if(Choice.equals("q")){
				System.out.println("See you in next game");
				break;
			}
			do{
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				flag = deck.checkDeck();
			}while(flag != false);
		
		
		
		
		}
	}
	
	public static void showCache(String[] arr) {
		System.out.print("[");
		for(int i = 0 ; i< arr.length ; i++){
			if(arr[i] != null){
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}