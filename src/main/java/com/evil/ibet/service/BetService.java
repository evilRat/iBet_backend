package com.evil.ibet.service;

import com.evil.ibet.domain.Bet;

import java.util.List;

public interface BetService {


    List<Bet> getBetSiteByIdList(List<Integer> idList);

}
