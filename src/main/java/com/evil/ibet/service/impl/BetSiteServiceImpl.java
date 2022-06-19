package com.evil.ibet.service.impl;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.repository.BetSiteRepository;
import com.evil.ibet.service.BetSiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BetSiteServiceImpl implements BetSiteService {

    @Resource
    BetSiteRepository betSiteRepository;


    @Override
    public List<BetSite> getBetSiteByIdList(List<Integer> idList) {
        return betSiteRepository.selectBetSiteByIdList(idList);
    }
}
