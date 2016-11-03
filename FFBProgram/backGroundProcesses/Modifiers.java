package backGroundProcesses;

	import java.util.*;
	

   public class Modifiers extends NFLTeam  {
   
      static final double _Six = 0.6;
      static final double _Five = 0.5;
      static final double _Four = 0.4;
      static final double _Three = 0.3;
      static final double _Two = 0.2;
      static final double _One = 0.1;
      static final boolean isPPR = CompleteStackFinal.isPPR;
      static final boolean isKeeper = CompleteStackFinal.isKeeper;
		public static String teamNameMOD;
		public static int QBrankMOD, ffSchedRankMOD, OffRankMOD,
				 	  DefRankMOD, OffStyleMOD, numStarsMOD;
 
      public static PlayerNode modify(PlayerNode veteran) {
         PlayerNode modified;
			
			
			if(veteran!=null)
			for(Team team : ListOfNFLTeams)
			{
				if(veteran.team.equalsIgnoreCase(team.teamName))
				{
					teamNameMOD = team.teamName;
					QBrankMOD = team.QBrank1;
					ffSchedRankMOD = team.ffSchedRank1;
					OffRankMOD = team.OffRank1;
					DefRankMOD = team.DefRank1;
					OffStyleMOD = team.OffStyle1;
					if(veteran.avgRank < 75.0)
						numStarsMOD = team.numStars1 - 1;
						
					numStarsMOD = team.numStars1;
					
				}
			}
			
         if (veteran.yrsPlayed == 0) {
            modified = modifyRookie(veteran);
         } 
         else {
            modified = modifyPlayer(veteran);
         }
         return modified;
      }
   
      @SuppressWarnings("resource")
	public static PlayerNode modifyPlayer(PlayerNode newPlayer) {
      	
			Scanner c;
			
			try
			{	
				c = new Scanner(System.in);
				System.out.println("Is this a Dynasty Keeper League? Y/N");
				String isDynasty = c.nextLine();
				if(isDynasty.equalsIgnoreCase("y"))
				{
					if(newPlayer.yrsPlayed<=4)
						newPlayer.avgRank = newPlayer.avgRank - _Three;
						
					
				}
			}
				catch(InputMismatchException e)
				{
					System.out.println("You did not hit Y or N. \n" + 
											 "Would you like to try again? Y or enter to continue.");
								c = new Scanner(System.in);
								String retry = c.nextLine();
								if(retry.equalsIgnoreCase("y"))
									newPlayer.avgRank = newPlayer.avgRank - _Three;

									
				}
			
      	if(newPlayer.yrsPlayed<=4)
				if(newPlayer.yrsPlayed<2)
					{
						newPlayer.avgRank = newPlayer.avgRank + _Six;
					}
					else
					{
						newPlayer.avgRank = newPlayer.avgRank - _Three;
					}
         if (QBrankMOD < 16) {
            newPlayer.avgRank = newPlayer.avgRank - _Five;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Five;
         }
         if (ffSchedRankMOD < 16) {
            newPlayer.avgRank = newPlayer.avgRank - _Six;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Six;
         }
         if (numStarsMOD < 2) {
            newPlayer.avgRank = newPlayer.avgRank - _Four;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Four;
         }
         if (newPlayer.projDepth < 2) {
            newPlayer.avgRank = newPlayer.avgRank - _Three;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Three;
         }
         if (newPlayer.avgPtsLast2 > 300) {
            newPlayer.avgRank = newPlayer.avgRank - _Six;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Six;
         }
         if (newPlayer.avgRushAttLast2 > 200) {
            if(newPlayer.avgRushAttLast2 > 250)
            {
               newPlayer.avgRank = newPlayer.avgRank - _Three;
            }
            if(newPlayer.avgRushAttLast2 > 300)
            {
               newPlayer.avgRank = newPlayer.avgRank - _Three;
            }
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Three;
         }
         if (newPlayer.offStyle == 1) {
            if (newPlayer.pos.equals("RB"))
               newPlayer.avgRank = newPlayer.avgRank - _Four;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _One;
         }
         if (newPlayer.offStyle == 2) {
            if (newPlayer.pos.equals("WR") || newPlayer.pos.equals("TE"))
               newPlayer.avgRank = newPlayer.avgRank - _Four;
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _One;
         }
         if (newPlayer.avgCatLast2 > 45) {
            if (newPlayer.pos.equals("RB"))
               newPlayer.avgRank = newPlayer.avgRank - _Two;
            if(isPPR)
               newPlayer.avgRank = newPlayer.avgRank - _Two;
         		
         
            if (newPlayer.avgCatLast2 > 55) {
               if (newPlayer.pos.equals("TE"))
                  newPlayer.avgRank = newPlayer.avgRank - _Two;
               if(isPPR)
                  newPlayer.avgRank = newPlayer.avgRank - _Two;
            
               if (newPlayer.avgCatLast2 > 70) {
                  if (newPlayer.pos.equals("WR"))
                     newPlayer.avgRank = newPlayer.avgRank - _Two;
                  if(isPPR)
                     newPlayer.avgRank = newPlayer.avgRank - _Two;
               }
            }
         } 
         else {
            newPlayer.avgRank = newPlayer.avgRank + _Two;
         }
         return newPlayer;
      
      }
   
   
      public static boolean ifIsPPR() {
      // TODO Auto-generated method stub
         if(isPPR)
         {
            return true;
         }
         return false;
      }
   
      public static boolean ifIsKeeper()
      {
         if(isKeeper)
         {
            return true;}
         return false;
      }
      public static PlayerNode modifyRookie(PlayerNode veteran) {
         if (veteran.QBrank < 16) {
            veteran.avgRank = veteran.avgRank - _Five;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Five;
         }
      
         if (veteran.ffSchedRank < 16) {
            veteran.avgRank = veteran.avgRank - _Six;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Six;
         }
      
         if (veteran.numOtrStrs < 2) {
            veteran.avgRank = veteran.avgRank - _Four;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Four;
         }
      
         if (veteran.projDepth < 2) {
            veteran.avgRank = veteran.avgRank - _Three;
         }
         veteran.avgRank = veteran.avgRank + _Three;
         if (veteran.collDiv > 6) {
            veteran.avgRank = veteran.avgRank - _Six;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Six;
         }
      
      
         if (veteran.offStyle == 1) {
            if (veteran.pos.equals("RB"))
               veteran.avgRank = veteran.avgRank + _One;
         }
         else
         {
            veteran.avgRank = veteran.avgRank - _Three;
         }
      
         if (veteran.offStyle == 2) {
            if (veteran.pos.equals("RB")) {
               veteran.avgRank = veteran.avgRank - _Three;
            }
            else
            {
               veteran.avgRank = veteran.avgRank + _One;
            }
         }
         if (veteran.threeCone < 7.00) {
            veteran.avgRank = veteran.avgRank - _Two;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Two;
         }
         if (veteran.broadJump > 125) {
            veteran.avgRank = veteran.avgRank - _Two;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Two;
         }
      
         if (veteran.shortShutt < 4.55) {
            veteran.avgRank = veteran.avgRank - _Two;
         }
         else
         {
            veteran.avgRank = veteran.avgRank + _Two;
         }
         return veteran;
      
      }
		
   }
