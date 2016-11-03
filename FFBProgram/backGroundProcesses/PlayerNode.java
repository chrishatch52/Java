package backGroundProcesses;
   public abstract class PlayerNode {
      public PlayerNode prev;
      public String name;
	public String pos;
	protected String team;
      protected int yrsPlayed, projDepth, collDiv, injRisk, ffSchedRank,
      	numGamesMiss, QBrank, offStyle, numOtrStrs;
      protected double avgRank, avgPosRank, avgPtsLast2, shortShutt, threeCone,
      	broadJump, avgCollProd, avgRushAttLast2, avgCatLast2;
			
   
      public PlayerNode nodeHead, next;
      public PlayerNode()
      {
         this.prev = this.next = this;
      }
      public PlayerNode(String name, String pos, String team, int yrsPlayed,
      	int projDepth, double avgRank, double avgPosRank, int injRisk,
      	int numGamesMiss,double avgPtsLast2,int collDiv, double threeCone,
      	double shortShutt, double broadJump,
      	double avgRushAttLast2, double avgCatLast2) 
      {
        
         this.name = name;
         this.pos = pos;
         this.team = team;
         this.yrsPlayed = yrsPlayed;
         this.projDepth = projDepth;
         this.avgRank = avgRank;
         this.avgPosRank = avgPosRank;
         this.injRisk = injRisk;
         this.numGamesMiss = numGamesMiss;
         this.avgPtsLast2 = avgPtsLast2;
         this.collDiv = collDiv;
         this.threeCone = threeCone;
         this.shortShutt = shortShutt;
         this.broadJump = broadJump;
         this.avgRushAttLast2 = avgRushAttLast2;
         this.avgCatLast2 = avgCatLast2;
      }
   
      public String toString() {
         PlayerNode curr = this;
         String result = "";
         while (curr != null) {
            result += ("Player Name: " + curr.name + "\n" + "Pos: " + curr.pos
               + "\n" + "AVG Rank: " + curr.avgRank + "\n" + "Team: "
               + curr.team + "\n" + "AVG Pts Last 2: " + curr.avgPtsLast2
               + "\n" + "Projected Depth: " + curr.projDepth + "\n"
               + "Inj Risk: " + curr.injRisk + "\n" + "Num Games Missed: "
               + curr.numGamesMiss + "\n"
               + "Fantasy Playoff Sched. Rank: " + curr.ffSchedRank + "\n");
         
         
         }
      
         return result;
      }
   
      public PlayerNode getNext()
      {
         return this.next;
      }
   
      public void setNext(PlayerNode newPlayer)
      {
         this.next = newPlayer;
      }
   }