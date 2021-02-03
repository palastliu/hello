package TicTacToe;

import java.util.Scanner;

public class Test {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		TicTacToePvE pve = new TicTacToePvE();  //create object
		PvP pvp = new PvP();
		//enter p or e to choose game model
		System.out.println("please enter letter to choose model (enter p to choose PvP, enter e to choose PvE) : ");
		char pOrE = in.next().charAt(0);
		/*
		 * wang xin
		 */
		do {
			try{//wrong input throw exception
				if(pOrE != 'p' && pOrE != 'e' && pOrE != 'P' && pOrE != 'E') {
					throw new IllegalArgumentException("wrong input, please enter p or e tp choose model.");
				}
			}catch(IllegalArgumentException ie){
				System.out.println(ie.getMessage());
			}
		}while(pOrE != 'p' && pOrE != 'e' && pOrE != 'P' && pOrE != 'E');
		/*
		 * liu yuhan
		 */
		if(pOrE == 'e' || pOrE == 'E') {  //if choose e player vs computer
			   String name = pve.chooseName();
		       boolean xOrO = pve.getXorO();
		       pve.startGame(xOrO);
		}
		if(pOrE == 'p' || pOrE == 'P') {  //if choose p player vs player
			
			boolean WhoStartPvP = pvp.getWhoStartPvP();
			boolean XorOPvP = pvp.getXorOPvP(WhoStartPvP);
			pvp.startGamePvP(XorOPvP, WhoStartPvP);
			
		}
		
	}
}
