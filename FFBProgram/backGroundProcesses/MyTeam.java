package backGroundProcesses;







   public class MyTeam<FinalCompleteNode> {
      private FinalTeamNode finalTeamHead = new FinalTeamNode();
      protected int QBcount, RBcount, WRcount, TEcount, Kcount, DSTcount;
      protected boolean ifNeedQB, ifNeedRB, ifNeedWR, ifNeedTE;
      protected String needQB, needRB, needWR, needTE;
      protected TeamNode next, prev;
      private int size;
      protected MyTeam<FinalCompleteNode> newTeam, NflTeams;
      public String teamName;
      protected PlayerNode lastTeamNode;
      protected TeamNode NFLTeamHead, NFLTeamTail;
      protected PlayerNode Finalprev;
      protected PlayerNode Finalnext;
   
      class FinalTeamNode extends backGroundProcesses.PlayerNode
      {
      
      
         String name, pos, team;
         int QBcount, RBcount, WRcount, TEcount, Kcount, DSTcount;
         int yrsPlayed, projDepth, collDiv, injRisk, ffSchedRank,
         	numGamesMiss, QBrank, offStyle, numOtrStrs;
         double avgRank, avgPosRank, avgPtsLast2, shortShutt, threeCone,
         	broadJump, avgCollProd, avgRushAttLast2, avgCatLast2;
         PlayerNode lastTeamNode;
         PlayerNode Finalprev;
         PlayerNode Finalnext;
      
         FinalTeamNode(int QBcount, int RBcount, int WRcount, int TEcount,
         int Kcount, int DSTcount)  {
            this.name = null;
            this.QBcount = QBcount;
            this.RBcount = RBcount;
            this.WRcount = WRcount;
            this.TEcount = TEcount;
            this.Kcount = Kcount;
            this.DSTcount = DSTcount;
         }
      
         FinalTeamNode()
         {
            this.Finalprev = this.Finalnext =  new FinalTeamNode(0,0,0,0,0,0);
         }
      
         FinalTeamNode(PlayerNode curr)
         {
        	 try{
        		 this.Finalnext = curr;
        	 }
        	 catch(IllegalStateException e)
        	 {
        		 
        	 }
         }
         
      }
   
   
   
      public void addNflTeam(TeamNode newTeam) {
         TeamNode curr;
         if (this.NFLTeamHead == null) {
            this.NFLTeamHead = new TeamNode();
            this.NFLTeamHead.next = newTeam;
            this.NFLTeamHead.prev = newTeam;
            newTeam.next = this.NFLTeamHead;
            newTeam.prev = this.NFLTeamHead;
         } 
         else {
            curr = this.NFLTeamHead.next;
            while (curr != this.NFLTeamHead) {
               if (curr.next == this.NFLTeamHead) {
                  curr.next = newTeam;
                  newTeam.next = this.NFLTeamHead;
                  this.NFLTeamHead.prev = newTeam;
                  this.size++;
               }
               curr = curr.next;
            }
         }
      }
      class TeamNode {
         protected TeamNode NFLTeamHead = new TeamNode();
      
         protected int offStyle, defStyle, offRankPrev, defRankPrev, ffSchedRank;
      
         protected double teamSOS;
         protected String teamName;
         protected TeamNode next, lastNFLNode, prev;
         protected FinalTeamNode nextTeamMate;
         protected PlayerNode newPlayer1;
      
      
         protected String info;
      
         public TeamNode() {
            this.prev = this.next = new TeamNode("********************************************\n\n"
               							+"**** This is a listing of all NFL teams ****\n\n"
               							+"**** it prints each|team name|offensive ****\n\n"
               							+"**** style|projected defensive rank|last ***\n\n"
               							+"**** offensive rank, last years defensive **\n\n"
               							+"**** rank and the current season strength **\n\n"
               							+"**** of schedule. **************************\n\n"
               							+"********************************************\n\n");
            this.lastNFLNode = this.NFLTeamHead.prev;
            TeamNode temp = new TeamNode(null, 0, 0, 0, 0, 0.0);
            temp.prev = this.lastNFLNode;
            temp.next = this.NFLTeamHead;
            this.lastNFLNode.next = temp;
         }
         public TeamNode(String info)
         {
            this.info = info;
         }
         public TeamNode(String team, int offStyle, int defStyle,
         	int offRankPrev, int defRankPrev, double teamSOS) {
         
            this.teamName = team;
            this.offStyle = offStyle;
            this.defStyle = defStyle;
            this.offRankPrev = offRankPrev;
            this.defRankPrev = defRankPrev;
            this.teamSOS = teamSOS;
         
         }
      
      
      }
   
      public void addToTeam(PlayerNode curr, String toAdd) {
      
         PlayerNode current = curr;
         FinalTeamNode temp;
         PlayerNode current1;
         if (this.finalTeamHead.next == this.finalTeamHead) {
            temp = newTeamNode(curr);
            this.lastTeamNode.next = temp;
            this.lastTeamNode = this.lastTeamNode.next;
            temp.Finalnext = this.finalTeamHead;
            this.size++;
         } 
         else {
            current1 = this.finalTeamHead;
            while (current1.next != this.finalTeamHead) {
               if (current1.name.equalsIgnoreCase(toAdd)) {
                  this.push(curr);
                  this.size++;
               
               
               
               }
               current = current.next;
            }
         	
         }
      }
   
   
      private void push(PlayerNode curr) {
		// TODO Auto-generated method stub
		
	}


	private FinalTeamNode newTeamNode(PlayerNode curr) {
      // TODO Auto-generated method stub
         if (curr.pos.equals("QB")) {
            this.QBcount++;
         }
         if (curr.pos.equals("RB")) {
            this.RBcount++;
         }
         if (curr.pos.equals("WR")) {
            this.WRcount++;
         }
         if (curr.pos.equals("TE")) {
            this.TEcount++;
         }
         if (curr.pos.equals("K")) {
            this.Kcount++;
         }
         if (curr.pos.equals("DST")) {
            this.DSTcount++;
         }
         return new FinalTeamNode(curr);
      
      }
      public MyTeam() {
         this.Finalprev = this.Finalnext = new FinalTeamNode();
      }
   
      public MyTeam(TeamNode newNflTeam) {
         NFLTeamHead.next = newNflTeam;
         NFLTeamTail.prev = newNflTeam;
         size++;
      }
   
      public int getSize()
      {
         return this.size;
      }
      public String detCurrNeed() {
         ifNeedQB = false;
         ifNeedRB = false;
         ifNeedWR = false;
         ifNeedTE = false;
         FinalTeamNode curr = this.finalTeamHead;
         if (curr.RBcount > 1 && curr.WRcount > 1) {
            ifNeedQB = true;
         }
         if (curr.QBcount > 1 && curr.WRcount > 2 && curr.RBcount > 2) {
            ifNeedTE = true;
         }
         if (curr.RBcount > 2 || (curr.TEcount > 0 && curr.QBcount > 0)) {
            ifNeedWR = true;
         }
         if (curr.RBcount < 2
         	|| (curr.WRcount > 2 && curr.QBcount > 0 && curr.TEcount > 0)) {
            ifNeedRB = true;
         }
         String result = ("Need QB: " + ifNeedQB + "\n" + "Need RB: " + ifNeedRB
            + "\n" + "Need WR: " + ifNeedWR + "\n" + "Need TE: " + ifNeedTE + "\n");
         if((curr.RBcount+curr.WRcount)<4)
            return "Choose from best available regardless of position.\n";
         return result;
      }
   
      public void removeAll() {
         if(this.getSize()==0)
         {
            System.out.println("List has already been cleared");
            return;
         }
         if(this.NFLTeamHead!=null)
         {
            this.NFLTeamHead.next = this.NFLTeamHead;
            this.NFLTeamTail = this.NFLTeamHead;
            this.size = 0;
         }
         if(this.finalTeamHead!=null)
         {
            this.finalTeamHead.next = this.finalTeamHead;
            this.lastTeamNode = this.finalTeamHead;
            this.size = 0;
         }
      }
   
      @Override
      public String toString() {
         int i=1;
         if (this.NFLTeamHead.next == this.NFLTeamHead) {
            return "[]";
         }
         else if(this.NFLTeamHead!=this.NFLTeamHead.next&&this.finalTeamHead==this.finalTeamHead.next)
         {
            String result = "";
            TeamNode current = this.NFLTeamHead.next;
            while (current.next != this.NFLTeamHead) {
            
               for(i = 1; i < this.getSize();)
                  System.out.print(current.teamName + "\t " + current.teamSOS);
            	
               i++;
            }
            System.out.println(this.finalTeamHead);
            return result;
         
         }
         if (this.finalTeamHead.next == this.finalTeamHead) {
            return "[ Team Name: " + this.teamName + "\n"
               + "QB count: " + this.QBcount + "\n" + "RBcount: "
               + this.RBcount + "\n" + "WRcount: " + this.WRcount + "\n"
               + "TEcount: " + this.TEcount + "\n" + "Kcount: "
               + this.Kcount + "\n" + "DSTcount: " + this.DSTcount + "]\n\n";
         } 
         else {
         
            System.out.print("[ Team Name: " + this.teamName + "\n"
               + "QB count: " + this.QBcount + "\n" + "RBcount: "
               + this.RBcount + "\n" + "WRcount: " + this.WRcount + "\n"
               + "TEcount: " + this.TEcount + "\n" + "Kcount: "
               + this.Kcount + "\n" + "DSTcount: " + this.DSTcount + "]\n\n");
            String result = "[";
            PlayerNode current = finalTeamHead.next;
            while (current.next != this.finalTeamHead) {
            
               result += (i) + ". " + current.name + " " + current.pos;
            
               current = current.next;
               i++;
            }
         //			System.out.println(this.finalTeamHead);
            return result;
         
         }
      
      }
   
   
   }