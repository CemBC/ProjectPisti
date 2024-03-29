import java.util.Random;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.FileWriter;
import java.util.Formatter;

public class GamePisti{
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		Random rd = new Random(System.currentTimeMillis());
		
		Formatter f = null;           //If there is no file as 'Top10' create that file with file writer and format that file with ' "" ' because ı dont want to append anything else when everytime game runs
		FileWriter fw = null;
		try{
			fw = new FileWriter("Top10",true);
			f = new Formatter(fw);
			f.format("");
			fw.close();
		}catch(Exception e) {
			System.out.println("Something went wrong");
		}finally{
			if(f != null) {
				f.close();
			}
		}
		
		
		while(true) {
			Deck deck = new Deck();				//{
			Hand hand_computer = new Hand();
			Hand hand_player = new Hand();     //Adding objects to the main code
			Board board = new Board();         // }
			
			
			String choice;          //Choice of the head or tail
			int dealer;				//variable dealer to control flow of the code
			String [] cache_user = new String[52];  //cache of the user
			String [] cache_computer = new String[52]; //cache of the computer
			int user_point = 0 ;                       //point of the user	
			int computer_point = 0;					//point of the computer
			
			
			
			//showing Top10 screen
			System.out.println("\t\t\t\t TOP 10 CHALLENGER");
			System.out.println("\t\t  -----------------------------------");
			Scanner reader = null;
			int player_size = 0;
			try{
				reader = new Scanner(Paths.get("Top10"));
				while(reader.hasNextLine()){
					if(player_size==10) {  //To show only first best 10 player
						break;
					}
					String[] splitted = reader.nextLine().split(",");
					System.out.println("\t\t\t"+(player_size+1)+". "+ splitted[0]+" -----> " + splitted[1]);
					player_size+= 1;
				}
			}catch(ArrayIndexOutOfBoundsException e) {  //if there is nothing to show on Top10 file that catch skips the exception
				System.out.println();
			}catch(IOException ex) {
				ex.printStackTrace();
			}finally{
				if(reader != null) {
					reader.close();
				}
			}
			System.out.println();
			//
			
			
			
					
			
			
					
			
			
			
			
			
			// Game interface
			System.out.println("\t\t\t ----THE GAME PISTI ----\n");
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
			 /*for(int i = 0; i < deck.get().length; i++){
				System.out.print(deck.get()[i] + " ");
			} */
			
			System.out.println("\n");
			
			for(int i = 0; i< 4 ; i++){   //getting 4 card to the board
				board.getToBoard(deck.getCard());
			}
			
			
			
				if(dealer== 1) {  //dealer is computer

					for(int i = 0 ; i < 6 ; i ++) {   //52 - 4 = 48         48 /8 = 6 , 6 times dealing cards
							System.out.println("\t\t\t\tTURN " + (i+1));
							System.out.println("\t\t\tCards are being dealt\n\n");
							try {
								Thread.sleep(1000);
							}catch(InterruptedException ex) {
								System.out.println("Something went wrong");
							}
						
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());  //dealing cards
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							
						for(int j = 0 ; j < 8 ; j++) { //each turn they are 8 cards in player hand so there will be  8 decision
							if(j % 2 == 0) {    //initial  player for each round
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
									Thread.sleep(1000);
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
					
					
					for(int i = 0 ; i < 6 ; i ++) {  //52 - 4 = 48         48 /8 = 6 , 6 times dealing cards
							System.out.println("\t\t\t\tTURN " + (i+1));
							System.out.println("\t\t\tCards are being dealt\n\n");
							try {
								Thread.sleep(2000);
							}catch(InterruptedException ex) {
								System.out.println("Something went wrong");
							}
						
							hand_computer.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());   //dealing cards
							hand_player.getToHand(deck.getCard(),deck.getCard(),deck.getCard(),deck.getCard());
							
						for(int j = 0 ; j < 8 ; j++) {  //each turn they are 8 cards in player hand so there will be  8 decision
							if(j % 2 == 0) {   //initial player for each round
								
								
							//Turn Computer
							System.out.println("\t\t\t\t MY TURN");
							String c_card = hand_computer.getFromHand(compDec(board.get(),hand_computer.get()));
							
								try {
									Thread.sleep(1000);
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
				//That code which is below takes number of cards for each player has
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
				
				
				
				showBoard(board.get());
				
				
				//Endgame Screen with adding 3 points for player who has more cards
				
				int temp_point = 0;
				if(numberOf_computer > numberOf_user) {
					temp_point = pointCalculater(cache_user,user_point);
					showCaches(cache_user,name_user);
					System.out.print("The Point Of " +name_user + " = ");
					System.out.println(pointCalculater(cache_user,user_point));
					System.out.println("\n");
					showCaches(cache_computer,"ME");
					System.out.print("The Point Of ME = ");
					System.out.print(pointCalculater(cache_computer,computer_point)+3);
					System.out.println();
					System.out.println("The Cards that have \"#\" sign at the end means PİSTİ");	
					System.out.println("\n");
					if(pointCalculater(cache_computer,computer_point)+3 > pointCalculater(cache_user,user_point)){
						System.out.println("\t\t\tThe Winner is ME!");
						System.out.println("\t\tYou can not defeat me, I am the master");
					}else{
						System.out.println("\t\t\tThe Winner is " + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");	
					}
				}else if(numberOf_computer  < numberOf_user) {
					temp_point = pointCalculater(cache_user,user_point)+3;
					showCaches(cache_user,name_user);
					System.out.print("The Point Of " +name_user + " = ");
					System.out.println(pointCalculater(cache_user,user_point)+3);
					System.out.println("\n");
					showCaches(cache_computer,"ME");
					System.out.print("The Point Of ME = ");
					System.out.print(pointCalculater(cache_computer,computer_point));
					System.out.println();
					System.out.println("The Cards that have \"#\" sign at the end means PİSTİ");	
					System.out.println("\n");
					if(pointCalculater(cache_computer,computer_point) > pointCalculater(cache_user,user_point)+3){
						System.out.println("\t\t\tThe Winner is ME!");
						System.out.println("\t\tYou can not defeat me, I am the master");
					}else{
						System.out.println("\t\t\tThe Winner is " + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");	
					}
				}else{
					temp_point = pointCalculater(cache_user,user_point);
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
						System.out.println("\t\t\t Another Game?\n\n");
					}else{
						System.out.println("\t\t\tThe Winner is " + name_user+ "!");
						System.out.println("\t\t\tLuckiest win HA?");
						System.out.println("\t\t\t Another Game?\n\n");
					}
				}
				
					//At the code which is below Top10 list have read by code and store them in to the Score class than into tha class's array
					//After that that array have bubble sorted to format Top10 file appropriately
					//Then formatted the Top10 file by using Player's array thus display of the top10 player will be shown sequentially
					Score[] scores = new Score[10];
					scores[0] = new Score(name_user,temp_point);
					int size = 1;
					reader = null;
					try{          //reading and storing into array
						reader = new Scanner(Paths.get("Top10"));
						while(reader.hasNextLine()) {
							if(size == scores.length) {
								Score[] old = scores;
								scores = new Score[size*2];
								System.arraycopy(old,0,scores,0,size);
							}
							String[] splitted = reader.nextLine().split(",");
							scores[size++] = new Score(splitted[0],Integer.parseInt(splitted[1]));
						}
					}catch(IOException e) {
						e.printStackTrace();
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println();
					}finally{
						if(reader != null) {
							reader.close();
						}
					}
				
					for(int i = 0; i < scores.length-1 ; i++) {  //bubble sort
						boolean swapped = false;
						Score temp_score = null;
						for(int j = 0 ; j < scores.length-1 ; j++) {
							if(scores[j+1] != null) {
								if(scores[j].isSmaller(scores[j+1])) {
									temp_score = scores[j];
									scores[j] = scores[j+1];
									scores[j+1] = temp_score;
									swapped = true;
								}
							}
						}
						if(!swapped) { break; }
					}
				
					f = null;
					try{           //Formating top10 file
						f = new Formatter("Top10");
						for(int i = 0; i < scores.length ; i++) {
							if(scores[i] != null) {
								f.format("%s,%d\n",scores[i].getName(),scores[i].getScore());
							}
						}
					}catch(Exception ex) {
						System.out.println("Something went wrong");
					}finally{
						if(f != null) {
							f.close();
						}
					}
					
						
				
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
	    }	
	}
	
	
	public static int pointCalculater(String [] cache , int point) { //point calculator
		for(int i = 0 ; i < cache.length ; i++) {
			if(cache[i] != null){
				if(cache[i].charAt(cache[i].length()-1) == '#') {   //İf card has  '#' end of it that means this card is pişti card, each pişti card is 5 point because there will  be 2 cards for each pişti
					point += 5;
				}else{
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
			if(ch < 1 || ch > 4){						//ArrayIndexOutOfBoundsException with if else
				System.out.println("There is no such a card choose carefully");
				continue;
			}else if(hand[ch-1] == null){              //playing played card Exception
				System.out.println("You have already played that card choose another");
				continue;
			}else {
				break;
			}
			} catch ( Exception e ) {				//Exception for entering string
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
	
	public static void showDeck(String [] deck) { //Shows Deck , I didnt use that in source code just check for flow and functions affect
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
	
	
	public static boolean check(String [] arr) { //Checking deck's empty indexes, I didnt use that either, just to check flow of code
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] != null){
				return false;
			}
		}
		return true;
	}
	
	
	public static void addToCache(String [] board , String [] cache , boolean a ) { //adding cache by boolean came from gameRules
		if(a) {
			int temp = 0;
				for(int i = 0 ; i < cache.length ; i++) {
					if(cache[i] == null) {
						temp = i;
						break;
					}
				}
				
				
			if(board[2] == null) {				//If its pişti adding card with # , If its not (for Example you throw J on board when board has only one card) it adds normally 
				if(board[0].substring(1).equals(board[1].substring(1))){
				cache[temp] = board[0]+"#";
				cache[temp+1] = board[1]+"#";
				}else{
					cache[temp] = board[0];
					cache[temp+1] = board[1];
				}
			}else{
			
			
			for(int j = 0 ; j < board.length ; j++) {  //getting boards first null index
				if(board[j] == null) {
					System.arraycopy(board,0,cache,temp,j);  //copying board to the cache
					break;
				}
			}
			}
			
			for(int i = 0 ; i < board.length ; i++) {   //deleting board
				if(board[i] != null) {
					board[i] = null;
				}
					
			}
		}
	}
	
	public static void showCaches(String[] cache,String name) {  //Shows cache of the player or computer
		System.out.println("THE CACHE OF " + name);
		System.out.print("[");
		for(int i = 0 ; i < cache.length-1 ; i++) {
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
		
	
			
		
	
	
	public static boolean gameRules(String[] board , int point  ) {  //returns boolean for addToCache
        boolean flag = false;
        for(int i = board.length-1 ; i > -1 ; i--) {
            if(board[i] != null) {
                if(i >= 1)     //If there is no card on the board there will be an NullException, that if flow checks that

                if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) && i == 1) { //Pişti suitation
                    System.out.println("\t\t\t\tPISTIIII!!");
                    flag = true;
                    break;
                }else if(board[i].substring(1,board[i].length()).equals(board[i-1].substring(1,board[i-1].length())) ) { //removing symbols and checking card name equality
                        flag = true;
                        break;

                }else if(board[i].substring(1,board[i].length()).equals("J")) {     //"J" suitation
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
        
        
		
	public static boolean gameRules(String[] board) { //Overriding the function to print "gettingboard" line // In the beginning of the project there was point adder into tha gameRules function, after I 
													  //have finished the project I deleted that, I didnt want to mixed up everything so the code is still using that function however it's meanless
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

				}else {
                    flag = false;
                    break;
                }
				}
            }
		}
        return flag;
        }
		
		
		public static int compDec(String [] board, String[] hand) {			//Decision of the computer 
			Random rd = new Random(System.currentTimeMillis());
			boolean flag = false;
			int temp_index = 0;
			int rd_index = 0;
			
			//----------------------------------------
			
			for(int y = board.length-1 ; y > -1 ; y--) {
				if(board[y] != null) {
					for(int x = 0 ; x < hand.length ; x ++) {   //choosing matches index
						if(hand[x] != null){
							if(hand[x].substring(1).equals(board[y].substring(1))) {
								temp_index = x;
								flag = true;
								break;
							}
						}
					}
					break;
				}
				
			}
			
			
			if(flag) {                    //returning matched index
				return (temp_index)+1;
			}
			
			
			
			
			
			
			//----------------------------------------
			int card_in_board= 0;                      //ıf there is more than 2 cards on the board computer will throw a "J" card if it has
			for(int i = 0 ; i < board.length ; i++) {
				if(board[i] != null) {
					card_in_board += 1;
				}
			}
				
			
			if(card_in_board >= 3 ) {
				for(int j = 0 ; j < hand.length ; j++) {
					if(hand[j] != null) {
						if(hand[j].substring(1).equals("J")) {
							return j+1;
						}
					}
				}
			}
			
			
			//----------------------------------------
			
			while(true) {                    //If nothing matches and no "J" throwing random card
				rd_index = rd.nextInt(4);
				if(hand[rd_index] != null) {
					break;
				}
			}
			return rd_index+1;
				
			
		}
		
		



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
				
				
				
				
				
				
				
	
		
		
	
	
	
	
	
		
