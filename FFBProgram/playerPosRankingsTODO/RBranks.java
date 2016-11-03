package playerPosRankingsTODO;

import java.util.Collection;
import java.util.EnumSet;


/**
 * 
 * @author chrisubuntu
 *
 *Take top 32 RB avg. them out for rookies projected to be the no. 1;
 *
 *	Use avg of player+next 4(yards and touchdowns) to build a projection;
 *	i.e. (Player1-->Player5)(yds)/5 = Player1 yds projection. 
 *		 (Player1-->Player5)(tds)/5 = Player1 tds projection.
 *		for each player in the list, if last 4, avg loses precision due 
 *		to lack of successive players(last 5 have same base avg, but
 *		lose 20 yds and 0 tds per slot greater than 194(195, 196, 197, 198, 199)(0-199 = 200 total)
 */
public enum RBranks {
	;
	RBranks()
	{
		
	}
	static Collection<?> top25RBS = EnumSet.allOf(RBranks.class);
	
	public static Collection<?> top25RBS()
	{
		return top25RBS;
		
	}
}
