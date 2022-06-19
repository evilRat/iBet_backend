package com.evil.ibet.repository;

import com.evil.ibet.domain.UserSite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface UserSiteRepository extends CrudRepository<UserSite, Integer> {

    @Query("select bean from UserSite bean where bean.userId = ?1")
    List<UserSite> selectUserBetSitesByUserId(Integer userId);

    @Query(value = "update t_user_site tus set tus.balance = tus.balance - ?3 where tus.user_id = ?1 and tus.site_id = ?2", nativeQuery = true)
    int updateUserBalanceByUserIdBetSiteId(Integer userId, Integer betSiteId, BigDecimal amount);

    @Query("select bean from UserSite bean where bean.userId = ?1 and bean.siteId = ?2")
    UserSite selectUserBetSitesByUserIdAndSiteId(Integer userId, Integer siteId);
}
