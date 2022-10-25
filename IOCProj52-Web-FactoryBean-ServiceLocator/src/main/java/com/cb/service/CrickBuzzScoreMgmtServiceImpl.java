package com.cb.service;

import com.ipl.external.IIPLScoreComp;

public class CrickBuzzScoreMgmtServiceImpl implements ICrickBuzzScoreMgmtService {
	
	private IIPLScoreComp extComp;
	
	
	public CrickBuzzScoreMgmtServiceImpl(IIPLScoreComp extComp) {
		this.extComp = extComp;
	}

	@Override
	public String fetchScore(int matchId) {
		//use extComp
		return extComp.getScore(matchId);
	}

}
