package playerPosRankingsTODO;

import java.util.EnumSet;


import player2PosRankingsTODO.QB2ranks;
import player2PosRankingsTODO.RB2_FlexRanks;
import player2PosRankingsTODO.WR2ranks;
import player2PosRankingsTODO.TE2ranks;
import player2PosRankingsTODO.WR3_FlexRanks;



public class PosRanks {
	
	EnumSet<QBranks> top15QBS;
	EnumSet<QB2ranks> next15QBS;
	EnumSet<WRranks> top25WRS;
	EnumSet<WR2ranks> next25WRS;
	EnumSet<WR3_FlexRanks> next20WRS;
	EnumSet<RBranks> top25RBS;
	EnumSet<RB2_FlexRanks> next35RBS;
	EnumSet<TEranks> top15TES;
	EnumSet<TE2ranks> next15TES;
	EnumSet<DSTranks> top5DST;
	EnumSet<Kranks> top5K;
	
	public PosRanks()
	{
		
	}
}
