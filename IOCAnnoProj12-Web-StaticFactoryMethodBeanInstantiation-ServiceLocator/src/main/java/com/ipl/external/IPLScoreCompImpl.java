package com.ipl.external;

public class IPLScoreCompImpl implements IIPLScoreComp {

	@Override
	public String getScore(int matchId) {
		if (matchId == 1001) 
			return "CSK vs MI : MI-(162/2), CSK-(167/5) CSK won by 5 wickets";
		else if (matchId == 1002) 
			return "DC vs KIXP : DC-(154/8), KIXP-(154/6) DC won by through super over";
		else if (matchId == 1003) 
			return "RCB vs SRH : RCB-(163/8), SRH-(153/10) RCB won by 10 runs";
		else 
			throw new IllegalArgumentException("Invalid match id");
	}

}
