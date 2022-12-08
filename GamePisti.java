import java.util.Scanner;
import java.util.Random;
public class GamePisti{
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		Random rd = new Random(System.currentTimeMillis());
		
		
		
		while(true) {
			Deck deck = new Deck();
			Hand hand_computer = new Hand();
			Hand hand_player = new Hand();
			Board board = new Board();
			boolean flag = true;
			
			
			String choice;
			int dealer;
			
			
			System.out.println("\t THE GAME PİŞTİ \n");
			System.out.println("Press \"Q\" to quit the game");
			System.out.println("Or press anything except \"Q\" to start game");
			String Choice = inp.nextLine();
			System.out.println("\n");
			if(Choice.equals("q")){
				System.out.println("See you in next game");
				break;
			}
			System.out.println("We'll toss a coin to choose dealer");
			System.out.println("Head or Tail ? ");
			System.out.println("HİNT = Please type \"head\" or \"tail\" or I will choose your decision >:)") ;				
			choice = inp.nextLine();
			int head_tail= 0;  //1 = head    2 = tail
			if(choice.equals("head")){
				head_tail = 1;
			}else if(choice.equals("tai")){
				head_tail=2;
			}else{
				head_tail = rd.nextInt(2)+1;
			}
					
			int computer_random_choice= rd.nextInt(2)+1;
			
			if(computer_random_choice == head_tail){ //1 = dealer is computer      2 = dealer is player
				System.out.println("I am the dealer, You go first on each round");
				dealer = 1;
			}else{
				System.out.println("You are the dealer, I go first on each round");
				dealer = 2;
			}
			
			
			for(int i = 0; i< 4 ; i++){
				board.getToBoard(deck.getCard());
			}
			
			while(true){
				flag = deck.checkDeck();	
					if(flag == false){
					break;
				}
				if(dealer== 1) {
					hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
					hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
					System.out.println(turnCh(board.get(),hand_player.get()));
					
					
					
					
					
					
					
					
					
					
					
					
				}else{
					hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
					hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
					System.out.println(turnCh(board.get(),hand_player.get()));
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				
				
				
						
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			}
		
		
		
		
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
	
	
	public static int turnCh(String[] board,String[] hand){
		Scanner inp = new Scanner(System.in);
		System.out.println("Your turn mate!");
		showBoard(board);
		showHand(hand);
		System.out.println("Choose your card to play");
		int ch = inp.nextInt();
		return ch;
		
		
		
	
	}
	
	public static void showBoard(String [] board){ //Shows Board
		System.out.println("THE BOARD");
		System.out.print("top-->[");
		for(int i = board.length-1 ; i > -1 ; i--){
			if(board[i] != null){
				System.out.print(board[i] + " ");
			}
		}
		System.out.print("]<--bottom");
		System.out.println("\n");
	}
	
	
	
	
	
	public static void showHand(String[] hand){ //Shows Hand
		System.out.println("THE HAND");
		System.out.print("[");
		for(String a: hand) {
			System.out.print(a + ", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println(" 1   2    3    4 ");
		System.out.println("\n");
	}
		
}