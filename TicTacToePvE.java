package TicTacToe;

import java.util.Scanner;

public class TicTacToePvE {     //people vs computer
	static Scanner in = new Scanner(System.in);
	
	public TicTacToePvE() {
		
	}
	/*Liu yuhan
	 */
	public String chooseName(){
		//press number 0-4 to choose name
		String[] name = {"WANG", "LIU", "XIN", "YUHAN", "SINA"};       //store names in a array
		for(int i = 0; i < name.length; i++){
			System.out.println("No." + i + "'s name is : " + name[i]); //show the names
		}
		System.out.println("please enter No. to choose your name : ");

		int Numbering = in.nextInt();   //enter number to choose nickname
		do {  //if user entered name is greater than 4, throw exception then let user enter again
			try {
				if(Numbering > 4) {
					throw new IndexOutOfBoundsException("entered number cannot greater than 4");
				}		
			}catch(IndexOutOfBoundsException ie) {
					System.err.println(ie.getMessage());
					System.out.print("\nplease enter Numbering to choose your name: ");
					Numbering = in.nextInt();
			}
		}while(Numbering > 4);
		System.out.println("Your name is : " + name[Numbering]);    //show the nick name you chose
		return name[Numbering];

    }
	
	/*
	 * liu yuhan
	 */
	public boolean getWhoStart() {          //randomly choose who start
		
		int random = (int) (Math.random() * 10);  //randomly get a number
		
		if(random < 5) {                    //number<5 human first
			System.out.println("\nRandomly choose who start first : human\n");
			return true;   //human first start
			
		}else {                              //number>5 c first
			System.out.println("\nRandomly choose who start first : computer\n");
			return false;  //computer first start
			
		}
		
	}
	

	/*
	 * wang xin
	 */
	//press x or o to choose your chess
	public boolean getXorO() {
		System.out.println("O or X , which chess you want to choose ? (please enter 'X' or 'O')");
		Scanner in = new Scanner(System.in);
		char chess = in.next().charAt(0);
		boolean result = false;
		do {
			try {
				if(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o') {
					throw new IllegalArgumentException("you cannot enter except 'O' or 'X'.");
				}
				else if(chess == 'O' || chess == 'o') {
					System.out.println("\nyour chess is O\n");
					result = true;
				}else{
					System.out.println("\nyour chess is X\n");
					result = false;
				}
			}catch(IllegalArgumentException ie){
				System.err.println(ie.getMessage());
			}
		}while(chess != 'X' && chess != 'O' && chess != 'x' && chess != 'o');
		return result;
	}
	/*
	 * wang xin
	 */
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
	/*
	 * wang xin
	 */
	public int[][] getHumanPut(int[][] storeChess) {
		

		int putChess;
		boolean ifExistChess = false;
		do {		//enter 1- 9 to choose position
			System.out.println("Please enter the 1-9 to put your chess : ");
			putChess = in.nextInt();
			try {
				if(putChess > 9 && putChess < 0) {                  //oonce the number exceed the field throw exception
					throw new IllegalArgumentException("the number your entered is not correct, please enter again.");
				}else {
					int row = (putChess-1) / 3;             //get the row position
				    int colume = (putChess-1) % 3;          //get the column position
				    if(storeChess[row][colume] == 0) {
				    	storeChess[row][colume] = 1;
				    }else {
				    	ifExistChess = true;                //if exist chess throw exception
				    	throw new IllegalArgumentException("already eixst chess, please enter again.");
				    }
			
					return storeChess;
				}
			}catch(IllegalArgumentException ie){             //display the exception
				System.out.println(ie.getMessage());
			}
		}while(putChess > 9 || putChess < 0 || ifExistChess);  //loop part
		
		return storeChess;
		
	}
	/*
	 * WANG XIN
	 */
	//get the computer input
	public int[][] getComputerPut(int[][] storeChess){
		
		boolean ifExistChess = false;
		do {
			int putChess = 1+(int)(Math.random()*9);    //randomly choose the position
			
			int row = (putChess-1) / 3;            
			int colume = (putChess-1) % 3; 
			if(storeChess[row][colume] == 0) {
				storeChess[row][colume] = 2;
				ifExistChess = false;
			}else {
				ifExistChess = true;
			}
		}while(ifExistChess);
		
		return storeChess;
		
	}
	/*
	 * LIU YUHAN
	 */
	//judge the win condition
	public boolean humanWin(int[][] StoreChess) {
		
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
	//judge the computer win condition
	public boolean computerWin(int[][] StoreChess) {
		
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
	
	public void startGame(boolean xOrO) {          //display the chess board
		
		int[][] storeChess = new int[3][3];
		boolean hwin = false;
		boolean cwin = false;
		int round = 0;                            //the steps
		int hwinNumber = 0;
		int cwinNumber = 0;
		int dogfallNumber = 0;
		char nextGame;      
		/*
		 * wang xin
		 */
		do {
			boolean whoStart = getWhoStart();        //get who start
			if(whoStart) {

	       game:for(int i = 0; i < 9; i++){
	    	        round ++;
	    	        if(hwin == false && cwin == false && round < 10) {    //human first until one win
		    	        storeChess = getHumanPut(storeChess);
						showChessBoard(storeChess, xOrO);
						hwin = humanWin(storeChess);
	    	        }else {
	    	        	break game;
	    	        }
				
					round ++;
					if(hwin == false && cwin == false && round < 10) {
						storeChess = getComputerPut(storeChess);
						showChessBoard(storeChess, xOrO);
						cwin = computerWin(storeChess);
					}else {
						break game;
					}
				}
				/*
				 * liu yuhan
				 */
				if(hwin) {           //display the result if human win
					System.out.println("Congradulation, you are winner!");
					hwinNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}else if(cwin) {    //display the result if computer win
					System.out.println("Sorry, you are loser!");
					cwinNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}else {              //display teh result if no one win
					System.out.println("Dogfall, nobady win.");
					dogfallNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}
				hwin = false;
				cwin = false;
				//ask users if want to play again
				System.out.println("Do you want to play again? (please enter y or n) : ");
				nextGame = in.next().charAt(0);
				storeChess = new int[3][3];    //show the chess board 
				round = 0;
				/*
				 * WANG XIN
				 */
			}else {       //computer first until one win
		  game:for(int i = 0; i < 9; i++){     
			  		round ++;          
			  		if(hwin == false && cwin == false && round < 10) {
				  		storeChess = getComputerPut(storeChess);
						showChessBoard(storeChess, xOrO);
						cwin = computerWin(storeChess);
			  		}else {
			  			break game;
			  		}
			  		
			  		
			  		round ++;
			  		if(hwin == false && cwin == false && round < 10) {
				  		storeChess = getHumanPut(storeChess);
						showChessBoard(storeChess, xOrO);
						hwin = humanWin(storeChess);
			  		}else {
			  			break game;
			  		}
				}
				/*
				 * lIU YUHAN
				 */
				if(hwin) {        //display the result if human win
					System.out.println("Congradulation, you are winner!");
					hwinNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}else if(cwin) {    //display the result if computer win
					System.out.println("Sorry, you are loser!");
					cwinNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}else {            //display teh result if no one win
					System.out.println("Dogfall, nobady win.");
					dogfallNumber++;
					System.out.println("you win times: " + hwinNumber);
					System.out.println("computer win times: " + cwinNumber);
					System.out.println("Dogfall times: " + dogfallNumber);
				}
				hwin = false;
				cwin = false;
				System.out.println("Do you want to play again? (please enter y or n) : ");
				nextGame = in.next().charAt(0);
				storeChess = new int[3][3];
				round = 0;

			}
		}while(nextGame == 'Y' || nextGame == 'y');    //enter Y to restart the game       
		
		System.out.println("End");   //display if put n and display the result
		System.out.println("you win times: " + hwinNumber);
		System.out.println("computer win times: " + cwinNumber);
		System.out.println("Dogfall times: " + dogfallNumber);
	}
	
	
}




