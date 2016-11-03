package backGroundProcesses;


	import java.util.EnumSet;



	public class NFLTeam {

		static String name;
		static int ffSchedRank, QBrank, OffRank,
						DefRank, OffStyle, numStars;
		protected enum Team {
		GB     ("Packers",21,1,13,11,2,0),
		NO       ("Saints",20,2,2,32,2,0),
		NE     ("Patriots",12,3,1,25,3,0),
		DEN       ("Broncos",7,4,4,2,3,0),
		CAR    ("Panthers",1,5,12,10,1,0),
		ATL      ("Falcons",8,6,8,24,2,0),
		SF         ("49ers",6,7,11,3,1,0),
		SEA     ("Seahawks",4,8,17,4,3,0),
		DET       ("Lions",13,9,3,13,2,0),
		DAL    ("Cowboys",16,10,6,19,2,0),
		IND     ("Colts",15,11,10,26,2,0),
		WSH   ("Redskins",11,12,5,28,1,0),
		HOU      ("Texans",18,13,7,7,3,0),
		NYG    ("Giants",22,14,14,31,2,0),
		PIT   ("Steelers",31,15,21,1,2,0),
		BAL    ("Ravens",10,16,16,17,1,0),
		ARI ("Cardinals",32,17,32,12,2,0),
		SD    ("Chargers",14,18,31,9,2,0),
		TB  ("Buccaneers",19,19,9,29,1,0),
		STL       ("Rams",2,20,23,14,1,0),
		CIN    ("Bengals",23,21,22,6,1,0),
		MIA  ("Dolphins",17,22,27,21,2,0),
		CHI       ("Bears",9,23,28,5,2,0),
		PHI    ("Eagles",18,24,15,15,2,0),
		KC      ("Chiefs",3,25,24,20,2,0),
		MIN   ("Vikings",24,26,20,16,1,0),
		CLE    ("Browns",28,27,25,23,1,0),
		TEN    ("Titans",30,28,26,27,1,0),
		OAK   ("Raiders",26,29,18,18,1,0),
		BUF     ("Bills",27,30,19,22,1,0),
		NYJ       ("Jets",25,31,30,8,1,0),
		JAC    ("Jaguars",5,32,29,30,1,0);
		
		
		String teamName;
		int ffSchedRank1, QBrank1, OffRank1,
		DefRank1, OffStyle1, numStars1;	
		public String teamName()
		{
			return teamName;
		}
		public int ffSchedRank()
		{
			return  ffSchedRank1;
		}
		public int QBRank()
		{
			return  QBrank;
		}
		public int OffRank()
		{
			return  OffRank1;
		}
		public int DefRank()
		{
			return  DefRank1;
		}
		public int OffStyle()
		{
			return  OffStyle1;
		}
		public int numStars()
		{
			return numStars1;
		}				
		Team(String name, int ffSchedRank, int QBrank, 
						 int OffRank, int DefRank, int OffStyle,
						 int numStars)
		{
			this.teamName = name;
			this.ffSchedRank1 = ffSchedRank;
			this.QBrank1 = QBrank;
			this.OffRank1 = OffRank;
			this.DefRank1 = DefRank;
			this.OffStyle1 = OffStyle;
			this.numStars1 = numStars;
		}
		
		public String toString()
		{
			String team;
			if(this!=null)
			{
						 team = "Team Name: " + this.teamName + "\n" +
								  "Fantasy Sched. Rank: " + this.ffSchedRank1 + "\n" +
								  "Team QB Rank: " + this.QBrank1 + "\n" +
								  "Team Off Rank Prev Year: " + this.OffRank1 + "\n" +
								  "Team Def Rank Prev Year: " + this.DefRank1 + "\n" + 
								  "Team Off Style: " + this.OffStyle1 + "\n" + 
								  "If Off Style = 1: Run Heavy\n" + 
								  "If Off Style = 2: Pass Heavy\n" + 
								  "If Off Style = 3: Balanced\n" +
								  "Team Number of Stars: " + this.numStars1 + 
								  "\n--> Number of players per team that rank top 75. \n";
								  
								  return team;
			}
			return null;
		}
		}
		
		public static final EnumSet<Team> ListOfNFLTeams = EnumSet.allOf(Team.class); 
		
	}

