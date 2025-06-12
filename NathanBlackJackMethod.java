import arc.*;

public class NathanBlackJackMethod{
	public static String getCardName(int intCardValue, int intCardSuit) {			
			String[] strSuits = {"Spades", "Hearts", "Diamonds", "Clubs"};
			String[] strFaces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
			return strFaces[intCardValue - 1] + " of " + strSuits[intCardSuit - 1];
	}
	
	public static int getCardValue (int intValue){
		if (intValue == 1) return 11;
		else if (intValue >=11) return 10;
		else return intValue;
	}
	
	public static int sumHand(int[] intHandArray, int intCardCount){
		int intSum = 0;
		int intAces = 0;
		for(int intLoop = 0; intLoop < intCardCount; intLoop++){
			int intValue = getCardValue(intHandArray[intLoop]);
			if(intValue == 11) intAces++;
				intSum = intSum + intValue;
		}
		while(intSum < 21 && intAces-- > 0) intSum = intSum - 10;
		return intSum;
	}
}
