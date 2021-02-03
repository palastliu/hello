package TicTacToe;

import java.util.Scanner;

public class PvP {     //player vs player

	static Scanner in = new Scanner(System.in);
	
	public PvP() {
		
	}
	
	public boolean getWhoStartPvP() { //randomly choose who start
		
		int random = (int) (Math.random() * 10);     //randomly get a number
		
		if(random < 5) {      //number<5 player1 first
			System.out.println("\nRandomly choose who start first : player 1\n");
			return true;   //player1 first start
			
		}else {              //number>5 player2 first
			System.out.println("\nRandomly choose who start first : player 2\n");
			return false;  //player2  first start
			
		}
		
	}
	//press x or o to choose your chess
	public boolean getXorOPvP(boolean WhoStartPvP) {
		
		Scanner in = new Scanner(System.in);
		char chess;
		boolean result = false;
		if(WhoStartPvP) {
			do {
				System.out.println("O or X , which chess player 1 want to choose ? (please enter 'X' or 'O') : ");
				chess = in.next().charAt(0);
				try {
					if(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o') {
						throw new IllegalArgumentException("player 1 cannot enter except 'O' or 'X'.");
					}
					else if(chess == 'O' || chess == 'o') {
						System.out.println("\nplayer 1 chess is O\nplayer 2 chess is X\n");
						result = true;
					}else{
						System.out.println("\nplayer 1 chess is X\nplayer 2 chess is O\n");
						result = false;
					}
				}catch(IllegalArgumentException ie){
					System.err.println(ie.getMessage());
				}
			}while(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o');
	    }else {
	    	do {
	    		System.out.println("O or X , which chess player 2 want to choose ? (please enter 'X' or 'O') : ");
	    		chess = in.next().charAt(0);
				try {
					if(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o') {
						throw new IllegalArgumentException("player 2 cannot enter except 'O' or 'X'.");
					}
					else if(chess == 'O' || chess == 'o') {
						System.out.println("\nplayer 2 chess is O\nplayer 1 is X\n");
						result = true;
					}else{
						System.out.println("\nplayer 2 chess is X\nplayer 1 is O\n");
						result = false;
					}
				}catch(IllegalArgumentException ie){
					System.err.println(ie.getMessage());
				}
			}while(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o');
	    }
		return result; 	
	}

	public void startGamePvP(boolean XorOPvP, boolean whoStartPvP) {
		//show the chess board
		int[][] storeChess = new int[3][3];
		boolean p1win = false;
		boolean p2win = false;
		int round = 0;
		int p1winNumber = 0;
		int p2winNumber = 0;
		int dogfallNumber = 0;
		char nextGame;
		do {       
			if(whoStartPvP) {
			//player1 first
		  game:for(int i = 0; i < 9; i++){
					round ++;  //if player 1 win  break 
					if(p1win == false && p2win == false && round < 10) {
						storeChess = getplayer1Put(storeChess);
						showChessBoard(storeChess, XorOPvP);
						p1win = player1Win(storeChess);
					}else {
						break game;
					}
					
					round ++;  //if player2 win break
					if(p1win == false && p2win == false && round < 10) {
						storeChess = getplayer2Put(storeChess);
						showChessBoard(storeChess, XorOPvP);
						p2win = player2Win(storeChess);
					}else {
						break game;
					}
					
					
				}
				
				if(p1win) {           //display the result if player1 win
					System.out.println("Congradulation, player 1 are winner!");
					p1winNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				}else if(p2win) {     //display the result if playeer2 win
					System.out.println("Congradulation, player 2 are winner!");
					p2winNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				}else {               //display the result if no one win
					System.out.println("Dogfall, nobady win.");
					dogfallNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				
				}
				p1win = false;
				p2win = false;
				//ask users if want to play again
				System.out.println("Do you want to play again? (please enter y or n) : ");
				nextGame = in.next().charAt(0);
				storeChess = new int[3][3];   //show the chess board 
				round = 0;
				if(nextGame == 'Y' || nextGame == 'y') {
					whoStartPvP = getWhoStartPvP();
				}
				
			}else {
          game:for(int i = 0; i < 9; i++){  //player2 first
                    round ++;// if player1 win break
					if(p1win == false && p2win == false && round < 10) {
						storeChess = getplayer2Put(storeChess);
						showChessBoard(storeChess, XorOPvP);
						p2win = player2Win(storeChess);
					}else {
						break game;
					}
					
					round ++;  //if player2 win break
					if(p1win == false && p2win == false && round < 10) {
						storeChess = getplayer1Put(storeChess);
						showChessBoard(storeChess, XorOPvP);
						p1win = player1Win(storeChess);
					}else {
						break game;
					}
					
				
				}
				
				if(p1win) {         //display the result if player1 win 
					System.out.println("Congradulation, player 1 are winner!");
					p1winNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				}else if(p2win) {   //display the result if player2 win
					System.out.println("Congradulation, player 2 are winner!");
					p2winNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				}else {             //display the result if no one win
					System.out.println("Dogfall, nobady win.");
					dogfallNumber++;
					System.out.println("player 1 win times: " + p1winNumber);
					System.out.println("player 2 win times: " + p2winNumber);
					System.out.println("dogfall times: " + dogfallNumber);
				
				}
				p1win = false;
				p2win = false;
				//ask users if want to play again
				System.out.println("Do you want to play again? (please enter y or n) : ");
				nextGame = in.next().charAt(0);
				storeChess = new int[3][3];
				round = 0;
				if(nextGame == 'Y' || nextGame == 'y') {
					whoStartPvP = getWhoStartPvP();
				}

			}
		}while(nextGame == 'Y' || nextGame == 'y');
		
		System.out.println("End");
	}
	
	//show the chess board
	public void showChessBoard(int[][] storePosition, boolean XorO) {
		
		if(XorO) {
			for(int i=0;i<3;i++){
              for(int j=0;j<3;j++){
                if(storePosition[i][j]==1)
                    System.out.print("| O |");
                else if(storePosition[i][j]==2)
                    System.out.print("| X |");
                else
                    System.out.print("|   |");
              }
            System.out.println("\n---------------");
            }System.out.println(" ");
		}else {
			for(int i=0;i<3;i++){
	              for(int j=0;j<3;j++){
	                if(storePosition[i][j]==1)
	                    System.out.print("| X |");
	                else if(storePosition[i][j]==2)
	                    System.out.print("| O |");
	                else
	                    System.out.print("|   |");
	              }
	            System.out.println("\n---------------");
	            }System.out.println(" ");
		}
	}
	
	public int[][] getplayer1Put(int[][] storeChess) {
		
		
		int putChess;
		boolean ifExistChess = false;
		do {		//enter 1-9 to choose position
			System.out.println("Please enter the 1-9 to put your chess : ");
			putChess = in.nextInt();
			try {
				if(putChess > 9 && putChess < 0) {        //oonce the number exceed the field throw exception
					throw new IllegalArgumentException("the number your entered is not correct, please enter again.");
				}else {
					int row = (putChess-1) / 3;            //get the row position
				    int colume = (putChess-1) % 3;         //get the column position
				    if(storeChess[row][colume] == 0) {
				    	storeChess[row][colume] = 1;
				    }else {
				    	ifExistChess = true;               //if exist chess throw exception
				    	throw new IllegalArgumentException("already eixst chess, please enter again.");
				    }
			
					return storeChess;
				}
			}catch(IllegalArgumentException ie){            //display the exception
				System.out.println(ie.getMessage());
			}
		}while(putChess > 9 || putChess < 0 || ifExistChess);    //loop part
		
		return storeChess;
		
	}
	
	public int[][] getplayer2Put(int[][] storeChess) {
		

		int putChess;
		boolean ifExistChess = false;
		do {		
			System.out.println("Please enter the 1-9 to put your chess : ");
			putChess = in.nextInt();
			try {
				if(putChess > 9 && putChess < 0) {
					throw new IllegalArgumentException("the number your entered is not correct, please enter again.");
				}else {
					int row = (putChess-1) / 3;            
				    int colume = (putChess-1) % 3; 
				    if(storeChess[row][colume] == 0) {
				    	storeChess[row][colume] = 2;
				    }else {
				    	ifExistChess = true;
				    	throw new IllegalArgumentException("already eixst chess, please enter again.");
				    }
			
					return storeChess;
				}
			}catch(IllegalArgumentException ie){
				System.out.println(ie.getMessage());
			}
		}while(putChess > 9 || putChess < 0 || ifExistChess);
		
		return storeChess;
		
	}
	//judge the win condition
	public boolean player1Win(int[][] StoreChess) {
		
		if( StoreChess[0][0] == 1 &&  StoreChess[0][1] == 1 &&  StoreChess[0][2] == 1 ||  //123
			StoreChess[1][0] == 1 &&  StoreChess[1][1] == 1 &&  StoreChess[1][2] == 1 ||  //456
			StoreChess[2][0] == 1 &&  StoreChess[2][1] == 1 &&  StoreChess[2][2] == 1) {  //789
			return true;
		}else if( StoreChess[0][0] == 1 &&  StoreChess[1][0] == 1 &&  StoreChess[2][0] == 1 ||  //147
			      StoreChess[0][1] == 1 &&  StoreChess[1][1] == 1 &&  StoreChess[2][1] == 1 ||  //258
			      StoreChess[0][2] == 1 &&  StoreChess[1][2] == 1 &&  StoreChess[2][2] == 1) {  //369
			return true;
		}else if( StoreChess[0][0] == 1 &&  StoreChess[1][1] == 1 &&  StoreChess[2][2] == 1 ||    //159
			      StoreChess[0][2] == 1 &&  StoreChess[1][1] == 1 &&  StoreChess[2][0] == 1 ) {   //357
			return true;
		}else {
			return false;
		}
	}
	//judge the win condition
	public boolean player2Win(int[][] StoreChess) {
		
		if( StoreChess[0][0] == 2 &&  StoreChess[0][1] == 2 &&  StoreChess[0][2] == 2 ||  //123
			StoreChess[1][0] == 2 &&  StoreChess[1][1] == 2 &&  StoreChess[1][2] == 2 ||  //456
			StoreChess[2][0] == 2 &&  StoreChess[2][1] == 2 &&  StoreChess[2][2] == 2) {  //789
			return true;
		}else if( StoreChess[0][0] == 2 &&  StoreChess[1][0] == 2 &&  StoreChess[2][0] == 2 ||  //147
			      StoreChess[0][1] == 2 &&  StoreChess[1][1] == 2 &&  StoreChess[2][1] == 2 ||  //258
			      StoreChess[0][2] == 2 &&  StoreChess[1][2] == 2 &&  StoreChess[2][2] == 2) {  //369
			return true;
		}else if( StoreChess[0][0] == 2 &&  StoreChess[1][1] == 2 &&  StoreChess[2][2] == 2 ||    //159
			      StoreChess[0][2] == 2 &&  StoreChess[1][1] == 2 &&  StoreChess[2][0] == 2 ) {   //357
			return true;
		}else {
			return false;
		}
	}
}
