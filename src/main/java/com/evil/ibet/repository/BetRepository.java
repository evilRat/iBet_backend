package com.evil.ibet.repository;

import com.evil.ibet.domain.Bet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BetRepository extends CrudRepository<Bet, Integer> {

    @Query("select bean from Bet bean where bean.id in (:idList)")
    List<Bet> selectBetByIdList(List<Integer> idList);
}
