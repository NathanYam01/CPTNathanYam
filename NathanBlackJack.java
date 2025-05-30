import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class NathanBlackJack{
	public static void main(String[] args){
		Console con = new Console("BlackJack",1280,720);
		BufferedImage blackjacklogo = con.loadImage("BlackJacklogo.png");
		con.drawImage(blackjacklogo ,100,100);
		con.repaint();
	}
}
