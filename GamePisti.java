import java.util.Scanner;
import java.util.Random;
public class GamePisti{
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		Random rd = new Random(System.currentTimeMillis());
		
		Deck deck = new Deck();
		Hand hand = new Hand();
		Board board = new Board();
		
		String ch;
		int dealer;
		
		while(true) {
			boolean flag = true;
			
			
			
			System.out.println("\t THE GAME PİŞTİ \n");
			System.out.println("Press \"Q\" to quit the game");
			System.out.println("Or press anything except \"Q\" to start game");
			String Choice = inp.nextLine();
			System.out.println("\n");
			if(Choice.equals("q")){
				System.out.println("See you in next game");
				break;
			}
			
			
			
			do{
				System.out.println("We'll toss a coin to choose dealer");
					System.out.println("Head or Tail ? ");
					System.out.println("HİNT = Please type \"head\" or \"tail\" or I will choose your decision >:)") ;
					choice = inp.nextLine();
					int head_tail= 0;  //1 = head    2 = tail;
					switch(choice){
						case "head":
						case "Head":
						case "HEAD":
							head_tail = 1;
							break;
						case "Tail":
						case "TAİL":
						case "tail":
							head_tail = 2;
							break;
						default:
							head_tail = rd.nextInt(2)+1;
							break;
						
					}
					
					int computer_random_choice = inp.nextInt(2)+1;
					
					if(computer_random_choice == head_tail){ //1 = dealer is computer      2 = dealer is player
						System.out.println("I am the dealer, You go first on each round");
						dealer = 1;
					}else{
						System.out.println("You are the dealer, I go first on each round");
						dealer = 2;
					}
						
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
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