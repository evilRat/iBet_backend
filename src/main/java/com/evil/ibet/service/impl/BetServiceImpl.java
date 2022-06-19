package com.evil.ibet.service.impl;

import com.evil.ibet.domain.Bet;
import com.evil.ibet.repository.BetRepository;
import com.evil.ibet.service.BetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    @Resource
    BetRepository betRepository;


    @Override
    public List<Bet> getBetSiteByIdList(List<Integer> idList) {
        return betRepository.selectBetByIdList(idList);
    }
}
