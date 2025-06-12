import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

public class NathanBlackJack{
	public static void main(String[] args){
		//Name of the game and the size of the console
		Console con = new Console("BlackJack",1280,720);
		//Main Menu
		//Imports and tells where the image goes
		BufferedImage blackjacklogo = con.loadImage("BlackJacklogo.png");
		con.drawImage(blackjacklogo ,250,200);

		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");
		con.println("                                                       ");



		//Main Menu Text
		con.println("                                                            Welcome To Nathan's Blackjack!      ");
		con.println("                                                                                                ");
		con.println("                                                            Type To Choose                      ");
		con.println("                                                            (P) Play                            ");
		con.println("                                                            (L) LeaderBoard                     ");
		con.println("                                                            (H) Help                            ");
		con.println("                                                            (Q) Quit                            ");	
		
		char charMenu = con.getChar();
		
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		
		//Play
		//Naming
			int intPlayerMoney;
			String strPlayerName;
			if(charMenu == 'P' || charMenu == 'p'){
			con.println("");
			con.println("                                             Let's Play");
			con.print("Enter your name: ");
			strPlayerName = con.readLine();
			if(strPlayerName.equals("statitan")){
				intPlayerMoney = 2000;
			}else{
				intPlayerMoney = 1000;
			}
		//Game Start
		Random rand = new Random();
		boolean booplaying = true;
		
		while(booplaying && intPlayerMoney > 0){
			int[][] intdeck = new int[52][3];
			int intdeckIndex = 0;
			for(int suit = 1; suit <=4; suit++) {
				for(int value = 1; value <= 13; value++){
					intdeck[intdeckIndex][0] = value;
					intdeck[intdeckIndex][1] = suit;
					intdeck[intdeckIndex][2] = (int)(Math.random()*100 + 1); 
					intdeckIndex++;
				}
			}
			for (int intcount = 0; intcount < 52 - 1; intcount++) {  //FIX
				for (int intcount2 = 0; intcount2 < 52 - 1 - intcount; intcount2++){ //FIX
					if(intdeck[intcount2][2] > intdeck[intcount2 + 1][2]){ //FIX
						int[] inttemp = intdeck[intcount2];
						intdeck[intcount2] = intdeck[intcount2 + 1];
						intdeck[intcount2 + 1] = inttemp;
					}
				}
			}
			intdeckIndex = 0;
			
			//Betting
			con.println("You have $" +intPlayerMoney);
			con.print("Enter your bet: ");
			int intbet = con.readInt();
			if(intbet > intPlayerMoney || intbet <= 0){
				con.println("Invalid bet");
				continue;
				
			}
			
			int[] intPlayerHand = new int[5];
			int[] intPlayerSuits = new int[5];
			int[] intDealerHand = new int[5];
			int[] intDealerSuits = new int[5];
			int intPlayerCards = 2, intDealerCards = 1;
			
			intPlayerHand[0] = intdeck[intdeckIndex][0]; 
			intPlayerSuits[0] = intdeck[intdeckIndex++][1];
			intPlayerHand[1] = intdeck[intdeckIndex][0]; 
			intPlayerSuits[1] = intdeck[intdeckIndex++][1];
			intPlayerHand[0] = intdeck[intdeckIndex][0]; 
			intPlayerSuits[1] = intdeck[intdeckIndex++][1];
			
			//int intPlayerHand;
			//int intPlayerSuits;
			//String strgetCardName = NathanBlackJackMethod.getCardName(intPlayerHand, intPlayerSuits);
			intDealerHand[0] = intdeck[intdeckIndex][0]; 
			intDealerSuits[0] = intdeck[intdeckIndex++][1];
			
			//con.println("Your cards :" + getCardName(intPlayerHand[0], intPlayerSuits[0]) + ", " + getCardName(intPlayerHand[1], intPlayerSuits[1]));

			//Show your starting cards
			con.println("Your cards: " + NathanBlackJackMethod.getCardName(intPlayerHand[0], intPlayerSuits[0]) + " , " + NathanBlackJackMethod.getCardName(intPlayerHand[1], intPlayerSuits[1]));
			con.println("Dealer shows: " + NathanBlackJackMethod.getCardName(intDealerHand[0], intDealerSuits[0]));
			
			//Double down
			boolean blnDoubleDown = false;
			int intInitialSum;
			intInitialSum = NathanBlackJackMethod.getCardValue(intPlayerHand[0]) + NathanBlackJackMethod.getCardValue(intPlayerHand[1]);
			if(intInitialSum == 9 || intInitialSum == 10 || intInitialSum == 11){
				con.println("Double down? (y/n): ");
				if(con.getChar()== 'y'){
					blnDoubleDown = true;
					intbet = intbet * 2;
					intPlayerHand[intPlayerCards] = intdeck[intdeckIndex][0];
					intPlayerSuits[intPlayerCards++] = intdeck[intdeckIndex++][1];
	
		}
	}
	
	//ask to hit or stand 
	if(blnDoubleDown == false){
		boolean blnHit = true;
		while(blnHit && intPlayerCards < 5){
			con.println("Hit (h) or Stand (s): ");
			if(con.getChar() == 'h'){
				intPlayerHand[intPlayerCards] = intdeck[intdeckIndex][0];
				intPlayerSuits[intPlayerCards++] = intdeck[intdeckIndex++][1];
				con.println("Your cards: ");
				for(int intShow = 0; intShow < intPlayerCards; intShow++){
					con.println(NathanBlackJackMethod.getCardName(intPlayerHand[intShow], intPlayerSuits[intShow]) + " ");
				}
				con.println("");
				if(NathanBlackJackMethod.sumHand(intPlayerHand, intPlayerCards) > 21) break;
			}else{
				blnHit = false;
			}
		}
	}
	//dealer plays	
	int intPlayerTotal = NathanBlackJackMethod.sumHand(intPlayerHand, intPlayerCards);
	int intDealerTotal = NathanBlackJackMethod.sumHand(intDealerHand, intDealerCards);
	while(intDealerTotal < 17 && intDealerCards < 5){
		intDealerHand[intDealerCards] = intdeck[intdeckIndex][0];
		intDealerSuits[intDealerCards++] = intdeck[intdeckIndex++][1];
		intDealerTotal = NathanBlackJackMethod.sumHand(intDealerHand, intDealerCards);
	}
	//Show dealer cards
	con.println("Dealer Cards: ");
	for(int intShow = 0; intShow < intDealerCards; intShow++){
		con.println(NathanBlackJackMethod.getCardName(intDealerHand[intShow], intDealerSuits[intShow]));
	}
	//shows final cards
	con.println("Dealer total: " + intDealerTotal);
	con.println("Your total: " +intPlayerTotal);
	
	//checks who wins 
	int intPayout;
	if(intPlayerTotal > 21){
		con.println("You busted.");
		intPlayerMoney = intPlayerMoney - intbet;
	}else if (intDealerTotal > 1 || intPlayerTotal > intDealerTotal){
		if(intPlayerTotal == 21 && intPlayerCards == 2 ||intPlayerCards == 5){
			intPayout = intbet * 3;
		}else{ 
			intPayout = intbet* 2;
		}
		//Pays the winner
		con.println("You win $" + intPayout);
		intPlayerMoney = intPlayerMoney + intPayout;
	}else if(intPlayerTotal == intDealerTotal){
		con.println("Push! You get your moneyback");
	}else{ 
		con.println("Dealer Wins. BooHoo");
		intPlayerMoney = intPlayerMoney - intbet;
	}
	//Asks if you want to play agian
	con.print("Play agian? (y/n)");
	booplaying = con.getChar() == 'y';
	NathanBlackJackMethod.savetoleaderboard(strPlayerName, intPlayerMoney);

	}
}
		
		
		//Leaderboard
		}else if (charMenu == 'L' || charMenu == 'l'){
			con.println("");
			con.println("                                        Welcome to the Leaderboard");
				
		//Help
		}else if (charMenu == 'H' || charMenu == 'h'){
			con.println("");
			con.println("  TERMS                                              Help");
			con.println("- Double Down");
			con.println("- Bust                        - You are playing against the dealer");
			con.println("- Hit");
			con.println("- Stand      - Your goal is to get the closest to 21 without going over or to be higher than the dealer");
			con.println("- Split");
			con.println("- Bet                         - The dealer always hits below 17 so they must hit even at 16");
			con.println("- Hand");
			con.println("- Deck        - If you bust, you lose your bet, you get back your money if tied, if you win you get 2x ");
			con.println(" ");
			con.println("                              - If your first two cards equal to 21, you get 3x your money");
			con.println(" ");
			con.println("                              - If you get 5 cards without busting, you get 3x your money,");
			con.println("                                	if the dealer gets 5 cards, they win automatically");
			con.println(" ");
			con.println("                              - Double down if your first 2 cards add up to 9,10,11");
			con.println("                                but you only get 1 card after");
		//Quit
		}else if (charMenu == 'Q' || charMenu == 'q'){
			con.println("");
			con.println("                                        You quit Nathan's Blackjack");
		//Secret
		}else if (charMenu == 'S' || charMenu == 's'){
			con.println("");
			con.println("                                        You found the secret menu!");
			con.println("");
			con.println("                                      Why was Cinderella so bad at soccer?");
			con.println("                                      She kept running away from the ball!");
		//Missclick
		}else{
			con.println("");
			con.println("                                        Wrong key, restart program!!!");
		
		
		
		}
	}
}
