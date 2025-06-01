import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

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
		
		if(charMenu == 'P' || charMenu == 'p'){
			con.println("");
			con.println("                                             Let's Play");
		}else if (charMenu == 'L' || charMenu == 'l'){
			con.println("");
			con.println("                                        Welcome to the Leaderboard");
		}else if (charMenu == 'H' || charMenu == 'h'){
			con.println("Help");
		}else if (charMenu == 'Q' || charMenu == 'q'){
			con.println("");
			con.println("                                        You quit Nathan's Blackjack");
		}else{
			con.println("");
			con.println("                                        Wrong key, restart program!!!");
		
		
		}
	}
}
