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
	public  static void displayLeaderboard(Console con){
		TextInputFile leaderboardfile = new TextInputFile("leaderboard.txt");
		con.println("Money Leaderboard:");
		
		while(leaderboardfile.eof() == false){
			String strplayerName = leaderboardfile.readLine();
			int intplayerMoney = leaderboardfile.readInt();
			con.println(strplayerName + " - $" + intplayerMoney);
		}
		
		leaderboardfile.close();
	}
	
	public static void savetoleaderboard(String name, int money){
		TextInputFile leaderboardFile = new TextInputFile("leaderboard.txt");
		String[] strplayerNames = new String[100];
		int[] intplayerMoney = new int[100];
		int intplayercount = 0;
		
		while(leaderboardFile.eof() == false){
			strplayerNames[intplayercount] = leaderboardFile.readLine();
			intplayerMoney[intplayercount] = leaderboardFile.readInt();
			intplayercount++;
		}
		
		leaderboardFile.close();
		
		strplayerNames[intplayercount] = name;
		intplayerMoney[intplayercount] = money;
		intplayercount++;
		
		bubbleSort(strplayerNames, intplayerMoney, intplayercount);
		
		TextOutputFile leaderboardOutputFile = new TextOutputFile("leaderboard.txt", false);
		for(int count = 0; count < intplayercount; count++){
			leaderboardOutputFile.println(strplayerNames[count]);
			leaderboardOutputFile.println(intplayerMoney[count]);
		}
		
		leaderboardOutputFile.close();
	}
	
	public static void bubbleSort(String [] strNames, int[] intMoney, int intSize){
		for(int intOuter = 0; intOuter < intSize - 1; intOuter++){
			for(int intInner = 0; intInner < intSize - 1 - intOuter; intInner++){
				if(intMoney[intInner] < intMoney[intInner + 1]){
					int intTempMoney = intMoney[intInner];
					intMoney[intInner] = intMoney[intInner + 1];
					intMoney[intInner + 1] = intTempMoney;
					
					String strTempName = strNames[intInner];
					strNames[intInner] = strNames[intInner + 1];
					strNames[intInner + 1] = strTempName;
				}
			}
		}
	}
}
