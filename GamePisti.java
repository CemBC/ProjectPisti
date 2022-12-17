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
			System.out.println("\t\t\t ----THE GAME PİŞTİ ----\n");
			System.out.println("\t\t\t Press \"Q\" to quit the game");
			System.out.println("\t\t Or press anything except \"Q\" to start game");
			System.out.print("\t\t\t\t   ");
			String Choice = inp.nextLine();
			System.out.println("\n");
			if(Choice.equals("q")){
				System.out.println("See you in next game");
				break;
			}
			//User İnterface
			String name_user = "";
			while(true){
			System.out.print("Enter your name = ");
			name_user = inp.nextLine();
			System.out.println("Are you sure? y = yes / n = no ");
			String sure = inp.nextLine();
			if(sure.equals("y")) {
				System.out.println("Alright then!");
				break;
			}else{
				continue;
			}
			}
			System.out.println("\n");
			System.out.println("\t\t\tWe'll toss a coin to choose dealer");
			System.out.println("\t\t\t\t Head or Tail ? ");
			System.out.println("\t HİNT = Please type \"head\" or \"tail\" or I will choose your decision ^^") ;	
			System.out.print("\t\t\t\t   ");			
			choice = inp.nextLine();
			System.out.println("\n");	
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
				System.out.println("\t\t   I am the dealer, You go first on each round");
				System.out.println("\t\t\t\t You will cutting the deck\n\n");
				dealer = 1;
			}else{
				System.out.println("\t\t   You are the dealer, I go first on each round");
				System.out.println("\t\t\t\t I will cutting the deck\n\n");
				dealer = 2;
			}
			//Tossing coin to decide dealer
			System.out.println("\t\t\t\t Shuffling the deck");
			
				try {
					Thread.sleep(2000);
				}catch(InterruptedException ex) {
					System.out.println("Something went wrong");
				}
			
		     deck.Shuffle();   //shuffle method with array's displayer
			/* for(int i = 0; i < deck.get().length; i++){
				System.out.print(deck.get()[i] + " ");
			} 
			System.out.println("-------------------"); */
			System.out.println("\t\t\t\t Cutting the deck");
			
				try {
					Thread.sleep(2000);
				}catch(InterruptedException ex) {
					System.out.println("Something went wrong");
				}
			
			 deck.cutDeck();  //cut method with array's displayer
			/* for(int i = 0; i < deck.get().length; i++){
				System.out.print(deck.get()[i] + " ");
			} */
			
			System.out.println("\n");
			
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
							
							if(gameRules(board.get())) {
								System.out.println("\t\t\t   YOU GOT THE BOARD!\n");
							}
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							System.out.println("\n\n");
							}
							else{
							//Turn Computer
							System.out.println("\t\t\t\t MY TURN");
							String c_card = hand_computer.getFromHand(compDec(board.get(),hand_computer.get()));
							
								try {
									Thread.sleep(2000);
								}catch(InterruptedException ex) {
									System.out.println("Something went wrong");
								}
							
							System.out.println("\t\t\t   I have played " + c_card);
							board.getToBoard(c_card);
							if(gameRules(board.get())) {
								System.out.println("\t\t\t   I got the board!");
							}
							addToCache(board.get(),cache_computer,gameRules(board.get(),computer_point));
							System.out.println("\n\n");
							}
						}
							
							
						
						
					
					
					}
					
					
					
					
					
					
					
					
				}else{ // dealer is you
					
					showBoard(board.get());
					
					
					for(int i = 0 ; i < 6 ; i ++) {
							
							System.out.println("\t\t\tCards are being dealt\n\n");
							try {
								Thread.sleep(2000);
							}catch(InterruptedException ex) {
								System.out.println("Something went wrong");
							}
						
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
						for(int j = 0 ; j < 8 ; j++) {
							if(j % 2 == 0) {
								
								
							//Turn Computer
							System.out.println("\t\t\t\t MY TURN");
							String c_card = hand_computer.getFromHand(compDec(board.get(),hand_computer.get()));
							
								try {
									Thread.sleep(2000);
								}catch(InterruptedException ex) {
									System.out.println("Something went wrong");
								}
							
							System.out.println("\t\t\t   I have played " + c_card);
							board.getToBoard(c_card);
							if(gameRules(board.get())) {
								System.out.println("\t\t\t   I got the board!");
							}
							addToCache(board.get(),cache_computer,gameRules(board.get(),computer_point)); 
							System.out.println("\n\n");
							
							
							}else{
								
								
								
							//Turn user
							String u_card = hand_player.getFromHand(turnCh(board.get(),hand_player.get()));
							board.getToBoard(u_card);
							
							if(gameRules(board.get())) {
								System.out.println("\t\t\t   YOU GOT THE BOARD!\n");
							}
							addToCache(board.get(),cache_user,gameRules(board.get(),user_point));
							System.out.println("\n\n");
							}
							
							
						}
						
						
					}
				}
				
				System.out.println("\t\t\t\tGAME IS OVER\n\n");
				
				int numberOf_user = 0;
				int numberOf_computer = 0;
				for(int x = 0 ; x < cache_computer.length ; x++) {
					if(cache_computer[x] == null) {
						numberOf_computer = x;
						break;
					}
				}
				for(int y = 0 ; y < cache_user.length ; y++) {
					if(cache_user[y] == null) {
						numberOf_user = y;
						break;
					}
				}
				
				
				
				
				if(numberOf_computer > numberOf_user) {
					showCaches(cache_user,name_user);
					System.out.print("The Point Of " +name_user + " = ");
					System.out.println(pointCalculater(cache_user,user_point));
					System.out.println("\n");
					showCaches(cache_computer,"ME");
					System.out.print("The Point Of ME = ");
					System.out.print(pointCalculater(cache_computer,computer_point)+3);
					System.out.println("The Cards that have \"#\" sign at the end means PİSTİ");	
					System.out.println("\n");
					if(pointCalculater(cache_computer,computer_point)+3 > pointCalculater(cache_user,user_point)){
						System.out.println("\t\t\tThe Winner is ME!");
						System.out.println("\t\tYou can not defeat me, I am the master");
					}else{
						System.out.println("\t\t\tThe Winner is" + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");	
					}
				}else if(numberOf_computer  < numberOf_user) {
					showCaches(cache_user,name_user);
					System.out.print("The Point Of " +name_user + " = ");
					System.out.println(pointCalculater(cache_user,user_point)+3);
					System.out.println("\n");
					showCaches(cache_computer,"ME");
					System.out.print("The Point Of ME = ");
					System.out.print(pointCalculater(cache_computer,computer_point));
					System.out.println("The Cards that have \"#\" sign at the end means PİSTİ");	
					System.out.println("\n");
					if(pointCalculater(cache_computer,computer_point) > pointCalculater(cache_user,user_point)+3){
						System.out.println("\t\t\tThe Winner is ME!");
						System.out.println("\t\tYou can not defeat me, I am the master");
					}else{
						System.out.println("\t\t\tThe Winner is" + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");	
					}
				}else{
					showCaches(cache_user,name_user);
					System.out.print("The Point Of " +name_user + " = ");
					System.out.println(pointCalculater(cache_user,user_point));
					System.out.println("\n");
					showCaches(cache_computer,"ME");
					System.out.print("The Point Of ME = ");
					System.out.print(pointCalculater(cache_computer,computer_point));
					System.out.println();
					System.out.println("The Cards that have \"#\" sign at the end means PİSTİ");	
					System.out.println("\n");
					if(pointCalculater(cache_computer,computer_point) > pointCalculater(cache_user,user_point)){
						System.out.println("\t\t\tThe Winner is ME!");
						System.out.println("\t\tYou can not defeat me, I am the master");
					}else{
						System.out.println("\t\t\tThe Winner is" + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");	
					}
				}
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
	    }	
	}
	
	
	public static int pointCalculater(String [] cache , int point) {
		for(int i = 0 ; i < cache.length ; i++) {
			if(cache[i] != null){
				if(cache[i].charAt(cache[i].length()-1) != '#') {
					if(cache[i].equals("♦10")) {
						point += 3;
					}
					else if(cache[i].equals("♣2")){
						point += 2;
					}
					else{
						point += 1;
					}
				}
			}
		}
		return point;
	}
	
	
	
	
	public static int turnCh(String[] board,String[] hand){ //turnCh = turn choice
		Scanner inp = new Scanner(System.in);
		System.out.println("\t\t\t    Your turn mate!\n");
		showBoard(board);
		System.out.println();
		showHand(hand);
		int ch = 0;
		while(true){
			System.out.println("Choose your card to play");
			try {
			ch = inp.nextInt();
			if(ch < 1 || ch > 4){
				System.out.println("There is no such a card choose carefully");
				continue;
			}else if(hand[ch-1] == null){
				System.out.println("You have already played that card choose another");
				continue;
			}else {
				break;
			}
			} catch ( Exception e ) {	
				System.out.println("You should enter an integer not anything else, Try again");
				inp.nextLine();
			}
		}
			
			
		
		return ch;
	}
	
	public static void showBoard(String [] board){ //Shows Board
		System.out.println("\t\t\t\tTHE BOARD");
		System.out.print("\t\t\t");
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
		System.out.println("\t\t\t\tTHE HAND");
		System.out.print("\t\t\t   ");
		System.out.print("[");
		for(int i = 0 ; i < hand.length ; i++) {
			if(hand[i] != null) {
				if( i == hand.length-1) {
					System.out.print(hand[i]);
				}else {
					System.out.print(hand[i] + ", ");
				}
			}else {
				if( i == hand.length-1) {
					System.out.print("# ");
				}else {
					System.out.print("# " + ", ");
				}
			}
		}
		System.out.print("]");
		System.out.println();
		System.out.println("\t\t\t    1   2    3    4 ");
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
			if(board[2] == null) {
				int temp = 0;
				for(int i = 0 ; i < cache.length ; i++) {
					if(cache[i] != null) {
						temp = i;
					}
				}
				cache[temp] = board[0]+"#";
				cache[temp+1] = board[1]+"#";
			}else{
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
			for(int i = 0 ; i < board.length ; i++) {
				if(board[i] != null) {
					board[i] = null;
				}
					
			}
		}
	}
	
	public static void showCaches(String[] cache,String name) {
		System.out.println("THE CACHE OF " + name);
		System.out.print("[");
		for(int i = 0 ; i < cache.length ; i++) {
			if(cache[i] != null) {
				if(cache[i+1] == null) {
					System.out.print(cache[i]);
				}else{
					System.out.print(cache[i] + ", ");
				}
			}
		}
		System.out.print("]");
		System.out.println();
	}
		
	
			
		
	
	
	public static boolean gameRules(String[] board , int point  ) {
        boolean flag = false;
        for(int i = board.length-1 ; i > -1 ; i--) {
            if(board[i] != null) {
                if(i >= 1) {

                if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) && i == 1) {
                    point += 10;
                    System.out.println("\t\t\t\tPİŞTİ!!");
                    flag = true;
                    break;
                }else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) ) { //removing symbols and checking card name equality
                        flag = true;
                        break;

                }else if(board[i].substring(1,board[i].length()).equals("J")) {
                flag = true;
                break;

				}else {
                    flag = false;
                    break;
                }
				}
            }
		}
        return flag;
        }
		
	public static boolean gameRules(String[] board) { //Overriding the function
        boolean flag = false;
        for(int i = board.length-1 ; i > -1 ; i--) {
            if(board[i] != null) {
                if(i >= 1) {

                if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) && i == 1) {
                    flag = true;
                    break;
                }else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) ) { 
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
			
			//----------------------------------------
			
			if(flag) {
				return (temp_index)+1;
			}
			
			//----------------------------------------
			
			if(card_in_board >= 3) {
				for(int h = 0 ; h < hand.length ; h++) {
					if(hand[h] != null) {
						if(hand[h].substring(1,hand[h].length()).equals("J")){
						return h+1;
						}
					}
				}
			}
			
			//----------------------------------------
			
			while(true) {
				rd_index = rd.nextInt(4);
				if(hand[rd_index] != null) {
					break;
				}
			}
			return rd_index+1;
				
			
		}
		
		



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
				
				
				
				
				
				
				
	
		
		
	
	
	
	
	
		
