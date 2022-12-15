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
			
			
				if(dealer== 1) {  //dealer is computer

					for(int i = 0 ; i < 6 ; i ++) {
						
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
						for(int j = 0 ; j < 8 ; j++) {
							if(j % 2 == 0) {
							//Turn user
							String u_card = hand_player.getFromHand(turnCh(board.get(),hand_player.get()));
							board.getToBoard(u_card);
							if(gameRules(board.get(),user_point)) {
								System.out.println("YOU GET THE BOARD!");
							}
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							}
							else{
							//Turn Computer
							showHand(hand_computer.get());
							System.out.println("-------");
							String c_card = hand_computer.getFromHand(compDec(board.get(),hand_computer.get()));
							System.out.println(c_card);
							board.getToBoard(c_card);
							if(gameRules(board.get(),computer_point)) {
								System.out.println("I get the board!");
							}
							addToCache(board.get(),cache_computer,gameRules(board.get(),computer_point));
							}
						}
							
							
						
						
					
					
					}
					
					
					
					
					
					
					
					
				}else{ // dealer is you
					
					
					
					
					for(int i = 0 ; i < 6 ; i ++) {
						
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
						for(int j = 0 ; j < 8 ; j++) {
							if(j % 2 == 0) {
								
								
							//Turn Computer
							showHand(hand_computer.get());
							System.out.println("-------");
							String c_card = hand_computer.getFromHand(compDec(board.get(),hand_computer.get()));
							System.out.println(c_card);
							board.getToBoard(c_card);
							if(gameRules(board.get(),computer_point)) {
								System.out.println("I get the board!");
							}
							addToCache(board.get(),cache_computer,gameRules(board.get(),computer_point)); 
							
							
							}else{
								
								
								
							//Turn user
							String u_card = hand_player.getFromHand(turnCh(board.get(),hand_player.get()));
							board.getToBoard(u_card);
							if(gameRules(board.get(),user_point)) {
								System.out.println("YOU GET THE BOARD!");
							}
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							}
							
							
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
			}else if(hand[ch-1] == null){
				System.out.println("You have already played that card choose another");
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
		for(int i = 0 ; i < hand.length ; i++) {
			if(hand[i] != null) {
				System.out.print(hand[i] + ", ");
			}else {
				System.out.print(" #" + ", ");
			}
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
			
			for(int i = 0 ; i < board.length ; i++) {
				if(board[i] != null) {
					board[i] = null;
				}
					
			}
		}
	}
		
	
			
		
	
	
	public static boolean gameRules(String[] board , int point  ) {
        boolean flag = false;
        for(int i = board.length-1 ; i > -1 ; i--) {
            if(board[i] != null) {
                if(i >= 1) {

                if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) && i == 1) {
                    point += 10;
                    System.out.println("PİŞTİ!!");
                    flag = true;
                    break;
                }else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) ) { //removing symbols and checking card name equality
                        flag = true;
                        break;

                }else if(board[i].substring(1,board[i].length()).equals("J")) {
                flag = true;
                break;

				}
				}else {
                    flag = false;
                    break;
                }
            }
		}
        return flag;
        }
		
		
		public static int compDec(String [] board, String[] hand) {			//Decision of the computer //I hope its work
			Random rd = new Random(System.currentTimeMillis());
			boolean flag = false;
			int temp_index = 0;
			int rd_index = 0;
			
			for(int x = 0 ; x < hand.length ; x ++) {
				for(int y = 0 ; y < board.length ; y++) {
					if(hand[x] != null && board[y] != null){
						if(hand[x].substring(1,hand[x].length()).equals(board[y].substring(1,board[y].length()))) {
						temp_index = x;
						flag = true;
						break;
						}
					}
				}
			}
			
			
			int card_in_board = 0;
			for (int i = 0 ; i < board.length ; i++) {
				if(board[i] != null) {
					card_in_board += 1;
				}
			}
			
			
			if(card_in_board >= 3) {
				for(int h = 0 ; h < hand.length ; h++) {
					if(hand[h] != null) {
						if(hand[h].substring(1,hand[h].length()).equals("J")){
						return h+1;
						}
					}
				}
			}
			
			if(flag) {
				return (temp_index)+1;
			}
			
			while(true) {
				rd_index = rd.nextInt(4);
				if(hand[rd_index] != null) {
					break;
				}
			}
			return rd_index+1;
				
			
		}
		
		



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
				
				
				
				
				
				
				
	
		
		
	
	
	
	
	
		
