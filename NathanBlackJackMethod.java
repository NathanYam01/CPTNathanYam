import arc.*;

public class NathanBlackJackMethod{
	public static String getCardName(int intCardValue, int intCardSuit) {
			String[] strSuits = {"Spades", "Hearts", "Diamonds", "Clubs"};
			String[] strFaces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
			return strFaces[intCardValue - 1] + " of " + strSuits[intCardSuit - 1];
	}
}
