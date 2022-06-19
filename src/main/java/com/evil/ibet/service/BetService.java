package com.evil.ibet.service;

import com.evil.ibet.domain.Bet;

import java.util.List;

public interface BetService {


    List<Bet> getBetByIdList(List<Integer> idList);

    Bet getBetById(Integer id);

}
