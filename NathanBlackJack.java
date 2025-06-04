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
		boolean playing = true;
		
		while(playing && intPlayerMoney > 0){
			int[][] deck = new int[52][3];
			int deckIndex = 0;
			for(int suit = 1; suit <=4; suit++) {
				for(int value = 1; value <= 13; value++){
					deck[deckIndex][0] = value;
					deck[deckIndex][1] = suit;
					deck[deckIndex][2] = rand.nextInt(100) + 1;
					deckIndex++;
				}
			}
			for (int intcount = 0; intcount < 52 - 1; intcount++) {
				for (int intcount2 = 0; intcount2 < 52 - 1 - intcount; intcount2++){
					if(deck[intcount2][2] > deck[intcount2 + 1][2]){
						int[] temp = deck[intcount2];
						deck[intcount2] = deck[intcount2 + 1];
						deck[intcount2 + 1] = temp;
					}
				}
			}
			deckIndex = 0;
			
			con.println("You have $" +intPlayerMoney);
			con.print("Enter your bet: ");
			int intbet = con.readInt();
			if(intbet > intPlayerMoney || intbet <= 0){
				con.println("Invalid bet");
				continue;
				
			}
			
			int[] PlayerHand = new int[5];
			int[] PlayerSuits = new int[5];
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
