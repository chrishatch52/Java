package backGroundProcesses;
	
/**
 * 
 */

/**
 * @author chrisubuntu
 *
 */
   public abstract class CompleteStack extends Modifiers implements
   	Stack<PlayerNode> {
      public final PlayerNode Finalhead = new CompleteStackFinal.FinalCompleteNode();
      @SuppressWarnings("unused")
      private static PlayerNode head;
   /**
    * 
    */
      public CompleteStack()
      {
         CompleteStack.head = Finalhead;
      }
   
      public class FinalCompleteNode extends PlayerNode
      {
      
         String name, pos, team;
         int yrsPlayed, projDepth, collDiv, injRisk, ffSchedRank,
         	numGamesMiss, QBrank, offStyle, numOtrStrs;
         double avgRank, avgPosRank, avgPtsLast2, shortShutt, threeCone,
         	broadJump, avgCollProd, avgRushAttLast2, avgCatLast2;
      	
         FinalCompleteNode()
         {
           this.prev = this.next = this;
         }
      
         public FinalCompleteNode(String name, String pos, String team, int yrsPlayed,
         	int projDepth, double avgRank, double avgPosRank, int injRisk,
         	int numGamesMiss, double avgPtsLast2, 
         	int collDiv, double threeCone,
         	double shortShutt, double broadJump,
         	double avgRushAttLast2, double avgCatLast2)
         {
        	 super(name, pos, team, yrsPlayed, projDepth,
						avgRank, avgPosRank, injRisk, numGamesMiss,
					   avgPtsLast2, 0, 0.0,0.0,0.0, avgRushAttLast2,
						avgCatLast2);
         	
         }
      
         FinalCompleteNode(PlayerNode newPlayer) {
         // TODO Auto-generated constructor stub
            this.name = newPlayer.name;
            this.pos = newPlayer.pos;
            this.team = newPlayer.team;
            this.yrsPlayed = newPlayer.yrsPlayed;
            this.projDepth = newPlayer.projDepth;
            this.avgRank = newPlayer.avgRank;
            this.avgPosRank = newPlayer.avgPosRank;
            this.injRisk = newPlayer.injRisk;
            this.numGamesMiss = newPlayer.numGamesMiss;
            this.avgPtsLast2 = newPlayer.avgPtsLast2;
            this.collDiv = newPlayer.collDiv;
            this.threeCone = newPlayer.threeCone;
            this.shortShutt = newPlayer.shortShutt;
            this.broadJump = newPlayer.broadJump;
            this.avgRushAttLast2 = newPlayer.avgRushAttLast2;
            this.avgCatLast2 = newPlayer.avgCatLast2;
         }
      
      
      }

	public abstract void push(PlayerNode curr2);
   }
