package runProgram;
import java.io.File;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import playerPosRankingsTODO.PosRanks;

import backGroundProcesses.CompleteStackFinal;
import backGroundProcesses.MyTeam;
import backGroundProcesses.PlayerNode;
import backGroundProcesses.LeagueType;
import backGroundProcesses.Modifiers;





   public class TheDraft {
   
      protected static CompleteStackFinal newStack1Vets;
      protected static CompleteStackFinal newStack2Rookies;
      protected static MyTeam<PlayerNode> newTeam;
      protected static String name, pos, team, toRemove;
      protected static int yrsPlayed, projDepth, injRisk, numGamesMiss,
      	numOtrStrs, collDiv, offStyle, QBrank, ffSchedRank;
      protected static double avgRank, avgPosRank, avgPtsLast2, avgRushAttLast2,
      	avgCatLast2, broadJump, avgCollProd, threeCone, shortShutt;
      protected static CompleteStackFinal newStack;
      protected static CompleteStackFinal newStackLeft;
   	protected static CompleteStackFinal newStackRight;
   
      public static void main(String[] args)
      {
         @SuppressWarnings("resource")
         Scanner c = new Scanner(System.in);
         newTeam = new MyTeam<PlayerNode>();
         System.out.print("Enter your league name: ");
         String league = c.nextLine();
         System.out.print("Please enter your team name:  ");
         String team = c.nextLine();
         newTeam.teamName = team;
         System.out.print("Welcome " +team+ " to the 2013 " + league + " Fantasy Football Draft.\n");
         LeagueType newLeague = new LeagueType();
         newStack = new CompleteStackFinal();
         newStack1Vets = new CompleteStackFinal();
         newStack2Rookies = new CompleteStackFinal();
         
         
      
      
         if(newLeague.isKeeper())
         {
         
            do
            {
            
               try
               {
                  System.out.print("Please enter a name to remove from the list: --> q to quit  ");
                  toRemove = c.nextLine();
                  if((newStack.contains(toRemove))==true)
                     newStack.removePlayer(toRemove);
               
               
               }
                  catch(InputMismatchException e)
                  {
                  
                  }
            }
            while(!toRemove.equalsIgnoreCase("q"));
         }
      
         do
         {
         
         
         
            System.out.print("Enter your draft position 1-12:  ");
            if(isMockDraft())
            {
               new MockDraft<CompleteStackFinal>(newStack);
            }
            int draftPos = c.nextInt();
            c.nextLine();
         
            for(int i = 1; i < 13; i++)
            {
            
            
               System.out.println(newStack.toString());
               if(i==draftPos)
               {
                  System.out.print("Select a player from the list for your team: ");
                  String toAdd = c.nextLine();
                  if(toAdd.equalsIgnoreCase("quit"))
                     return;
                  System.out.println();
                  PlayerNode currNode;
                  for(currNode = newStack.Finalhead; currNode.next!=newStack.Finalhead; currNode = currNode.next);
                  newTeam.addToTeam(currNode, toAdd);
                  System.out.println(newTeam.detCurrNeed());
                  newStack.removePlayer(toAdd);
               
                  System.out.println(newTeam.toString());
                  System.out.println();
               }
               System.out.print("Enter last drafted player name: -->quit to exit  ");
               String remove = c.nextLine();
               if(remove==null)
                  System.exit(-1);
               if(remove.equalsIgnoreCase("quit"))
                  return;
               newStack.removePlayer(remove);
            }
         }
         while(theDraft(newStack));
      
      
      
      
      }
   
      private static boolean isMockDraft() {
      // TODO Auto-generated method stub
         return false;
      }
   
      private static boolean theDraft(CompleteStackFinal newTeam) {
      // TODO Auto-generated method stub
         if(newTeam.availSlots==0)
            return false;
      
         return true;
      }
   
   
   
   
      @SuppressWarnings("resource")
      public static CompleteStackFinal addPlayers(PosRanks newPos) {
         

      
        
         
            do {
 
               
               if(yrsPlayed==0)
               {
            	   PlayerNode tempRookie = newStack2Rookies.new FinalCompleteNode(name, pos, team, yrsPlayed,
																projDepth, avgRank, avgPosRank, 0, 0, 0.0,
																collDiv, threeCone, shortShutt, broadJump, 0.0, 0.0);
            	   newStack2Rookies.push(Modifiers.modify(tempRookie));
            	   newStack.push(Modifiers.modify(tempRookie));
               }
               if (yrsPlayed>0) {
               	  
                  PlayerNode veteran = newStack.new FinalCompleteNode(name, pos, team, yrsPlayed,
                		  											projDepth, avgRank, avgPosRank, 0, 0, 0.0,
                     												collDiv, threeCone, shortShutt, broadJump, 0.0, 0.0);
               		newStack1Vets.push(Modifiers.modify(veteran));
               		newStack.push(Modifiers.modify(veteran));
       
               }
            } while (newStack.size()<=200);
         
          
            
      		CompleteStackFinal temp1 = CompleteStackFinal.copy(newStack);
      		CompleteStackFinal temp2 = CompleteStackFinal.copy(newStack);
      		CompleteStackFinal temp3 = temp1.sort(temp1.Finalhead, newStack.size()/2);
      		temp1.sort2();
      		temp2.sort3(temp2.Finalhead);
      		System.out.println(temp3.toString());
      		System.out.println(temp2.toString());
      		System.out.println(temp1.toString());
      		System.out.println(newStack.toString());
      		
      		
         System.out.println(newStack1Vets.toString());
         System.out.println(newStack2Rookies.toString());
         return newStack;
      }
   }

