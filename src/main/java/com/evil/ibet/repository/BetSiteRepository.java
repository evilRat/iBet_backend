package com.evil.ibet.repository;

import com.evil.ibet.domain.BetSite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BetSiteRepository extends CrudRepository<BetSite, Integer> {

    @Query("select bean from BetSite bean where bean.id in (:idList)")
    List<BetSite> selectBetSiteByIdList(List<Integer> idList);
}
