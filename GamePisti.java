import java.util.Scanner;
import java.util.Random;
public class GamePisti{
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		Random rd = new Random(System.currentTimeMillis());
		
		
		
		while(true) {
			Deck deck = new Deck();				//{
			Hand hand_computer = new Hand();
			Hand hand_player = new Hand();     //Adding objects to the main code
			Board board = new Board();         // }
			
			boolean flag = true;
			String choice;          //Adding variables for future codes
			int dealer;
			String [] cache_user = new String[52];
			String [] cache_computer = new String[52];
			int user_point = 0 ;
			int computer_point = 0;
			
			//
			System.out.println("\t THE GAME PİŞTİ \n");
			System.out.println("Press \"Q\" to quit the game");
			System.out.println("Or press anything except \"Q\" to start game");
			String Choice = inp.nextLine();
			System.out.println("\n");
			if(Choice.equals("q")){
				System.out.println("See you in next game");
				break;
			}
			//User İnterface
			System.out.println("We'll toss a coin to choose dealer");
			System.out.println("Head or Tail ? ");
			System.out.println("HİNT = Please type \"head\" or \"tail\" or I will choose your decision >:)") ;				
			choice = inp.nextLine();
			int head_tail= 0;  //1 = head    2 = tail
			if(choice.equals("head")){
				head_tail = 1;
			}else if(choice.equals("tail")){
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
			
			//Tossing coin to decide dealer
			
		     deck.Shuffle();   //shuffle method with array's displayer
			/* for(int i = 0; i < deck.get().length; i++){
				System.out.print(deck.get()[i] + " ");
			} 
			System.out.println("-------------------"); */
			 deck.cutDeck();  //cut method with array's displayer
			/* for(int i = 0; i < deck.get().length; i++){
				System.out.print(deck.get()[i] + " ");
			} */
			
			
			
			for(int i = 0; i< 4 ; i++){   //getting 4 card to the board
				board.getToBoard(deck.getCard());
			}
			
			
				if(dealer== 1) {

					for(int i = 0 ; i < 6 ; i ++) {
						if(i % 2 == 0) {
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
	
							//Turn user
							String card = hand_player.getFromHand(turnCh(board.get(),hand_player.get()));
							board.getToBoard(card);
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							
							
						}
						else if ( i % 2 == 1 ) {
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
						
						
						}
					
					}
					
					
					
					
					
					
					
					
				}else{
					
					
					
					
					for(int i = 0 ; i < 6 ; i ++) {
						if(i % 2 == 1) {
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
	
							//Turn user
							String card = hand_player.getFromHand(turnCh(board.get(),hand_player.get()));
							board.getToBoard(card);
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							
						}
						else if(i % 2 == 0) {
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
					
						}
					}
				}
		
		
		
		
		
	    }	
	}
	
	public static void showCache(String[] arr) { //showing the cache of the user or computer
		System.out.print("[");
		for(int i = 0 ; i< arr.length ; i++){
			if(arr[i] != null){
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	
	public static int turnCh(String[] board,String[] hand){ //turnCh = turn choice
		Scanner inp = new Scanner(System.in);
		System.out.println("Your turn mate!");
		showBoard(board);
		showHand(hand);
		int ch = 0;
		while(true){
			System.out.println("Choose your card to play");
			try {
			ch = inp.nextInt();
			} catch ( Exception e ) {	
				System.out.println("Invalid Syntax");
				turnCh(board, hand);
			}
			if(ch < 1 || ch > 4){
				System.out.println("There is no such a card choose carefully");
				continue;
			}else {
				break;
			}
		}
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
	
	public static void showDeck(String [] deck) { //Shows Deck
		System.out.println("THE DECK");
		System.out.print("top-->[");
		for(int i = deck.length-1 ; i > -1 ; i--){
			if(deck[i] != null){
				System.out.print(deck[i] + " ");
			}
		}
		System.out.print("]<--bottom");
		System.out.println("\n");
	}
	
	
	public static boolean check(String [] arr) { //Checking deck's empty indexes
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] != null){
				return false;
			}
		}
		return true;
	}
	
	
	public static void addToCache(String [] board , String [] cache , boolean a ) {
		if(a) {
			int temp = 0;
			for(int i = 0 ; i < cache.length ; i++) {
				if(cache[i] == null) {
					temp = i;
					break;
				}
			}	
			for(int j = 0 ; j < board.length ; j++) {
				if(board[j] == null) {
					System.arraycopy(board,0,cache,temp,j);
					break;
				}
			}
					
			}
		}
		
	
			
		
	
	
	public static boolean gameRules(String[] board , int point  ) {
		boolean flag = false;
		for(int i = board.length-1 ; i > -1 ; i--) {
			if(board[i] != null) {
				if(board[i].substring(1,board[i].length()).equals("J")) {
					flag = true;
					break;
				
				}else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) ) { //removing symbols and checking card name equality 
					flag = true;
					break;
				
				}else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) && i == 1) {
					point += 10;
					System.out.println("PİŞTİ!!");
					flag = true;
					break;
				}else {
					flag = false;
					break;
				}
				}
				
			}
			return flag;
		}
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
				
				
				
				
				
				
				
	
		
		
	
	
	
	
	
		
