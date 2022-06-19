package com.evil.ibet.service;

import com.evil.ibet.domain.BetSite;

import java.util.List;

public interface BetSiteService {

    List<BetSite> getBetSiteByIdList(List<Integer> idList);
}
