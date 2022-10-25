package com.cb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.external.IIPLScoreComp;

@Service("cbService")
public class CrickBuzzScoreMgmtServiceImpl implements ICrickBuzzScoreMgmtService {
	
	@Autowired
	private IIPLScoreComp extComp;

	@Override
	public String fetchScore(int matchId) {
		//use extComp
		return extComp.getScore(matchId);
	}

}
